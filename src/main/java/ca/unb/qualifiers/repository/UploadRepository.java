package ca.unb.qualifiers.repository;

import ca.unb.qualifiers.model.Upload;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UploadRepository extends CrudRepository<Upload, Integer> {
    List<Upload> findByName(String name);
}
