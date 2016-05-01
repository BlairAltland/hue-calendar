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

        final Cursor cursor = db.query(
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
            startTime.set(Calendar.HOUR_OF_DAY, 14);
            startTime.set(Calendar.MINUTE, 0);
            startTime.set(Calendar.MONTH, newMonth-1);
            startTime.set(Calendar.YEAR, newYear);
            endTime = (Calendar) startTime.clone();
            endTime.set(Calendar.HOUR_OF_DAY, 16);
            endTime.set(Calendar.MINUTE, 50);
            endTime.set(Calendar.MONTH, newMonth-1);

            // set event name
            WeekViewEvent event = new WeekViewEvent(1, Events.SubmitEvent.COLUMN_EVENT_NAME, startTime, endTime);
            event.setColor(getResources().getColor(setRandomColor()));
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
        //Return all events
        */
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
        colorArray.add(color1);
        colorArray.add(color2);
        colorArray.add(color3);
        colorArray.add(color4);
        colorArray.add(color5);
        colorArray.add(color6);
        colorArray.add(color7);
        colorArray.add(color8);
        colorArray.add(color9);
        colorArray.add(color10);

        randomNumber = rand.nextInt(9 - 0) + 0;

        int returnColor = colorArray.get(randomNumber);
        //remove this color form the array so it isnt used again for awhile
        colorArray.remove(randomNumber);

        //once we run out of colors, refill them
        if (colorArray.size() == 0) {

            colorArray.add(color1);
            colorArray.add(color2);
            colorArray.add(color3);
            colorArray.add(color4);
            colorArray.add(color5);
            colorArray.add(color6);
            colorArray.add(color7);
            colorArray.add(color8);
            colorArray.add(color9);
            colorArray.add(color10);
        }

        return returnColor;
    }

}
