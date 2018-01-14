package ch.bfh.frauen.event.repository;

import ch.bfh.frauen.event.model.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface ScheduleRepository extends CrudRepository<Schedule,String> {
    @RestResource(path="event")
    List<Schedule> findByEventId(@Param("eventId") String eventId);
    @RestResource(path="dj")
    List<Schedule> findByDjId(@Param("djId") String djId);
}
