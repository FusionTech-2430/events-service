package co.allconnected.fussiontech.eventsservice.dtos;


import co.allconnected.fussiontech.eventsservice.models.Label;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

/**
 * DTO for {@link co.allconnected.fussiontech.eventsservice.models.Event}
 */
@Data
@Builder
@AllArgsConstructor
public class EventCreateDto implements Serializable {
    private String name;
    private String description;
    private String photoUrl;
    private Integer capacity;
    private Instant date;
    private Double price;
}