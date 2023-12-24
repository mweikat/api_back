package cl.back.api.src.auth.application;


import cl.back.api.src.auth.controller.response.LoginResponse;
import cl.back.api.src.security.JpaUserDetailsService;
import cl.back.api.src.security.JwtUtils;
import cl.back.api.src.security.UserSecurity;
import cl.back.api.src.utils.UserSesion;
import jakarta.servlet.http.Cookie;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
@RequiredArgsConstructor
public class UserLogin {

    private final AuthenticationManager authenticationManager;
    private final JpaUserDetailsService jpaUserDetailsService;
    private final JwtUtils jwtUtils;
    private String jwt;
    @Getter
    private Cookie cookie;
    @Autowired
    private UserSesion userSesion;

    public LoginResponse login(String email, String password){

        Cookie cookie = null;
        Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(email, password, new ArrayList<>()));

        final UserDetails user = jpaUserDetailsService.loadUserByUsername(email);

        if (user != null) {
            jwt = jwtUtils.generateToken(user);
            setCookie(jwt);
        }

        UserSecurity userSecurity = (UserSecurity) auth.getPrincipal();
        return new LoginResponse(userSecurity.getName(), userSecurity.getLastName(),userSecurity.getUsername(),jwt);
    }

    private void setCookie(String jwt){
        cookie = null;
        cookie = new Cookie("jwt", jwt);

        cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
//                cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/"); // Global

    }


}
