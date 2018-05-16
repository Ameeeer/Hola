package ru.kpfu.itis.entertainmentadviser.dao;

import ru.kpfu.itis.entertainmentadviser.model.Event;

import java.util.List;

public interface EventDao {
    List<Event> findall();
    Event save(Event event);
}
