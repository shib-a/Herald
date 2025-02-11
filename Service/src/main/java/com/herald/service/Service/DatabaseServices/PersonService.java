package com.herald.service.Service.DatabaseServices;

import com.herald.service.Service.DTOs.PersonDTO;
import com.herald.service.Service.DTOs.PersonMapper;
import com.herald.service.Service.Entities.Person;
import com.herald.service.Service.Repositories.PersonRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    @Autowired
    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository=personRepository;
        this.personMapper=personMapper;
    }
    @Transactional
    public PersonDTO getPersonByFullName(String fullName) {
        Person foundPerson = personRepository.findByFullname(fullName);
        return personMapper.toDTO(foundPerson);
    }
    @Transactional
    public PersonDTO addPerson(PersonDTO personDTO) {
        Person saved = personRepository.save(personMapper.toPerson(personDTO));
        return personMapper.toDTO(saved);
    }
}
