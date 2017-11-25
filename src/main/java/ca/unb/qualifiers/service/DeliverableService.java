package ca.unb.qualifiers.service;

import ca.unb.qualifiers.model.Deliverable;
import ca.unb.qualifiers.model.Upload;
import ca.unb.qualifiers.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DeliverableService {
    Deliverable load(String filename);
    Iterable<Deliverable> loadAll();
    void add(Deliverable deliverable, User student, MultipartFile file) throws IOException;
    Iterable<Upload> loadAll(Integer deliverableId);
}
