package cl.back.api.src.auth.controller;


import cl.back.api.src.auth.application.UserLogin;
import cl.back.api.src.auth.controller.request.LoginRequest;
import cl.back.api.src.auth.controller.response.LoginResponse;
import cl.back.api.src.messages.AuthMessages;
import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping( value = "/api/v1/auth")
//@RequiredArgsConstructor
public class LoginController {

    @Autowired
    private UserLogin userLogin;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request, HttpServletResponse response) {

        LoginResponse lur = userLogin.login(request.getEmail(), request.getPassword());
        response.addCookie(userLogin.getCookie());
        return ResponseEntity.ok(lur);

    }
}
