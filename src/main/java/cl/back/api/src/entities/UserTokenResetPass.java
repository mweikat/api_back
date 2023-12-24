package cl.back.api.src.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;
import java.util.Date;

@Entity
@Table(name = "user_token_reset_pass")
@Data
@AllArgsConstructor //genera automaticamente un constructor con argumentos
@NoArgsConstructor  //genera automaticamente un constructor sin argumentos
@Builder //crea instancia de la endidad
public class UserTokenResetPass {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(45)")
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    private UUID id;

    @Column
    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @Column(name="expired_date", insertable = false, updatable = false)
    private Date expiryDate;

}
