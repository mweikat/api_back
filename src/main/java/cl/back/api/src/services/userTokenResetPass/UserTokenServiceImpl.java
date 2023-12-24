package cl.back.api.src.services.userTokenResetPass;


import cl.back.api.src.entities.UserTokenResetPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserTokenServiceImpl implements UserTokenService{

    @Autowired
    private UserTokenRepository userTokenRepository;

    @Override
    public void createResetToken(UserTokenResetPass userTokenResetPass) {
        userTokenRepository.save(userTokenResetPass);
    }

    @Override
    public UserTokenResetPass getLast(UUID user_id) {
        Optional<UserTokenResetPass> resp =  userTokenRepository.getLastToken(user_id);
        return resp.orElse(null);
    }

    @Override
    public UserTokenResetPass isValidToken(String token) {
        Optional<UserTokenResetPass> resp =  userTokenRepository.isValid(token);
        return resp.orElse(null);
    }
}
