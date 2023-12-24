package cl.back.api.src.services.user;

import cl.back.api.src.exceptions.customs.UserExistHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import cl.back.api.src.entities.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public User getUserWhitEmail(String email){
        Optional<User> user =  userRepository.findByEmail(email);
        return user.orElse(null);
    }

    @Override
    public User getUserById(UUID id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public void userRegister(User user) {
        try {
            userRepository.save(user);
        }catch (DataIntegrityViolationException ex){
            throw new UserExistHandler();
        }

    }

    public void updateUser(User user) {
        userRepository.save(user);

    }

    public void updatePassword(UUID id, String newPass){
        userRepository.updatePassword(id,newPass);
    }

    @Override
    public void updateEmailVerificaction(UUID id) {
        userRepository.updateEmailVerification(id);
    }

    @Override
    public void changePassword(UUID id, String newPass) {
        userRepository.changePassword(id, newPass);
    }


}
