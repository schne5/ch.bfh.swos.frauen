package ch.bfh.frauen.dj.repository;

import ch.bfh.frauen.dj.model.DJ;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DJRepository extends CrudRepository<DJ,String> {
}
