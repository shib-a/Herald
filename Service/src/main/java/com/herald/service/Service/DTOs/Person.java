package com.herald.service.Service.DTOs;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String fullname;
    @OneToMany(mappedBy = "person")
    private Set<AccountDto> account;
    @OneToMany(mappedBy = "person")
    private Set<Organizer> organizers;
}
