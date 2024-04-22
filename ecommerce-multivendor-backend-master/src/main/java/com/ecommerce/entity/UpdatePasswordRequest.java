package com.ecommerce.entity;

import jakarta.persistence.Id;
import lombok.Data;
@Data
public class UpdatePasswordRequest {
	 
	private int id;
    private String email;
    private String otp;
    private String newPassword;

    // Constructor, getters, and setters
}
