package com.herald.service.Service.DTOs.mappers;

import com.herald.service.Service.DTOs.EventDTO;
import com.herald.service.Service.Entities.Event;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventMapper{
    EventDTO toEventDTO(Event event);
    Event toEvent(EventDTO eventDTO);
}
