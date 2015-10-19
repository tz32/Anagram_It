package android.anagramit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button startbutton;
    Button settingsbutton;
    Button creditsbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the buttons
        startbutton = (Button) findViewById(R.id.startbutton);
        startbutton.setOnClickListener(this);

       // settingsbutton = (Button) findViewById(R.id.settingsbutton);
       // settingsbutton.setOnClickListener(this);

        creditsbutton = (Button) findViewById(R.id.creditsbutton);
        creditsbutton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            // Go to the screen that corresponds with the button pressed
            case R.id.startbutton:
                Intent intent1 = new Intent(this, LevelSelect.class);
                startActivity(intent1);
                break;

            //case R.id.settingsbutton:
               // Intent intent2 = new Intent(this, Settings.class);
               // startActivity(intent2);
              //  break;

            case R.id.creditsbutton:
                Intent intent3 = new Intent(this, Credits.class);
                startActivity(intent3);
                break;
        }
    }
}
