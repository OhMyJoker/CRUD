package com.example.crud.employee;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "employee_sequence"
    )
    private Long id;
    private String name;
    private String username;
    private LocalDate dateofbirth;
    @Transient
    private Integer age;
    private Integer workExp;

    public Employee() {
    }

    public Employee(Long id,
                    String name,
                    String username,
                    LocalDate dateofbirth,
                    Integer workExp) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.dateofbirth = dateofbirth;
        this.workExp = workExp;
    }

    public Employee(String name,
                    String username,
                    LocalDate dateofbirth,
                    Integer workExp) {
        this.name = name;
        this.username = username;
        this.dateofbirth = dateofbirth;
        this.workExp = workExp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public Integer getAge() {
        return Period.between(this.dateofbirth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWorkExp() {
        return workExp;
    }

    public void setWorkExp(Integer workExp) {
        this.workExp = workExp;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", dateofbirth=" + dateofbirth +
                ", age=" + age +
                ", workExp=" + workExp +
                ", dateofbirth=" + dateofbirth +
                ", workExp=" + workExp +
                '}';
    }
}
