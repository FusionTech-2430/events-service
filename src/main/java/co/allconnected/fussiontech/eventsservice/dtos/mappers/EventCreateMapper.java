package co.allconnected.fussiontech.eventsservice.dtos.mappers;

import co.allconnected.fussiontech.eventsservice.dtos.EventCreateDto;
import co.allconnected.fussiontech.eventsservice.models.Event;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EventCreateMapper {

    // Entity to DTO
    public EventCreateDto toDto(EventCreateDto createEventDto) {
        if (createEventDto == null) {
            return null;
        }
        return EventCreateDto.builder()
                .name(createEventDto.getName())
                .description(createEventDto.getDescription())
                .photoUrl(createEventDto.getPhotoUrl())
                .capacity(createEventDto.getCapacity())
                .date(createEventDto.getDate())
                .price(createEventDto.getPrice())
                .build();
    }

    // DTO to Entity
    public Event toEntity(EventCreateDto createEventDto) {
        if (createEventDto == null) {
            return null;
        }
        Event event = new Event();
        event.setName(createEventDto.getName());
        event.setDescription(createEventDto.getDescription());
        event.setPhotoUrl(createEventDto.getPhotoUrl());
        event.setCapacity(createEventDto.getCapacity());
        event.setDate(createEventDto.getDate());
        event.setPrice(createEventDto.getPrice());
        return event;
    }
}
