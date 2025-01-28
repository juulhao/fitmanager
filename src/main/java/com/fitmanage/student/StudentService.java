package com.fitmanage.student;

import com.fitmanage.user.UserModel;
import com.fitmanage.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    public StudentModel createStudent(CreateStudentDTO studentDTO) {
        // Verifica se o usuário existe
        Optional<UserModel> userOptional = userRepository.findById(studentDTO.getUserId());
        if (userOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }

        UserModel user = userOptional.get();

        // Cria o estudante
        StudentModel student = new StudentModel();
        student.setId(UUID.randomUUID());
        student.setUserID(user); // Associa o estudante ao usuário
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setGender(studentDTO.getGender());
        student.setCpf(studentDTO.getCpf());
        student.setPhone(studentDTO.getPhone());
        student.setActivePlan(studentDTO.getActivePlan());
        student.setPhone(studentDTO.getPhone());
        student.setGender(student.getGender());
        student.setCpf(studentDTO.getCpf());

        // Salva o estudante no banco de dados
        return studentRepository.save(student);
    }

    public StudentModel updateStudent(UUID id, UpdateStudentDTO studentDTO) {
        // Verifica se o estudante existe
        Optional<StudentModel> studentOptional = studentRepository.findById(id);

        if (studentOptional.isEmpty()) {
            throw new RuntimeException("Estudante não encontrado");
        }

        StudentModel student = studentOptional.get();
        student.setEmail(studentDTO.getEmail());
        student.setPhone(studentDTO.getPhone());
        student.setActivePlan(studentDTO.getActivePlan());

        // Salva o estudante no banco de dados
        return studentRepository.save(student);
    }
}