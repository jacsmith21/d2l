package ca.unb.qualifiers.repository;

import ca.unb.qualifiers.model.Submission;
import ca.unb.qualifiers.model.User;
import org.springframework.data.repository.CrudRepository;

public interface SubmissionRepository extends CrudRepository<Submission, Integer> {
}
