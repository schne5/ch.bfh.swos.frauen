package ch.bfh.frauen.eventlocationservice.controller;

import ch.bfh.frauen.eventlocationservice.client.EventClient;
import ch.bfh.frauen.eventlocationservice.client.LocationClient;
import ch.bfh.frauen.eventlocationservice.model.EventLocation;
import ch.bfh.frauen.eventlocationservice.model.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;



@RestController
public class EventLocationController implements ResourceProcessor<RepositoryLinksResource> {

    private static final Logger LOG =  LoggerFactory.getLogger(EventLocationController.class);

    @Autowired
    private LocationClient locationClient;

    @Autowired
    private EventClient eventClient;

    @RequestMapping(value = "/eventLocation/{id}", method = RequestMethod.GET, produces = "application/hal+json")
    @ResponseBody
    public Resource<EventLocation> getEventLocation(@PathVariable("id") String id) {
        Location location = locationClient.getLocation(id).getContent();
        EventLocation eventLocation = new EventLocation();
        eventLocation.setName(location.getName());
        eventLocation.setContact(location.getContact());
        eventLocation.setMaxPerson(location.getMaxPerson());
        eventLocation.setAddress(location.getAddress());
        eventLocation.setEvents(eventClient.getEventsForLocation(id).getContent());
        LOG.info("----------- Orchestrating a Location and Event -----------");
        return new Resource<>(eventLocation);
    }

    @RequestMapping(value = "/eventLocation", method = RequestMethod.GET, produces = "application/hal+json")
    @ResponseBody
    public Resources<EventLocation> listLocationEvents() {
        List<EventLocation> eventLocationList = new ArrayList<>();
        Resources<Location> locationList = locationClient.getLocations();

        for (Location location : locationList) {
            EventLocation eventLocation = new EventLocation();
            eventLocation.add(linkTo(methodOn(EventLocationController.class).getEventLocation(location.getId())).withSelfRel());
            eventLocation.add(linkTo(methodOn(EventLocationController.class).getEventLocation(location.getId())).withRel("eventLocation"));
            eventLocation.setName(location.getName());
            eventLocation.setContact(location.getContact());
            eventLocation.setAddress(location.getAddress());
            eventLocation.setMaxPerson(location.getMaxPerson());
            eventLocation.setEvents(eventClient.getEventsForLocation(location.getId()).getContent());
            eventLocationList.add(eventLocation);
        }
        LOG.info("----------- Orchestrating multiple Locations and Events -----------");
        return new Resources<>(eventLocationList);
    }

    @Override
    public RepositoryLinksResource process(RepositoryLinksResource repositoryLinksResource) {
        repositoryLinksResource.add(linkTo(methodOn(EventLocationController.class).listLocationEvents()).withRel("eventLocation"));
        return repositoryLinksResource;
    }
}
