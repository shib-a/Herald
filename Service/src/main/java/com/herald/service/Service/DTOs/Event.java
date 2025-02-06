package com.herald.service.Service.DTOs;

import com.herald.service.Service.Entities.EventType;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, length = 150)
    private String name;
    @Column(nullable = false)
    private Date start;
    @Column(nullable = false)
    private Date end;
    @Column(nullable = false)
    private int attendeeLimit;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String linkToExternal;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    @Column(nullable = false)
    private Date createdAt;
    @Column(nullable = false)
    private Date updatedAt;
    @Column(nullable = false)
    private boolean is_over = false;
    @ManyToMany(mappedBy = "events")
    private Set<AccountDto> accounts;
    @ManyToMany(mappedBy = "events")
    private Set<Organizer> organizers;
}
