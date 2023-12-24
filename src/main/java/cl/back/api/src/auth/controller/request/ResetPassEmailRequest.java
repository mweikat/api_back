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
public class ResetPassEmailRequest {

    @Email
    @NotEmpty
    @Size(max=100)
    private String email;


}
