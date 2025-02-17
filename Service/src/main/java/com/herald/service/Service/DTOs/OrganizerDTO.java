package com.herald.service.Service.DTOs;

import com.herald.service.Service.Entities.OrganizationType;
import jakarta.persistence.*;

import java.util.Set;

public class OrganizerDTO {
    private Long id;
    private String name;
    private Set<ContactInfo> contactInfo;
    private Set<EventDTO> events;
    private OrganizationType organizationType;
    private PersonDTO person;
    private Set<AccountDto> accounts;
}
