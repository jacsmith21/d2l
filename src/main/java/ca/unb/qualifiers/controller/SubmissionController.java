package ca.unb.qualifiers.controller;

import ca.unb.qualifiers.exception.BadRequestException;
import ca.unb.qualifiers.model.Course;
import ca.unb.qualifiers.model.Submission;
import ca.unb.qualifiers.model.Upload;
import ca.unb.qualifiers.model.User;
import ca.unb.qualifiers.repository.CourseRepository;
import ca.unb.qualifiers.repository.SubmissionRepository;
import ca.unb.qualifiers.repository.UploadRepository;
import ca.unb.qualifiers.repository.UserRepository;
import ca.unb.qualifiers.service.SubmissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Controller
@EnableAutoConfiguration
public class SubmissionController {
    private static final Logger LOG = LoggerFactory.getLogger(SubmissionController.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    UploadRepository uploadRepository;

    @Autowired
    SubmissionService submissionService;

    @Autowired
    SubmissionRepository submissionRepository;

    @PostMapping("/submissions/{submissionId}")
    @ResponseBody
    public String uploadSubmission(@PathVariable Integer submissionId, @RequestParam("file") MultipartFile file, Principal principal) {
        LOG.info("uploadSubmission - starting - file.name: {}", file.getOriginalFilename());

        User student = userRepository.findByUsername(principal.getName());

        Submission submission = submissionRepository.findOne(submissionId);
        Course course = submission.getCourse();
        if(!student.inCourse(course)) {
            throw new BadRequestException();
        }

        try {
            submissionService.add(submission, file);
        } catch (IOException e) {
            LOG.error("can't store the file : {}", e);
            throw new BadRequestException();
        }
        return "success";
    }

    @GetMapping(value = "/uploads/{uploadId}")
    @ResponseBody
    public ResponseEntity<byte[]> getUpload(@PathVariable Integer uploadId) {
        LOG.info("getUpload - starting - uploadId {}", uploadId);

        Upload upload = uploadRepository.findOne(uploadId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        headers.setContentDispositionFormData(upload.getName(), upload.getName());
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return new ResponseEntity<>(upload.getData(), headers, HttpStatus.OK);
    }

    @GetMapping("/submissions/{submissionId}")
    @ResponseBody
    public Iterable<Submission> getSubmissions() {
        LOG.debug("getSubmissions - starting");
        return submissionService.loadAll();
    }
}
