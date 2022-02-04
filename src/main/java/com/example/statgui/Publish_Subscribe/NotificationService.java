package com.example.statgui.Publish_Subscribe;

import java.util.*;

public class NotificationService {
    private final Map<Event, List<EventListner>> listenerList;

    public NotificationService() {
        listenerList = new HashMap<>();
        Arrays.stream(Event.values()).forEach(event -> listenerList.put(event, new ArrayList<>()));
    }

    public void subscribe(EventListner listener, Event eventType){
        listenerList.get(eventType).add(listener);

    }

    public void unsubscribe(EventListner listener, Event eventType){
        listenerList.get(eventType).remove(listener);
    }

    public void notifyListners(Event eventType){

        listenerList.get(eventType).forEach(listner -> listner.update(eventType));
    }
}
