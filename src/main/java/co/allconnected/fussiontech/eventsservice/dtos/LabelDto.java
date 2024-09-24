package co.allconnected.fussiontech.eventsservice.dtos;

import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link co.allconnected.fussiontech.eventsservice.models.Label}
 */
@Value
public class LabelDto implements Serializable {
    Integer id;
    String label;
    Set<EventDto> events;
}