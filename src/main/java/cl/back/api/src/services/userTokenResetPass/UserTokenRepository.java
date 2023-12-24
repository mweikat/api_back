package cl.back.api.src.services.userTokenResetPass;

import cl.back.api.src.entities.UserTokenResetPass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserTokenRepository extends JpaRepository<UserTokenResetPass, UUID> {


    @Query("FROM UserTokenResetPass u where u.user.id = :id and expiryDate>= CURRENT_DATE()")
    Optional<UserTokenResetPass> getLastToken(@Param("id")UUID id);

    @Query("FROM UserTokenResetPass u where u.token = :token and expiryDate>= CURRENT_DATE()")
    Optional<UserTokenResetPass> isValid(@Param("token")String token);
}
