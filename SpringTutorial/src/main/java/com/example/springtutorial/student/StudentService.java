package com.example.springtutorial.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
       Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
       if(studentByEmail.isPresent()){
           throw new IllegalStateException("Email is taken");
       }
        studentRepository.save(student);

    }
    public void deleteStudent(Long studentId){
       boolean exists = studentRepository.existsById(studentId);
       if (!exists){
           throw new IllegalStateException("Student with id" + studentId + "does not exist");
       }
       studentRepository.deleteById(studentId);
    }
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id" + studentId + "does not exist.")
                );
        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if(email != null &&
            email.length() > 0 &&
                !Objects.equals(student.getEmail(), email)){
                Optional<Student> studentOptional = studentRepository
                        .findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email is taken");

            }
            student.setEmail(email);
            }



    }
}
