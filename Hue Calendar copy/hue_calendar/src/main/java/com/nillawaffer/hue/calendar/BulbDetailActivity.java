package com.nillawaffer.hue.calendar;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;

import com.philips.lighting.hue.listener.PHLightListener;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.PHHueError;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;

import java.util.List;
import java.util.Map;


public class BulbDetailActivity extends AppCompatActivity {

    private View root;
    private int currentBackgroundColor = 0xffffffff;

    private PHHueSDK phHueSDK;
    private static final int MAX_HUE=65535;
    public static final String TAG = "Hue Calendar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulb_detail);

        phHueSDK = PHHueSDK.create();

        addListenerOnButton();

        root = findViewById(R.id.color_screen);
        changeBackgroundColor(currentBackgroundColor);

        Switch onOffSwitch;
        onOffSwitch = (Switch) findViewById(R.id.switch1);
        onOffSwitch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setLightStatus("Family Lamp");
            }

        });

        findViewById(R.id.colorWheel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context = BulbDetailActivity.this;

                ColorPickerDialogBuilder
                        .with(context)
                        .setTitle("Choose color")
                        .initialColor(currentBackgroundColor)
                        .wheelType(ColorPickerView.WHEEL_TYPE.CIRCLE)
                        .density(12)
                        .setOnColorSelectedListener(new OnColorSelectedListener() {
                            @Override
                            public void onColorSelected(int selectedColor) {
                                toast("onColorSelected: 0x" + Integer.toHexString(selectedColor));
                            }
                        })
                        .setPositiveButton("ok", new ColorPickerClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                                changeBackgroundColor(selectedColor);
                                if (allColors != null) {
                                    StringBuilder sb = null;

                                    for (Integer color : allColors) {
                                        if (color == null)
                                            continue;
                                        if (sb == null)
                                            sb = new StringBuilder("Color List:");
                                        sb.append("\r\n#" + Integer.toHexString(color).toUpperCase());
                                    }

                                    if (sb != null)
                                        Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .build()
                        .show();
            }
        });

    }


    public void addListenerOnButton() {

        ImageButton bulb;
        final Switch onOffSwitch;

        //set the intents for all of the images: launch the color picker for each respective bulb
        bulb = (ImageButton) findViewById(R.id.image);
        bulb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLightStatus("Family Lamp");
            }
        });

        onOffSwitch = (Switch) findViewById(R.id.switch1);
        onOffSwitch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (onOffSwitch.isChecked()) {

                    setLightStatus("Family Lamp");

                }else{

                    setLightStatus("Family Lamp");
                }
            }
        });



    }

    private void changeBackgroundColor(int selectedColor) {
        currentBackgroundColor = selectedColor;
        root.setBackgroundColor(selectedColor);
    }

    private void toast(String text) {
    }

    //If lights are on, turn them off: if lights are off, turn them on
    public void setLightStatus(String name) {

        PHBridge bridge = phHueSDK.getSelectedBridge();

        List<PHLight> allLights = bridge.getResourceCache().getAllLights();

        for (PHLight light : allLights) {
            PHLightState lightState = new PHLightState();

            if (light.getName().contains(name)) {


                if (light.getLastKnownLightState().isOn()) {

                    lightState.setOn(false);

                } else {

                    lightState.setOn(true);
                }

                bridge.updateLightState(light, lightState, listener);
            }
        }
    }

    //If lights are on, turn them off: if lights are off, turn them on
    public void increaseBrightnessIntervalForSeekBar(String name) {

        PHBridge bridge = phHueSDK.getSelectedBridge();

        List<PHLight> allLights = bridge.getResourceCache().getAllLights();

        for (PHLight light : allLights) {
            PHLightState lightState = new PHLightState();

            if (light.getName().contains(name)) {

                int currentBrightness = light.getLastKnownLightState().getBrightness();

                int newBrightness = currentBrightness + 1;

                lightState.setBrightness(newBrightness);

                bridge.updateLightState(light, lightState, listener);
            }
        }
    }

    // If you want to handle the response from the bridge, create a PHLightListener object.
    PHLightListener listener = new PHLightListener() {

        @Override
        public void onSuccess() {
        }

        @Override
        public void onStateUpdate(Map<String, String> arg0, List<PHHueError> arg1) {
            Log.w(TAG, "Light has updated");
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        menu.getItem(0).setVisible(false);
        menu.getItem(1).setVisible(false);
        menu.getItem(2).setVisible(false);
        menu.getItem(3).setVisible(false);
        menu.getItem(4).setVisible(false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){

            case R.id.basic_activity:
                Intent intent = new Intent(this, BasicActivity.class);
                startActivity(intent);
                return true;

            case R.id.light_bulbs:
                Intent intent3 = new Intent(this, LightBulbs.class);
                startActivity(intent3);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
