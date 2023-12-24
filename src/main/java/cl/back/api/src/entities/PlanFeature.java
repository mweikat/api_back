package cl.back.api.src.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "plans_features")
@Data
@AllArgsConstructor //genera automaticamente un constructor con argumentos
@NoArgsConstructor  //genera automaticamente un constructor sin argumentos
@Builder //crea instancia de la endidad
public class PlanFeature {

    @Id
    @Column
    private int id;

    @ManyToOne(targetEntity = Plan.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "plan_id")
    private Plan plan;

    @Column
    private String feature;

    @Column
    private char status;

    @Column
    private int order;

}
