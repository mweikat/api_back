package cl.back.api.src.plans.application;

import cl.back.api.src.entities.Plan;
import cl.back.api.src.plans.controllers.response.PlansResponse;
import cl.back.api.src.services.plan.PlanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GetPlans {

    @Autowired
    private PlanServiceImpl planServiceImpl;

    public ArrayList<PlansResponse> getAllPlans(){
        ArrayList<PlansResponse> arr = new ArrayList<>();
        List<Plan> plans = planServiceImpl.getAll();

       if(!plans.isEmpty()){
           for(Plan plan : plans){
               PlansResponse pr = new PlansResponse(plan.getId(),plan.getName(),plan.getPrice(),plan.getPrice_usd(),plan.getDesc());
               arr.add(pr);
           }
       }

        return arr;
    }

}
