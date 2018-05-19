package ru.kpfu.itis.entertainmentadviser.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.entertainmentadviser.dao.mapper.EventRowMapper;
import ru.kpfu.itis.entertainmentadviser.model.Event;
import ru.kpfu.itis.entertainmentadviser.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EventDaoimpl implements EventDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Event> findall() {
        String sqlQuery = "SELECT * FROM event";
        List<Event> events = jdbcTemplate.query(sqlQuery, new EventRowMapper());
        return events;
    }

    @Override
    public Event save(Event event) {
        return null;
    }

    @Override
    public List<Event> AllInfoAboutEventbyid(Long id) {
        String sqlQuery = "SELECT *FROM event WHERE id = ? ORDER BY id";
        Object[] arr = {id};
        return jdbcTemplate.query(sqlQuery, arr, new EventRowMapper());
    }

    @Override
    public Event iGo(Event event, User user) {
        String sqlQuery = "INSERT INTO user_event user_id = :user_id,  event_id =:event_id";
        Map namedParams = new HashMap();
        namedParams.put("user_id", user.getId());
        namedParams.put("event_id", event.getId());
        jdbcTemplate.update(sqlQuery , namedParams);
        return null;
    }

}
