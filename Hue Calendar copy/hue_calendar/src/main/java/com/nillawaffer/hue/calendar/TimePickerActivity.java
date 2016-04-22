package com.nillawaffer.hue.calendar;

/**
 * Created by ramsf_000 on 4/4/2016.
 */

import java.util.Calendar;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class TimePickerActivity extends AppCompatActivity {
    /** Private members of the class */
    private TextView displayTime;
    private Button pickTime;

    private int pHour;
    private int pMinute;
    /** This integer will uniquely define the dialog to be used for displaying time picker.*/
    static final int TIME_DIALOG_ID = 0;

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
                    displayTime.setText(
                            new StringBuilder()
                                    .append(pad(currentHour)).append(":")
                                    .append(pad(pMinute)).append(" ").append(aMpM));
                }
            };

    /** Add padding to numbers less than ten */
    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        /** Capture our View elements */
        displayTime = (TextView) findViewById(R.id.timeDisplay);
        pickTime = (Button) findViewById(R.id.pickTime);

        /** Listener for click event of the button */
        pickTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID);
            }
        });

        /** Get the current time */
        final Calendar cal = Calendar.getInstance();
        pHour = cal.get(Calendar.HOUR_OF_DAY);
        pMinute = cal.get(Calendar.MINUTE);

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
        //Set a message for user
        displayTime.setText(
                new StringBuilder()
                        .append(pad(currentHour)).append(":")
                        .append(pad(pMinute)).append(" ").append(aMpM));
    }

    /** Create a new dialog for time picker */

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case TIME_DIALOG_ID:
                return new TimePickerDialog(this,
                        mTimeSetListener, pHour, pMinute, false);
        }
        return null;
    }
}
