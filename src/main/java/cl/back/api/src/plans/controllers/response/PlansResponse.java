package cl.back.api.src.plans.controllers.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlansResponse {

    private int id;
    private String name;
    private int price;
    private float price_usd;
    private String desc;
}
