package ca.unb.qualifiers.service;

import ca.unb.qualifiers.controller.SubmissionController;
import ca.unb.qualifiers.exception.InternalServerErrorException;
import ca.unb.qualifiers.exception.NotFoundException;
import ca.unb.qualifiers.model.Submission;
import ca.unb.qualifiers.model.Upload;
import ca.unb.qualifiers.repository.SubmissionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class SubmissionServiceImpl implements SubmissionService {
    private static final Logger LOG = LoggerFactory.getLogger(SubmissionServiceImpl.class);

    @Autowired
    SubmissionRepository submissionRepository;

    @Override
    public void add(Submission submission, MultipartFile file) throws IOException {
        Upload upload = new Upload();
        upload.setName(file.getOriginalFilename());
        upload.setData(file.getBytes());

        submission.getUploads().add(upload);
        submissionRepository.save(submission);
    }

    @Override
    public Submission load(String filename) {
        List<Submission> submissions = submissionRepository.findByName(filename);
        if(submissions.size() == 0) {
            LOG.warn("there are no files named {}", filename);
            throw new NotFoundException();
        }

        if(submissions.size() > 1) {
            LOG.warn("there are too many file named {} -> {}", filename, submissions.size());
            throw new InternalServerErrorException();
        }

        return submissions.get(0);
    }

    @Override
    public Iterable<Submission> loadAll() {
        return null;
    }
}
