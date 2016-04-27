package com.nillawaffer.hue.calendar;

import android.provider.BaseColumns;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public final class Events{

    public Events(){}

    public static abstract class SubmitEvent implements BaseColumns{

        public static final String TABLE_NAME="Events";
        public static final String COLUMN_EVENT_NAME="eventName";
        public static final int COLUMN_EVENT_START_MINUTE="timeDisplay";
        public static final int COLUMN_EVENT_START_HOUR="timeDisplay";
        public static final int COLUMN_EVENT_END_MINUTE="timeDisplay2";
        public static final int COLUMN_EVENT_END_HOUR="timeDisplay2";
        public static final int COLUMN_EVENT_START_YEAR="dateDisplay";
        public static final int COLUMN_EVENT_START_MONTH="dateDisplay";
        public static final int COLUMN_EVENT_START_DAY="dateDisplay";
        public static final int COLUMN_EVENT_END_YEAR="dateDisplay2";
        public static final int COLUMN_EVENT_END_MONTH="dateDisplay2";
        public static final int COLUMN_EVENT_END_DAY="dateDisplay2";
        public static final String COLUMN_EVENT_TAGS="eventTags";

    }

}








