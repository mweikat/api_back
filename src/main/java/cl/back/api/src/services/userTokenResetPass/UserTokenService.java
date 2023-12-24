package cl.back.api.src.services.userTokenResetPass;

import cl.back.api.src.entities.User;
import cl.back.api.src.entities.UserTokenResetPass;

import java.util.UUID;

public interface UserTokenService {

    public void createResetToken(UserTokenResetPass userTokenResetPass);

    public UserTokenResetPass getLast(UUID user_id);

    public UserTokenResetPass isValidToken(String token);

}
