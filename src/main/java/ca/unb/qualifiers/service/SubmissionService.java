package ca.unb.qualifiers.service;

import ca.unb.qualifiers.model.Submission;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface SubmissionService {
    Submission load(String filename);
    Iterable<Submission> loadAll();
    void add(Submission submission, MultipartFile file) throws IOException;
}
