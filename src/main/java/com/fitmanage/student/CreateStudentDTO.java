package com.fitmanage.student;

import java.util.UUID;

import com.fitmanage.models.GenderModel;
import com.fitmanage.models.PlansModel;

import lombok.Data;

@Data
public class CreateStudentDTO {
    private UUID userId;
    private String name;
    private String email;
    private String phone;
    private String cpf;
    private GenderModel gender;
    private PlansModel activePlan; 
}