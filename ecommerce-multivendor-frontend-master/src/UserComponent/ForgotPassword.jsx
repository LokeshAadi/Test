// ForgotPasswordForm.js
import React, { useState } from "react";

const ForgotPasswordForm = () => {
  const [email, setEmail] = useState("");
  const [otpSent, setOtpSent] = useState(false);
  const [otp, setOtp] = useState("");
  const [resetPassword, setResetPassword] = useState(false);
  const [newPassword, setNewPassword] = useState("");

  const handleSendOtp = (e) => {
    e.preventDefault();
    // Simulate sending OTP
    setOtpSent(true);
  };

  const handleVerifyOtp = (e) => {
    e.preventDefault();
    // Simulate verifying OTP
    setResetPassword(true);
  };

  const handleResetPassword = (e) => {
    e.preventDefault();
    // Simulate resetting password
    alert("Password reset successful!");
    // Reset form fields
    setEmail("");
    setOtpSent(false);
    setOtp("");
    setResetPassword(false);
    setNewPassword("");
  };

  return (
    <div>
      {!otpSent && !resetPassword && (
        <form onSubmit={handleSendOtp}>
          <input
            type="email"
            placeholder="Enter your email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
          <button type="submit">Send OTP</button>
        </form>
      )}

      {otpSent && !resetPassword && (
        <form onSubmit={handleVerifyOtp}>
          <input
            type="text"
            placeholder="Enter OTP"
            value={otp}
            onChange={(e) => setOtp(e.target.value)}
            required
          />
          <button type="submit">Verify OTP</button>
        </form>
      )}

      {resetPassword && (
        <form onSubmit={handleResetPassword}>
          <input
            type="password"
            placeholder="Enter new password"
            value={newPassword}
            onChange={(e) => setNewPassword(e.target.value)}
            required
          />
          <button type="submit">Reset Password</button>
        </form>
      )}
    </div>
  );
};

export default ForgotPasswordForm;
