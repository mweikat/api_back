package cl.back.api.src.admin.user.application;

import cl.back.api.src.services.user.UserServiceImpl;
import cl.back.api.src.utils.UserSesion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import cl.back.api.src.entities.User;
@Component
public class UpdateUser {

    //Logger logger = LoggerFactory.getLogger(GetLoggedUser.class);
    @Autowired
    private UserSesion userSesion;
    @Autowired
    private UserServiceImpl userService;
    public void updateUser(String name, String lastName){
        User userToUpdate = userService.getUserWhitEmail(userSesion.getUserLogged().getUsername());
        userToUpdate.setName(name);
        userToUpdate.setLast_name(lastName);
        userService.updateUser(userToUpdate);
    }
}
