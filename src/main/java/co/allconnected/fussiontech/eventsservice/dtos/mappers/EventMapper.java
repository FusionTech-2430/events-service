package co.allconnected.fussiontech.eventsservice.dtos.mappers;

import co.allconnected.fussiontech.eventsservice.dtos.EventDto;
import co.allconnected.fussiontech.eventsservice.models.Event;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EventMapper {

    // Entity to DTO
    public EventDto toDto(Event event) {
        if (event == null) {
            return null;
        }
        return EventDto.builder()
                .id(event.getId())
                .idBusiness(String.valueOf(event.getIdBusiness()))
                .name(event.getName())
                .description(event.getDescription())
                .photoUrl(event.getPhotoUrl())
                .capacity(event.getCapacity())
                .date(event.getDate())
                .active(event.getActive())
                .price(event.getPrice())
                .labels(event.getLabels())
                .eventParticipants(event.getEventParticipants())
                .build();
    }

    // DTO to Entity
    public Event toEntity(EventDto eventDto) {
        if (eventDto == null) {
            return null;
        }
        Event event = new Event();
        event.setId(eventDto.getId());
        event.setIdBusiness(UUID.fromString(eventDto.getIdBusiness()));
        event.setName(eventDto.getName());
        event.setDescription(eventDto.getDescription());
        event.setPhotoUrl(eventDto.getPhotoUrl());
        event.setCapacity(eventDto.getCapacity());
        event.setDate(eventDto.getDate());
        event.setActive(eventDto.getActive());
        event.setPrice(eventDto.getPrice());
        event.setLabels(eventDto.getLabels());
        event.setEventParticipants(eventDto.getEventParticipants());
        return event;
    }
}
