package com.candidate.interview.hiringevent.runtime.service;


import com.candidate.interview.hiringevent.runtime.dao.impl.ApplicantDaoImpl;
import com.candidate.interview.hiringevent.runtime.dao.impl.InterviewDetailsDaoImpl;
import com.candidate.interview.hiringevent.runtime.mock.IUserInfoService;
import com.candidate.interview.hiringevent.runtime.model.Applicant;
import com.candidate.interview.hiringevent.runtime.model.ApplicatStatus;
import com.candidate.interview.hiringevent.runtime.model.Interview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ApplicantModelService {
    @Autowired
    private ApplicantDaoImpl applicantDao;

    public Applicant save(Applicant applicant)
    {
        applicant.setStatus(ApplicatStatus.SUBMITTED);
        return applicantDao.insert(applicant);
    }
}
