package cl.back.api.src.auth.controller.response;

import jakarta.servlet.http.Cookie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {

    private String name;
    private String lastName;
    private String email;
    private String token;
}
