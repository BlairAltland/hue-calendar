package com.nillawaffer.hue.calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by ramsf_000 on 4/6/2016.
 */
public class DatePickerActivity extends AppCompatActivity {
    /** Private members of the class */
    private TextView displayDate;
    private Button pickDate;

    private int year2;
    private int month3;
    private int day2;
    /** This integer will uniquely define the dialog to be used for displaying date picker.*/
    static final int DATE_DIALOG_ID = 0;

    /** Callback received when the user "picks" a date in the dialog */
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int month, int day) {

                    //Set a message for user
                    //pHour = hourOfDay;
                    //pMinute = minute;
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
                    displayDate.setText(
                            new StringBuilder()
                                    .append(month2).append(" ")
                                    .append(day2).append(", ").append(year2));
                }
            };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        /** Capture our View elements */
        displayDate = (TextView) findViewById(R.id.dateDisplay);
        pickDate = (Button) findViewById(R.id.pickDate);

        /** Listener for click event of the button */
        pickDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        /** Get the current date */
        final Calendar c2 = Calendar.getInstance();
        year2 = c2.get(Calendar.YEAR);
        month3 = c2.get(Calendar.MONTH);
        day2 = c2.get(Calendar.DAY_OF_MONTH);

        /** Display the current time in the TextView */
        String month2 = " ";
        if (month3 == 0) {
            month2 = "January";
        } else if (month3 == 1) {
            month2 = "February";
        } else if (month3 == 2) {
            month2 = "March";
        } else if (month3 == 3) {
            month2 = "April";
        } else if (month3 == 4) {
            month2 = "May";
        } else if (month3 == 5) {
            month2 = "June";
        } else if (month3 == 6) {
            month2 = "July";
        } else if (month3 == 7) {
            month2 = "August";
        } else if (month3 == 8) {
            month2 = "September";
        } else if (month3 == 9) {
            month2 = "October";
        } else if (month3 == 10) {
            month2 = "November";
        } else {
            month2 = "December";
        }

        displayDate.setText(
                new StringBuilder()
                        .append(month2).append(" ")
                        .append(day2).append(", ").append(year2));
    }

    /** Create a new dialog for time picker */

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        mDateSetListener, year2, month3, day2);
        }
        return null;
    }
}
