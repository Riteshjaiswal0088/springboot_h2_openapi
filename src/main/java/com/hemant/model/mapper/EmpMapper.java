package com.hemant.model.mapper;

import com.hemant.entity.Emp;
import com.hemant.model.dto.EmpDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface EmpMapper {
    EmpMapper EMPMAPPER = Mappers.getMapper(EmpMapper.class);

    EmpDto toDto(Emp emp);
    Emp toEntity(EmpDto empDto);

    List<EmpDto> toDtoList(List<Emp> emps);
    List<Emp> toEntityList(List<EmpDto> empDtos);

}
