package com.hemant.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
@Entity
public class Emp {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer empId;
    private Integer age;
    private String name;
    private String department;
}
