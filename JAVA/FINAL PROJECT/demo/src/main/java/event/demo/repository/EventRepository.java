package event.demo.repository;

import event.demo.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends CrudRepository<Event,Integer> {
Optional<Event> findByName(String name);
}
