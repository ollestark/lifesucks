package com.ollestark.lifesucks;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    public int positive;
    public int negative;

    Button happyButton;
    Button sadButton;
    Button tallyButton;

    public final static String EXTRA_MESSAGE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Startknapp och onClickListener-metod som startar den huvudsakliga aktivitetsklassen
        happyButton = (Button) findViewById(R.id.happybutton);
        happyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.1F);
                v.startAnimation(buttonClick);
                positive += 1;
            }
        });
        sadButton = (Button) findViewById(R.id.sadbutton);
        sadButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.1F);
                v.startAnimation(buttonClick);
                negative += 1;
            }
        });
        tallyButton = (Button) findViewById(R.id.tallybutton);
        tallyButton.setOnClickListener(this);
    }

    //Metod for att starta nasta aktivitet/klass "Timer" nar knapptryck detekteras, dar appens
    // huvudsakliga funktionalitet ar placerad. Harifran inkluderas inga "extras".
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, com.ollestark.lifesucks.Resultat.class);
        if (positive < negative) {
            intent.putExtra(EXTRA_MESSAGE, "Idag var en trist dag, med " + negative + " irriterande saker och bara " + positive + " roliga :(");
        }
        else if (positive > negative){
            intent.putExtra(EXTRA_MESSAGE, "Idag var en bra dag, med " + positive + " roliga saker och bara " + negative + " trista :)");
        }
        else if (positive == negative) {
            intent.putExtra(EXTRA_MESSAGE, "Idag var en vanlig dag, med lika mycket roliga och trista saker :)");
        }

        startActivity(intent);
        finish();

    }
    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = getSharedPreferences("X", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("com.ollestark.lifesucks.MainActivity" ,getClass().getName());
        editor.commit();
    }
}
