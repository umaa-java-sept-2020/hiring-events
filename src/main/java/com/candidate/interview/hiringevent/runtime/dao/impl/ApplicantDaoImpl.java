package com.candidate.interview.hiringevent.runtime.dao.impl;

import com.candidate.interview.hiringevent.runtime.dao.AbstractDaoImpl;
import com.candidate.interview.hiringevent.runtime.model.Applicant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApplicantDaoImpl extends AbstractDaoImpl<Applicant, Integer> {
    private final String INSERT = "INSERT INTO TBL_JOB_APPLICANT(PAN_CARD, JOB_ID, EMAIL, RESUME_PATH, " +
            "STATUS) VALUES (?,?,?,?,?)";
    @Override
    public Applicant insert(Applicant applicant) {
        System.out.println(applicant.getJobId());
        System.out.println(applicant.getEmailId());
        System.out.println(applicant.getResumePath());
        getJdbcTemplate().update(INSERT, new Object[]{applicant.getPanCard(), applicant.getJobId(),
                applicant.getEmailId(), applicant.getResumePath(), applicant.getStatus().name()});
        return applicant;
    }

    @Override
    public Applicant update(Integer id, Applicant applicant) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }

    @Override
    public Applicant select(Integer id) {
        return null;
    }

    @Override
    public List<Applicant> selectAll() {
        return null;
    }
}
