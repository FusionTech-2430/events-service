package co.allconnected.fussiontech.eventsservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class EventParticipantId implements Serializable {
    private static final long serialVersionUID = 2480122400196556643L;
    @Column(name = "id_event", nullable = false)
    private Integer idEvent;

    @Column(name = "id_user", nullable = false, length = 28)
    private String idUser;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EventParticipantId entity = (EventParticipantId) o;
        return Objects.equals(this.idUser, entity.idUser) &&
                Objects.equals(this.idEvent, entity.idEvent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, idEvent);
    }

}