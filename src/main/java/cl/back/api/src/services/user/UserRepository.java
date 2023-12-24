package cl.back.api.src.services.user;


import cl.back.api.src.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);

    @Modifying
    @Query("update User u set u.email_verified_at=CURRENT_TIMESTAMP() where u.id= :id")
    void updateEmailVerification(@Param("id")UUID id);

    @Modifying
    @Query("update User u set u.password = :newPass where u.id = :id")
    void updatePassword(@Param("id")UUID id, @Param("newPass")String newPassword);

    @Modifying
    @Query("update User u set u.password = :newPass where u.id = :user_id")
    void changePassword(@Param("user_id")UUID id, @Param("newPass")String newPassword);

}
