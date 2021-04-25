package com.bida.logoeat.logoeat.service;

import com.bida.logoeat.logoeat.domain.Message;
import com.bida.logoeat.logoeat.domain.User;
import com.bida.logoeat.logoeat.repository.UserRepository;
import com.bida.logoeat.logoeat.service.dto.MyUserDetails;
import com.bida.logoeat.logoeat.service.dto.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApplicationContext context;

    public ResponseEntity<Message> registerUser(UserRegistrationDTO userDTO){
        User user = userDTO.getUser();
        if (findUserByEmail(user.getEmail()) != null) {
            return new ResponseEntity<>((Message) context.getBean("occupiedEmail"), HttpStatus.NOT_FOUND);
        } else {
            if (checkAcceptableUserData(user)) {
                userRepository.save(user);
                return new ResponseEntity<>((Message) context.getBean("userIsSuccessfulRegistered"), HttpStatus.OK);
            } else return new ResponseEntity<>((Message) context.getBean("unacceptableEmailOrPassword"), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = findUserByEmail(s);
        if (user == null){
            throw new UsernameNotFoundException(s);
        }
        return new MyUserDetails(user);
    }

    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public boolean checkAcceptableUserData(User user){
        Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
        Matcher emailMatcher = emailPattern.matcher(user.getEmail());
        Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,}$");
        Matcher passwordMatcher = passwordPattern.matcher(user.getPassword());
        return passwordMatcher.matches() && emailMatcher.matches();
    }
}
