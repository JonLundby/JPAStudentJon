package org.example.jpastudentjon.controller;

import org.example.jpastudentjon.model.Student;
import org.example.jpastudentjon.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/")
    public String hello() {
        return "Welcome to the main page!";
    }

    @GetMapping("/students")
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/addstudent")
    public List<Student> addStudent(){
        Student std = new Student();
        std.setBornDate(LocalDate.now());
        std.setBornTime(LocalTime.now());
        List<Student> lst = studentRepository.findAll();
        std.setName("Autogenerated sz=" + lst.size());
        studentRepository.save(std);
        System.out.println("student was added!");


        return studentRepository.findAll();
    }

    @GetMapping("students/{name}")
    public List<Student> getallstudentsbyname(@PathVariable String name) {
        return studentRepository.findAllByName(name);
    }
}