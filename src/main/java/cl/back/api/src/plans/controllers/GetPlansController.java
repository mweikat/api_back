package cl.back.api.src.plans.controllers;

import cl.back.api.src.plans.application.GetPlans;
import cl.back.api.src.plans.controllers.response.PlansResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping( value = "/api/v1/plans")
public class GetPlansController {

    @Autowired
    private GetPlans getPlans;

    @GetMapping
    public ResponseEntity<ArrayList<PlansResponse>> getUser(){
        return ResponseEntity.ok(getPlans.getAllPlans());
    }
}
