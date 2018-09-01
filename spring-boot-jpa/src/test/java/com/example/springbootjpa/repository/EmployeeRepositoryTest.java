package com.example.springbootjpa.repository;

import com.example.springbootjpa.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void findByIdTest() {
        Optional<Employee> optional = employeeRepository.findById("93fce66c1ef340fa866d5bd389de3d79");
        System.out.println(optional.get());
    }

}