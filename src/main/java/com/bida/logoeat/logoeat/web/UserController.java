package com.bida.logoeat.logoeat.web;

import com.bida.logoeat.logoeat.config.JWTUtil;
import com.bida.logoeat.logoeat.domain.JWTResponse;
import com.bida.logoeat.logoeat.domain.Message;
import com.bida.logoeat.logoeat.service.UserService;
import com.bida.logoeat.logoeat.service.dto.UserLogin;
import com.bida.logoeat.logoeat.service.dto.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public ResponseEntity<Message> index() {
        return new ResponseEntity<>(new Message("You can see it."), HttpStatus.OK);
    }

    @PostMapping("/registration")
    @ResponseBody
    public ResponseEntity<Message> registerNewUser(@RequestBody UserRegistrationDTO userDTO){
        return userService.registerUser(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLogin userLogin) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getEmail(), userLogin.getPassword()));
        } catch (BadCredentialsException e) {
//            new ResponseEntity<>(new Message("Email or Password is wrong."), HttpStatus.NOT_ACCEPTABLE);
            throw new Exception("Incorrect email or password");
        }
        final UserDetails userDetails = userService.loadUserByUsername(userLogin.getEmail());
        return ResponseEntity.ok(new JWTResponse(jwtUtil.generateTOKEN(userDetails)));
    }
}
