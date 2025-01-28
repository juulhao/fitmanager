package com.fitmanage.student;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fitmanage.models.GenderModel;
import com.fitmanage.models.PlansModel;
import com.fitmanage.user.UserModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tb_student")
public class StudentModel {
    @Id
    private UUID id;

    @CreationTimestamp 
    @Column(name = "created_at", updatable = false) 
    private LocalDateTime createdAt;
    
    private PlansModel activePlan; 

    @OneToOne
    @JoinColumn(name = "userID", referencedColumnName = "id")
    private UserModel userID;

    private String name;
    private String email;
    private String phone;
    private String cpf;
    private GenderModel gender;
}
