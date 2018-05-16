package ru.kpfu.itis.entertainmentadviser.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.entertainmentadviser.dao.mapper.EventRowMapper;
import ru.kpfu.itis.entertainmentadviser.model.Event;

import java.util.List;
@Component
public class EventDaoimpl implements EventDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public List<Event> findall() {
        String sqlQuery = "SELECT * FROM event";
        List<Event> events = jdbcTemplate.query(sqlQuery,new EventRowMapper());
        return events;
    }

    @Override
    public Event save(Event event) {
        return null;
    }
}
