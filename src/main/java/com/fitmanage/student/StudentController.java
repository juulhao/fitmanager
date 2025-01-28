package com.fitmanage.student;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity createStudent(@RequestBody CreateStudentDTO studentDTO) {
        try {
            StudentModel student = studentService.createStudent(studentDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(student);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateStudent(
            @PathVariable UUID id, // ID do estudante a ser atualizado
            @RequestBody UpdateStudentDTO studentDTO) { // Dados de atualização
        try {
            // Passa o ID e o DTO para o serviço
            StudentModel student = studentService.updateStudent(id, studentDTO);
            return ResponseEntity.status(HttpStatus.OK).body(student); // Retorna o estudante atualizado
        } catch (RuntimeException e) {
            // Retorna uma mensagem de erro no corpo da resposta
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}