package co.allconnected.fussiontech.eventsservice.services;

import co.allconnected.fussiontech.eventsservice.dtos.EventCreateDto;
import co.allconnected.fussiontech.eventsservice.dtos.EventDto;
import co.allconnected.fussiontech.eventsservice.dtos.mappers.EventCreateMapper;
import co.allconnected.fussiontech.eventsservice.dtos.mappers.EventMapper;
import co.allconnected.fussiontech.eventsservice.models.Event;
import co.allconnected.fussiontech.eventsservice.models.Label;
import co.allconnected.fussiontech.eventsservice.repositories.EventRepository;
import co.allconnected.fussiontech.eventsservice.repositories.LabelRepository;
import co.allconnected.fussiontech.eventsservice.utils.OperationException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final LabelRepository labelRepository;
    private final EventMapper eventMapper;
    private final EventCreateMapper eventCreateMapper;
    private final FirebaseService firebaseService;

    @Autowired
    public EventService(EventRepository eventRepository, LabelRepository labelRepository,
                        EventMapper eventMapper, FirebaseService firebaseService,
                        EventCreateMapper eventCreateMapper) {
        this.eventRepository = eventRepository;
        this.labelRepository = labelRepository;
        this.eventMapper = eventMapper;
        this.firebaseService = firebaseService;
        this.eventCreateMapper = eventCreateMapper;
    }

    // Create an event
    public EventDto createEvent(EventCreateDto crateEventDto, MultipartFile photo) {
        Event event = eventCreateMapper.toEntity(crateEventDto);
        // Create the UUID
        event.setIdBusiness( UUID.randomUUID());
        event.setActive(true);
        Event savedEvent = eventRepository.save(event);

        // Upload photo to firebase
        if (photo != null) {
            String photoName = String.valueOf(savedEvent.getId());
            String extension = FilenameUtils.getExtension(photo.getOriginalFilename());
            try{
                savedEvent.setPhotoUrl(firebaseService.uploadImg(photoName, extension, photo));

            } catch (IOException e) {
                throw new OperationException(500, "Error uploading photo: " + e.getMessage());
            }
        }

        savedEvent = eventRepository.save(event);
        return eventMapper.toDto(savedEvent);
    }

    // Get event by id
    public EventDto getEventById(Integer id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
        return eventMapper.toDto(event);
    }

    // Get all events
    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(eventMapper::toDto).collect(Collectors.toList());
    }

    // Update an event
    public EventDto updateEvent(Integer id, EventDto eventDto) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));

        // Update fields
        existingEvent.setName(eventDto.getName());
        existingEvent.setDescription(eventDto.getDescription());
        existingEvent.setPhotoUrl(eventDto.getPhotoUrl());
        existingEvent.setCapacity(eventDto.getCapacity());
        existingEvent.setDate(eventDto.getDate());
        existingEvent.setActive(eventDto.getActive());
        existingEvent.setPrice(eventDto.getPrice());
        existingEvent.setLabels(eventDto.getLabels());
        existingEvent.setEventParticipants(eventDto.getEventParticipants());

        Event updatedEvent = eventRepository.save(existingEvent);
        return eventMapper.toDto(updatedEvent);
    }

    // Delete an event
    public void deleteEvent(Integer id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
        eventRepository.delete(event);
    }

    // Add a label to an event
    public EventDto addLabelToEvent(Integer eventId, Integer labelId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + eventId));
        Label label = labelRepository.findById(labelId)
                .orElseThrow(() -> new RuntimeException("Label not found with id: " + labelId));

        // Add the label to the event
        event.getLabels().add(label);

        Event updatedEvent = eventRepository.save(event);
        return eventMapper.toDto(updatedEvent);
    }

    // Remove a label from an event
    public void removeLabelFromEvent(Integer eventId, Integer labelId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + eventId));
        Label label = labelRepository.findById(labelId)
                .orElseThrow(() -> new RuntimeException("Label not found with id: " + labelId));

        // Remove the label from the event
        event.getLabels().remove(label);

        eventRepository.save(event);
    }
}
