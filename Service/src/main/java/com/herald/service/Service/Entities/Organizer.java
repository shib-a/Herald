package com.herald.service.Service.Entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, length = 150)
    private String name;
    @OneToMany(mappedBy = "organizer")
    @JoinColumn(name = "contact_info_id", referencedColumnName = "id")
    private Set<ContactInfo> contactInfo;
    @ManyToMany
    @JoinTable(
            name = "events_organizers",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "organizer_id")
    )
    private Set<Event> events;
    @Column(nullable = false)
    private OrganizationType organizationType;
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @ManyToMany
    @JoinTable(
            name = "account_organizer_subscribers",
            joinColumns = @JoinColumn(name="account_id"),
            inverseJoinColumns = @JoinColumn(name = "organizer_id")
    )
    private Set<Account> accounts;
}
