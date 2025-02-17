package com.herald.service.Service.Controllers;

import com.herald.service.Service.DTOs.EventDTO;
import com.herald.service.Service.DatabaseServices.EventService;
import com.herald.service.Service.Entities.Event;
import com.herald.service.Service.Repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;
    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @PostMapping("/add")
    public ResponseEntity<Event> addEvent(@RequestBody EventDTO event) {

    }
}
