package com.example.studentCrud.controller;
import com.example.studentCrud.model.Student;
import com.example.studentCrud.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Void> createStudent(@RequestBody Student student){
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        studentService.save(student);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Student>> listAll(){
       List<Student> allStudents = studentService.listAll();
       return ResponseEntity.ok(allStudents);
    }

    @GetMapping("/getByStudentId")
    public ResponseEntity<Student> getByStudentId(@RequestParam("id") Long id){
        Student student = studentService.getByStudentId(id);
        return ResponseEntity.ok(student);
    }
//    @GetMapping("/getByStudentFirstLetter")
//    public ResponseEntity<Student> getByStudentFirstLetter(@RequestParam("name") String name) {
//        Student student = studentService.getByStudentFirstLetter(name);
//        return ResponseEntity.ok(student);
//    }
}
