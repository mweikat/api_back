package cl.back.api.src.auth.controller.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResetChangePassRequest {

    @NotEmpty
    private String token;

    @NotEmpty
    @Size(min=6, max = 12)
    private String password;

}
