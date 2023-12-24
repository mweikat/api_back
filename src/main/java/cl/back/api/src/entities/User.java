package cl.back.api.src.entities;

import cl.back.api.src.utils.Encrypt;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor //genera automaticamente un constructor con argumentos
@NoArgsConstructor  //genera automaticamente un constructor sin argumentos
@Builder //crea instancia de la endidad
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(45)")
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    private UUID id;
    private String name;
    private String last_name;
    private String email;
    //@Nullable
    private Date email_verified_at;
    private String password;
    @Transient
    private Date created_at;
    @Transient
    private Date updated_at;

    @Transient
    private Collection rol = new ArrayList<String>() {{ add("ROLE_ADMIN"); add("ADMIN"); add("3"); }};

    /**methods**/

    public String getRoles(){
        return rol.toString();
    }
}
