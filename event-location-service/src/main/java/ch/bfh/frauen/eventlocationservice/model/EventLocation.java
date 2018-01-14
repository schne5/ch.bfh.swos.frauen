package ch.bfh.frauen.eventlocationservice.model;

import org.springframework.hateoas.ResourceSupport;

import java.util.Collection;
import java.util.Date;

public class EventLocation extends ResourceSupport {
    private String address;
    private String contact;
    private String name;
    private int maxPerson;
    private Collection<Event> events;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    public Collection<Event> getEvents() {
        return events;
    }

    public void setEvents(Collection<Event> events) {
        this.events = events;
    }
}
