package ch.bfh.frauen.eventlocationservice.client;

import ch.bfh.frauen.eventlocationservice.model.Event;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component
public class EventClientFallback implements EventClient {
    @Override
    public Resources<Event> getEvents() {
       return createDummyEvents();
    }

    @Override
    public Resources<Event> getEventsForLocation(String locationId) {
        return createDummyEvents();
    }

    private Resources<Event> createDummyEvents() {
        List<Event> eventList = new ArrayList<>();
        Event event = new Event();
        event.setId("-- DUMMY Event --");
        event.setLocationId("-- DUMMY LOCATIONID --");
        event.setTitle("-- DUMMY TITLE --");
        event.setDate(new Date());
        eventList.add(event);
        return new Resources<>(eventList);
    }
}
