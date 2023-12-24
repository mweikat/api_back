package cl.back.api.src.services.plan;

import cl.back.api.src.entities.Plan;
import cl.back.api.src.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {

    List<Plan> findByStatus(char status);
}
