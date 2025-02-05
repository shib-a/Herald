package com.herald.service.Service.Repositories;

import com.herald.service.Service.Entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
