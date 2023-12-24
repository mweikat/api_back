package cl.back.api.src.auth.controller;

import cl.back.api.src.auth.application.UserResetPassEmail;
import cl.back.api.src.auth.controller.request.ResetPassEmailRequest;
import cl.back.api.src.auth.controller.request.ResetChangePassRequest;
import cl.back.api.src.messages.AuthMessages;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class ResetPasswordController {

    @Autowired
    private UserResetPassEmail userResetPassEmail;

    @PostMapping("/reset_pass/mail")
    public ResponseEntity<String> reset_pass_email(@Valid @RequestBody ResetPassEmailRequest resetPassEmailRequest) {

        userResetPassEmail.userResetPass(resetPassEmailRequest.getEmail());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(AuthMessages.USER_CHANGEPASS_EMAIL);
    }

    @GetMapping("/reset_pass/mail_confirm/{token}")
    public ResponseEntity<String> reset_pass_confirm(@PathVariable String token){
        
        if(userResetPassEmail.userResetConfirm(token))
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("");
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(AuthMessages.USER_NOT_VALID_TOKEN);
    }

    @PostMapping("/reset_pass/mail/change_pass")
    public ResponseEntity<String> reset_change_pass(@Valid @RequestBody ResetChangePassRequest resetchangePassRequest) {

        if(userResetPassEmail.changePass(resetchangePassRequest.getToken(),resetchangePassRequest.getPassword()))
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("AuthMessages");
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(AuthMessages.USER_NOT_VALID_TOKEN);
    }

}
