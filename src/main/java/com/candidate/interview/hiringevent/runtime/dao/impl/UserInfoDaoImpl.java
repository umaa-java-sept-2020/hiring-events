package com.candidate.interview.hiringevent.runtime.dao.impl;

import com.candidate.interview.hiringevent.runtime.dao.AbstractDaoImpl;
import com.candidate.interview.hiringevent.runtime.model.LoginProvider;
import com.candidate.interview.hiringevent.runtime.model.UserInfo;
import com.candidate.interview.hiringevent.runtime.model.UserType;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
// EMAIL_ID VARCHAR(256) PRIMARY KEY,
//         USER_TYPE ENUM ('CANDIDATE', 'INTERVIEWER'),
//         MOCK_USER TINYINT,
//         LOGIN_PROVIDER ENUM ('DATABASE','GITHUB','MOCK')
public class UserInfoDaoImpl extends AbstractDaoImpl<UserInfo, Integer> {

    private final String INSERT = "INSERT INTO TBL_USER_INFO(EMAIL_ID, USER_TYPE, MOCK_USER,LOGIN_PROVIDER) VALUES " +
            "(?,?,?,?)";
    private final String SELECT_ALL = "SELECT * FROM TBL_USER_INFO";
    @Override
    public UserInfo insert(UserInfo userInfo) {
        int rows = getJdbcTemplate().update(INSERT, new Object[]{userInfo.getEmail(),userInfo.getUserType(),
        userInfo.isMockUser(),userInfo.getLoginProvider()});
        if (rows == 0)
            throw new RuntimeException("error while saving entity skillSet");
        return userInfo;
    }

    @Override
    public UserInfo update(Integer id, UserInfo userInfo) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }

    @Override
    public UserInfo select(Integer id) {
        return null;
    }

    @Override
    public List<UserInfo> selectAll() {
        return getJdbcTemplate().query(SELECT_ALL, userInfoRow);
    }

    private static final RowMapper<UserInfo> userInfoRow = (resultSet, i) -> {
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail(resultSet.getString("EMAIL_ID"));
        UserType userType = UserType.valueOf(resultSet.getString("USER_TYPE"));
        userInfo.setUserType(userType);
        userInfo.setMockUser(resultSet.getBoolean("MOCK_USER"));
        LoginProvider loginProvider = LoginProvider.valueOf(resultSet.getString("LOGIN_PROVIDER"));
        userInfo.setLoginProvider(loginProvider);

        return userInfo;
    };
}
