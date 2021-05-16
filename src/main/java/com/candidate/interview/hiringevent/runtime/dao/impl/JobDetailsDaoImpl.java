package com.candidate.interview.hiringevent.runtime.dao.impl;

import com.candidate.interview.hiringevent.runtime.dao.AbstractDaoImpl;
import com.candidate.interview.hiringevent.runtime.model.JobDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JobDetailsDaoImpl extends AbstractDaoImpl<JobDetails, Integer> {
    @Override
    public JobDetails insert(JobDetails jobDetails) {
        return null;
    }

    @Override
    public JobDetails update(Integer id, JobDetails jobDetails) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }

    @Override
    public JobDetails select(Integer id) {
        return null;
    }

    @Override
    public List<JobDetails> selectAll() {
        return null;
    }
}
