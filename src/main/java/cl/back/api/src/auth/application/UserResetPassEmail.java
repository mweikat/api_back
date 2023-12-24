package cl.back.api.src.auth.application;

import cl.back.api.src.entities.UserTokenResetPass;
import cl.back.api.src.exceptions.customs.UserNotExistHandler;
import cl.back.api.src.services.user.UserServiceImpl;
import cl.back.api.src.services.userTokenResetPass.UserTokenServiceImpl;
import cl.back.api.src.utils.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import cl.back.api.src.entities.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
public class UserResetPassEmail {

    @Autowired
    private UserTokenServiceImpl userTokenService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private Encrypt encrypt;

    @Transactional
    public void userResetPass(String email){
        User user = userService.getUserWhitEmail(email);

        if(user==null)
            throw new UserNotExistHandler();

        UserTokenResetPass userTokenResetPassLast = userTokenService.getLast(user.getId());

        if(userTokenResetPassLast==null) {
            String token = UUID.randomUUID().toString();

            UserTokenResetPass userTokenResetPass = new UserTokenResetPass();
            userTokenResetPass.setToken(token);
            userTokenResetPass.setUser(user);

            userTokenService.createResetToken(userTokenResetPass);
        }
        //send email

    }

    public boolean userResetConfirm(String token){


        return userTokenService.isValidToken(token) != null;
    }

    public boolean changePass(String token, String password){

        UserTokenResetPass userTokenResetPassLast = userTokenService.isValidToken(token);

        if(userTokenResetPassLast!=null){
            userService.changePassword(userTokenResetPassLast.getUser().getId(),encrypt.getPasswordEncrypt(password));
            return true;
        }else
            return false;

    }
}
