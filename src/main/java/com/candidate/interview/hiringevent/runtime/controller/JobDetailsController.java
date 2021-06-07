package com.candidate.interview.hiringevent.runtime.controller;

import com.candidate.interview.hiringevent.runtime.model.JobDetails;
import com.candidate.interview.hiringevent.runtime.model.SkillSet;
import com.candidate.interview.hiringevent.runtime.service.JobDetailsModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/job-details")
public class JobDetailsController extends AbstractRestController<JobDetails, Integer>{

    @Autowired
    private JobDetailsModelService jobDetailsModelService;

    @PostMapping("/")
    @Override
    public ResponseEntity<JobDetails> createResource(@RequestBody JobDetails body, HttpServletRequest request) {
        JobDetails jobdetails = jobDetailsModelService.save(body);
        return ResponseEntity.ok(body);
    }


    @PutMapping("/{id}")
    @Override
    public ResponseEntity<JobDetails> updateResource(@RequestBody JobDetails body, @PathVariable("id") Integer id,
            HttpServletRequest request) {
        body.setId(id);
        JobDetails jobDetails = jobDetailsModelService.updateById(id,body);
        return ResponseEntity.ok(jobDetails);
    }
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<JobDetails> getResource(@PathVariable("id") Integer id, HttpServletRequest request) {
        JobDetails skillSet = jobDetailsModelService.findById(id);

        return ResponseEntity.ok(skillSet);
    }
    @GetMapping("/")
    @Override
    public ResponseEntity<List<JobDetails>> getResources(HttpServletRequest request) {
        List<JobDetails> jobDetailsList = jobDetailsModelService.findAll();
        return ResponseEntity.ok(jobDetailsList);
    }
    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Integer> deleteResource(@PathVariable("id") Integer id, HttpServletRequest request) {
        Boolean result = jobDetailsModelService.delete(id);
        return ResponseEntity.ok(1);
    }
}
