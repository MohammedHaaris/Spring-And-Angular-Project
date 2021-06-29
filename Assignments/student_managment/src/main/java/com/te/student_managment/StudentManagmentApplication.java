package com.te.student_managment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.te.student_managment.bean.Student;
import com.te.student_managment.repository.StudentRepo;

@SpringBootApplication
public class StudentManagmentApplication  {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagmentApplication.class, args);
	}

	
	
}
