package co.allconnected.fussiontech.eventsservice.controllers;

import co.allconnected.fussiontech.eventsservice.dtos.EventCreateDto;
import co.allconnected.fussiontech.eventsservice.dtos.EventDto;
import co.allconnected.fussiontech.eventsservice.dtos.Response;
import co.allconnected.fussiontech.eventsservice.services.EventService;
import co.allconnected.fussiontech.eventsservice.utils.OperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/api/v0/events")
public class EventController {
    // Services
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // Get all events
    @GetMapping
    public ResponseEntity<List<EventDto>> getAllEvents() {
        List<EventDto> events = eventService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    // Get event by ID
    @GetMapping("/{id_event}")
    public ResponseEntity<EventDto> getEventById(@PathVariable("id_event") Integer id) {
        EventDto event = eventService.getEventById(id);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    // Create a new event
    @PostMapping
    public ResponseEntity<?> createEvent(@ModelAttribute EventCreateDto eventDto, @RequestParam(value = "photo", required = false) MultipartFile photo) {
        try {
            EventDto newEvent = eventService.createEvent(eventDto, photo);
            return new ResponseEntity<>(newEvent, HttpStatus.CREATED);
        } catch (OperationException e) {
            return ResponseEntity.status(e.getCode()).body(new Response(e.getCode(), e.getMessage()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
        }
    }

    // Update an event
    @PutMapping("/{id_event}")
    public ResponseEntity<EventDto> updateEvent(@PathVariable("id_event") Integer id, @RequestBody EventDto eventDto) {
        EventDto updatedEvent = eventService.updateEvent(id, eventDto);
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }

    // Delete an event
    @DeleteMapping("/{id_event}")
    public ResponseEntity<Void> deleteEvent(@PathVariable("id_event") Integer id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Add a label to an event
    @PostMapping("/{id_event}/labels")
    public ResponseEntity<EventDto> addLabelToEvent(@PathVariable("id_event") Integer eventId, @RequestBody Integer labelId) {
        EventDto updatedEvent = eventService.addLabelToEvent(eventId, labelId);
        return new ResponseEntity<>(updatedEvent, HttpStatus.CREATED);
    }

    // Remove a label from an event
    @DeleteMapping("/{id_event}/labels/{id_label}")
    public ResponseEntity<Void> removeLabelFromEvent(@PathVariable("id_event") Integer eventId, @PathVariable("id_label") Integer labelId) {
        eventService.removeLabelFromEvent(eventId, labelId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
