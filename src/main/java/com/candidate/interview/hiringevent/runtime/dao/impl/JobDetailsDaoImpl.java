package com.candidate.interview.hiringevent.runtime.dao.impl;

import com.candidate.interview.hiringevent.runtime.dao.AbstractDaoImpl;
import com.candidate.interview.hiringevent.runtime.model.JobDetails;
import com.candidate.interview.hiringevent.runtime.model.SkillSet;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JobDetailsDaoImpl extends AbstractDaoImpl<JobDetails, Integer> {

    private final String INSERT = "INSERT INTO TBL_JOB_DETAILS(TITLE, DESCRIPTION,TEAM,MANAGER_EMAIL," +
            "NUM_OF_POSITIONS, RESOURCE_ID, CREATED_BY,MODIFIED_BY) " +
            "VALUES(?,?,?,?,?,?,?,?)";
    private final String DELETE = "DELETE FROM TBL_JOB_DETAILS WHERE ID=?";
    private final String SELECT_ONE = "SELECT * FROM TBL_JOB_DETAILS WHERE ID=?";
    private final String SELECT_ALL = "SELECT * FROM TBL_JOB_DETAILS";

    @Override
    public JobDetails insert(JobDetails jobDetails) {
        int rows = getJdbcTemplate().update(INSERT, new Object[]{jobDetails.getTitle(), jobDetails.getDescription(),
                jobDetails.getTeam(),jobDetails.getHiringManagerEmail(),jobDetails.getNumOfPositions(),
                jobDetails.getResourceId(),jobDetails.getCreatedBy(),jobDetails.getModifiedBy()});
        if (rows == 0)
            throw new RuntimeException("error while saving entity skillSet");
        return jobDetails;
    }

    @Override
    public JobDetails update(Integer id, JobDetails jobDetails) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return getJdbcTemplate().update(DELETE, new Object[]{id});
    }

    @Override
    public JobDetails select(Integer id) {
        return getJdbcTemplate().queryForObject(SELECT_ONE,jobDetailsRow, new Object[]{id});
    }

    @Override
    public List<JobDetails> selectAll() {
        return getJdbcTemplate().query(SELECT_ALL,jobDetailsRow);
    }

    private static final RowMapper<JobDetails> jobDetailsRow = (resultSet, i) -> {
        JobDetails jobDetails  = new JobDetails();
        jobDetails.setTitle(resultSet.getString("TITLE"));
        jobDetails.setDescription(resultSet.getString("DESCRIPTION"));
        jobDetails.setTeam(resultSet.getString("TEAM"));
        jobDetails.setHiringManagerEmail(resultSet.getString("MANAGER_EMAIL"));
        jobDetails.setNumOfPositions(resultSet.getInt("NUM_OF_POSITIONS"));
        jobDetails.setResourceId(resultSet.getString("RESOURCE_ID"));
        jobDetails.setCreatedBy(resultSet.getString("CREATED_BY"));
        jobDetails.setModifiedBy(resultSet.getLong("MODIFIED_BY"));
        return jobDetails;
    };
}