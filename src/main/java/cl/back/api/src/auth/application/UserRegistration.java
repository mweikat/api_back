package cl.back.api.src.auth.application;


import cl.back.api.src.entities.User;
import cl.back.api.src.services.user.UserServiceImpl;
import cl.back.api.src.utils.Encrypt;
import cl.back.api.src.utils.mail.EmailDetails;
import cl.back.api.src.utils.mail.EmailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
public class UserRegistration {

    Logger logger = LoggerFactory.getLogger(UserRegistration.class);

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private Encrypt encrypt;
    @Autowired
    private EmailServiceImpl emailServiceImpl;

    @Transactional
    public void register(String name, String lastName, String email, String password){

        User user = new User();
        user.setName(name);
        user.setLast_name(lastName);
        user.setEmail(email);
        user.setPassword(encrypt.getPasswordEncrypt(password));

        //logger.debug("user [{}]",user);

        userService.userRegister(user);

        //send mail to verify account
        EmailDetails ed = new EmailDetails();
        ed.setSubject("test");
        ed.setRecipient("mweikat@gmail.com");
        ed.setMsgBody("Test for backend");
        emailServiceImpl.sendSimpleMail(ed);


    }

    @Transactional
    public boolean validateEmail(UUID userId){

        User u = userService.getUserById(userId);
        if(u!=null){
            if(u.getEmail_verified_at()==null)
                userService.updateEmailVerificaction(userId);
            return true;
        }else
            return false;
    }
}
