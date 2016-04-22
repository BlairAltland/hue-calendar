package com.nillawaffer.hue.calendar;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alamkanak.weekview.WeekViewEvent;

public class EventDB extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="events.db";
    private static final String TEXT_TYPE = "TEXT";
    private static final String COMMA_SEP=",";

    private static final String SQL_CREATE_EVENT = "CREATE TABLE " + Events.SubmitEvent.TABLE_NAME + " (" +
            Events.SubmitEvent.COLUMN_EVENT_NAME + TEXT_TYPE + COMMA_SEP +

            Events.SubmitEvent.COLUMN_EVENT_START_TIME + TEXT_TYPE + COMMA_SEP +

            Events.SubmitEvent.COLUMN_EVENT_END_TIME + TEXT_TYPE + COMMA_SEP +

            Events.SubmitEvent.COLUMN_EVENT_START_DATE + TEXT_TYPE + COMMA_SEP +

            Events.SubmitEvent.COLUMN_EVENT_END_DATE + TEXT_TYPE + COMMA_SEP +

            Events.SubmitEvent.COLUMN_EVENT_TAGS + TEXT_TYPE + COMMA_SEP +

            Events.SubmitEvent.COLUMN_EVENT_REPEAT + TEXT_TYPE + ")";

    // deleting a table
    private static final String SQL_DELETE = "DROP TABLE IF EXISTS" + Events.SubmitEvent.TABLE_NAME;

    public EventDB (Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public EventDB (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_EVENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_DELETE);
        onCreate(db);
    }



}









