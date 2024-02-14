package org.example.jpastudentjon.repository;

import org.example.jpastudentjon.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByName(String name);

}
