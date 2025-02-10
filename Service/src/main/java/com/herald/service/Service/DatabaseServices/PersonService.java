package com.herald.service.Service.DatabaseServices;

import com.herald.service.Service.DTOs.PersonDTO;
import com.herald.service.Service.Repositories.PersonRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository=personRepository;
    }
    @Transactional
    public PersonDTO getPersonById(PersonDTO){

    }
}
