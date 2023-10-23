package com.demoSpring.databases;

import com.demoSpring.databases.StudentRepository;
import com.demoSpring.modules.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.util.Calendar.OCTOBER;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student bill = new Student(
                    "BiLZay",
                    "billzay@gmail.com",
                    LocalDate.of(2002, OCTOBER, 20)
            );

            Student tuan = new Student(
                    "Tuan Phan",
                    "phanletuan@gmail.com",
                    LocalDate.of(2005, OCTOBER, 20)
            );

            repository.saveAll(
                    List.of(bill,tuan)
            );
        };
    }
}
