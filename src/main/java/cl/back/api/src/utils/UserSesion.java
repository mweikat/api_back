package cl.back.api.src.utils;


import cl.back.api.src.security.UserSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserSesion {

    private UserSecurity userSecurity;

    public UserSecurity getUserLogged(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        userSecurity = (UserSecurity) auth.getPrincipal();
        return userSecurity;
    }
}
