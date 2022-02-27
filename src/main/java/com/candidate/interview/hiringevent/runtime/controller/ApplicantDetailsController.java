package com.candidate.interview.hiringevent.runtime.controller;

import com.candidate.interview.hiringevent.runtime.dao.impl.ApplicantDaoImpl;
import com.candidate.interview.hiringevent.runtime.model.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/applicant")

public class ApplicantDetailsController extends AbstractRestController<Applicant, Integer>{
    @Autowired
    private ApplicantDaoImpl applicantModelService;

    @PostMapping("/")
    @Override
    public ResponseEntity<Applicant> createResource(@RequestBody Applicant body, HttpServletRequest request) {
        Applicant applicant = applicantModelService.insert(body);
        return ResponseEntity.ok(applicant);
    }

    @Override
    public ResponseEntity<Applicant> updateResource(Applicant body, Integer id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Applicant> getResource(Integer id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<List<Applicant>> getResources(HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Integer> deleteResource(Integer id, HttpServletRequest request) {
        return null;
    }
}
