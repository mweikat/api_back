package cl.back.api.src.admin.user.controller.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
@NoArgsConstructor
public class UpdateUserRequest {

    @NotEmpty()
    @Size(min=3,max = 30)
    private String name;


    @Nullable
    @Size(max = 30)
    private String lastName;

}
