package co.allconnected.fussiontech.eventsservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "event", schema = "all_connected_events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event", nullable = false)
    private Integer id;

    @Column(name = "id_business", nullable = false)
    private UUID idBusiness;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "description", nullable = false, length = 280)
    private String description;

    @Column(name = "photo_url", length = 700)
    private String photoUrl;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "date", nullable = false)
    private Instant date;

    @ColumnDefault("true")
    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @Column(name = "price")
    private Double price;

    @ManyToMany
    @JoinTable(name = "event_label",
            joinColumns = @JoinColumn(name = "id_event"),
            inverseJoinColumns = @JoinColumn(name = "id_label"))
    private Set<Label> labels = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idEvent")
    private Set<EventParticipant> eventParticipants = new LinkedHashSet<>();

}