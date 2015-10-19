package android.anagramit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class LevelSelect extends ActionBarActivity implements View.OnClickListener {

    Button level1;
    Button level2;
    Button level3;
    Button level4;
    Button level5;
    Button level6;
    Button level7;
    Button level8;
    Button level9;
    Button backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);

        // Set up the buttons
        backbutton = (Button) findViewById(R.id.backbutton);
        backbutton.setOnClickListener(this);

        level1 = (Button) findViewById(R.id.level1);
        level1.setOnClickListener(this);

        level2 = (Button) findViewById(R.id.level2);
        level2.setOnClickListener(this);

        level3 = (Button) findViewById(R.id.level3);
        level3.setOnClickListener(this);


    }

    // Actions based on button press
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            // If back button is pressed, go to the home screen
            case R.id.backbutton:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

            // If a level button is pressed, go to the game screen,
            // and pass the level number as an extra
            case R.id.level1:
                Intent intent1 = new Intent(this, GameScreen.class);
                intent1.putExtra("level_num", 1);
                startActivity(intent1);
                break;

            case R.id.level2:
                Intent intent2 = new Intent(this, GameScreen.class);
                intent2.putExtra("level_num", 2);
                startActivity(intent2);
                break;

            case R.id.level3:
                Intent intent3 = new Intent(this, GameScreen.class);
                intent3.putExtra("level_num", 3);
                startActivity(intent3);
                break;


        }
    }
}
