package com.example.crud.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class EmployeeConfig {
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository){
        return args -> {
            Employee john = new Employee(
                    "John",
                    "johncena",
                    LocalDate.of(2000, JANUARY, 5),
                    3
            );

            Employee steve = new Employee(
                    "Steve",
                    "stevenash",
                    LocalDate.of(1995, NOVEMBER, 25),
                    3
            );

            Employee rod = new Employee(
                    "Rod",
                    "roddie",
                    LocalDate.of(1991, MAY, 13),
                    3
            );

            repository.saveAll(
                    List.of(john, steve, rod)
            );
        };
    }
}
