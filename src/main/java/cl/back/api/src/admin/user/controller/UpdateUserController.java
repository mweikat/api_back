package cl.back.api.src.admin.user.controller;

import cl.back.api.src.admin.user.application.UpdateUser;
import cl.back.api.src.admin.user.controller.request.UpdateUserRequest;
import cl.back.api.src.messages.UserMessage;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/api/v1/user")
public class UpdateUserController {

    @Autowired
    private UpdateUser updateUser;

    @PostMapping
    public ResponseEntity<String> UpdateUser(@Valid @RequestBody UpdateUserRequest updateUserRequest){

            updateUser.updateUser(updateUserRequest.getName(),updateUserRequest.getLastName());
            return ResponseEntity.ok("");

    }
}
