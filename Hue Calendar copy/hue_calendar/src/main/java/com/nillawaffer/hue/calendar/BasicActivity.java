package com.nillawaffer.hue.calendar;

import com.alamkanak.weekview.WeekViewEvent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


//TO DO
//create a global array
//load array
//create add method
//clear array of none-repeating events
//find repeating events
//events = repeating events

//NOTES
//Use setRandomColor() as a means of randomly creating a color

public class BasicActivity extends BaseActivity {

    int randomNumber;
    Random rand = new Random();

    @Override
    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
        // Populate the week view with some events.
        List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();

        EventDB dbHelper = new EventDB(getApplicationContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();


        /*
        public ArrayList<WeekViewEvent> getEvents() {

            List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();
            WeekViewEvent dbEvent = WeekViewEvent.format("SELECT * FROM TABLE_NAME");
            Cursor cursor = db.getReadableDatabase().rawQuery(dbEvent, null);


            if(cursor.moveToFirst())
                do {
                    events.add(sessionCursor.getString(1));
                }
                while (sessionCursor.moveToNext());

            return events;

        }
*/

        String[] projection = {
        Events.SubmitEvent.COLUMN_EVENT_NAME,
        Events.SubmitEvent.COLUMN_EVENT_START_MINUTE,
        Events.SubmitEvent.COLUMN_EVENT_START_HOUR,
        Events.SubmitEvent.COLUMN_EVENT_END_MINUTE,
        Events.SubmitEvent.COLUMN_EVENT_END_HOUR,
        Events.SubmitEvent.COLUMN_EVENT_START_YEAR,
        Events.SubmitEvent.COLUMN_EVENT_START_MONTH,
        Events.SubmitEvent.COLUMN_EVENT_START_DAY,
        Events.SubmitEvent.COLUMN_EVENT_END_YEAR,
        Events.SubmitEvent.COLUMN_EVENT_END_MONTH,
        Events.SubmitEvent.COLUMN_EVENT_END_DAY,
        Events.SubmitEvent.COLUMN_EVENT_TAGS
        };

        String[] bind = {
        Events.SubmitEvent._ID,
        Events.SubmitEvent.COLUMN_EVENT_NAME,
        Events.SubmitEvent.COLUMN_EVENT_START_MINUTE,
        Events.SubmitEvent.COLUMN_EVENT_START_HOUR,
        Events.SubmitEvent.COLUMN_EVENT_END_MINUTE,
        Events.SubmitEvent.COLUMN_EVENT_END_HOUR,
        Events.SubmitEvent.COLUMN_EVENT_START_YEAR,
        Events.SubmitEvent.COLUMN_EVENT_START_MONTH,
        Events.SubmitEvent.COLUMN_EVENT_START_DAY,
        Events.SubmitEvent.COLUMN_EVENT_END_YEAR,
        Events.SubmitEvent.COLUMN_EVENT_END_MONTH,
        Events.SubmitEvent.COLUMN_EVENT_END_DAY,
        Events.SubmitEvent.COLUMN_EVENT_TAGS
        };

        //now going to call method to return cursor

        Cursor cursor = db.query(
                Events.SubmitEvent.TABLE_NAME, //table to query
                projection,
                null,
                null,
                null,
                null,
                null
        );

        while (cursor.moveToNext()) {
            //
            // set start time
            /*
            Calendar startTime = Calendar.getInstance();
            startTime.set(Calendar.DAY_OF_MONTH, Integer.parseInt(Events.SubmitEvent.COLUMN_EVENT_START_DAY));
            startTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(Events.SubmitEvent.COLUMN_EVENT_START_HOUR));
            startTime.set(Calendar.MINUTE, Integer.parseInt(Events.SubmitEvent.COLUMN_EVENT_START_MINUTE));
            startTime.set(Calendar.MONTH, Integer.parseInt(Events.SubmitEvent.COLUMN_EVENT_START_MONTH));
            startTime.set(Calendar.YEAR, Integer.parseInt(Events.SubmitEvent.COLUMN_EVENT_START_YEAR));


            // set end time
            Calendar endTime = (Calendar) startTime.clone();
            endTime.set(Calendar.DAY_OF_MONTH, Integer.parseInt(Events.SubmitEvent.COLUMN_EVENT_END_DAY));
            endTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(Events.SubmitEvent.COLUMN_EVENT_END_HOUR));
            endTime.set(Calendar.MINUTE, Integer.parseInt(Events.SubmitEvent.COLUMN_EVENT_END_MINUTE));
            endTime.set(Calendar.MONTH, Integer.parseInt(Events.SubmitEvent.COLUMN_EVENT_END_MONTH));
            endTime.set(Calendar.YEAR, Integer.parseInt(Events.SubmitEvent.COLUMN_EVENT_END_YEAR));
            */
            Calendar startTime = Calendar.getInstance();
            Calendar endTime = (Calendar) startTime.clone();
            int month = 4;

            startTime = Calendar.getInstance();
            startTime.set(Calendar.DAY_OF_MONTH, month);
            startTime.set(Calendar.HOUR_OF_DAY, 9);
            startTime.set(Calendar.MINUTE, 0);
            startTime.set(Calendar.MONTH, newMonth-1);
            startTime.set(Calendar.YEAR, newYear);
            endTime = (Calendar) startTime.clone();
            endTime.set(Calendar.HOUR_OF_DAY, 9);
            endTime.set(Calendar.MINUTE, 50);
            endTime.set(Calendar.MONTH, newMonth-1);

            // set event name
            WeekViewEvent event = new WeekViewEvent(1, Events.SubmitEvent.COLUMN_EVENT_NAME, startTime, endTime);
            event.setColor(getResources().getColor(R.color.event_color_01));
            events.add(event);
        }

/*
        Calendar startTime = Calendar.getInstance();

        //Set Start Time
        startTime.set(Calendar.DAY_OF_MONTH, 2);
        startTime.set(Calendar.HOUR_OF_DAY, 12);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth - 1);
        startTime.set(Calendar.YEAR, newYear);

        //Set End Time
        Calendar endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR, 1);
        endTime.set(Calendar.MONTH, newMonth - 1);

        //Configure Event                           Name    Start      End
        WeekViewEvent event = new WeekViewEvent(1, "Class", startTime, endTime);
        //Set Color
              event.setColor(getResources().getColor(R.color.event_color_01));
        //Create Event
        events.add(event);

        //monday

        int month = 4;

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, month);
        startTime.set(Calendar.HOUR_OF_DAY, 9);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 9);
        endTime.set(Calendar.MINUTE, 50);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Software Engineering", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_01));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 4);
        startTime.set(Calendar.HOUR_OF_DAY, 10);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 12);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Work", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_02));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 4);
        startTime.set(Calendar.HOUR_OF_DAY, 12);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 12);
        endTime.set(Calendar.MINUTE, 50);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Lunch", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_03));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 4);
        startTime.set(Calendar.HOUR_OF_DAY, 13);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY,14);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Ancient Philosophy", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_03));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 4);
        startTime.set(Calendar.HOUR_OF_DAY, 16);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY,17);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Paper Run", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_04));
        events.add(event);

        //tuesday

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 5);
        startTime.set(Calendar.HOUR_OF_DAY, 9);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 10);
        endTime.set(Calendar.MINUTE, 50);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Epistemology", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_01));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 5);
        startTime.set(Calendar.HOUR_OF_DAY, 11);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 12);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Lunch", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_04));
        events.add(event);

        //wednesday

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 6);
        startTime.set(Calendar.HOUR_OF_DAY, 9);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 9);
        endTime.set(Calendar.MINUTE, 50);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Software Engineering", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_01));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 6);
        startTime.set(Calendar.HOUR_OF_DAY, 10);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 12);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Work", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_02));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 6);
        startTime.set(Calendar.HOUR_OF_DAY, 12);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 12);
        endTime.set(Calendar.MINUTE, 50);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Lunch", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_03));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 6);
        startTime.set(Calendar.HOUR_OF_DAY, 13);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY,14);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Ancient Philosophy", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_03));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 6);
        startTime.set(Calendar.HOUR_OF_DAY, 16);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY,17);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Paper Run", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_04));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 6);
        startTime.set(Calendar.HOUR_OF_DAY, 17);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY,18);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Work Meeting", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_03));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 6);
        startTime.set(Calendar.HOUR_OF_DAY, 18);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY,19);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Exec Board Office Hours", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_01));
        events.add(event);

        //thursday

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 7);
        startTime.set(Calendar.HOUR_OF_DAY, 9);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 10);
        endTime.set(Calendar.MINUTE, 50);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Epistemology", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_01));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 7);
        startTime.set(Calendar.HOUR_OF_DAY, 11);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 12);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Lunch", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_04));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 7);
        startTime.set(Calendar.HOUR_OF_DAY, 12);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 12);
        endTime.set(Calendar.MINUTE, 50);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "CS in Germany", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_02));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 7);
        startTime.set(Calendar.HOUR_OF_DAY, 13);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 13);
        endTime.set(Calendar.MINUTE, 50);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Android Programming", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_03));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 7);
        startTime.set(Calendar.HOUR_OF_DAY, 14);
        startTime.set(Calendar.MINUTE, 30);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 15);
        endTime.set(Calendar.MINUTE, 30);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "CS Seminar", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_04));
        events.add(event);

        //friday

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 8);
        startTime.set(Calendar.HOUR_OF_DAY, 9);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 9);
        endTime.set(Calendar.MINUTE, 50);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Software Engineering", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_01));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 8);
        startTime.set(Calendar.HOUR_OF_DAY, 10);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 12);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Work", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_02));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 8);
        startTime.set(Calendar.HOUR_OF_DAY, 12);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 12);
        endTime.set(Calendar.MINUTE, 50);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Lunch", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_03));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 8);
        startTime.set(Calendar.HOUR_OF_DAY, 13);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY,14);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Ancient Philosophy", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_04));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 8);
        startTime.set(Calendar.HOUR_OF_DAY, 16);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY,17);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Paper Run", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_04));
        events.add(event);

        //saturday

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 9);
        startTime.set(Calendar.HOUR_OF_DAY, 12);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY,14);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Work", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_01));
        events.add(event);

        //sunday

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 10);
        startTime.set(Calendar.HOUR_OF_DAY, 16);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY,18);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Work", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_02));
        events.add(event);

        //monday

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 11);
        startTime.set(Calendar.HOUR_OF_DAY, 9);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 9);
        endTime.set(Calendar.MINUTE, 50);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Software Engineering", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_01));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 11);
        startTime.set(Calendar.HOUR_OF_DAY, 10);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 12);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Work", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_02));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 11);
        startTime.set(Calendar.HOUR_OF_DAY, 12);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 12);
        endTime.set(Calendar.MINUTE, 50);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Lunch", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_03));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 11);
        startTime.set(Calendar.HOUR_OF_DAY, 13);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY,14);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Ancient Philosophy", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_03));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 11);
        startTime.set(Calendar.HOUR_OF_DAY, 16);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY,17);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Paper Run", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_04));
        events.add(event);

        //tuesday

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 12);
        startTime.set(Calendar.HOUR_OF_DAY, 9);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 10);
        endTime.set(Calendar.MINUTE, 50);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Epistemology", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_01));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 12);
        startTime.set(Calendar.HOUR_OF_DAY, 11);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 12);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Lunch", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_04));
        events.add(event);

        //wednesday

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 13);
        startTime.set(Calendar.HOUR_OF_DAY, 9);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 9);
        endTime.set(Calendar.MINUTE, 50);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Software Engineering", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_01));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 13);
        startTime.set(Calendar.HOUR_OF_DAY, 10);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 12);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Work", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_02));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 13);
        startTime.set(Calendar.HOUR_OF_DAY, 12);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 12);
        endTime.set(Calendar.MINUTE, 50);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Lunch", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_03));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 13);
        startTime.set(Calendar.HOUR_OF_DAY, 13);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY,14);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Ancient Philosophy", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_03));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 13);
        startTime.set(Calendar.HOUR_OF_DAY, 16);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY,17);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Paper Run", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_04));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 13);
        startTime.set(Calendar.HOUR_OF_DAY, 17);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY,18);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Work Meeting", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_03));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 13);
        startTime.set(Calendar.HOUR_OF_DAY, 18);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY,19);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Exec Board Office Hours", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_01));
        events.add(event);

        //thursday

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 14);
        startTime.set(Calendar.HOUR_OF_DAY, 9);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 10);
        endTime.set(Calendar.MINUTE, 50);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Epistemology", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_01));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 14);
        startTime.set(Calendar.HOUR_OF_DAY, 11);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 12);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Lunch", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_04));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 14);
        startTime.set(Calendar.HOUR_OF_DAY, 12);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 12);
        endTime.set(Calendar.MINUTE, 50);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "CS in Germany", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_02));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 14);
        startTime.set(Calendar.HOUR_OF_DAY, 13);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 13);
        endTime.set(Calendar.MINUTE, 50);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Android Programming", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_03));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 14);
        startTime.set(Calendar.HOUR_OF_DAY, 14);
        startTime.set(Calendar.MINUTE, 30);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 15);
        endTime.set(Calendar.MINUTE, 30);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "CS Seminar", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_04));
        events.add(event);

        //friday

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 15);
        startTime.set(Calendar.HOUR_OF_DAY, 9);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 9);
        endTime.set(Calendar.MINUTE, 50);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Software Engineering", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_01));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 15);
        startTime.set(Calendar.HOUR_OF_DAY, 10);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 12);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Work", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_02));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 15);
        startTime.set(Calendar.HOUR_OF_DAY, 12);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 12);
        endTime.set(Calendar.MINUTE, 50);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Lunch", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_03));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 15);
        startTime.set(Calendar.HOUR_OF_DAY, 13);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY,14);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Ancient Philosophy", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_04));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 15);
        startTime.set(Calendar.HOUR_OF_DAY, 16);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY,17);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Paper Run", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_04));
        events.add(event);

        //saturday

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 16);
        startTime.set(Calendar.HOUR_OF_DAY, 12);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY,14);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Work", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_01));
        events.add(event);

        //sunday

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 17);
        startTime.set(Calendar.HOUR_OF_DAY, 16);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY,18);
        endTime.set(Calendar.MINUTE, 0);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(1, "Work", startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_02));
        events.add(event);
        */
        //Return all events
        return events;
    }

    public int setRandomColor(){

        int color1 = R.color.event_color_01;
        int color2 = R.color.event_color_02;
        int color3 = R.color.event_color_03;
        int color4 = R.color.event_color_04;
        int color5 = R.color.event_color_05;
        int color6 = R.color.event_color_06;
        int color7 = R.color.event_color_07;
        int color8 = R.color.event_color_08;
        int color9 = R.color.event_color_09;
        int color10 = R.color.event_color_010;

        ArrayList<Integer> colorArray = new ArrayList<Integer>(10);
        colorArray.add(color1, color2);
        colorArray.add(color3, color4);
        colorArray.add(color5, color6);
        colorArray.add(color7, color8);
        colorArray.add(color9, color10);

        randomNumber = rand.nextInt(9 - 0) + 0;

        int returnColor = colorArray.get(randomNumber);
        //remove this color form the array so it isnt used again for awhile
        colorArray.remove(randomNumber);

        //once we run out of colors, refill them
        if (colorArray.size() == 0) {

            colorArray.add(color1, color2);
            colorArray.add(color3, color4);
            colorArray.add(color5, color6);
            colorArray.add(color7, color8);
            colorArray.add(color9, color10);
        }

        return returnColor;
    }

}
