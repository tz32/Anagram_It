package android.anagramit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameScreen extends ActionBarActivity implements View.OnClickListener {

    Button endgamebutton;
    TextView leveltext;
    int level_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        endgamebutton = (Button) findViewById(R.id.endgamebutton);
        endgamebutton.setOnClickListener(this);

        leveltext = (TextView) findViewById(R.id.leveltext);

        Intent intent = getIntent();
        level_number = intent.getIntExtra("level_num", 0);

        leveltext.setText(Integer.toString(level_number));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.endgamebutton:
                Intent intent = new Intent(this, ScoreScreen.class);
                startActivity(intent);
        }
    }
}
