package com.candidate.interview.hiringevent.runtime.dao.impl;

import com.candidate.interview.hiringevent.runtime.dao.AbstractDaoImpl;
import com.candidate.interview.hiringevent.runtime.model.Interview;
import com.candidate.interview.hiringevent.runtime.model.InterviewStatus;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class InterviewDetailsDaoImpl extends AbstractDaoImpl<Interview, Integer> {
    private final String INSERT = "INSERT INTO TBL_INTERVIEW_DETAILS(ID, TITLE, JOB_DETAILS_ID, CANDIDATE_EMAIL, " +
            "INTERVIEW_STATUS) VALUES (?,?,?,?,?)";
    private final String SELECT_ONE= "SELECT * FROM TBL_INTERVIEW_DETAILS WHERE ID=?";
    private final String SELECT_ALL= "SELECT * FROM TBL_INTERVIEW_DETAILS";

    @Override
    public Interview insert(Interview interview) {
        int rows = getJdbcTemplate().update(INSERT, new Object[]{interview.getId(),interview.getTitle(),
                interview.getJobDetailsId(),interview.getCandidateEmail(),interview.getStatus().name()});

        if (rows == 0)
            throw new RuntimeException("error while saving entity interview Details");
        return interview;
    }

    @Override
    public Interview update(Integer id, Interview interview) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }

    @Override
    public Interview select(Integer id) {
        return getJdbcTemplate().queryForObject(SELECT_ONE,interviewDetailsRow, new Object[]{id});
    }

    @Override
    public List<Interview> selectAll() {
        return getJdbcTemplate().query(SELECT_ALL,interviewDetailsRow);
    }

    private static final RowMapper<Interview> interviewDetailsRow = (resultSet, i) -> {
        Interview interview = new Interview();
        interview.setId(resultSet.getInt("ID"));
        interview.setTitle(resultSet.getString("TITLE"));
        interview.setJobDetailsId(resultSet.getInt("JOB_DETAILS_ID"));
        interview.setCandidateEmail(resultSet.getString("CANDIDATE_EMAIL"));
        InterviewStatus interviewStatus = InterviewStatus.valueOf(resultSet.getString("INTERVIEW_STATUS"));
        interview.setStatus(interviewStatus);
        return interview;
    };

}
