package ca.unb.qualifiers.service;

import ca.unb.qualifiers.model.Deliverable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface SubmissionService {
    Deliverable load(String filename);
    Iterable<Deliverable> loadAll();
    void add(Deliverable deliverable, MultipartFile file) throws IOException;
}
