package com.herald.service.Service.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;
    @Column(nullable = false)
    private boolean isMain = true;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SocialNetworkEnum socialNetwork;
    @Column(nullable = false, length = 50)
    private String socialNetworkId;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LanguageEnum language;
    @ManyToMany
    @JoinTable(
            name = "events_accounts",
            joinColumns = @JoinColumn(name="account_id"),
            inverseJoinColumns = @JoinColumn(name="event_id")
    )
    private Set<Event> events;
    @ManyToMany
    private Set<Organizer> organizers;
    private String password;
}
