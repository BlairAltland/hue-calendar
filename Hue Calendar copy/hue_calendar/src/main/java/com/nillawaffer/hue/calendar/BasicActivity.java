package com.nillawaffer.hue.calendar;

import com.alamkanak.weekview.WeekViewEvent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


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

        //EventDB dbHelper = new EventDB(getApplicationContext());
        //SQLiteDatabase db = dbHelper.getReadableDatabase();

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
/*
        String[] projection = {
                Events.SubmitEvent.COLUMN_EVENT_NAME,
                Events.SubmitEvent.COLUMN_EVENT_START_TIME,
                Events.SubmitEvent.COLUMN_EVENT_END_TIME,
                Events.SubmitEvent.COLUMN_EVENT_START_DATE,
                Events.SubmitEvent.COLUMN_EVENT_END_DATE,
                Events.SubmitEvent.COLUMN_EVENT_TAGS,
                Events.SubmitEvent.COLUMN_EVENT_REPEAT
        };

        String[] bind = {
                Events.SubmitEvent._ID,
                Events.SubmitEvent.COLUMN_EVENT_NAME,
                Events.SubmitEvent.COLUMN_EVENT_START_TIME,
                Events.SubmitEvent.COLUMN_EVENT_END_TIME,
                Events.SubmitEvent.COLUMN_EVENT_START_DATE,
                Events.SubmitEvent.COLUMN_EVENT_END_DATE,
                Events.SubmitEvent.COLUMN_EVENT_TAGS,
                Events.SubmitEvent.COLUMN_EVENT_REPEAT
        };

        //now going to call method to return cursor

        Cursor cursor = db.query(Events.SubmitEvent.TABLE_NAME, //table to query
                bind,
                null, //columns for where, Null will return all rows
                null, //values for where
                null, //Group By, null is no group by
                null, //Having, null says return all rows
                null,
                null,
                null
        );

        //the list items from the layout, will find these in the row_item, should have named them better
        int[] to = new int[]{
                //pull the 7 different variables into their respective Event Object variables
                //This may require some more code refactoring, for instance, startTime is broken into
                //day, hour, minute month and year.
        };

*/


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

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 4);
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

        randomNumber = rand.nextInt(10 - 0) + 0;

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
