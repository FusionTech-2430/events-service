package co.allconnected.fussiontech.eventsservice.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link co.allconnected.fussiontech.eventsservice.models.EventParticipantId}
 */
@Value
public class EventParticipantIdDto implements Serializable {
    Integer idEvent;
    String idUser;
}