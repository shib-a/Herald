package com.herald.service.Service.DTOs;

import com.herald.service.Service.Entities.EventType;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class EventDTO {
    private Long id;
    private String name;
    private Date start;
    private Date end;
    private int attendeeLimit;
    private String description;
    private String linkToExternal;
    private String eventType;
    private Date createdAt;
    private Date updatedAt;
    private boolean is_over = false;
    private List<AccountDto> accounts;
    private List<OrganizerDTO> organizers;
}
