package co.allconnected.fussiontech.eventsservice.dtos;

import co.allconnected.fussiontech.eventsservice.models.EventParticipant;
import co.allconnected.fussiontech.eventsservice.models.Label;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link co.allconnected.fussiontech.eventsservice.models.Event}
 */
@Value
public class EventDto implements Serializable {
    Integer id;
    UUID idBusiness;
    String name;
    String description;
    String photoUrl;
    Integer capacity;
    Instant date;
    Boolean active;
    Double price;
    Set<Label> labels;
    Set<EventParticipant> eventParticipants;
}