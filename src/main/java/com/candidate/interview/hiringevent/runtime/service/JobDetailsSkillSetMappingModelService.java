package com.candidate.interview.hiringevent.runtime.service;


import com.candidate.interview.hiringevent.runtime.dao.impl.JobDetailsSkillSetMappingDaoImpl;
import com.candidate.interview.hiringevent.runtime.dao.impl.SkillSetDaoImpl;
import com.candidate.interview.hiringevent.runtime.mock.IUserInfoService;
import com.candidate.interview.hiringevent.runtime.model.JobDetailsSkillSetMapping;
import com.candidate.interview.hiringevent.runtime.model.SkillSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class JobDetailsSkillSetMappingModelService {
    @Autowired
    private JobDetailsSkillSetMappingDaoImpl skillSetMappingDao;

    @Autowired
    IUserInfoService userInfoService;

    public JobDetailsSkillSetMapping save(JobDetailsSkillSetMapping jobDetailsSkillSetMapping)
    {
        return skillSetMappingDao.insert(jobDetailsSkillSetMapping);
    }

    public boolean delete(Integer id)
    {
        return skillSetMappingDao.delete(id)!=0;
    }
}
