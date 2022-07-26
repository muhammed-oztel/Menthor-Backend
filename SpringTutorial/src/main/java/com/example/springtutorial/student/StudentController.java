package com.example.springtutorial.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/")

public class StudentController {
    private final StudentService studentService;
@Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("student")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("student/register")
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
   @DeleteMapping("student/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
   }
   @PutMapping("/student/update/{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email)
   {
       //Example PUT: localhost:8080/api/v1/student/update/1?name=oguzhan
       //localhost:8080/api/v1/student/update/1?name=oguzhan&email=oguzhan@gmail.com
    studentService.updateStudent(studentId, name, email);
   }
}
