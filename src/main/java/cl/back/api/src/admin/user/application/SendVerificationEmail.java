package cl.back.api.src.admin.user.application;

import cl.back.api.src.utils.UserSesion;
import cl.back.api.src.utils.mail.EmailDetails;
import cl.back.api.src.utils.mail.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendVerificationEmail {

    @Autowired
    private UserSesion userSesion;
    @Autowired
    private EmailServiceImpl emailServiceImpl;
    public void sendEmail(){

        EmailDetails ed = new EmailDetails();
        ed.setSubject("test");
        ed.setRecipient(userSesion.getUserLogged().getUsername());
        ed.setMsgBody("Test for backend");
        emailServiceImpl.sendSimpleMail(ed);
    }

}
