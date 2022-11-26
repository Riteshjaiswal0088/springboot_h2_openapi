package com.hemant.service;

import com.hemant.entity.Emp;
import com.hemant.exception.EmpNotFoundException;
import com.hemant.model.dto.EmpDto;
import com.hemant.model.mapper.EmpMapper;
import com.hemant.repository.EmpRepository;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmpServiceTest {

    @InjectMocks
    private EmpService empService;

    @Mock
    private EmpRepository repository;

    @Mock
    private EmpMapper empMapper;


    @Test
    void testGetEmp() {
        Emp emp =  Instancio.of(Emp.class).create();;
        when(repository.findByEmpId(anyInt())).thenReturn(Optional.of(emp));
        when(empMapper.toDto(any())).thenReturn(EmpMapper.EMPMAPPER.toDto(emp));
        EmpDto empDto = empService.getEmp(emp.getEmpId());
        Assertions.assertNotNull(empDto);
        Assertions.assertEquals(empDto.getEmpId(), emp.getEmpId());
    }

    @Test
    void testGetEmpException() {
        Emp emp = getEmp();
        EmpNotFoundException exception = Assertions.assertThrows(EmpNotFoundException.class,
                () -> empService.getEmp(emp.getId()));
      Assertions.assertNotNull(exception);

    }

    private Emp getEmp() {
        return Instancio.of(Emp.class).create();
    }

    @Test
    void testGetAllEmp() {
        List<Emp> emps = getAllEmp();
        when(repository.findAll()).thenReturn(emps);
        when(empMapper.toDtoList(anyList())).thenReturn(EmpMapper.EMPMAPPER.toDtoList(emps));
        List<EmpDto> allEmp = empService.getAllEmp();
        Assertions.assertNotNull(allEmp);
        Assertions.assertEquals(10,allEmp.size());
    }

    private List<Emp> getAllEmp(){
        return Instancio.stream(Emp.class).limit(10)
                .collect(Collectors.toList());
    }

    @Test
    void sameEmp() {
     /*   String[] str ={"SELECTED","0"};
        String val = "[SELECTED]";
        String all = removeAllSpecialCar(val);
        var anyMatch = Arrays.stream(str).anyMatch(v -> v.matches(all));
        System.out.println(anyMatch);*/
        List<Integer> ins = Arrays.asList(1,2,3,4,5,6,7);
        List<String> str = Arrays.asList("one","three","four");
        str.stream().mapToInt(String::length).forEach(System.out::println);
        System.out.println("===========");
        ins.stream().filter(n-> n%2 == 0).forEach(System.out::println);

    }

    private String removeAllSpecialChar(String val) {
        return val.replaceAll("[^\\w\\s]", "");
    }

    @Test
    void deleteEmp() {
        Emp emp = Instancio.create(Emp.class);
        when(repository.findByEmpId(anyInt())).thenReturn(Optional.ofNullable(emp));
        doNothing().when(repository).delete(any());
        String deleteEmp = empService.deleteEmp(Objects.requireNonNull(emp).getEmpId());
        Assertions.assertNotNull(deleteEmp);
    }
}