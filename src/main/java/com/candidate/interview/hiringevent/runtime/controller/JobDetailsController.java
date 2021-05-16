package com.candidate.interview.hiringevent.runtime.controller;

import com.candidate.interview.hiringevent.runtime.model.JobDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/job-details")
public class JobDetailsController extends AbstractRestController<JobDetails, Integer>{

    @Override
    public ResponseEntity<JobDetails> createResource(JobDetails body, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<JobDetails> updateResource(JobDetails body, Integer id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<List<JobDetails>> getResource(Integer id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<List<JobDetails>> getResources(HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Integer> deleteResource(Integer id, HttpServletRequest request) {
        return null;
    }
}
