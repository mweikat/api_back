package cl.back.api.src.auth.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {

    @Email(message = "{jakarta.validation.constraints.Email.message}")
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;
}