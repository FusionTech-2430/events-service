package co.allconnected.fussiontech.eventsservice.repositories;

import co.allconnected.fussiontech.eventsservice.models.EventParticipant;
import co.allconnected.fussiontech.eventsservice.models.EventParticipantId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventParticipantRepository extends JpaRepository<EventParticipant, EventParticipantId> {
  }