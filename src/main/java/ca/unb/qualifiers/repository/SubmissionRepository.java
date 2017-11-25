package ca.unb.qualifiers.repository;

import ca.unb.qualifiers.model.Deliverable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubmissionRepository extends CrudRepository<Deliverable, Integer> {
    List<Deliverable> findByName(String name);
}
