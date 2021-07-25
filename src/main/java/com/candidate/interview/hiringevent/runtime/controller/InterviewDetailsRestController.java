package com.candidate.interview.hiringevent.runtime.controller;

import com.candidate.interview.hiringevent.runtime.model.Interview;
import com.candidate.interview.hiringevent.runtime.model.JobDetails;
import com.candidate.interview.hiringevent.runtime.model.UserInfo;
import com.candidate.interview.hiringevent.runtime.service.InterviewDetailsModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/interview-status")
public class InterviewDetailsRestController extends AbstractRestController<Interview, Integer> {

    @Autowired
    private InterviewDetailsModelService interviewDetailsModelService;

    @PostMapping("/")
    @Override
    public ResponseEntity<Interview> createResource(@RequestBody Interview body, HttpServletRequest request) {
        Interview interview = interviewDetailsModelService.save(body);
        return ResponseEntity.ok(interview);
    }


    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Interview> getResource(@PathVariable("id") Integer id, HttpServletRequest request) {
        Interview interview = interviewDetailsModelService.findById(id);

        return ResponseEntity.ok(interview);
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<List<Interview>> getResources(HttpServletRequest request) {
        List<Interview> interviewList = interviewDetailsModelService.findAll();
        return ResponseEntity.ok(interviewList);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Interview> updateResource(@RequestBody Interview body, @PathVariable("id") Integer id,
                                                   HttpServletRequest request) {
        body.setId(id);
        Interview interview = interviewDetailsModelService.updateById(id,body);
        return ResponseEntity.ok(interview);
    }


    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Integer> deleteResource(@PathVariable("id") Integer id, HttpServletRequest request) {
        Boolean result = interviewDetailsModelService.delete(id);
        return ResponseEntity.ok(1);
    }

}
