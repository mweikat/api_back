package cl.back.api.src.admin.user.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter
@AllArgsConstructor
public class LoggedUserResponse {

    private String email;
    private String name;
    private String lastName;

}
