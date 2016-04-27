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
        public static final String COLUMN_EVENT_START_TIME="timeDisplay";
        public static final String COLUMN_EVENT_END_TIME="timeDisplay2";
        public static final String COLUMN_EVENT_START_DATE="dateDisplay";
        public static final String COLUMN_EVENT_END_DATE="dateDisplay2";
        public static final String COLUMN_EVENT_TAGS="eventTags";
        public static final String COLUMN_EVENT_REPEAT="eventRepeat";

    }

}








