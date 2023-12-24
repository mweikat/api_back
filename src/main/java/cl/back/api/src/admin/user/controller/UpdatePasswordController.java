package cl.back.api.src.admin.user.controller;

import cl.back.api.src.admin.user.application.UpdatePassword;
import cl.back.api.src.admin.user.controller.request.UpdatePasswordRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/api/v1/user/password")
public class UpdatePasswordController {

    @Autowired
    private UpdatePassword updatePassword;

    @PostMapping
    public ResponseEntity<String> UpdatePassword(@Valid @RequestBody UpdatePasswordRequest updatePasswordRequest){
        //try {
            updatePassword.updatePassword(updatePasswordRequest.getOldPassword(), updatePasswordRequest.getNewPassword());
            return ResponseEntity.ok("");
        //}catch (Exception e){
         //   return ResponseEntity.ok(e.getMessage());
       // }
    }
}
