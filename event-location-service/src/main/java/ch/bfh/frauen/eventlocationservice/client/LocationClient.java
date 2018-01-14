package ch.bfh.frauen.eventlocationservice.client;

import ch.bfh.frauen.eventlocationservice.model.Event;
import ch.bfh.frauen.eventlocationservice.model.Location;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient("location-service")
public interface LocationClient {
    @RequestMapping(method = RequestMethod.GET, value = "/locations/{id}")
    Resource<Location> getLocation(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.GET, value = "/locations")
    Resources<Location> getLocations();

}
