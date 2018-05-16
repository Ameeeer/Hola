package ru.kpfu.itis.entertainmentadviser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.entertainmentadviser.dao.EventDao;
import ru.kpfu.itis.entertainmentadviser.model.Event;

import java.util.List;

@Controller
public class EventController {
    @Autowired
    EventDao eventDao;
    @GetMapping("/events")
    String getAllevents(Model model){
        List<Event> EventList = eventDao.findall();
        model.addAttribute("getAllevents", EventList);
        return "events";
    }
}

