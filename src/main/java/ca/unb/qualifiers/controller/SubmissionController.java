package ca.unb.qualifiers.controller;

import ca.unb.qualifiers.exception.BadRequestException;
import ca.unb.qualifiers.model.Submission;
import ca.unb.qualifiers.model.User;
import ca.unb.qualifiers.repository.SubmissionRepository;
import ca.unb.qualifiers.service.SubmissionService;
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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;

@Controller
@EnableAutoConfiguration
public class SubmissionController {

    @Autowired
    SubmissionRepository submissionRepository;

    @Autowired
    SubmissionService submissionService;

    @PostMapping
    @ResponseBody
    public String uploadSubmission(@RequestParam MultipartFile file) {
        try {
            submissionService.store(file);
        } catch (IOException e) {
            throw new BadRequestException();
        }
        return "success";

    }

    @GetMapping(value = "/submissions/{filename:.+}")
    @ResponseBody
    public ResponseEntity<byte[]> getSubmission(@PathVariable  String filename) {
        Submission submission = submissionService.load(filename);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        ResponseEntity<byte[]> response = new ResponseEntity<>(submission.getData(), headers, HttpStatus.OK);
        return response;
    }

    @GetMapping("/submissions")
    @ResponseBody
    public Iterable<Submission> getSubmissions() {
        return submissionService.loadAll();
    }
}
