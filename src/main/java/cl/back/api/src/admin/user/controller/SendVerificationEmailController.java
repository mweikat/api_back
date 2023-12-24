package cl.back.api.src.admin.user.controller;

import cl.back.api.src.admin.user.application.SendVerificationEmail;
import cl.back.api.src.admin.user.controller.response.LoggedUserResponse;
import cl.back.api.src.messages.AuthMessages;
import cl.back.api.src.messages.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/api/v1/user/send-verification-email")
public class SendVerificationEmailController {

    @Autowired
    private SendVerificationEmail sendVerificationEmail;

    @GetMapping
    public ResponseEntity<String> sendVerificationEmail(){
        sendVerificationEmail.sendEmail();
        return ResponseEntity.status(HttpStatus.OK).body(UserMessage.VERIFICATION_EMAIL_SEND);
    }
}
