package com.example.springbootjpa.repository;

import com.example.springbootjpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    User findByUsername(String username);

    List<User> findByUsernameIgnoreCase(String username);

    List<User> findByUsernameLike(String username);

    User findByUsernameAndPassword(String username, String password);

    User findByEmail(String email);

    List<User> findByEmailLike(String email);

    List<User> findByIdIn(List<String> ids);

    List<User> findByIdInOrderByUsername(List<String> ids);

    void deleteByIdIn(List<String> ids);

    Long countByUsernameLike(String username);

    User findFirstByUsernameOrderByUsernameAsc(String username);

    List<User> findTop10ByUsername(String username, Sort sort);

    List<User> findTop10ByUsername(String username, Pageable pageable);

    // @Query("select u from User u where u.email = ?1")
    @Query("select u from #{#entityName} u where u.email = ?1")
    User getByEmail(String eamil);

    @Query("select u from User u where u.username = ?1 and u.password = ?2")
    User getByUsernameAndPassword(String username, String password);

    @Query("select u from User u where u.username like %?1%")
    List<User> getByUsernameLike(String username);

    @Query("select u from User u where u.id = :id")
    User getById(@Param("id") String userId);

    @Query("select u from User u where u.username = :username or u.email = :email")
    User getByUsernameOrEmail(@Param("username") String username, @Param("email") String email);

    /*@Query(value = "select * from tb_user u where u.email = ?1", nativeQuery = true)
    User queryByEmail(String email);*/

    @Query(value = "select * from tb_user u where u.email = :email", nativeQuery = true)
    User queryByEmail(@Param("email") String email);

    @Query(value = "select * from tb_user u where u.username like %?1%",
            countQuery = "select count(1) from tb_user u where u.username = %?1%",
            nativeQuery = true)
    Page<User> queryByUsernameLike(String username, Pageable pageable);

    @Query("select u from User u where u.username like %?1%")
    Page<User> findByUsernameLike(String username, Pageable pageable);

    @Query("select u from User u where u.username like %?1%")
    List<User> findByUsernameAndSort(String username, Sort sort);

    @Transactional(propagation = Propagation.REQUIRED)
    @Modifying
    @Query("update User u set u.password = ?2 where u.username = ?1")
    int updatePasswordByUsername(String username, String password);

    @Transactional(propagation = Propagation.REQUIRED)
    @Modifying
    @Query("delete from User where username = ?1")
    void deleteByUsername(String username);

}
