package cl.back.api.src.services.plan;

import cl.back.api.src.entities.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService{

    @Autowired
    private PlanRepository planRepository;

    @Override
    public List<Plan> getAll() {
        return planRepository.findByStatus('1');
    }
}
