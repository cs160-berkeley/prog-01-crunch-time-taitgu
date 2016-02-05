package com.example.taitgu.crunchtime;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.EditText;
import android.text.TextWatcher;
import android.text.Editable;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private EditText calories;
    private EditText pushups;
    private EditText situps;
    private EditText jumpingJacks;
    private EditText jogging;
    private boolean changeFlag;
    private static final HashMap<String, Double> exerciseValues;

    static {
        exerciseValues = new HashMap<String, Double>();
        exerciseValues.put("pushups", 3.5);
        exerciseValues.put("situps", 2.0);
        exerciseValues.put("jumping jacks", 0.1);
        exerciseValues.put("jogging", 0.12);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();


        //user code
        changeFlag = true;
        calories = (EditText)findViewById(R.id.calories);
        calories.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {
                if (changeFlag) {
                    if (s.toString().equals("")) {
                        clearValues();
                    } else {
                        updateValues(Double.parseDouble(s.toString()));
                        calories.setSelection(calories.getText().length());
                    }
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });


        pushups = (EditText)findViewById(R.id.pushups);
        pushups.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {
                if(changeFlag) {
                    if(s.toString().equals("")){
                        clearValues();
                    } else {
                        updateValues(Double.parseDouble(s.toString()) / exerciseValues.get("pushups"));
                        pushups.setSelection(pushups.getText().length());
                    }
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        situps = (EditText)findViewById(R.id.situps);
        situps.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {
                if(changeFlag) {
                    if(s.toString().equals("")){
                        clearValues();
                    } else {
                        updateValues(Double.parseDouble(s.toString()) / exerciseValues.get("situps"));
                        situps.setSelection(situps.getText().length());
                    }
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        jumpingJacks = (EditText)findViewById(R.id.jumpingJacks);
        jumpingJacks.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {
                if(changeFlag) {
                    if(s.toString().equals("")){
                        clearValues();
                    } else {
                        updateValues(Double.parseDouble(s.toString()) / exerciseValues.get("jumping jacks"));
                        jumpingJacks.setSelection(jumpingJacks.getText().length());
                    }
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        jogging = (EditText)findViewById(R.id.jogging);
        jogging.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {
                if(changeFlag) {
                    if(s.toString().equals("")){
                        clearValues();
                    } else {
                        updateValues(Double.parseDouble(s.toString()) / exerciseValues.get("jogging"));
                        jogging.setSelection(jogging.getText().length());
                    }
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });
    }

    private void updateValues(Double amount){
        if  (changeFlag) {
            changeFlag = false;
            calories.setText(String.valueOf(java.lang.Math.round(amount)));
            pushups.setText(String.valueOf(java.lang.Math.round(amount * exerciseValues.get("pushups"))));
            situps.setText(String.valueOf(java.lang.Math.round(amount * exerciseValues.get("situps"))));
            jumpingJacks.setText(String.valueOf(java.lang.Math.round(amount * exerciseValues.get("jumping jacks"))));
            jogging.setText(String.valueOf(java.lang.Math.round(amount * exerciseValues.get("jogging"))));
            changeFlag = true;
        }
    }

    private void clearValues(){
        if (changeFlag) {
            changeFlag = false;
            calories.getText().clear();
            pushups.getText().clear();
            situps.getText().clear();
            jumpingJacks.getText().clear();
            jogging.getText().clear();
            changeFlag = true;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.taitgu.crunchtime/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.taitgu.crunchtime/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
