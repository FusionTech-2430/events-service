package co.allconnected.fussiontech.eventsservice.dtos.mappers;

import co.allconnected.fussiontech.eventsservice.dtos.LabelDto;
import co.allconnected.fussiontech.eventsservice.models.Label;
import co.allconnected.fussiontech.eventsservice.dtos.EventDto;
import co.allconnected.fussiontech.eventsservice.models.Event;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class LabelMapper {

    private final EventMapper eventMapper;

    public LabelMapper(EventMapper eventMapper) {
        this.eventMapper = eventMapper;
    }

    // Entity to DTO
    public LabelDto toDto(Label label) {
        if (label == null) {
            return null;
        }

        return new LabelDto(
                label.getId(),
                label.getLabel(),
                label.getEvents() != null ? label.getEvents().stream()
                        .map(eventMapper::toDto)
                        .collect(Collectors.toSet()) : null
        );
    }

    // DTO to Entity
    public Label toEntity(LabelDto labelDto) {
        if (labelDto == null) {
            return null;
        }

        Label label = new Label();
        label.setId(labelDto.getId());
        label.setLabel(labelDto.getLabel());
        label.setEvents(labelDto.getEvents() != null ? labelDto.getEvents().stream()
                .map(eventMapper::toEntity)
                .collect(Collectors.toSet()) : null);

        return label;
    }
}