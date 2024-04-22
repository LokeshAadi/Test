package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.CommonApiResponse;
import com.ecommerce.service.EmailService;
import com.ecommerce.service.Emailservice2;
import com.ecommerce.service.OtpService;
 @CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/password")
public class ForgotPasswordController {

	 @Autowired
	    private OtpService otpService;

	    @Autowired
	    private EmailService emailService;
	    
	    
	    @Autowired
	    private Emailservice2 emailService1;

	    @PostMapping("/send-email")
	    public String sendEmail(@RequestParam String email) {
	    	
	        String otp = otpService.generateOtp();

	        String subject = "Subject of the Email";
	        String text = "your OTP  is     " + otp;

	        emailService1.sendEmail(email, subject, text);

	        return "Email OTp sent successfully!";
	    }
	     
	     

		/*
		 * @PostMapping("/verify-otp") public ResponseEntity<CommonApiResponse>
		 * verifyOtp(@RequestParam String email, @RequestParam String otp) { try { if
		 * (otpService.verifyOtp(email, otp)) { return ResponseEntity.ok(new
		 * CommonApiResponse()); } else { return ResponseEntity.ok(new
		 * CommonApiResponse()); } } catch (Exception e) { return
		 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR) .body(new
		 * CommonApiResponse()); } }
		 */

	    // Step 3: Change Password
	    @PostMapping("/change-password")
	    public ResponseEntity<CommonApiResponse> changePassword(@RequestParam String email,
	                                                             @RequestParam String newPassword,
	                                                             @RequestParam boolean verifiedOtp) {
	        try {
	            if (otpService.isOtpVerified(email) && verifiedOtp) {
	                // Change password logic
	                return ResponseEntity.ok(new CommonApiResponse());
	            } else {
	                return ResponseEntity.ok(new CommonApiResponse());
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body(new CommonApiResponse());
	        }
	    }
}
