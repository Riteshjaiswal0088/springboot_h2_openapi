package com.hemant.repository;

import com.hemant.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpRepository extends JpaRepository<Emp,Integer> {

    Optional<Emp> findByEmpId(Integer empId);

    Integer deleteByEmpId(Integer empId);
}
