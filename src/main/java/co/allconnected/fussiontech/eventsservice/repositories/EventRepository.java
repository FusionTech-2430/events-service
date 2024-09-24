package co.allconnected.fussiontech.eventsservice.repositories;

import co.allconnected.fussiontech.eventsservice.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}