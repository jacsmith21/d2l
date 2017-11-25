package ca.unb.qualifiers.service;

import ca.unb.qualifiers.exception.InternalServerErrorException;
import ca.unb.qualifiers.exception.NotFoundException;
import ca.unb.qualifiers.model.Submission;
import ca.unb.qualifiers.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    @Autowired
    SubmissionRepository submissionRepository;

    @Override
    public void store(MultipartFile file) throws IOException {
        Submission submission = new Submission();
        submission.setName(file.getOriginalFilename());
        submission.setData(file.getBytes());
        submissionRepository.save(submission);
    }

    @Override
    public Submission load(String filename) {
        List<Submission> submissions = submissionRepository.findByName(filename);
        if(submissions.size() == 0) {
            throw new NotFoundException();
        }

        if(submissions.size() > 1) {
            throw new InternalServerErrorException();
        }

        return submissions.get(0);
    }

    @Override
    public Iterable<Submission> loadAll() {
        return null;
    }
}
