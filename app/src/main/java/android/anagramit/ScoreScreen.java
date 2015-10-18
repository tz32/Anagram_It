package android.anagramit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreScreen extends ActionBarActivity implements View.OnClickListener {

    Button continuebutton;
    TextView scoretext;

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_screen);

        scoretext = (TextView) findViewById(R.id.scoretext);

        continuebutton = (Button) findViewById(R.id.continuebutton);
        continuebutton.setOnClickListener(this);

        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

        scoretext.setText(Integer.toString(score));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            // If the continue button is pressed, go to the level select screen
            case R.id.continuebutton:
                Intent intent = new Intent(this, LevelSelect.class);
                startActivity(intent);
                break;
        }
    }
}
