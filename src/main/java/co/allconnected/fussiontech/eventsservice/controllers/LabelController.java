package co.allconnected.fussiontech.eventsservice.controllers;

import co.allconnected.fussiontech.eventsservice.dtos.LabelDto;
import co.allconnected.fussiontech.eventsservice.services.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/labels")
public class LabelController {

    private final LabelService labelService;

    @Autowired
    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    // Create a new label
    @PostMapping
    public ResponseEntity<LabelDto> createLabel(@RequestBody LabelDto labelDto) {
        LabelDto createdLabel = labelService.createLabel(labelDto);
        return new ResponseEntity<>(createdLabel, HttpStatus.CREATED);
    }

    // Get all labels
    @GetMapping
    public ResponseEntity<List<LabelDto>> getAllLabels() {
        List<LabelDto> labels = labelService.getAllLabels();
        return new ResponseEntity<>(labels, HttpStatus.OK);
    }

    // Get a label by ID
    @GetMapping("/{id_label}")
    public ResponseEntity<LabelDto> getLabelById(@PathVariable Integer id_label) {
        LabelDto label = labelService.getLabelById(id_label);
        return new ResponseEntity<>(label, HttpStatus.OK);
    }

    // Update the label by ID
    @PutMapping("/{id_label}")
    public ResponseEntity<LabelDto> updateLabel(@PathVariable Integer id_label, @RequestBody LabelDto labelDto) {
        LabelDto updatedLabel = labelService.createLabel(labelDto);
        return new ResponseEntity<>(updatedLabel, HttpStatus.OK);
    }

    // Delete a label by ID
    @DeleteMapping("/{id_label}")
    public ResponseEntity<Void> deleteLabel(@PathVariable Integer id_label) {
        labelService.deleteLabel(id_label);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
