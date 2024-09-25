package co.allconnected.fussiontech.eventsservice.dtos;

import co.allconnected.fussiontech.eventsservice.models.EventParticipant;
import co.allconnected.fussiontech.eventsservice.models.Label;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link co.allconnected.fussiontech.eventsservice.models.Event}
 */
@Data
@Builder
@AllArgsConstructor
public class EventDto implements Serializable {
    private Integer id;
    private String idBusiness;
    private String name;
    private String description;
    private String photoUrl;
    private Integer capacity;
    private Instant date;
    private Boolean active;
    private Double price;
    private Set<Label> labels;
    private Set<EventParticipant> eventParticipants;
}