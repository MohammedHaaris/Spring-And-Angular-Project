package com.te.student_managment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.te.student_managment.bean.Student;
import com.te.student_managment.exception.ResourceNotFoundException;
import com.te.student_managment.repository.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/")
public class StudentController {
	StudentRepo studentRepo;

    @PostMapping("/students")
    public Student addEmployee(@RequestBody Student student) {
        return studentRepo.save(student);
    }


    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudent() {

        return ResponseEntity.ok(studentRepo.findAll());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getEmployeeById(@PathVariable(value = "id") Long studentId)
            throws ResourceNotFoundException {
    	Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
        return ResponseEntity.ok().body(student);
    }

//    @PutMapping("/student/{id}")
//    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId,
//                                                   @RequestBody Student StudentDetails) throws ResourceNotFoundException {
//    	Student student = studentRepo.findById(studentId)
//                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
//
//        Student.setName(StudentDetails.getName());
//        Student.setEmail(StudentDetails.getEmail());
//        Student.setMarks(StudentDetails.getMarks());
//        Student.setId(StudentDetails.getId());
//
//        final Student updatedEmployee = studentRepo.save(student);
//        return ResponseEntity.ok(updatedEmployee);
//    }

    @DeleteMapping("/students/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long studentId)
            throws ResourceNotFoundException {
    	Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));

        studentRepo.delete(student);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
