package com.nillawaffer.hue.calendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.List;
import java.util.Map;

import com.philips.lighting.hue.listener.PHLightListener;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.PHHueError;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;


public class LightBulbs extends AppCompatActivity {

    private PHHueSDK phHueSDK;
    private static final int MAX_HUE=65535;
    public static final String TAG = "Hue Calendar";

    //instantiate all of the images
    ImageButton imagebutton1;
    ImageButton imagebutton2;
    ImageButton imagebutton3;
    ImageButton imagebutton4;
    ImageButton imagebutton5;
    ImageButton imagebutton6;
    ImageButton imagebutton7;
    ImageButton imagebutton8;
    ImageButton imagebutton9;
    ImageButton imagebutton10;
    ImageButton imagebutton11;
    ImageButton imagebutton12;

    TextView label1;
    TextView label2;
    TextView label3;
    TextView label4;
    TextView label5;
    TextView label6;
    TextView label7;
    TextView label8;
    TextView label9;
    TextView label10;
    TextView label11;
    TextView label12;

    Button doneButton;

    TextView[] textViews = {label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12};

    ImageButton[] buttons = {imagebutton1, imagebutton2, imagebutton3, imagebutton4, imagebutton5, imagebutton6, imagebutton7, imagebutton8,
            imagebutton9, imagebutton10, imagebutton11, imagebutton12};

    LightBulbControlActivity control = new LightBulbControlActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.light_bulb_view);
        setTitle("Home");
        addListenerOnButton();

        setLabelText();
        setImageButtonContent();

        phHueSDK = PHHueSDK.create();

        doneButton = (Button) findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LightBulbs.this, BasicActivity.class);
                startActivity(intent);
            }
        });

        //control.setImageButtonResources(label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12);
    }

    public void addListenerOnButton() {


        //set the intents for all of the images: launch the color picker for each respective bulb
        imagebutton1 = (ImageButton) findViewById(R.id.imageButton);
        imagebutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LightBulbs.this, PHHomeActivity.class);
                //intent.putExtra("pushName", label1.getText());
                startActivity(intent);

            }
        });

        imagebutton2 = (ImageButton) findViewById(R.id.imageButton2);
        imagebutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LightBulbs.this, PHHomeActivity.class);
                //intent.putExtra("pushName", label2.getText());
                startActivity(intent);
            }
        });

        imagebutton3 = (ImageButton) findViewById(R.id.imageButton3);
        imagebutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LightBulbs.this, LightBulbControlActivity.class);
                //intent.putExtra("pushName", label3.getText());
                startActivity(intent);
            }
        });

        imagebutton4 = (ImageButton) findViewById(R.id.imageButton4);
        imagebutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LightBulbs.this, PHHomeActivity.class);
                //intent.putExtra("pushName", label4.getText());
                startActivity(intent);
            }
        });

        imagebutton5 = (ImageButton) findViewById(R.id.imageButton5);
        imagebutton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LightBulbs.this, PHHomeActivity.class);
                //intent.putExtra("pushName", label5.getText());
                startActivity(intent);
            }
        });

        imagebutton6 = (ImageButton) findViewById(R.id.imageButton6);
        imagebutton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LightBulbs.this, PHHomeActivity.class);
                //intent.putExtra("pushName", label6.getText());
                startActivity(intent);
            }
        });

        imagebutton7 = (ImageButton) findViewById(R.id.imageButton7);
        imagebutton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LightBulbs.this, ColorPicker.class);
                startActivity(intent);
            }
        });

        imagebutton8 = (ImageButton) findViewById(R.id.imageButton8);
        imagebutton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LightBulbs.this, ColorPicker.class);
                startActivity(intent);
            }
        });

        imagebutton9 = (ImageButton) findViewById(R.id.imageButton9);
        imagebutton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LightBulbs.this, ColorPicker.class);
                startActivity(intent);
            }
        });

        imagebutton10 = (ImageButton) findViewById(R.id.imageButton10);
        imagebutton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LightBulbs.this, ColorPicker.class);
                startActivity(intent);
            }
        });
        imagebutton11 = (ImageButton) findViewById(R.id.imageButton11);
        imagebutton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LightBulbs.this, ColorPicker.class);
                startActivity(intent);
            }
        });
        imagebutton12 = (ImageButton) findViewById(R.id.imageButton12);
        imagebutton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LightBulbs.this, ColorPicker.class);
                startActivity(intent);
            }
        });
    }

/*
    // If you want to handle the response from the bridge, create a PHLightListener object.
    PHLightListener listener = new PHLightListener() {

        @Override
        public void onSuccess() {
        }

        @Override
        public void onStateUpdate(Map<String, String> arg0, List<PHHueError> arg1) {
        }

        @Override
        public void onError(int arg0, String arg1) {}

        @Override
        public void onReceivingLightDetails(PHLight arg0) {}

        @Override
        public void onReceivingLights(List<PHBridgeResource> arg0) {}

        @Override
        public void onSearchComplete() {}
    };


    @Override
    protected void onDestroy() {
        PHBridge bridge = phHueSDK.getSelectedBridge();
        if (bridge != null) {

            if (phHueSDK.isHeartbeatEnabled(bridge)) {
                phHueSDK.disableHeartbeat(bridge);
            }

            phHueSDK.disconnect(bridge);
            super.onDestroy();
        }
    }
*/
    public void setImageButtonContent() {

        //label6 = (TextView) findViewById(R.id.label6);
        //label6.setText("");

        label1 = (TextView) findViewById(R.id.label1);
        label1.setText("");

        label2 = (TextView) findViewById(R.id.label2);
        label2.setText("");

        label3 = (TextView) findViewById(R.id.label3);
        label3.setText("");

        label4 = (TextView) findViewById(R.id.label4);
        label4.setText("");

        label5 = (TextView) findViewById(R.id.label5);
        label5.setText("");

        label6 = (TextView) findViewById(R.id.label6);
        label6.setText("");

        label7 = (TextView) findViewById(R.id.label7);
        label7.setText("");

        label8 = (TextView) findViewById(R.id.label8);
        label8.setText("");

        label9 = (TextView) findViewById(R.id.label9);
        label9.setText("");

        label10 = (TextView) findViewById(R.id.label10);
        label10.setText("");

        label11 = (TextView) findViewById(R.id.label11);
        label11.setText("");

        label12 = (TextView) findViewById(R.id.label12);
        label12.setText("");

        setLabelText();

        if (label1.getText().length() < 1) {
            imagebutton1.setVisibility(View.INVISIBLE);
        }

        if (label2.getText().length() < 1) {
            imagebutton2.setVisibility(View.INVISIBLE);
        }
        if (label3.getText().length() < 1) {
            imagebutton3.setVisibility(View.INVISIBLE);
        }
        if (label4.getText().length() < 1) {
            imagebutton4.setVisibility(View.INVISIBLE);
        }
        if (label5.getText().length() < 1) {
            imagebutton5.setVisibility(View.INVISIBLE);
        }
        if (label6.getText().length() < 1) {
            imagebutton6.setVisibility(View.INVISIBLE);
        }
        if (label7.getText().length() < 1) {
            imagebutton7.setVisibility(View.INVISIBLE);
        }
        if (label8.getText().length() < 1) {
            imagebutton8.setVisibility(View.INVISIBLE);
        }
        if (label9.getText().length() < 1) {
            imagebutton9.setVisibility(View.INVISIBLE);
        }
        if (label10.getText().length() < 1) {
            imagebutton10.setVisibility(View.INVISIBLE);
        }
        if (label11.getText().length() < 1) {
            imagebutton11.setVisibility(View.INVISIBLE);
        }
        if (label12.getText().length() < 1) {
            imagebutton12.setVisibility(View.INVISIBLE);
        }



        /*
        for (TextView text : textViews) {
            for (ImageButton button : buttons){

                if (text.getText().length() < 1) {
                    button.setVisibility(View.INVISIBLE);
                }
            }
        }
        */
    }

    public void setLabelText() {

        label1 = (TextView) findViewById(R.id.label1);
        label1.setText("Mood");

        label2 = (TextView) findViewById(R.id.label2);
        label2.setText("Nightstand");

        label3 = (TextView) findViewById(R.id.label3);
        label3.setText("Main Lamp");

        label4 = (TextView) findViewById(R.id.label4);
        label4.setText("Side Lamp");

        label5 = (TextView) findViewById(R.id.label5);
        label5.setText("Family Lamp");
    }
}