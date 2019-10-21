package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @NotNull
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private int age;
}
