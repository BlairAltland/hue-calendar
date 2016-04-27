package com.nillawaffer.hue.calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;

import java.util.Calendar;

public class EventAddition extends AppCompatActivity {


    public int startMin;
    private int startHour;

    private int endMin;
    private int endHour;

    private int startYear;
    private int startMonth;
    private int startDay;

    private int endYear;
    private int endMonth;
    private int endDay;


    private EditText eventName;
    private EditText tagName;
    private EditText eventRepeat;

    private TextView firstHourDisplay;
    private TextView firstMinuteDisplay;
    private Button pickTime;

    private int pHour;
    private int pMinute;
    /** This integer will uniquely define the dialog to be used for displaying time picker.*/
    static final int TIME_DIALOG_ID = 0;

    private TextView firstMonthDisplay;
    private TextView firstDayDisplay;
    private TextView firstYearDisplay;
    private Button pickDate;

    private int year2;
    private int month3;
    private int day2;
    /** This integer will uniquely define the dialog to be used for displaying time picker.*/
    static final int DATE_DIALOG_ID = 2;
    static final int DATE_DIALOG_ID2 = 3;

    private TextView secondMonthDisplay;
    private TextView secondDayDisplay;
    private TextView secondYearDisplay;
    private Button pickDate2;

    private TextView secondHourDisplay;
    private TextView secondMinuteDisplay;
    private Button pickTime2;

    private int pHour2;
    private int pMinute2;
    /** This integer will uniquely define the dialog to be used for displaying time picker.*/
    static final int TIME_DIALOG_ID2 = 1;

    Button addButton;
    Button cancelButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventaddition);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        addButton = (Button) findViewById(R.id.buttonadd);


        //add tappablity
        addListenerOnButton();

        addButton = (Button) findViewById(R.id.buttonadd);

        eventName = (EditText) findViewById(R.id.textfieldone);
        tagName = (EditText) findViewById(R.id.tagField);

        /** Capture our View elements */
        firstHourDisplay = (TextView) findViewById(R.id.firstHourDisplay);
        firstMinuteDisplay = (TextView) findViewById(R.id.firstMinuteDisplay);
        pickTime = (Button) findViewById(R.id.pickTime);

        firstMonthDisplay = (TextView) findViewById(R.id.firstMonthDisplay);
        firstDayDisplay = (TextView) findViewById(R.id.firstDayDisplay);
        firstYearDisplay = (TextView) findViewByID(R.id.firstYearDisplay);
        pickDate = (Button) findViewById(R.id.pickDate);

        /** Listener for click event of the button */
        pickTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {showDialog(TIME_DIALOG_ID);
            }
        });

        /** Listener for click event of the button */
        pickDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {showDialog(DATE_DIALOG_ID);
            }
        });

        /** Get the current time */
        final Calendar cal = Calendar.getInstance();
        pHour = cal.get(Calendar.HOUR_OF_DAY);
        pMinute = cal.get(Calendar.MINUTE);

        /** Get the current date */
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        /** Display the current time in the TextView */
        String aMpM = "AM";
        if (pHour > 11) {
            aMpM = "PM";
        }

        //Make the 24 hour time format to 12 hour time format
        int currentHour;
        if (pHour > 11) {
            currentHour = pHour - 12;
        } else {
            currentHour = pHour;
        }
        startMin = pMinute;
        startHour = pHour;
        //Set a message for user
        firstHourDisplay.setText(
                new StringBuilder()
                        .append(pad(currentHour)).append(":"));
        firstMinuteDisplay.setText(
                new StringBuilder()
                        .append(pad(pMinute)).append(" ").append(aMpM));


        /** Display the current time in the TextView */
        String month2 = " ";
        if (month == 0) {
            month2 = "January";
        } else if (month == 1) {
            month2 = "February";
        } else if (month == 2) {
            month2 = "March";
        } else if (month == 3) {
            month2 = "April";
        } else if (month == 4) {
            month2 = "May";
        } else if (month == 5) {
            month2 = "June";
        } else if (month == 6) {
            month2 = "July";
        } else if (month == 7) {
            month2 = "August";
        } else if (month == 8) {
            month2 = "September";
        } else if (month == 9) {
            month2 = "October";
        } else if (month == 10) {
            month2 = "November";
        } else {
            month2 = "December";
        }

        startYear = year;
        startMonth = month;
        startDay = day;

        firstMonthDisplay.setText(
                new StringBuilder()
                        .append(month2).append(" "));
        firstDayDisplay.setText(
                new StringBuilder()
                        .append(day).append(", "));
        firstYearDisplay.setText(
                new StringBuilder()
                        .append(year));

        /** Capture our View elements */
        secondHourDisplay = (TextView) findViewById(R.id.secondHourDisplay);
        secondMinuteDisplay = (TextView) findViewById(R.id.secondMinuteDisplay);
        pickTime2 = (Button) findViewById(R.id.pickTime2);

        /** Capture our View elements */
        secondMonthDisplay = (TextView) findViewById(R.id.secondMonthDisplay);
        secondDayDisplay = (TextView) findViewById(R.id.secondDayDisplay);
        secondYearDisplay = (TextView) findViewById(R.id.secondYearDisplay);
        pickDate2 = (Button) findViewById(R.id.pickDate2);

        /** Listener for click event of the button */
        pickTime2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID2);
            }
        });

        /** Listener for click event of the button */
        pickDate2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID2);
            }
        });

        /** Get the current time */
        final Calendar cal2 = Calendar.getInstance();
        pHour2 = cal2.get(Calendar.HOUR_OF_DAY)+1;
        pMinute2 = cal2.get(Calendar.MINUTE);

        /** Get the current date */
        final Calendar c2 = Calendar.getInstance();
        int year2 = c2.get(Calendar.YEAR);
        int month3 = c2.get(Calendar.MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);

        /** Display the current time in the TextView */
        String aMpM2 = "AM";
        if (pHour2 > 11) {
            aMpM2 = "PM";
        }

        //Make the 24 hour time format to 12 hour time format
        int currentHour2;
        if (pHour2 > 11) {
            currentHour2 = pHour2 - 12;
        } else {
            currentHour2 = pHour2;
        }
        endMin = pMinute2;
        endHour = pHour2;
        //Set a message for user
        secondHourDisplay.setText(
                new StringBuilder()
                        .append(pad(currentHour2)).append(":"));
        secondMinuteDisplay.setText(
                new StringBuilder()
                        .append(pad(pMinute2)).append(" ").append(aMpM2));

        /** Display the current date in the TextView */
        String monthh2 = " ";
        if (month3 == 0) {
            monthh2 = "January";
        } else if (month3 == 1) {
            monthh2 = "February";
        } else if (month3 == 2) {
            monthh2 = "March";
        } else if (month3 == 3) {
            monthh2 = "April";
        } else if (month3 == 4) {
            monthh2 = "May";
        } else if (month3 == 5) {
            monthh2 = "June";
        } else if (month3 == 6) {
            monthh2 = "July";
        } else if (month3 == 7) {
            monthh2 = "August";
        } else if (month3 == 8) {
            monthh2 = "September";
        } else if (month3 == 9) {
            monthh2 = "October";
        } else if (month3 == 10) {
            monthh2 = "November";
        } else {
            monthh2 = "December";
        }


        endYear = year2;
        endMonth = month3;
        endDay = day2;

        secondMonthDisplay.setText(
                new StringBuilder()
                        .append(monthh2).append(" ")
        secondDayDisplay.setText(
                new StringBuilder()
                        .append(day2).append(", "));
        secondYearDisplay.setText(
                new StringBuilder()
                        .append(year2));

    }

    /** Callback received when the user "picks" a time in the dialog */
    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    String aMpM = "AM";
                    if (hourOfDay > 11) {
                        aMpM = "PM";
                    }

                    //Make the 24 hour time format to 12 hour time format
                    int currentHour;
                    if (hourOfDay > 11) {
                        currentHour = hourOfDay - 12;
                    } else {
                        currentHour = hourOfDay;
                    }
                    //Set a message for user
                    pHour = hourOfDay;
                    pMinute = minute;
                    firstHourDisplay.setText(
                            new StringBuilder()
                                    .append(pad(currentHour)).append(":")
                                    .append(pad(pMinute)).append(" ").append(aMpM));
                    firstMinuteDisplay.setText(
                            new StringBuilder()
                                    .append(pad(pMinute)).append(" ").append(aMpM));
                }
            };

    /** Callback received when the user "picks" a date in the dialog */
    private DatePickerDialog.OnDateSetListener mDateSetListener2 =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int month, int day) {

                    String month2 = " ";
                    if (month == 0) {
                        month2 = "January";
                    } else if (month == 1) {
                        month2 = "February";
                    } else if (month == 2) {
                        month2 = "March";
                    } else if (month == 3) {
                        month2 = "April";
                    } else if (month == 4) {
                        month2 = "May";
                    } else if (month == 5) {
                        month2 = "June";
                    } else if (month == 6) {
                        month2 = "July";
                    } else if (month == 7) {
                        month2 = "August";
                    } else if (month == 8) {
                        month2 = "September";
                    } else if (month == 9) {
                        month2 = "October";
                    } else if (month == 10) {
                        month2 = "November";
                    } else {
                        month2 = "December";
                    }

                    //Set a message for user
                    year2 = year;
                    month3 = month;
                    day2 = day;

                    secondMonthDisplay.setText(
                            new StringBuilder()
                                    .append(month2).append(" ")
                    secondDayDisplay.setText(
                            new StringBuilder()
                                    .append(day).append(", "));
                    secondYearDisplay.setText(
                            new StringBuilder()
                                    .append(year));
                    )

                }
            };


    /** Add padding to numbers less than ten */
    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

    /** Create a new dialog for time picker */

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case TIME_DIALOG_ID:
                return new TimePickerDialog(this,
                        mTimeSetListener, pHour, pMinute, false);

            case TIME_DIALOG_ID2:
                return new TimePickerDialog(this,
                        mTimeSetListener2, pHour2, pMinute2, false);

            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        mDateSetListener, month3, day2, year2);

            case DATE_DIALOG_ID2:
                return new DatePickerDialog(this,
                        mDateSetListener2, month3, day2, year2);
        }
        return null;
    }



    /** Callback received when the user "picks" a time in the dialog */
    private TimePickerDialog.OnTimeSetListener mTimeSetListener2 =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    String aMpM = "AM";
                    if (hourOfDay > 11) {
                        aMpM = "PM";
                    }

                    //Make the 24 hour time format to 12 hour time format
                    int currentHour;
                    if (hourOfDay > 11) {
                        currentHour = hourOfDay - 12;
                    } else {
                        currentHour = hourOfDay;
                    }
                    //Set a message for user
                    pHour2 = hourOfDay;
                    pMinute2 = minute;

                    secondHourDisplay.setText(
                            new StringBuilder()
                                    .append(pad(currentHour)).append(":")
                    secondMinuteDisplay.setText(
                            new StringBuilder()
                                    .append(pad(pMinute2)).append(" ").append(aMpM));
                }
            };

    /** Callback received when the user "picks" a date in the dialog */
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int month, int day) {

                    String month2 = " ";
                    if (month == 0) {
                        month2 = "January";
                    } else if (month == 1) {
                        month2 = "February";
                    } else if (month == 2) {
                        month2 = "March";
                    } else if (month == 3) {
                        month2 = "April";
                    } else if (month == 4) {
                        month2 = "May";
                    } else if (month == 5) {
                        month2 = "June";
                    } else if (month == 6) {
                        month2 = "July";
                    } else if (month == 7) {
                        month2 = "August";
                    } else if (month == 8) {
                        month2 = "September";
                    } else if (month == 9) {
                        month2 = "October";
                    } else if (month == 10) {
                        month2 = "November";
                    } else {
                        month2 = "December";
                    }

                    //Set a message for user
                    year2 = year;
                    month3 = month;
                    day2 = day;

                    firstMonthDisplay.setText(
                            new StringBuilder()
                                    .append(month2).append(" ")
                                    .append(day).append(", ").append(year));
                    firstDayDisplay.setText(
                            new StringBuilder()
                                    .append(day).append(", "));
                    firstYearDisplay.setText(
                            new StringBuilder()
                                    .append(year));

                }
            };

    /** Add padding to numbers less than ten */
    private static String pad2(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

    public void addListenerOnButton() {

        cancelButton = (Button) findViewById(R.id.buttoncancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        addButton = (Button) findViewById(R.id.buttonadd);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventDB myDbHelper = new EventDB(getApplicationContext());
                SQLiteDatabase db = myDbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();


                values.put(Events.SubmitEvent.COLUMN_EVENT_NAME, eventName.getText().toString());
                //values.put(Events.SubmitEvent.COLUMN_EVENT_START_MINUTE, startMin);
                values.put(Events.SubmitEvent.COLUMN_EVENT_START_HOUR, startHour);
                //values.put(Events.SubmitEvent.COLUMN_EVENT_END_MINUTE, endMin);
                values.put(Events.SubmitEvent.COLUMN_EVENT_END_HOUR, endHour);
                values.put(Events.SubmitEvent.COLUMN_EVENT_START_YEAR, startYear);
                //values.put(Events.SubmitEvent.COLUMN_EVENT_START_MONTH, startHour);
                //values.put(Events.SubmitEvent.COLUMN_EVENT_START_DAY, startDay);
                values.put(Events.SubmitEvent.COLUMN_EVENT_END_YEAR, endYear);
                //values.put(Events.SubmitEvent.COLUMN_EVENT_END_MONTH, endMonth);
                //values.put(Events.SubmitEvent.COLUMN_EVENT_END_DAY, endDay);
                values.put(Events.SubmitEvent.COLUMN_EVENT_TAGS, tagName.getText().toString());

                // insert the values into the database
                long newRowId = db.insert(Events.SubmitEvent.TABLE_NAME, null, values);

                // toast for new data
                int duration = Toast.LENGTH_LONG;
                String result;

                // check if data was inserted
                if (newRowId != -1) {
                    result = "New Event Added";
                } else {
                    result = "Error";
                }

                Toast toast = Toast.makeText(getApplicationContext(), result, duration);
                toast.show();

                eventName.setText("");
                tagName.setText("");
                eventRepeat.setText("");

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

/*
    addButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            EventDB myDbHelper = new EventDB(getApplicationContext());
            SQLiteDatabase db = myDbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();


            values.put(Events.SubmitEvent.COLUMN_EVENT_NAME, eventName.getText().toString());
            values.put(Events.SubmitEvent.COLUMN_EVENT_START_MINUTE, startMin);
            values.put(Events.SubmitEvent.COLUMN_EVENT_START_HOUR, startHour);
            values.put(Events.SubmitEvent.COLUMN_EVENT_END_MINUTE, endMin);
            values.put(Events.SubmitEvent.COLUMN_EVENT_END_HOUR, endHour);
            values.put(Events.SubmitEvent.COLUMN_EVENT_START_YEAR, startYear);
            values.put(Events.SubmitEvent.COLUMN_EVENT_START_MONTH, startHour);
            values.put(Events.SubmitEvent.COLUMN_EVENT_START_DAY, startDay);
            values.put(Events.SubmitEvent.COLUMN_EVENT_END_YEAR, endYear);
            values.put(Events.SubmitEvent.COLUMN_EVENT_END_MONTH, endMonth);
            values.put(Events.SubmitEvent.COLUMN_EVENT_END_DAY, endDay);
            values.put(Events.SubmitEvent.COLUMN_EVENT_TAGS, tagName.getText().toString());

            // insert the values into the database
            long newRowId = db.insert(Events.SubmitEvent.TABLE_NAME, null, values);

            // toast for new data
            int duration = Toast.LENGTH_LONG;
            String result;

            // check if data was inserted
            if (newRowId != -1) {
                result = "New Event Added";
            } else {
                result = "Error";
            }

            Toast toast = Toast.makeText(getApplicationContext(), result, duration);
            toast.show();

            eventName.setText("");
            tagName.setText("");
            eventRepeat.setText("");

        }
    }
*/
}
