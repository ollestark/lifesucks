package com.ollestark.lifesucks;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

/**
 * Created by Olle on 2016-05-23.
 */
public class RestorePrevActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Class<?> activityClass;

        try {
            SharedPreferences prefs = getSharedPreferences("X", MODE_PRIVATE);
            activityClass = Class.forName(
                    prefs.getString("lastActivity", com.ollestark.lifesucks.MainActivity.class.getName()));
        } catch(ClassNotFoundException ex) {
            activityClass = com.ollestark.lifesucks.MainActivity.class;
        }

        startActivity(new Intent(this, activityClass));
    }
}
