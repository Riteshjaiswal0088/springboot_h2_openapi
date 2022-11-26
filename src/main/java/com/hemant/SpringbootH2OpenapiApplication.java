package com.hemant;

import com.hemant.entity.Emp;
import com.hemant.model.mapper.EmpMapper;
import com.hemant.repository.EmpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringbootH2OpenapiApplication implements CommandLineRunner {

    private final EmpRepository empRepository;
    private final EmpMapper empMapper;


    public static void main(String[] args) {
        SpringApplication.run(SpringbootH2OpenapiApplication.class, args);
    }

    @Override
    public void run(String... args) {
        List<Emp> empList = List.of(Emp.builder().name("Hemant Sahu").age(32).department("IT").empId(123).build(),
                Emp.builder().name("Sonu Sahu").age(32).department("IT").empId(124).build(),
                Emp.builder().name("Ritesh Jaiswal").age(35).department("IT").empId(125).build(),
                Emp.builder().name("Dharam").age(32).department("Non IT").empId(126).build());

        empRepository.saveAll(empList);
        int empId = 123;
        System.out.println(empRepository.findByEmpId(empId).map(empMapper::toDto).orElseThrow(() -> new RuntimeException("Emp not find:" + empId)));
    }
}
