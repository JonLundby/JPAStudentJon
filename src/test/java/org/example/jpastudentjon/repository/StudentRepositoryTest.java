package org.example.jpastudentjon.repository;

import org.example.jpastudentjon.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void testOneTim(){
        List<Student> lst = studentRepository.findAllByName("Rut");
        assertEquals(0,lst.size());
    }

    @Test
    void testOneViggo(){
        Student s1 = new Student();
        s1.setName("Viggo");
        s1.setBornDate(LocalDate.of(1986,12,1));
        studentRepository.save(s1);

        List<Student> lst = studentRepository.findAllByName("Viggo");
        assertEquals(1,lst.size());
    }
}