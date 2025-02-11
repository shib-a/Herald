package com.herald.service.Service.Controllers;

import com.herald.service.Service.Repositories.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/organizer")
public class OrganizerController {
    private final OrganizerRepository organizerRepository;
    @Autowired
    public OrganizerController(OrganizerRepository organizerRepository) {
        this.organizerRepository = organizerRepository;
    }

}
