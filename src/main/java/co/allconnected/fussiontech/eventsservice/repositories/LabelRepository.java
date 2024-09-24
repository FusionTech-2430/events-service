package co.allconnected.fussiontech.eventsservice.repositories;

import co.allconnected.fussiontech.eventsservice.models.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository<Label, Integer> {
}