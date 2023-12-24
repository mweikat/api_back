package cl.back.api.src.admin.user.application;


import cl.back.api.src.admin.user.controller.response.LoggedUserResponse;
import cl.back.api.src.security.UserSecurity;
import cl.back.api.src.utils.UserSesion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetLoggedUser {

    Logger logger = LoggerFactory.getLogger(GetLoggedUser.class);

    @Autowired
    private UserSesion userSesion;


    public LoggedUserResponse getLoggedUser(){
        UserSecurity userSecurity = userSesion.getUserLogged();
        return new LoggedUserResponse(userSecurity.getUsername(), userSecurity.getName(), userSecurity.getLastName());
    }

}
