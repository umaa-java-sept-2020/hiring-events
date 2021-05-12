package com.candidate.interview.hiringevent.runtime.controller;

import com.candidate.interview.hiringevent.runtime.model.SkillSet;
import com.candidate.interview.hiringevent.runtime.service.SkillSetModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillsRestController extends AbstractRestController<SkillSet, Integer> {

    @Autowired
    private SkillSetModelService skillSetModelService;

    @PostMapping("/")
    @Override
    public ResponseEntity<SkillSet> createResource(SkillSet body, HttpServletRequest request) {
        SkillSet skillSet = skillSetModelService.save(body);
        return ResponseEntity.ok(body);
    }

    @Override
    public ResponseEntity<SkillSet> updateResource(SkillSet body, Integer id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<List<SkillSet>> getResource(Integer id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<List<SkillSet>> getResources(HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Integer> deleteResource(Integer id, HttpServletRequest request) {
        Boolean result = skillSetModelService.delete(id);
        return ResponseEntity.ok(1);
    }
}
