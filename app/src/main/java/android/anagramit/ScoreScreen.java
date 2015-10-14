package android.anagramit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class ScoreScreen extends ActionBarActivity implements View.OnClickListener {

    Button continuebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_screen);

        continuebutton = (Button) findViewById(R.id.continuebutton);
        continuebutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.continuebutton:
                Intent intent = new Intent(this, LevelSelect.class);
                startActivity(intent);
        }
    }
}
