package com.hemant.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class EmpDto {
    private Integer empId;
    private Integer age;
    private String name;
    private String department;
}
