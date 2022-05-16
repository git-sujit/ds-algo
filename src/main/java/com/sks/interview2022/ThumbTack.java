package com.sks.interview2022;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Build a Calendar for a Professional having events in it & implement
 * - addEvent
 * - retrieveEvent
 * - deleteEvent
 * - isSlotFree
 */
public class ThumbTack {
    static int eventId = 1;
    Map<Integer, Event> events = new HashMap<>();
    Map<Integer, List<Event>> dayEvents = new HashMap<>();

    public void addEvent(Calendar startDateTime, Calendar endDateTime, String jobDesc) {
        Event e = new Event(startDateTime, endDateTime, jobDesc);
        int day = getDay(startDateTime.getTimeInMillis());
        if (dayEvents.containsKey(day)) {
            dayEvents.get(day).add(e);
        }
        events.put(eventId, e);
    }

    public Event retrieveEvent(int eventId) {
        return events.get(eventId);
    }

    public void deleteEvent(int eventId) {
        events.remove(eventId);
    }

    public boolean isSlotFree(Calendar startDateTime, Calendar endDateTime) {
        int day = getDay(startDateTime.getTimeInMillis());
        List<Event> ev = dayEvents.get(day);
        for (Event e : ev) {
            if (isOverlapping(e.startDateTime.getTimeInMillis(), e.endDateTime.getTimeInMillis(), startDateTime.getTimeInMillis(), endDateTime.getTimeInMillis()))
                return false;
        }
        return true;
    }

    private boolean isOverlapping(long es, long ee, long s, long e) {
        return s < es && e > es || s == es && e == ee || s < ee && e > ee && s > es && s < ee && e > ee;
    }

    /**
     * JDateTime not working
     */
    private int getDay(long milliseconds) {
        //JDateTime jdt = new JDateTime(milliseconds);
        //JulianDateStamp jds = jdt.getJulianDate();
        //double jdn = jdt.getJulianDateDouble();
        //int jdn = jdt.getJulianDateNumber();
        return 1;
    }

    class Event {
        Calendar startDateTime;
        Calendar endDateTime;
        String jobDesc;

        public Event(Calendar startDateTime, Calendar endDateTime, String jobDesc) {
            this.startDateTime = startDateTime;
            this.endDateTime = endDateTime;
            this.jobDesc = jobDesc;
        }
    }
}
