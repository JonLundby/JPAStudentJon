package org.example.jpastudentjon.config;

import org.example.jpastudentjon.model.Student;
import org.example.jpastudentjon.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student();
        s1.setName("Allan");
        s1.setBornDate(LocalDate.of(1986,12,1));
        s1.setBornTime(LocalTime.of(11,5,9));
        studentRepository.save(s1);

        s1.setName("Lone");
        s1.setId(0);
        studentRepository.save(s1);

        s1.setName("Rut");
        s1.setId(0);
        studentRepository.save(s1);
    }
}
