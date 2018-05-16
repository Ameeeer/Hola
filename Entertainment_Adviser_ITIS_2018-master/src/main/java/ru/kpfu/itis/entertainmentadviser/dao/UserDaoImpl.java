package ru.kpfu.itis.entertainmentadviser.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.entertainmentadviser.model.User;

import java.util.HashMap;
import java.util.Map;
@Component
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    RowMapper<User> userRowMapper;

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        String sqlQuery = "SELECT * FROM users WHERE username = :username";
        Map namedParameters = new HashMap();
        namedParameters.put("username", username);
        User user = namedParameterJdbcTemplate.queryForObject(sqlQuery, namedParameters, userRowMapper);
        return user;
    }
}
