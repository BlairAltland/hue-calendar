package com.nillawaffer.hue.calendar;

import android.provider.BaseColumns;

public final class Events{

    public Events(){}

    public static abstract class SubmitEvent implements BaseColumns{


        public static final String TABLE_NAME="Events";
        public static final String COLUMN_EVENT_NAME="";
        public static final String COLUMN_EVENT_START_MINUTE="";
        public static final String COLUMN_EVENT_START_HOUR="";
        public static final String COLUMN_EVENT_END_MINUTE="";
        public static final String COLUMN_EVENT_END_HOUR="";
        public static final String COLUMN_EVENT_START_YEAR="";
        public static final String COLUMN_EVENT_START_MONTH="";
        public static final String COLUMN_EVENT_START_DAY="";
        public static final String COLUMN_EVENT_END_YEAR="";
        public static final String COLUMN_EVENT_END_MONTH="";
        public static final String COLUMN_EVENT_END_DAY="";
        public static final String COLUMN_EVENT_TAGS="";


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








