package co.allconnected.fussiontech.eventsservice.dtos;

import co.allconnected.fussiontech.eventsservice.models.EventParticipantId;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link co.allconnected.fussiontech.eventsservice.models.EventParticipant}
 */
@Value
public class EventParticipantDto implements Serializable {
    EventParticipantId id;
    EventDto idEvent;
}