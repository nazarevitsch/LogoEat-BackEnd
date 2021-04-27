package com.bida.logoeat.logoeat.service;

import com.bida.logoeat.logoeat.domain.Message;
import com.bida.logoeat.logoeat.domain.User;
import com.bida.logoeat.logoeat.messeging.EmailNotification;
import com.bida.logoeat.logoeat.repository.UserRepository;
import com.bida.logoeat.logoeat.service.dto.ForgotPasswordRequest;
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

    @Autowired
    private EmailNotification emailNotification;

    public ResponseEntity<Message> updateName(String oldPassword, String newPassword, String username) {
        if (oldPassword.equals(newPassword)) {
            return new ResponseEntity<>((Message) context.getBean("oldPasswordAndNewPasswordAreSimilar"), HttpStatus.NOT_ACCEPTABLE);
        }
        if (validatePassword(oldPassword) && validatePassword(newPassword)) {
            User user = findUserByEmail(username);
            if (!user.getPassword().equals(oldPassword)){
                return new ResponseEntity<>((Message) context.getBean("oldPasswordWrong"), HttpStatus.NOT_ACCEPTABLE);
            }
            userRepository.updatePasswordByEmailAndOldPassword(username, oldPassword, newPassword);
            return new ResponseEntity<>((Message) context.getBean("passwordWasChanged"), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>((Message) context.getBean("invalidPassword"), HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<Message> updateName(String newName, String username) {
        if (validateName(newName)) {
            userRepository.updateNameByEmail(username, newName);
            return new ResponseEntity<>((Message) context.getBean("nameWasChanged"), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>((Message) context.getBean("invalidName"), HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<Message> updatePhoneNumber(String newPhoneNumber, String username) {
        if (validatePhoneNumber(newPhoneNumber)) {
            userRepository.updatePhoneNumberByEmail(username, newPhoneNumber);
            return new ResponseEntity<>((Message) context.getBean("numberWasChanged"), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>((Message) context.getBean("invalidPhoneNumber"), HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<Message> forgotPassword(ForgotPasswordRequest forgotPasswordRequest) {
        if (validateEmail(forgotPasswordRequest.getEmailPhone())){
            User user = userRepository.findByEmail(forgotPasswordRequest.getEmailPhone());
            if (user != null) {
                String newPassword = generateNewPassword();
                try {
                    emailNotification.sendMessage(user.getEmail(), "New Password", "New Password: " + newPassword);
                } catch (Exception e) {
                    return new ResponseEntity<>((Message) context.getBean("emailNotificationIsNotAvailable"), HttpStatus.EXPECTATION_FAILED);
                }
                userRepository.updatePasswordById(user.getId(), newPassword);
                return new ResponseEntity<>((Message) context.getBean("emailWithNewPassword"), HttpStatus.OK);
            }
        }
        if (validatePhoneNumber(forgotPasswordRequest.getEmailPhone())) {
            return new ResponseEntity<>((Message) context.getBean("SMSNotificationIsNotAvailable"), HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>((Message) context.getBean("noSuchEmailOrPhone"), HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<Message> registerUser(UserRegistrationDTO userDTO){
        User user = userDTO.getUser();
        if (findUserByEmail(user.getEmail()) != null) {
            return new ResponseEntity<>((Message) context.getBean("occupiedEmail"), HttpStatus.NOT_FOUND);
        } else {
            if (validateUserData(user)) {
                userRepository.save(user);
                return new ResponseEntity<>((Message) context.getBean("userIsSuccessfulRegistered"), HttpStatus.OK);
            } else return new ResponseEntity<>((Message) context.getBean("unacceptableEmailOrPassword"), HttpStatus.NOT_FOUND);
        }
    }

    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public boolean validateUserData(User user){
        return validatePassword(user.getPassword()) && validateEmail(user.getEmail());
    }

    public boolean validatePassword(String password) {
        Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,}$");
        Matcher passwordMatcher = passwordPattern.matcher(password);
        return passwordMatcher.matches();
    }

    public boolean validateEmail(String email) {
        Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
        Matcher emailMatcher = emailPattern.matcher(email);
        return emailMatcher.matches();
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        Pattern phoneNumberPattern = Pattern.compile("^\\+380[\\d]{9}$");
        Matcher phoneNumberMatcher = phoneNumberPattern.matcher(phoneNumber);
        return phoneNumberMatcher.matches();
    }

    public boolean validateName(String name) {
        Pattern namePattern = Pattern.compile("^[[\\w\\w\\p{IsCyrillic}[\\s]*]&&[\\D]]{5,20}$");
        Matcher nameMatcher = namePattern.matcher(name);
        return nameMatcher.matches();
    }

    private String generateNewPassword() {
        StringBuilder passwordBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            passwordBuilder.append((char) ((int) (Math.random() * 10) + 48));
        }
        for (int i = 0; i < 5; i++) {
            passwordBuilder.append((char) ((int) (Math.random() * 26) + 65));
        }
        return passwordBuilder.toString();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = findUserByEmail(s);
        if (user == null){
            throw new UsernameNotFoundException(s);
        }
        return new MyUserDetails(user);
    }
}
