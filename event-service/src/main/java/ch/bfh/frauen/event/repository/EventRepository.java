package ch.bfh.frauen.event.repository;

import ch.bfh.frauen.event.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface EventRepository extends CrudRepository<Event,String> {
    @RestResource(path="location")
    List<Event> findByLocationId(@Param("locationId") String locationId);
}
