package com.hemant.service;

import com.hemant.entity.Emp;
import com.hemant.exception.EmpNotFoundException;
import com.hemant.model.dto.EmpDto;
import com.hemant.model.mapper.EmpMapper;
import com.hemant.repository.EmpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpService {
    private final EmpRepository empRepository;
    private final EmpMapper empMapper;

    public EmpDto getEmp(Integer id) {
        return empRepository.findByEmpId(id)
                .map(empMapper::toDto)
                .orElseThrow(() -> new EmpNotFoundException("Emp not found id: " + id));
    }

    public List<EmpDto> getAllEmp() {
        return empMapper.toDtoList(empRepository.findAll());
    }

    public EmpDto sameEmp(EmpDto empDto) {
        return empMapper.toDto(empRepository.save(empMapper.toEntity(empDto)));
    }

    public String deleteEmp(Integer empId) {
        Emp emp = empRepository.findByEmpId(empId)
                .orElseThrow(() -> new EmpNotFoundException("EmpId is not found:" + empId));
        empRepository.delete(emp);
        return "EmpId is deleted:" + empId;
    }
}
