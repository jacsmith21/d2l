package ca.unb.qualifiers.repository;

import ca.unb.qualifiers.model.Submission;
import ca.unb.qualifiers.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubmissionRepository extends CrudRepository<Submission, Integer> {
    List<Submission> findByName(String name);
}
