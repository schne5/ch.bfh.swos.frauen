package ch.bfh.frauen.location.repository;

import ch.bfh.frauen.location.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface LocationRepository  extends CrudRepository<Location,String> {

}
