package cl.back.api.src.admin.user.application;

import cl.back.api.src.exceptions.customs.UserWrongOldPassHandler;
import cl.back.api.src.security.UserSecurity;
import cl.back.api.src.services.user.UserServiceImpl;
import cl.back.api.src.utils.Encrypt;
import cl.back.api.src.utils.UserSesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UpdatePassword {

    @Autowired
    private UserSesion userSesion;
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private Encrypt encrypt;


    @Transactional
    public void updatePassword(String oldPassword, String newPassword){
        UserSecurity user = userSesion.getUserLogged();

        if(encrypt.comparaPass(oldPassword,user.getPassword())){
            String encNewPass = encrypt.getPasswordEncrypt(newPassword);
            userService.updatePassword(user.getId(),encNewPass);
        }else
            throw new UserWrongOldPassHandler();



    }
}
