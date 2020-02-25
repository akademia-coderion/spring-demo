package pl.coderion.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderion.springdemo.model.Student;
import pl.coderion.springdemo.service.StudentService;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    private List<Student> getAllPersons() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    private Student getPerson(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/students/{id}")
    private void deletePerson(@PathVariable("id") int id) {
        studentService.delete(id);
    }

    @PostMapping("/students")
    private int savePerson(@RequestBody Student student) {
        studentService.saveOrUpdate(student);
        return student.getId();
    }
}
