package com.herald.service.Service.Repositories;

import com.herald.service.Service.Entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
