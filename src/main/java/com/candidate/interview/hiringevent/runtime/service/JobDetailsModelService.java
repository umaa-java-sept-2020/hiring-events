package com.candidate.interview.hiringevent.runtime.service;

import com.candidate.interview.hiringevent.runtime.dao.impl.JobDetailsDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobDetailsModelService {

    @Autowired
    private JobDetailsDaoImpl jobDetailsDao;
}
