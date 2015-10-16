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

        level4 = (Button) findViewById(R.id.level4);
        level4.setOnClickListener(this);

        level5 = (Button) findViewById(R.id.level5);
        level5.setOnClickListener(this);

        level6 = (Button) findViewById(R.id.level6);
        level6.setOnClickListener(this);

        level7 = (Button) findViewById(R.id.level7);
        level7.setOnClickListener(this);

        level8 = (Button) findViewById(R.id.level8);
        level8.setOnClickListener(this);

        level9 = (Button) findViewById(R.id.level9);
        level9.setOnClickListener(this);

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

            case R.id.level4:
                Intent intent4 = new Intent(this, GameScreen.class);
                intent4.putExtra("level_num", 4);
                startActivity(intent4);
                break;

            case R.id.level5:
                Intent intent5 = new Intent(this, GameScreen.class);
                intent5.putExtra("level_num", 5);
                startActivity(intent5);
                break;

            case R.id.level6:
                Intent intent6 = new Intent(this, GameScreen.class);
                intent6.putExtra("level_num", 6);
                startActivity(intent6);
                break;

            case R.id.level7:
                Intent intent7 = new Intent(this, GameScreen.class);
                intent7.putExtra("level_num", 7);
                startActivity(intent7);
                break;

            case R.id.level8:
                Intent intent8 = new Intent(this, GameScreen.class);
                intent8.putExtra("level_num", 8);
                startActivity(intent8);
                break;

            case R.id.level9:
                Intent intent9 = new Intent(this, GameScreen.class);
                intent9.putExtra("level_num", 9);
                startActivity(intent9);
                break;

        }
    }
}
