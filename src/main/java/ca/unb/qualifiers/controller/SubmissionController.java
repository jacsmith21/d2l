package ca.unb.qualifiers.controller;

import ca.unb.qualifiers.model.Submission;
import ca.unb.qualifiers.model.User;
import ca.unb.qualifiers.repository.SubmissionRepository;
import ca.unb.qualifiers.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SubmissionController {

    @Autowired
    SubmissionRepository submissionRepository;

    @Autowired
    SubmissionService submissionService;

    @GetMapping("/submissions")
    @ResponseBody
    public Iterable<Submission> getSubmissions() {
        return submissionRepository.findAll();
    }
}
