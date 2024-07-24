package cl.back.api.src.auth.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterRequest {

    @NotEmpty
    @Size(min=2,max=30)
    private String name;

    @Size(min=2, max=30)
    private String lastName;

    @Email(message = "{jakarta.validation.constraints.Email.message}")
    @NotEmpty
    @Size(max=100)
    private String email;

    @NotEmpty
    @Size(min=6, max = 12)
    private String password;
}
