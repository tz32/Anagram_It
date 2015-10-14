package android.anagramit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class Settings extends ActionBarActivity implements View.OnClickListener{

    Button backbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        backbutton = (Button) findViewById(R.id.backbutton);
        backbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.backbutton:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
        }
    }
}
