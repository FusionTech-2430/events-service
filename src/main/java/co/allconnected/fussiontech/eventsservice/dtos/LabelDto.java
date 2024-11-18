package co.allconnected.fussiontech.eventsservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link co.allconnected.fussiontech.eventsservice.models.Label}
 */
@Data
@Builder
@AllArgsConstructor
public class LabelDto implements Serializable {
    private Integer id;
    private String label;
    private Set<EventDto> events;
}