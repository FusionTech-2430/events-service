package co.allconnected.fussiontech.eventsservice.services;

import co.allconnected.fussiontech.eventsservice.dtos.EventDto;
import co.allconnected.fussiontech.eventsservice.dtos.LabelDto;
import co.allconnected.fussiontech.eventsservice.dtos.mappers.EventMapper;
import co.allconnected.fussiontech.eventsservice.dtos.mappers.LabelMapper;
import co.allconnected.fussiontech.eventsservice.models.Event;
import co.allconnected.fussiontech.eventsservice.models.Label;
import co.allconnected.fussiontech.eventsservice.repositories.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabelService {

    private final LabelRepository labelRepository;
    private final LabelMapper labelMapper;
    private final EventMapper eventMapper;

    @Autowired
    public LabelService(LabelRepository labelRepository, LabelMapper labelMapper, EventMapper eventMapper) {
        this.labelRepository = labelRepository;
        this.labelMapper = labelMapper;
        this.eventMapper = eventMapper;
    }

    @Transactional
    // Create a new label
    public LabelDto createLabel(LabelDto labelDto) {
        Label label = labelMapper.toEntity(labelDto);
        Label savedLabel = labelRepository.save(label);
        return labelMapper.toDto(savedLabel);
    }

    @Transactional
    // Get all labels
    public List<LabelDto> getAllLabels() {
        List<Label> labels = labelRepository.findAll();
        return labels.stream().map(labelMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    // Get a label by ID
    public LabelDto getLabelById(Integer id) {
        Label label = labelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Label not found with id: " + id));
        return labelMapper.toDto(label);
    }

    @Transactional
    // Update an existing label
    public LabelDto put(Integer id, LabelDto labelDto) {
        Label existingLabel = labelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Label not found with id: " + id));

        // Update fields
        existingLabel.setLabel(labelDto.getLabel());
        existingLabel.setEvents(labelDto.getEvents().stream()
                .map(eventMapper::toEntity)
                .collect(Collectors.toSet()));

        Label updatedLabel = labelRepository.save(existingLabel);
        return labelMapper.toDto(updatedLabel);
    }

    @Transactional
    // Delete a label
    public void deleteLabel(Integer id) {
        Label label = labelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Label not found with id: " + id));
        labelRepository.delete(label);
    }
}
