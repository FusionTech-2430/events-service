package co.allconnected.fussiontech.eventsservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "event_participant", schema = "all_connected_events")
public class EventParticipant {
    @SequenceGenerator(name = "event_participant_id_gen", sequenceName = "event_id_event_seq", allocationSize = 1)
    @EmbeddedId
    private EventParticipantId id;

    @MapsId("idEvent")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_event", nullable = false)
    private Event idEvent;

}