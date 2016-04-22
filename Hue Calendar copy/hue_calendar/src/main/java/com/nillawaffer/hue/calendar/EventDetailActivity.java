package com.nillawaffer.hue.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;



public class EventDetailActivity extends AppCompatActivity {

    //Instaniate buttons and strings for later usage
    Button doneButton;
    String tag = "0";
    String name = "0";
    String startTime = "0";
    String startMin= "0";
    String endTime = "0";
    String endMin = "0";

    //set the labels with the correct text
    public void setTextOnLabels(){

        Bundle extras = getIntent().getExtras();

            name = extras.getString("pushName");
            startTime = extras.getString("pushStartTime");
            startMin = extras.getString("pushStartMin");

            endTime = extras.getString("pushEndTime");
            endMin = extras.getString("pushEndMin");

            tag = extras.getString("pushTag");

            TextView nameField = (TextView) findViewById(R.id.name);
            nameField.setText(name);

            TextView startTimeField = (TextView) findViewById(R.id.startTime);
            startTimeField.setText(startTime);
            TextView startMinField = (TextView) findViewById(R.id.startMin);
            startMinField.setText(startMin);



            TextView endTimeField = (TextView) findViewById(R.id.endTime);
            endTimeField.setText(endTime);
            TextView endMinField = (TextView) findViewById(R.id.endMin);
            endMinField.setText(endMin);

            TextView tagField = (TextView) findViewById(R.id.busy);
            tagField.setText(tag);

    }

    public void addListenerOnButton() {

        doneButton = (Button) findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        doneButton = (Button) findViewById(R.id.editButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Edit The Event", Toast.LENGTH_SHORT).show();

                Bundle extras = getIntent().getExtras();
                name = extras.getString("pushName");
                startTime = extras.getString("pushStartTime");
                startMin = extras.getString("pushStartMin");
                endTime = extras.getString("pushEndTime");
                endMin = extras.getString("pushEndMin");

                Intent intent = new Intent(EventDetailActivity.this, EventEdit.class);
                intent.putExtra("pushName", name);
                intent.putExtra("pushStartTime", startTime);
                intent.putExtra("pushStartMin", startMin);
                intent.putExtra("pushEndTime", endTime);
                intent.putExtra("pushEndMin", endMin);

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail);
        addListenerOnButton();
        setTextOnLabels();
    }

}
