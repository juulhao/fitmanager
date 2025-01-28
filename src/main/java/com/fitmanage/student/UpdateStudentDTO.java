package com.fitmanage.student;
import java.util.UUID;

import com.fitmanage.models.PlansModel;

import lombok.Data;

@Data
public class UpdateStudentDTO {
    private UUID userId;
    private String email;
    private String phone;
    private PlansModel activePlan; 
}
