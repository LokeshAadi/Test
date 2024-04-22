package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.UserDao;
import com.ecommerce.dto.CommonApiResponse;
import com.ecommerce.entity.User;

@Service
public class EmailService {

	@Autowired
	private UserDao userDao;
	 
	@Autowired
    private PasswordEncoder passwordEncoder;
	@Autowired
    private OtpService otpService;

	public ResponseEntity<CommonApiResponse> updatePassword(String email, String otp, String newPassword) {
        // Validate OTP
        if (!otpService.verifyOtp(email, otp)) {
            return ResponseEntity.badRequest().body(new CommonApiResponse());
        }

        User user = userDao.findByEmailId(email);
        if (user == null) {
            return ResponseEntity.notFound().build(); // Return ResponseEntity with 404 status code
        }

        // Update password
        user.setPassword(passwordEncoder.encode(newPassword));
        userDao.save(user);

        return ResponseEntity.ok(new CommonApiResponse());
    }
	
 
}
