package com.nillawaffer.hue.calendar;

import android.provider.BaseColumns;

public final class Events{

    public Events(){}

    public static abstract class SubmitEvent implements BaseColumns{


        public static final String TABLE_NAME="Events";
        public static final String COLUMN_EVENT_NAME="eventName";
        public static final String COLUMN_EVENT_START_MINUTE="firstMinuteDisplay";
        public static final String COLUMN_EVENT_START_HOUR="firstHourDisplay";
        public static final String COLUMN_EVENT_END_MINUTE="secondMinuteDisplay";
        public static final String COLUMN_EVENT_END_HOUR="secondHourDisplay";
        public static final String COLUMN_EVENT_START_YEAR="firstYearDisplay";
        public static final String COLUMN_EVENT_START_MONTH="firstMonthDisplay";
        public static final String COLUMN_EVENT_START_DAY="firstDayDisplay";
        public static final String COLUMN_EVENT_END_YEAR="secondYearDisplay";
        public static final String COLUMN_EVENT_END_MONTH="secondMonthDisplay";
        public static final String COLUMN_EVENT_END_DAY="secondDayDisplay";
        public static final String COLUMN_EVENT_TAGS="eventTags";


        /*
        public static final String TABLE_NAME="Events";
        public static final String COLUMN_EVENT_NAME="eventName";
        public static final int COLUMN_EVENT_START_MINUTE=0;
        public static final int COLUMN_EVENT_START_HOUR=0;
        public static final int COLUMN_EVENT_END_MINUTE=0;
        public static final int COLUMN_EVENT_END_HOUR=0;
        public static final int COLUMN_EVENT_START_YEAR=0;
        public static final int COLUMN_EVENT_START_MONTH=0;
        public static final int COLUMN_EVENT_START_DAY=0;
        public static final int COLUMN_EVENT_END_YEAR=0;
        public static final int COLUMN_EVENT_END_MONTH=0;
        public static final int COLUMN_EVENT_END_DAY=0;
        public static final String COLUMN_EVENT_TAGS="eventTags";
        */
    }

}








