package ca.unb.qualifiers.service;

import org.springframework.web.multipart.MultipartFile;

public interface SubmissionService {
    void store(MultipartFile file);
}
