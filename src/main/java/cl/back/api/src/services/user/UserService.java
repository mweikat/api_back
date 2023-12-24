package cl.back.api.src.services.user;

import cl.back.api.src.entities.User;

import java.util.UUID;

public interface UserService {

    public void userRegister(User user);
    public void updateUser(User user);
    public User getUserWhitEmail(String email);
    public User getUserById(UUID id);
    public void updatePassword(UUID id, String newPass);
    public void updateEmailVerificaction(UUID id);
    public void changePassword(UUID id, String newPass);


}
