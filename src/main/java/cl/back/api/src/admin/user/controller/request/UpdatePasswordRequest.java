package cl.back.api.src.admin.user.controller.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdatePasswordRequest {

    @NotEmpty()
    @Size(min=6,max = 12)
    private String oldPassword;

    @NotEmpty()
    @Size(min=6,max = 12)
    private String newPassword;
}
