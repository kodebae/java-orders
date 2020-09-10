package javaorders.app.repositories;

import javaorders.app.models.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentRepository extends CrudRepository <Agent, Long> {
}
