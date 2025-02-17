package com.herald.service.Service.DatabaseServices;

import com.herald.service.Service.DTOs.EventDTO;
import com.herald.service.Service.DTOs.mappers.EventMapper;
import com.herald.service.Service.Repositories.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    @Autowired
    public EventService(EventRepository eventRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }
    @Transactional
    public EventDTO save(EventDTO event) {
        var eventEntity = eventMapper.toEvent(event);
        var savedEvent = eventRepository.save(eventEntity);
        return eventMapper.toEventDTO(savedEvent);
    }
    @Transactional
    public EventDTO update(EventDTO event) {
        var eventEntity = eventMapper.toEvent(event);
        eventEntity.setEventType(eventEntity.getEventType());

        var updatedEvent = eventRepository.save(eventEntity);
        return eventMapper.toEventDTO(updatedEvent);
    }
}
