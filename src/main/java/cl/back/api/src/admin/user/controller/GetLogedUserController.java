package cl.back.api.src.admin.user.controller;

import cl.back.api.src.admin.user.application.GetLoggedUser;
import cl.back.api.src.admin.user.controller.response.LoggedUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/api/v1/user")
public class GetLogedUserController {

    @Autowired
    private GetLoggedUser getLoggedUser;
    @GetMapping
    public ResponseEntity<LoggedUserResponse> getUser(){
        return ResponseEntity.ok(getLoggedUser.getLoggedUser());
    }

}
