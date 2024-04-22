package com.ecommerce.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class OtpService {

    // This map will hold the generated OTPs with the associated email address
	  private final Map<String, String> otpMap = new HashMap<>();

	    // This method generates a random 6-digit OTP
	    public String generateOtp() {
	        Random random = new Random();
	        int otp = 100000 + random.nextInt(900000);
	        return String.valueOf(otp);
	    }

	    // This method generates and sends OTP to the specified email address
	    public void sendOtp(String email) {
	        String otp = generateOtp();
	        // Here you would send the OTP to the user via email or SMS
	        // For demonstration purposes, we'll just print it
	        System.out.println("OTP sent to " + email + ": " + otp);
	        otpMap.put(email, otp);
	    }

	    // This method verifies if the provided OTP matches the one associated with the email address
	    public boolean verifyOtp(String email, String otp) {
	        String storedOtp = otpMap.get(email);
	        return storedOtp != null && storedOtp.equals(otp);
	    }

	    // This method checks if OTP is verified for the given email
	    public boolean isOtpVerified(String email) {
	        return otpMap.containsKey(email);
	    }
}