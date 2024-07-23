package cl.back.api.src.auth.controller;


import cl.back.api.src.auth.application.UserRegistration;
import cl.back.api.src.auth.controller.request.RegisterRequest;
import cl.back.api.src.auth.controller.response.RegisterResponse;
import cl.back.api.src.messages.AuthMessages;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static cl.back.api.src.messages.AuthMessages.USER_CREATE_OK;

@RestController
@RequestMapping("/api/v1/auth")
public class RegistrationController {
    Logger logger = LoggerFactory.getLogger(RegistrationController.class);
    @Autowired
    private UserRegistration userRegistration;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest registerData) {
        //logger.debug("entra por a register",registerData);
        RegisterResponse rr = new RegisterResponse(USER_CREATE_OK);
        userRegistration.register(registerData.getName(),registerData.getLastName(),registerData.getEmail(),registerData.getPassword());
        //return ResponseEntity.status(HttpStatus.CREATED).body(AuthMessages.USER_CREATE_OK);
        return ResponseEntity.ok(rr);
    }

    @GetMapping("/validate_email/{user_id}")
    public ResponseEntity<String> validateEmail(@PathVariable UUID user_id){
        boolean resp = userRegistration.validateEmail(user_id);
        if(resp)
            return ResponseEntity.status(HttpStatus.OK).body(AuthMessages.USER_VALIDATE_EMAIL);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(AuthMessages.USER_NOT_EXISTS);
    }

}
