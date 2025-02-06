package com.herald.service.Service.DTOs;

import com.herald.service.Service.Entities.SocialNetworkEnum;
import jakarta.persistence.*;

@Entity
public class ContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false)
    private String socialNetworkId;
    @Column(nullable = false)
    private SocialNetworkEnum socialNetwork;
    @Column(nullable = false, length = 15)
    private String number;
    @ManyToOne
    private Organizer organizer;
}
