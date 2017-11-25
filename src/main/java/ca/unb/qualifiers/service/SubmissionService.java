package ca.unb.qualifiers.service;

import ca.unb.qualifiers.model.Submission;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface SubmissionService {
    void store(MultipartFile file) throws IOException;
    Submission load(String filename);
    Iterable<Submission> loadAll();
}
