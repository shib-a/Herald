package com.herald.service.Service.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String fullname;
    @OneToMany(mappedBy = "person")
    private Set<Account> account;
    @OneToMany(mappedBy = "person")
    private Set<Organizer> organizers;
}
