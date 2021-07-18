package com.candidate.interview.hiringevent.runtime.controller;

import com.candidate.interview.hiringevent.runtime.model.InterviewRound;
import com.candidate.interview.hiringevent.runtime.model.SkillSet;
import com.candidate.interview.hiringevent.runtime.service.InterviewRoundModelService;
import com.candidate.interview.hiringevent.runtime.service.SkillSetModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/interview-round")
public class InterviewRoundController extends AbstractRestController<InterviewRound, Integer> {

    @Autowired
    private InterviewRoundModelService interviewRoundModelService;

    @PostMapping("/")
    @Override
    public ResponseEntity<InterviewRound> createResource(@RequestBody InterviewRound body, HttpServletRequest request) {
        InterviewRound interviewRound = interviewRoundModelService.save(body);
        return ResponseEntity.ok(interviewRound);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<InterviewRound> updateResource(@RequestBody InterviewRound body, @PathVariable("id") Integer id,
                                                   HttpServletRequest request) {
        body.setId(id);
        InterviewRound interviewRound = interviewRoundModelService.updateById(id,body);
        return ResponseEntity.ok(interviewRound);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<InterviewRound> getResource(@PathVariable("id") Integer id, HttpServletRequest request) {
        InterviewRound interviewRound = interviewRoundModelService.findById(id);

        return ResponseEntity.ok(interviewRound);
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<List<InterviewRound>> getResources(HttpServletRequest request) {
        List<InterviewRound> interviewRoundList = interviewRoundModelService.findAll();
        return ResponseEntity.ok(interviewRoundList);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Integer> deleteResource(@PathVariable("id") Integer id, HttpServletRequest request) {
        Boolean result = interviewRoundModelService.delete(id);
        return ResponseEntity.ok(1);
    }
}
