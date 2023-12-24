package cl.back.api.src.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "plans")
@Data
@AllArgsConstructor //genera automaticamente un constructor con argumentos
@NoArgsConstructor  //genera automaticamente un constructor sin argumentos
@Builder //crea instancia de la endidad
public class Plan {

    @Id
    @Column
    private int id;

    @Column
    private String name;
    @Column
    private int price;
    @Column
    private float price_usd;
    @Column
    private String desc;
    @Column
    private char status;



}
