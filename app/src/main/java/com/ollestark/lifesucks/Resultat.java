package com.ollestark.lifesucks;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Olle on 2016-10-21.
 */
public class Resultat extends ActionBarActivity implements View.OnClickListener{

    Button returnButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.texten);
        textView.setTextSize(30);
        textView.setText(message);

        returnButton = (Button) findViewById(R.id.tallybutton);
        returnButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, com.ollestark.lifesucks.MainActivity.class);
        startActivity(intent);
        finish();

    }
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = getSharedPreferences("X", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("com.ollestark.lifesucks.MainActivity", getClass().getName());
        editor.commit();
    }
}
