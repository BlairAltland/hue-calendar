package com.nillawaffer.hue.calendar;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.philips.lighting.hue.listener.PHLightListener;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.PHHueError;
import com.philips.lighting.model.PHLight;

public class TagAdditionActivity extends ListActivity  {

    private PHHueSDK phHueSDK;
    private static final int MAX_HUE=65535;
    public static final String TAG = "Hue Calendar";
    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;

    Button doneButton;
    Button cancelButton;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tagaddition);
        phHueSDK = PHHueSDK.create();
        addListenerOnButton();

        // Find the ListView resource.
        //mainListView = (ListView) findViewById(R.id.BulbListView);
        mainListView = getListView();

        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.row_item, getBulbNames());

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter( listAdapter );

    }

    public ArrayList getBulbNames() {

        PHBridge bridge = phHueSDK.getSelectedBridge();
        List<PHLight> allLights = bridge.getResourceCache().getAllLights();

        ArrayList<String> bulbNames = new ArrayList<String>();

        for (PHLight light : allLights) {

            bulbNames.add(light.getName());
        }

        return bulbNames;
    }

    public void addListenerOnButton() {

        doneButton = (Button) findViewById(R.id.addButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        cancelButton = (Button) findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    /*
    @Override
    protected  void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);

        Long text = l.getItemIdAtPosition(position);
        String stringText = text.toString();

        Toast.makeText(getApplicationContext(), stringText,Toast.LENGTH_SHORT).show();
        /*
        //Handle the on-click and display a toast, will do more work here later
        Cursor cursor = (Cursor) l.getItemAtPosition(position);

        //this is returning a cursor this time, so need to get the string out of the cursor
        String selectedItem = (String) cursor.getString(cursor.getColumnIndex(PersonContract.PersonEntry.COLUMN_NAME_FIRST));
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), selectedItem, duration);
        toast.show();
        
    }
    */

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
/*
    public void setListView() {

        lv = (ListView) findViewById(R.id.BulbListView);

        // Instanciating an array list (you don't need to do this,
        // you already have yours).
        List<String> your_array_list = new ArrayList<String>();
        your_array_list.add("foo");
        your_array_list.add("bar");

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, your_array_list );

        lv.setAdapter(arrayAdapter);
    }
    */
}
