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

@FeignClient(value = "event-service", fallback = EventClientFallback.class)
public interface EventClient {

    @RequestMapping(method = RequestMethod.GET, value = "/events")
    Resources<Event> getEvents();

    @RequestMapping(method = RequestMethod.GET, value = "/events/search/location")
    Resources<Event> getEventsForLocation(@RequestParam("locationId") String locationId);

}
