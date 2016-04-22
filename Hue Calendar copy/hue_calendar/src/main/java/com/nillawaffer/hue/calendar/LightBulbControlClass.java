package com.nillawaffer.hue.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.philips.lighting.hue.listener.PHLightListener;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.PHHueError;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;

import java.util.List;
import java.util.Map;


public class LightBulbControlClass extends AppCompatActivity {

    private PHHueSDK phHueSDK;
    private static final int MAX_HUE=65535;
    public static final String TAG = "Hue Calendar";


    public void setInitialBrightness(String bulbName, SeekBar seekBar) {

        PHBridge bridge = phHueSDK.getSelectedBridge();

        List<PHLight> allLights = bridge.getResourceCache().getAllLights();

        for (PHLight light : allLights) {
            if (light.getName().contains(bulbName)) {
                int currentBrightness = light.getLastKnownLightState().getBrightness();
                seekBar.setProgress(currentBrightness);
            }
        }
    }
    /*
    public void setSwitchPosition(String bulbName, Switch onOffSwitch) {

        PHBridge bridge = phHueSDK.getSelectedBridge();

        List<PHLight> allLights = bridge.getResourceCache().getAllLights();

        for (PHLight light : allLights) {
            if (light.getName().contains(bulbName)) {

                if (light.getLastKnownLightState().isOn()) {

                    onOffSwitch.setChecked(true);
                }else{

                    onOffSwitch.setChecked(false);
                }
            }
        }
    }
    */
    public void changeNameLabel(String name) {

        PHBridge bridge = phHueSDK.getSelectedBridge();

        List<PHLight> allLights = bridge.getResourceCache().getAllLights();

        for (PHLight light : allLights) {
            PHLightState lightState = new PHLightState();

            if (light.getName().contains(name)) {

                TextView nameLabel = (TextView) findViewById(R.id.nameLabel);
                nameLabel.setText(name);

            }
        }
    }
    public void setImageButtonResources(TextView label1, TextView label2, TextView label3, TextView label4,
                                        TextView label5,TextView label6, TextView label7, TextView label8 ,TextView label9, TextView label10, TextView label11, TextView label12) {

        //create array of all of the bulbs on the network
        //loop through the array of bulbs and fill them with images
        PHBridge bridge = phHueSDK.getSelectedBridge();

        List<PHLight> allLights = bridge.getResourceCache().getAllLights();

        TextView[] textViews = {label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12};

        List<PHLight> Lights = allLights;

        for (TextView text : textViews){

            for (PHLight light : Lights) {

                text.setText(light.getName());
                Lights.remove(Lights.size() - 1);
            }
        }
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

    /*
    PHBridge bridge = phHueSDK.getSelectedBridge();

                                List<PHLight> allLights = bridge.getResourceCache().getAllLights();

                                for (PHLight light : allLights) {
                                    PHLightState lightState = new PHLightState();

                                    if (light.getName().contains(bulbName)) {

                                        lightState.setX(x);
                                        lightState.setY(y);

                                        bridge.updateLightState(light, lightState, listener);
                                    }
                                }

                                PHBridge bridge = phHueSDK.getSelectedBridge();

                List<PHLight> allLights = bridge.getResourceCache().getAllLights();

                for (PHLight light : allLights) {
                    PHLightState lightState = new PHLightState();

                    if (light.getName().contains(bulbName)) {

                        lightState.setBrightness(progressChanged);

                        bridge.updateLightState(light, lightState, listener);
                    }
                }
     */


}
