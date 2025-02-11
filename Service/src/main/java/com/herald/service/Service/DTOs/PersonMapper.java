package com.herald.service.Service.DTOs;

import com.herald.service.Service.Entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonMapper {
    PersonDTO toDTO(Person person);
    Person toPerson(PersonDTO personDTO);
}
