package com.candidate.interview.hiringevent.runtime.controller;

import com.candidate.interview.hiringevent.runtime.model.JobDetails;
import com.candidate.interview.hiringevent.runtime.model.JobDetailsSkillSetMapping;
import com.candidate.interview.hiringevent.runtime.model.SkillSet;
import com.candidate.interview.hiringevent.runtime.service.JobDetailsSkillSetMappingModelService;
import com.candidate.interview.hiringevent.runtime.service.SkillSetModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/job-details-skill-set-mapping")
public class JobDetailsSkillSetMappingController extends AbstractRestController<JobDetailsSkillSetMapping, Integer> {
    @Autowired
    private JobDetailsSkillSetMappingModelService jobDetailsSkillSetMappingModelService;


    @PostMapping("/")
    @Override
    public ResponseEntity<JobDetailsSkillSetMapping> createResource(@RequestBody JobDetailsSkillSetMapping body,
                                                                     HttpServletRequest request) {
        JobDetailsSkillSetMapping jobDetailsSkillSetMapping = jobDetailsSkillSetMappingModelService.save(body);
        return ResponseEntity.ok(jobDetailsSkillSetMapping);
    }

    @Override
    public ResponseEntity<JobDetailsSkillSetMapping> updateResource(JobDetailsSkillSetMapping body, Integer id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<JobDetailsSkillSetMapping> getResource(Integer id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<List<JobDetailsSkillSetMapping>> getResources(HttpServletRequest request) {
        return null;
    }
    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Integer> deleteResource(@PathVariable("id") Integer id, HttpServletRequest request) {
        Boolean result = jobDetailsSkillSetMappingModelService.delete(id);
        return ResponseEntity.ok(1);
    }
}
