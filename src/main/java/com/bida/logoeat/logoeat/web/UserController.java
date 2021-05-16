package com.bida.logoeat.logoeat.web;

import com.bida.logoeat.logoeat.config.JWTUtil;
import com.bida.logoeat.logoeat.domain.JWTResponse;
import com.bida.logoeat.logoeat.domain.Message;
import com.bida.logoeat.logoeat.service.UserService;
import com.bida.logoeat.logoeat.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    @ResponseBody
    public ResponseEntity<Message> registerNewUser(@RequestBody UserRegistrationDTO userDTO){
        return userService.registerUser(userDTO);
    }

    @PostMapping("/forgot_password")
    @ResponseBody
    public ResponseEntity<Message> forgotPassword(@RequestBody ForgotPasswordRequest forgotPasswordRequest){
        return userService.forgotPassword(forgotPasswordRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginRequest userLogin) throws Exception{
        System.out.println(userLogin);
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getEmail(), userLogin.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect email or password");
        }
        final UserDetails userDetails = userService.loadUserByUsername(userLogin.getEmail());
        return ResponseEntity.ok(new JWTResponse(jwtUtil.generateTOKEN(userDetails)));
    }

    @PutMapping("/update_phone_number")
    public ResponseEntity<Message> updatePhoneNumber(@RequestBody PhoneNumberRequest phoneNumberRequest, Principal principal) {
        return userService.updatePhoneNumber(phoneNumberRequest.getPhoneNumber(), principal.getName());
    }

    @PutMapping("/update_name")
    public ResponseEntity<Message> updateName(@RequestBody NameRequest nameRequest, Principal principal) {
        return userService.updateName(nameRequest.getName(), principal.getName());
    }

    @PutMapping("/update_password")
    public ResponseEntity<Message> updatePassword(@RequestBody ChangePasswordRequest changePasswordRequest, Principal principal) {
        return userService.updatePassword(changePasswordRequest.getOldPassword(), changePasswordRequest.getNewPassword(), principal.getName());
    }
}
