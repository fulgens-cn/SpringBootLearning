package com.example.springbootjpa.repository;

import com.example.springbootjpa.entity.Department;
import com.example.springbootjpa.entity.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void findByIdTest() {
        Optional<Department> optional = departmentRepository.findById("0a4fe7234fff42afad34f6a06a8e1821");
        Set<Employee> employees = optional.get().getEmployees();
        Assert.assertNotEquals(0, employees.size());
    }

}