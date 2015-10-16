package android.anagramit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class GameScreen extends ActionBarActivity implements View.OnClickListener {

    Button endgamebutton;
    Button submitbutton;
    Button letter1;
    Button letter2;
    Button letter3;
    Button letter4;
    Button letter5;
    Button letter6;
    Button letter7;
    Button letter8;
    Button letter9;
    Button letter10;
    Button letter11;
    Button letter12;
    TextView leveltext;
    TextView space1;
    TextView space2;
    TextView space3;
    TextView space4;
    TextView space5;
    TextView space6;
    TextView space7;
    TextView space8;
    TextView space9;
    TextView space10;
    TextView space11;
    TextView space12;
    int levelNumber;
    int buttonY;
    int textY;
    int wordLength;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Array of the words for each level
        // i.e. anagram[0] = level 1, anagram[1] = level 2, etc
        // Length of each word must be between 3 and 12
        String[] anagram = {"DRJACOBS", "ANAGRAM", "DEVELOPMENT"};

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        buttonY = 500;
        textY = 750;

        leveltext = (TextView) findViewById(R.id.leveltext);
        space1 = (TextView) findViewById(R.id.space1);
        space2 = (TextView) findViewById(R.id.space2);
        space3 = (TextView) findViewById(R.id.space3);
        space4 = (TextView) findViewById(R.id.space4);
        space5 = (TextView) findViewById(R.id.space5);
        space6 = (TextView) findViewById(R.id.space6);
        space7 = (TextView) findViewById(R.id.space7);
        space8 = (TextView) findViewById(R.id.space8);
        space9 = (TextView) findViewById(R.id.space9);
        space10 = (TextView) findViewById(R.id.space10);
        space11 = (TextView) findViewById(R.id.space11);
        space12 = (TextView) findViewById(R.id.space12);

        endgamebutton = (Button) findViewById(R.id.endgamebutton);
        endgamebutton.setOnClickListener(this);

        submitbutton = (Button) findViewById(R.id.submitbutton);
        submitbutton.setOnClickListener(this);

        // Get the level number
        Intent intent = getIntent();
        levelNumber = intent.getIntExtra("level_num", 0) - 1;

        // Setup the buttons
        letter1 = (Button) findViewById(R.id.letter1);
        letter1.setOnClickListener(this);

        letter2 = (Button) findViewById(R.id.letter2);
        letter2.setOnClickListener(this);

        letter3 = (Button) findViewById(R.id.letter3);
        letter3.setOnClickListener(this);

        letter4 = (Button) findViewById(R.id.letter4);
        letter4.setOnClickListener(this);

        letter5 = (Button) findViewById(R.id.letter5);
        letter5.setOnClickListener(this);

        letter6 = (Button) findViewById(R.id.letter6);
        letter6.setOnClickListener(this);

        letter7 = (Button) findViewById(R.id.letter7);
        letter7.setOnClickListener(this);

        letter8 = (Button) findViewById(R.id.letter8);
        letter8.setOnClickListener(this);

        letter9 = (Button) findViewById(R.id.letter9);
        letter9.setOnClickListener(this);

        letter10 = (Button) findViewById(R.id.letter10);
        letter10.setOnClickListener(this);

        letter11 = (Button) findViewById(R.id.letter11);
        letter11.setOnClickListener(this);

        letter12 = (Button) findViewById(R.id.letter12);
        letter12.setOnClickListener(this);

        // Set up the buttons depending on the length of the word
        initButtons(anagram, levelNumber);

        // Set the textbox for the level number
        leveltext.setText(Integer.toString(levelNumber + 1));

        wordLength = anagram[levelNumber].length();

        
    }

    // Set up the buttons depending on the length of the word
    private void initButtons(String[] anagram, int levelNumber) {
        
        switch (anagram[levelNumber].length())
        {
            case 3:
                setup3Buttons(anagram[levelNumber]);
                break;

            case 4:
                setup4Buttons(anagram[levelNumber]);
                break;

            case 5:
                setup5Buttons(anagram[levelNumber]);
                break;

            case 6:
                setup6Buttons(anagram[levelNumber]);
                break;

            case 7:
                setup7Buttons(anagram[levelNumber]);
                break;

            case 8:
                setup8Buttons(anagram[levelNumber]);
                break;

            case 9:
                setup9Buttons(anagram[levelNumber]);
                break;

            case 10:
                setup10Buttons(anagram[levelNumber]);
                break;

            case 11:
                setup11Buttons(anagram[levelNumber]);
                break;

            case 12:
                setup12Buttons(anagram[levelNumber]);
                break;

            default:
                break;

        }
        
    }

    private void setup3Buttons(String word) {
        ViewGroup.LayoutParams letter1params = letter1.getLayoutParams();
        letter1params.width = 125;
        letter1params.height = 125;
        letter1.requestLayout();

        ViewGroup.LayoutParams letter2params = letter2.getLayoutParams();
        letter2params.width = 125;
        letter2params.height = 125;
        letter2.requestLayout();

        ViewGroup.LayoutParams letter3params = letter3.getLayoutParams();
        letter3params.width = 125;
        letter3params.height = 125;
        letter3.requestLayout();

        letter1.setX(25);
        letter1.setY(buttonY);

        letter2.setX(150);
        letter2.setY(buttonY);

        letter3.setX(275);
        letter3.setY(buttonY);

        letter1.setText(word.subSequence(0, 1));
        letter2.setText(word.subSequence(1, 2));
        letter3.setText(word.subSequence(2, 3));

        ViewGroup.LayoutParams space1params = space1.getLayoutParams();
        space1params.width = 125;
        space1params.height = 125;
        space1.requestLayout();

        ViewGroup.LayoutParams space2params = space2.getLayoutParams();
        space2params.width = 125;
        space2params.height = 125;
        space2.requestLayout();

        ViewGroup.LayoutParams space3params = space3.getLayoutParams();
        space3params.width = 125;
        space3params.height = 125;
        space3.requestLayout();

        space1.setX(25);
        space1.setY(textY);

        space2.setX(150);
        space2.setY(textY);

        space3.setX(275);
        space3.setY(textY);

        letter4.setVisibility(View.INVISIBLE);
        letter5.setVisibility(View.INVISIBLE);
        letter6.setVisibility(View.INVISIBLE);
        letter7.setVisibility(View.INVISIBLE);
        letter8.setVisibility(View.INVISIBLE);
        letter9.setVisibility(View.INVISIBLE);
        letter10.setVisibility(View.INVISIBLE);
        letter11.setVisibility(View.INVISIBLE);
        letter12.setVisibility(View.INVISIBLE);

        space4.setVisibility(View.INVISIBLE);
        space5.setVisibility(View.INVISIBLE);
        space6.setVisibility(View.INVISIBLE);
        space7.setVisibility(View.INVISIBLE);
        space8.setVisibility(View.INVISIBLE);
        space9.setVisibility(View.INVISIBLE);
        space10.setVisibility(View.INVISIBLE);
        space11.setVisibility(View.INVISIBLE);
        space12.setVisibility(View.INVISIBLE);

        space1.setText("");
        space2.setText("");
        space3.setText("");
    }

    private void setup4Buttons(String word) {
        ViewGroup.LayoutParams letter1params = letter1.getLayoutParams();
        letter1params.width = 125;
        letter1params.height = 125;
        letter1.requestLayout();

        ViewGroup.LayoutParams letter2params = letter2.getLayoutParams();
        letter2params.width = 125;
        letter2params.height = 125;
        letter2.requestLayout();

        ViewGroup.LayoutParams letter3params = letter3.getLayoutParams();
        letter3params.width = 125;
        letter3params.height = 125;
        letter3.requestLayout();

        ViewGroup.LayoutParams letter4params = letter4.getLayoutParams();
        letter4params.width = 125;
        letter4params.height = 125;
        letter4.requestLayout();

        letter1.setX(25);
        letter1.setY(buttonY);

        letter2.setX(150);
        letter2.setY(buttonY);

        letter3.setX(275);
        letter3.setY(buttonY);

        letter4.setX(400);
        letter4.setY(buttonY);

        letter1.setText(word.subSequence(0, 1));
        letter2.setText(word.subSequence(1, 2));
        letter3.setText(word.subSequence(2, 3));
        letter4.setText(word.subSequence(3, 4));

        ViewGroup.LayoutParams space1params = space1.getLayoutParams();
        space1params.width = 125;
        space1params.height = 125;
        space1.requestLayout();

        ViewGroup.LayoutParams space2params = space2.getLayoutParams();
        space2params.width = 125;
        space2params.height = 125;
        space2.requestLayout();

        ViewGroup.LayoutParams space3params = space3.getLayoutParams();
        space3params.width = 125;
        space3params.height = 125;
        space3.requestLayout();

        ViewGroup.LayoutParams space4params = space4.getLayoutParams();
        space4params.width = 125;
        space4params.height = 125;
        space4.requestLayout();

        space1.setX(25);
        space1.setY(textY);

        space2.setX(150);
        space2.setY(textY);

        space3.setX(275);
        space3.setY(textY);

        space4.setX(400);
        space4.setY(textY);

        letter5.setVisibility(View.INVISIBLE);
        letter6.setVisibility(View.INVISIBLE);
        letter7.setVisibility(View.INVISIBLE);
        letter8.setVisibility(View.INVISIBLE);
        letter9.setVisibility(View.INVISIBLE);
        letter10.setVisibility(View.INVISIBLE);
        letter11.setVisibility(View.INVISIBLE);
        letter12.setVisibility(View.INVISIBLE);

        space5.setVisibility(View.INVISIBLE);
        space6.setVisibility(View.INVISIBLE);
        space7.setVisibility(View.INVISIBLE);
        space8.setVisibility(View.INVISIBLE);
        space9.setVisibility(View.INVISIBLE);
        space10.setVisibility(View.INVISIBLE);
        space11.setVisibility(View.INVISIBLE);
        space12.setVisibility(View.INVISIBLE);

        space1.setText("");
        space2.setText("");
        space3.setText("");
        space4.setText("");

    }

    private void setup5Buttons(String word) {
        ViewGroup.LayoutParams letter1params = letter1.getLayoutParams();
        letter1params.width = 125;
        letter1params.height = 125;
        letter1.requestLayout();

        ViewGroup.LayoutParams letter2params = letter2.getLayoutParams();
        letter2params.width = 125;
        letter2params.height = 125;
        letter2.requestLayout();

        ViewGroup.LayoutParams letter3params = letter3.getLayoutParams();
        letter3params.width = 125;
        letter3params.height = 125;
        letter3.requestLayout();

        ViewGroup.LayoutParams letter4params = letter4.getLayoutParams();
        letter4params.width = 125;
        letter4params.height = 125;
        letter4.requestLayout();

        ViewGroup.LayoutParams letter5params = letter5.getLayoutParams();
        letter5params.width = 125;
        letter5params.height = 125;
        letter5.requestLayout();

        letter1.setX(25);
        letter1.setY(buttonY);

        letter2.setX(150);
        letter2.setY(buttonY);

        letter3.setX(275);
        letter3.setY(buttonY);

        letter4.setX(400);
        letter4.setY(buttonY);

        letter5.setX(525);
        letter5.setY(buttonY);

        letter1.setText(word.subSequence(0, 1));
        letter2.setText(word.subSequence(1, 2));
        letter3.setText(word.subSequence(2, 3));
        letter4.setText(word.subSequence(3, 4));
        letter5.setText(word.subSequence(4, 5));

        ViewGroup.LayoutParams space1params = space1.getLayoutParams();
        space1params.width = 125;
        space1params.height = 125;
        space1.requestLayout();

        ViewGroup.LayoutParams space2params = space2.getLayoutParams();
        space2params.width = 125;
        space2params.height = 125;
        space2.requestLayout();

        ViewGroup.LayoutParams space3params = space3.getLayoutParams();
        space3params.width = 125;
        space3params.height = 125;
        space3.requestLayout();

        ViewGroup.LayoutParams space4params = space4.getLayoutParams();
        space4params.width = 125;
        space4params.height = 125;
        space4.requestLayout();

        ViewGroup.LayoutParams space5params = space5.getLayoutParams();
        space5params.width = 125;
        space5params.height = 125;
        space5.requestLayout();

        space1.setX(25);
        space1.setY(textY);

        space2.setX(150);
        space2.setY(textY);

        space3.setX(275);
        space3.setY(textY);

        space4.setX(400);
        space4.setY(textY);

        space5.setX(525);
        space5.setY(textY);

        letter6.setVisibility(View.INVISIBLE);
        letter7.setVisibility(View.INVISIBLE);
        letter8.setVisibility(View.INVISIBLE);
        letter9.setVisibility(View.INVISIBLE);
        letter10.setVisibility(View.INVISIBLE);
        letter11.setVisibility(View.INVISIBLE);
        letter12.setVisibility(View.INVISIBLE);

        space6.setVisibility(View.INVISIBLE);
        space7.setVisibility(View.INVISIBLE);
        space8.setVisibility(View.INVISIBLE);
        space9.setVisibility(View.INVISIBLE);
        space10.setVisibility(View.INVISIBLE);
        space11.setVisibility(View.INVISIBLE);
        space12.setVisibility(View.INVISIBLE);

        space1.setText("");
        space2.setText("");
        space3.setText("");
        space4.setText("");
        space5.setText("");

    }

    private void setup6Buttons(String word) {
        ViewGroup.LayoutParams letter1params = letter1.getLayoutParams();
        letter1params.width = 125;
        letter1params.height = 125;
        letter1.requestLayout();

        ViewGroup.LayoutParams letter2params = letter2.getLayoutParams();
        letter2params.width = 125;
        letter2params.height = 125;
        letter2.requestLayout();

        ViewGroup.LayoutParams letter3params = letter3.getLayoutParams();
        letter3params.width = 125;
        letter3params.height = 125;
        letter3.requestLayout();

        ViewGroup.LayoutParams letter4params = letter4.getLayoutParams();
        letter4params.width = 125;
        letter4params.height = 125;
        letter4.requestLayout();

        ViewGroup.LayoutParams letter5params = letter5.getLayoutParams();
        letter5params.width = 125;
        letter5params.height = 125;
        letter5.requestLayout();

        ViewGroup.LayoutParams letter6params = letter6.getLayoutParams();
        letter6params.width = 125;
        letter6params.height = 125;
        letter6.requestLayout();

        letter1.setX(25);
        letter1.setY(buttonY);

        letter2.setX(150);
        letter2.setY(buttonY);

        letter3.setX(275);
        letter3.setY(buttonY);

        letter4.setX(400);
        letter4.setY(buttonY);

        letter5.setX(525);
        letter5.setY(buttonY);

        letter6.setX(650);
        letter6.setY(buttonY);

        letter1.setText(word.subSequence(0, 1));
        letter2.setText(word.subSequence(1, 2));
        letter3.setText(word.subSequence(2, 3));
        letter4.setText(word.subSequence(3, 4));
        letter5.setText(word.subSequence(4, 5));
        letter6.setText(word.subSequence(5, 6));

        ViewGroup.LayoutParams space1params = space1.getLayoutParams();
        space1params.width = 125;
        space1params.height = 125;
        space1.requestLayout();

        ViewGroup.LayoutParams space2params = space2.getLayoutParams();
        space2params.width = 125;
        space2params.height = 125;
        space2.requestLayout();

        ViewGroup.LayoutParams space3params = space3.getLayoutParams();
        space3params.width = 125;
        space3params.height = 125;
        space3.requestLayout();

        ViewGroup.LayoutParams space4params = space4.getLayoutParams();
        space4params.width = 125;
        space4params.height = 125;
        space4.requestLayout();

        ViewGroup.LayoutParams space5params = space5.getLayoutParams();
        space5params.width = 125;
        space5params.height = 125;
        space5.requestLayout();

        ViewGroup.LayoutParams space6params = space6.getLayoutParams();
        space6params.width = 125;
        space6params.height = 125;
        space6.requestLayout();

        space1.setX(25);
        space1.setY(textY);

        space2.setX(150);
        space2.setY(textY);

        space3.setX(275);
        space3.setY(textY);

        space4.setX(400);
        space4.setY(textY);

        space5.setX(525);
        space5.setY(textY);

        space6.setX(650);
        space6.setY(textY);

        letter7.setVisibility(View.INVISIBLE);
        letter8.setVisibility(View.INVISIBLE);
        letter9.setVisibility(View.INVISIBLE);
        letter10.setVisibility(View.INVISIBLE);
        letter11.setVisibility(View.INVISIBLE);
        letter12.setVisibility(View.INVISIBLE);

        space7.setVisibility(View.INVISIBLE);
        space8.setVisibility(View.INVISIBLE);
        space9.setVisibility(View.INVISIBLE);
        space10.setVisibility(View.INVISIBLE);
        space11.setVisibility(View.INVISIBLE);
        space12.setVisibility(View.INVISIBLE);

        space1.setText("");
        space2.setText("");
        space3.setText("");
        space4.setText("");
        space5.setText("");
        space6.setText("");

    }

    private void setup7Buttons(String word) {
        ViewGroup.LayoutParams letter1params = letter1.getLayoutParams();
        letter1params.width = 125;
        letter1params.height = 125;
        letter1.requestLayout();

        ViewGroup.LayoutParams letter2params = letter2.getLayoutParams();
        letter2params.width = 125;
        letter2params.height = 125;
        letter2.requestLayout();

        ViewGroup.LayoutParams letter3params = letter3.getLayoutParams();
        letter3params.width = 125;
        letter3params.height = 125;
        letter3.requestLayout();

        ViewGroup.LayoutParams letter4params = letter4.getLayoutParams();
        letter4params.width = 125;
        letter4params.height = 125;
        letter4.requestLayout();

        ViewGroup.LayoutParams letter5params = letter5.getLayoutParams();
        letter5params.width = 125;
        letter5params.height = 125;
        letter5.requestLayout();

        ViewGroup.LayoutParams letter6params = letter6.getLayoutParams();
        letter6params.width = 125;
        letter6params.height = 125;
        letter6.requestLayout();

        ViewGroup.LayoutParams letter7params = letter7.getLayoutParams();
        letter7params.width = 125;
        letter7params.height = 125;
        letter7.requestLayout();

        letter1.setX(25);
        letter1.setY(buttonY);

        letter2.setX(150);
        letter2.setY(buttonY);

        letter3.setX(275);
        letter3.setY(buttonY);

        letter4.setX(400);
        letter4.setY(buttonY);

        letter5.setX(525);
        letter5.setY(buttonY);

        letter6.setX(650);
        letter6.setY(buttonY);

        letter7.setX(775);
        letter7.setY(buttonY);

        letter1.setText(word.subSequence(0, 1));
        letter2.setText(word.subSequence(1, 2));
        letter3.setText(word.subSequence(2, 3));
        letter4.setText(word.subSequence(3, 4));
        letter5.setText(word.subSequence(4, 5));
        letter6.setText(word.subSequence(5, 6));
        letter7.setText(word.subSequence(6, 7));

        ViewGroup.LayoutParams space1params = space1.getLayoutParams();
        space1params.width = 125;
        space1params.height = 125;
        space1.requestLayout();

        ViewGroup.LayoutParams space2params = space2.getLayoutParams();
        space2params.width = 125;
        space2params.height = 125;
        space2.requestLayout();

        ViewGroup.LayoutParams space3params = space3.getLayoutParams();
        space3params.width = 125;
        space3params.height = 125;
        space3.requestLayout();

        ViewGroup.LayoutParams space4params = space4.getLayoutParams();
        space4params.width = 125;
        space4params.height = 125;
        space4.requestLayout();

        ViewGroup.LayoutParams space5params = space5.getLayoutParams();
        space5params.width = 125;
        space5params.height = 125;
        space5.requestLayout();

        ViewGroup.LayoutParams space6params = space6.getLayoutParams();
        space6params.width = 125;
        space6params.height = 125;
        space6.requestLayout();

        ViewGroup.LayoutParams space7params = space7.getLayoutParams();
        space7params.width = 125;
        space7params.height = 125;
        space7.requestLayout();

        space1.setX(25);
        space1.setY(textY);

        space2.setX(150);
        space2.setY(textY);

        space3.setX(275);
        space3.setY(textY);

        space4.setX(400);
        space4.setY(textY);

        space5.setX(525);
        space5.setY(textY);

        space6.setX(650);
        space6.setY(textY);

        space7.setX(775);
        space7.setY(textY);

        letter8.setVisibility(View.INVISIBLE);
        letter9.setVisibility(View.INVISIBLE);
        letter10.setVisibility(View.INVISIBLE);
        letter11.setVisibility(View.INVISIBLE);
        letter12.setVisibility(View.INVISIBLE);

        space8.setVisibility(View.INVISIBLE);
        space9.setVisibility(View.INVISIBLE);
        space10.setVisibility(View.INVISIBLE);
        space11.setVisibility(View.INVISIBLE);
        space12.setVisibility(View.INVISIBLE);

        space1.setText("");
        space2.setText("");
        space3.setText("");
        space4.setText("");
        space5.setText("");
        space6.setText("");
        space7.setText("");
    }

    private void setup8Buttons(String word) {
        ViewGroup.LayoutParams letter1params = letter1.getLayoutParams();
        letter1params.width = 125;
        letter1params.height = 125;
        letter1.requestLayout();

        ViewGroup.LayoutParams letter2params = letter2.getLayoutParams();
        letter2params.width = 125;
        letter2params.height = 125;
        letter2.requestLayout();

        ViewGroup.LayoutParams letter3params = letter3.getLayoutParams();
        letter3params.width = 125;
        letter3params.height = 125;
        letter3.requestLayout();

        ViewGroup.LayoutParams letter4params = letter4.getLayoutParams();
        letter4params.width = 125;
        letter4params.height = 125;
        letter4.requestLayout();

        ViewGroup.LayoutParams letter5params = letter5.getLayoutParams();
        letter5params.width = 125;
        letter5params.height = 125;
        letter5.requestLayout();

        ViewGroup.LayoutParams letter6params = letter6.getLayoutParams();
        letter6params.width = 125;
        letter6params.height = 125;
        letter6.requestLayout();

        ViewGroup.LayoutParams letter7params = letter7.getLayoutParams();
        letter7params.width = 125;
        letter7params.height = 125;
        letter7.requestLayout();

        ViewGroup.LayoutParams letter8params = letter8.getLayoutParams();
        letter8params.width = 125;
        letter8params.height = 125;
        letter8.requestLayout();

        letter1.setX(25);
        letter1.setY(buttonY);

        letter2.setX(150);
        letter2.setY(buttonY);

        letter3.setX(275);
        letter3.setY(buttonY);

        letter4.setX(400);
        letter4.setY(buttonY);

        letter5.setX(525);
        letter5.setY(buttonY);

        letter6.setX(650);
        letter6.setY(buttonY);

        letter7.setX(775);
        letter7.setY(buttonY);

        letter8.setX(900);
        letter8.setY(buttonY);

        letter1.setText(word.subSequence(0, 1));
        letter2.setText(word.subSequence(1, 2));
        letter3.setText(word.subSequence(2, 3));
        letter4.setText(word.subSequence(3, 4));
        letter5.setText(word.subSequence(4, 5));
        letter6.setText(word.subSequence(5, 6));
        letter7.setText(word.subSequence(6, 7));
        letter8.setText(word.subSequence(7, 8));

        ViewGroup.LayoutParams space1params = space1.getLayoutParams();
        space1params.width = 125;
        space1params.height = 125;
        space1.requestLayout();

        ViewGroup.LayoutParams space2params = space2.getLayoutParams();
        space2params.width = 125;
        space2params.height = 125;
        space2.requestLayout();

        ViewGroup.LayoutParams space3params = space3.getLayoutParams();
        space3params.width = 125;
        space3params.height = 125;
        space3.requestLayout();

        ViewGroup.LayoutParams space4params = space4.getLayoutParams();
        space4params.width = 125;
        space4params.height = 125;
        space4.requestLayout();

        ViewGroup.LayoutParams space5params = space5.getLayoutParams();
        space5params.width = 125;
        space5params.height = 125;
        space5.requestLayout();

        ViewGroup.LayoutParams space6params = space6.getLayoutParams();
        space6params.width = 125;
        space6params.height = 125;
        space6.requestLayout();

        ViewGroup.LayoutParams space7params = space7.getLayoutParams();
        space7params.width = 125;
        space7params.height = 125;
        space7.requestLayout();

        ViewGroup.LayoutParams space8params = space8.getLayoutParams();
        space8params.width = 125;
        space8params.height = 125;
        space8.requestLayout();

        space1.setX(25);
        space1.setY(textY);

        space2.setX(150);
        space2.setY(textY);

        space3.setX(275);
        space3.setY(textY);

        space4.setX(400);
        space4.setY(textY);

        space5.setX(525);
        space5.setY(textY);

        space6.setX(650);
        space6.setY(textY);

        space7.setX(775);
        space7.setY(textY);

        space8.setX(900);
        space8.setY(textY);

        letter9.setVisibility(View.INVISIBLE);
        letter10.setVisibility(View.INVISIBLE);
        letter11.setVisibility(View.INVISIBLE);
        letter12.setVisibility(View.INVISIBLE);

        space9.setVisibility(View.INVISIBLE);
        space10.setVisibility(View.INVISIBLE);
        space11.setVisibility(View.INVISIBLE);
        space12.setVisibility(View.INVISIBLE);

        space1.setText("");
        space2.setText("");
        space3.setText("");
        space4.setText("");
        space5.setText("");
        space6.setText("");
        space7.setText("");
        space8.setText("");
    }

    private void setup9Buttons(String word) {
        ViewGroup.LayoutParams letter1params = letter1.getLayoutParams();
        letter1params.width = 125;
        letter1params.height = 125;
        letter1.requestLayout();

        ViewGroup.LayoutParams letter2params = letter2.getLayoutParams();
        letter2params.width = 125;
        letter2params.height = 125;
        letter2.requestLayout();

        ViewGroup.LayoutParams letter3params = letter3.getLayoutParams();
        letter3params.width = 125;
        letter3params.height = 125;
        letter3.requestLayout();

        ViewGroup.LayoutParams letter4params = letter4.getLayoutParams();
        letter4params.width = 125;
        letter4params.height = 125;
        letter4.requestLayout();

        ViewGroup.LayoutParams letter5params = letter5.getLayoutParams();
        letter5params.width = 125;
        letter5params.height = 125;
        letter5.requestLayout();

        ViewGroup.LayoutParams letter6params = letter6.getLayoutParams();
        letter6params.width = 125;
        letter6params.height = 125;
        letter6.requestLayout();

        ViewGroup.LayoutParams letter7params = letter7.getLayoutParams();
        letter7params.width = 125;
        letter7params.height = 125;
        letter7.requestLayout();

        ViewGroup.LayoutParams letter8params = letter8.getLayoutParams();
        letter8params.width = 125;
        letter8params.height = 125;
        letter8.requestLayout();

        ViewGroup.LayoutParams letter9params = letter8.getLayoutParams();
        letter9params.width = 125;
        letter9params.height = 125;
        letter9.requestLayout();

        letter1.setX(25);
        letter1.setY(buttonY);

        letter2.setX(150);
        letter2.setY(buttonY);

        letter3.setX(275);
        letter3.setY(buttonY);

        letter4.setX(400);
        letter4.setY(buttonY);

        letter5.setX(525);
        letter5.setY(buttonY);

        letter6.setX(650);
        letter6.setY(buttonY);

        letter7.setX(775);
        letter7.setY(buttonY);

        letter8.setX(900);
        letter8.setY(buttonY);

        letter9.setX(900);
        letter9.setY(buttonY);

        letter1.setText(word.subSequence(0, 1));
        letter2.setText(word.subSequence(1, 2));
        letter3.setText(word.subSequence(2, 3));
        letter4.setText(word.subSequence(3, 4));
        letter5.setText(word.subSequence(4, 5));
        letter6.setText(word.subSequence(5, 6));
        letter7.setText(word.subSequence(6, 7));
        letter8.setText(word.subSequence(7, 8));
        letter9.setText(word.subSequence(8, 9));

        ViewGroup.LayoutParams space1params = space1.getLayoutParams();
        space1params.width = 125;
        space1params.height = 125;
        space1.requestLayout();

        ViewGroup.LayoutParams space2params = space2.getLayoutParams();
        space2params.width = 125;
        space2params.height = 125;
        space2.requestLayout();

        ViewGroup.LayoutParams space3params = space3.getLayoutParams();
        space3params.width = 125;
        space3params.height = 125;
        space3.requestLayout();

        ViewGroup.LayoutParams space4params = space4.getLayoutParams();
        space4params.width = 125;
        space4params.height = 125;
        space4.requestLayout();

        ViewGroup.LayoutParams space5params = space5.getLayoutParams();
        space5params.width = 125;
        space5params.height = 125;
        space5.requestLayout();

        ViewGroup.LayoutParams space6params = space6.getLayoutParams();
        space6params.width = 125;
        space6params.height = 125;
        space6.requestLayout();

        ViewGroup.LayoutParams space7params = space7.getLayoutParams();
        space7params.width = 125;
        space7params.height = 125;
        space7.requestLayout();

        ViewGroup.LayoutParams space8params = space8.getLayoutParams();
        space8params.width = 125;
        space8params.height = 125;
        space8.requestLayout();

        ViewGroup.LayoutParams space9params = space9.getLayoutParams();
        space9params.width = 125;
        space9params.height = 125;
        space9.requestLayout();

        space1.setX(25);
        space1.setY(textY);

        space2.setX(150);
        space2.setY(textY);

        space3.setX(275);
        space3.setY(textY);

        space4.setX(400);
        space4.setY(textY);

        space5.setX(525);
        space5.setY(textY);

        space6.setX(650);
        space6.setY(textY);

        space7.setX(775);
        space7.setY(textY);

        space8.setX(900);
        space8.setY(textY);

        space9.setX(1015);
        space9.setY(textY);

        letter10.setVisibility(View.INVISIBLE);
        letter11.setVisibility(View.INVISIBLE);
        letter12.setVisibility(View.INVISIBLE);

        space10.setVisibility(View.INVISIBLE);
        space11.setVisibility(View.INVISIBLE);
        space12.setVisibility(View.INVISIBLE);

        space1.setText("");
        space2.setText("");
        space3.setText("");
        space4.setText("");
        space5.setText("");
        space6.setText("");
        space7.setText("");
        space8.setText("");
        space9.setText("");

    }

    private void setup10Buttons(String word) {
        ViewGroup.LayoutParams letter1params = letter1.getLayoutParams();
        letter1params.width = 125;
        letter1params.height = 125;
        letter1.requestLayout();

        ViewGroup.LayoutParams letter2params = letter2.getLayoutParams();
        letter2params.width = 125;
        letter2params.height = 125;
        letter2.requestLayout();

        ViewGroup.LayoutParams letter3params = letter3.getLayoutParams();
        letter3params.width = 125;
        letter3params.height = 125;
        letter3.requestLayout();

        ViewGroup.LayoutParams letter4params = letter4.getLayoutParams();
        letter4params.width = 125;
        letter4params.height = 125;
        letter4.requestLayout();

        ViewGroup.LayoutParams letter5params = letter5.getLayoutParams();
        letter5params.width = 125;
        letter5params.height = 125;
        letter5.requestLayout();

        ViewGroup.LayoutParams letter6params = letter6.getLayoutParams();
        letter6params.width = 125;
        letter6params.height = 125;
        letter6.requestLayout();

        ViewGroup.LayoutParams letter7params = letter7.getLayoutParams();
        letter7params.width = 125;
        letter7params.height = 125;
        letter7.requestLayout();

        ViewGroup.LayoutParams letter8params = letter8.getLayoutParams();
        letter8params.width = 125;
        letter8params.height = 125;
        letter8.requestLayout();

        ViewGroup.LayoutParams letter9params = letter8.getLayoutParams();
        letter9params.width = 125;
        letter9params.height = 125;
        letter9.requestLayout();

        ViewGroup.LayoutParams letter10params = letter8.getLayoutParams();
        letter10params.width = 125;
        letter10params.height = 125;
        letter10.requestLayout();

        letter1.setX(25);
        letter1.setY(buttonY);

        letter2.setX(150);
        letter2.setY(buttonY);

        letter3.setX(275);
        letter3.setY(buttonY);

        letter4.setX(400);
        letter4.setY(buttonY);

        letter5.setX(525);
        letter5.setY(buttonY);

        letter6.setX(650);
        letter6.setY(buttonY);

        letter7.setX(775);
        letter7.setY(buttonY);

        letter8.setX(900);
        letter8.setY(buttonY);

        letter9.setX(900);
        letter9.setY(buttonY);

        letter10.setX(900);
        letter10.setY(buttonY);

        letter1.setText(word.subSequence(0, 1));
        letter2.setText(word.subSequence(1, 2));
        letter3.setText(word.subSequence(2, 3));
        letter4.setText(word.subSequence(3, 4));
        letter5.setText(word.subSequence(4, 5));
        letter6.setText(word.subSequence(5, 6));
        letter7.setText(word.subSequence(6, 7));
        letter8.setText(word.subSequence(7, 8));
        letter9.setText(word.subSequence(8, 9));
        letter10.setText(word.subSequence(9, 10));

        ViewGroup.LayoutParams space1params = space1.getLayoutParams();
        space1params.width = 125;
        space1params.height = 125;
        space1.requestLayout();

        ViewGroup.LayoutParams space2params = space2.getLayoutParams();
        space2params.width = 125;
        space2params.height = 125;
        space2.requestLayout();

        ViewGroup.LayoutParams space3params = space3.getLayoutParams();
        space3params.width = 125;
        space3params.height = 125;
        space3.requestLayout();

        ViewGroup.LayoutParams space4params = space4.getLayoutParams();
        space4params.width = 125;
        space4params.height = 125;
        space4.requestLayout();

        ViewGroup.LayoutParams space5params = space5.getLayoutParams();
        space5params.width = 125;
        space5params.height = 125;
        space5.requestLayout();

        ViewGroup.LayoutParams space6params = space6.getLayoutParams();
        space6params.width = 125;
        space6params.height = 125;
        space6.requestLayout();

        ViewGroup.LayoutParams space7params = space7.getLayoutParams();
        space7params.width = 125;
        space7params.height = 125;
        space7.requestLayout();

        ViewGroup.LayoutParams space8params = space8.getLayoutParams();
        space8params.width = 125;
        space8params.height = 125;
        space8.requestLayout();

        ViewGroup.LayoutParams space9params = space9.getLayoutParams();
        space9params.width = 125;
        space9params.height = 125;
        space9.requestLayout();

        ViewGroup.LayoutParams space10params = space10.getLayoutParams();
        space10params.width = 125;
        space10params.height = 125;
        space10.requestLayout();

        space1.setX(25);
        space1.setY(textY);

        space2.setX(150);
        space2.setY(textY);

        space3.setX(275);
        space3.setY(textY);

        space4.setX(400);
        space4.setY(textY);

        space5.setX(525);
        space5.setY(textY);

        space6.setX(650);
        space6.setY(textY);

        space7.setX(775);
        space7.setY(textY);

        space8.setX(900);
        space8.setY(textY);

        space9.setX(1015);
        space9.setY(textY);

        space10.setX(1150);
        space10.setY(textY);

        letter11.setVisibility(View.INVISIBLE);
        letter12.setVisibility(View.INVISIBLE);

        space11.setVisibility(View.INVISIBLE);
        space12.setVisibility(View.INVISIBLE);

        space1.setText("");
        space2.setText("");
        space3.setText("");
        space4.setText("");
        space5.setText("");
        space6.setText("");
        space7.setText("");
        space8.setText("");
        space9.setText("");
        space10.setText("");

    }

    private void setup11Buttons(String word) {
        ViewGroup.LayoutParams letter1params = letter1.getLayoutParams();
        letter1params.width = 125;
        letter1params.height = 125;
        letter1.requestLayout();

        ViewGroup.LayoutParams letter2params = letter2.getLayoutParams();
        letter2params.width = 125;
        letter2params.height = 125;
        letter2.requestLayout();

        ViewGroup.LayoutParams letter3params = letter3.getLayoutParams();
        letter3params.width = 125;
        letter3params.height = 125;
        letter3.requestLayout();

        ViewGroup.LayoutParams letter4params = letter4.getLayoutParams();
        letter4params.width = 125;
        letter4params.height = 125;
        letter4.requestLayout();

        ViewGroup.LayoutParams letter5params = letter5.getLayoutParams();
        letter5params.width = 125;
        letter5params.height = 125;
        letter5.requestLayout();

        ViewGroup.LayoutParams letter6params = letter6.getLayoutParams();
        letter6params.width = 125;
        letter6params.height = 125;
        letter6.requestLayout();

        ViewGroup.LayoutParams letter7params = letter7.getLayoutParams();
        letter7params.width = 125;
        letter7params.height = 125;
        letter7.requestLayout();

        ViewGroup.LayoutParams letter8params = letter8.getLayoutParams();
        letter8params.width = 125;
        letter8params.height = 125;
        letter8.requestLayout();

        ViewGroup.LayoutParams letter9params = letter8.getLayoutParams();
        letter9params.width = 125;
        letter9params.height = 125;
        letter9.requestLayout();

        ViewGroup.LayoutParams letter10params = letter8.getLayoutParams();
        letter10params.width = 125;
        letter10params.height = 125;
        letter10.requestLayout();

        ViewGroup.LayoutParams letter11params = letter8.getLayoutParams();
        letter11params.width = 125;
        letter11params.height = 125;
        letter11.requestLayout();

        letter1.setX(25);
        letter1.setY(buttonY);

        letter2.setX(150);
        letter2.setY(buttonY);

        letter3.setX(275);
        letter3.setY(buttonY);

        letter4.setX(400);
        letter4.setY(buttonY);

        letter5.setX(525);
        letter5.setY(buttonY);

        letter6.setX(650);
        letter6.setY(buttonY);

        letter7.setX(775);
        letter7.setY(buttonY);

        letter8.setX(900);
        letter8.setY(buttonY);

        letter9.setX(900);
        letter9.setY(buttonY);

        letter10.setX(900);
        letter10.setY(buttonY);

        letter11.setX(900);
        letter11.setY(buttonY);

        letter1.setText(word.subSequence(0, 1));
        letter2.setText(word.subSequence(1, 2));
        letter3.setText(word.subSequence(2, 3));
        letter4.setText(word.subSequence(3, 4));
        letter5.setText(word.subSequence(4, 5));
        letter6.setText(word.subSequence(5, 6));
        letter7.setText(word.subSequence(6, 7));
        letter8.setText(word.subSequence(7, 8));
        letter9.setText(word.subSequence(8, 9));
        letter10.setText(word.subSequence(9, 10));
        letter11.setText(word.subSequence(10, 11));

        ViewGroup.LayoutParams space1params = space1.getLayoutParams();
        space1params.width = 125;
        space1params.height = 125;
        space1.requestLayout();

        ViewGroup.LayoutParams space2params = space2.getLayoutParams();
        space2params.width = 125;
        space2params.height = 125;
        space2.requestLayout();

        ViewGroup.LayoutParams space3params = space3.getLayoutParams();
        space3params.width = 125;
        space3params.height = 125;
        space3.requestLayout();

        ViewGroup.LayoutParams space4params = space4.getLayoutParams();
        space4params.width = 125;
        space4params.height = 125;
        space4.requestLayout();

        ViewGroup.LayoutParams space5params = space5.getLayoutParams();
        space5params.width = 125;
        space5params.height = 125;
        space5.requestLayout();

        ViewGroup.LayoutParams space6params = space6.getLayoutParams();
        space6params.width = 125;
        space6params.height = 125;
        space6.requestLayout();

        ViewGroup.LayoutParams space7params = space7.getLayoutParams();
        space7params.width = 125;
        space7params.height = 125;
        space7.requestLayout();

        ViewGroup.LayoutParams space8params = space8.getLayoutParams();
        space8params.width = 125;
        space8params.height = 125;
        space8.requestLayout();

        ViewGroup.LayoutParams space9params = space9.getLayoutParams();
        space9params.width = 125;
        space9params.height = 125;
        space9.requestLayout();

        ViewGroup.LayoutParams space10params = space10.getLayoutParams();
        space10params.width = 125;
        space10params.height = 125;
        space10.requestLayout();

        ViewGroup.LayoutParams space11params = space11.getLayoutParams();
        space11params.width = 125;
        space11params.height = 125;
        space11.requestLayout();

        space1.setX(25);
        space1.setY(textY);

        space2.setX(150);
        space2.setY(textY);

        space3.setX(275);
        space3.setY(textY);

        space4.setX(400);
        space4.setY(textY);

        space5.setX(525);
        space5.setY(textY);

        space6.setX(650);
        space6.setY(textY);

        space7.setX(775);
        space7.setY(textY);

        space8.setX(900);
        space8.setY(textY);

        space9.setX(1015);
        space9.setY(textY);

        space10.setX(1150);
        space10.setY(textY);

        space11.setX(775);
        space11.setY(textY);

        letter12.setVisibility(View.INVISIBLE);

        space12.setVisibility(View.INVISIBLE);

        space1.setText("");
        space2.setText("");
        space3.setText("");
        space4.setText("");
        space5.setText("");
        space6.setText("");
        space7.setText("");
        space8.setText("");
        space9.setText("");
        space10.setText("");
        space11.setText("");

    }

    private void setup12Buttons(String word) {
        ViewGroup.LayoutParams letter1params = letter1.getLayoutParams();
        letter1params.width = 125;
        letter1params.height = 125;
        letter1.requestLayout();

        ViewGroup.LayoutParams letter2params = letter2.getLayoutParams();
        letter2params.width = 125;
        letter2params.height = 125;
        letter2.requestLayout();

        ViewGroup.LayoutParams letter3params = letter3.getLayoutParams();
        letter3params.width = 125;
        letter3params.height = 125;
        letter3.requestLayout();

        ViewGroup.LayoutParams letter4params = letter4.getLayoutParams();
        letter4params.width = 125;
        letter4params.height = 125;
        letter4.requestLayout();

        ViewGroup.LayoutParams letter5params = letter5.getLayoutParams();
        letter5params.width = 125;
        letter5params.height = 125;
        letter5.requestLayout();

        ViewGroup.LayoutParams letter6params = letter6.getLayoutParams();
        letter6params.width = 125;
        letter6params.height = 125;
        letter6.requestLayout();

        ViewGroup.LayoutParams letter7params = letter7.getLayoutParams();
        letter7params.width = 125;
        letter7params.height = 125;
        letter7.requestLayout();

        ViewGroup.LayoutParams letter8params = letter8.getLayoutParams();
        letter8params.width = 125;
        letter8params.height = 125;
        letter8.requestLayout();

        ViewGroup.LayoutParams letter9params = letter8.getLayoutParams();
        letter9params.width = 125;
        letter9params.height = 125;
        letter9.requestLayout();

        ViewGroup.LayoutParams letter10params = letter8.getLayoutParams();
        letter10params.width = 125;
        letter10params.height = 125;
        letter10.requestLayout();

        ViewGroup.LayoutParams letter11params = letter8.getLayoutParams();
        letter11params.width = 125;
        letter11params.height = 125;
        letter11.requestLayout();

        ViewGroup.LayoutParams letter12params = letter8.getLayoutParams();
        letter12params.width = 125;
        letter12params.height = 125;
        letter12.requestLayout();

        letter1.setX(25);
        letter1.setY(buttonY);

        letter2.setX(150);
        letter2.setY(buttonY);

        letter3.setX(275);
        letter3.setY(buttonY);

        letter4.setX(400);
        letter4.setY(buttonY);

        letter5.setX(525);
        letter5.setY(buttonY);

        letter6.setX(650);
        letter6.setY(buttonY);

        letter7.setX(775);
        letter7.setY(buttonY);

        letter8.setX(900);
        letter8.setY(buttonY);

        letter9.setX(900);
        letter9.setY(buttonY);

        letter10.setX(900);
        letter10.setY(buttonY);

        letter11.setX(900);
        letter11.setY(buttonY);

        letter12.setX(900);
        letter12.setY(buttonY);

        letter1.setText(word.subSequence(0, 1));
        letter2.setText(word.subSequence(1, 2));
        letter3.setText(word.subSequence(2, 3));
        letter4.setText(word.subSequence(3, 4));
        letter5.setText(word.subSequence(4, 5));
        letter6.setText(word.subSequence(5, 6));
        letter7.setText(word.subSequence(6, 7));
        letter8.setText(word.subSequence(7, 8));
        letter9.setText(word.subSequence(8, 9));
        letter10.setText(word.subSequence(9, 10));
        letter11.setText(word.subSequence(10, 11));
        letter12.setText(word.subSequence(11, 12));

        ViewGroup.LayoutParams space1params = space1.getLayoutParams();
        space1params.width = 125;
        space1params.height = 125;
        space1.requestLayout();

        ViewGroup.LayoutParams space2params = space2.getLayoutParams();
        space2params.width = 125;
        space2params.height = 125;
        space2.requestLayout();

        ViewGroup.LayoutParams space3params = space3.getLayoutParams();
        space3params.width = 125;
        space3params.height = 125;
        space3.requestLayout();

        ViewGroup.LayoutParams space4params = space4.getLayoutParams();
        space4params.width = 125;
        space4params.height = 125;
        space4.requestLayout();

        ViewGroup.LayoutParams space5params = space5.getLayoutParams();
        space5params.width = 125;
        space5params.height = 125;
        space5.requestLayout();

        ViewGroup.LayoutParams space6params = space6.getLayoutParams();
        space6params.width = 125;
        space6params.height = 125;
        space6.requestLayout();

        ViewGroup.LayoutParams space7params = space7.getLayoutParams();
        space7params.width = 125;
        space7params.height = 125;
        space7.requestLayout();

        ViewGroup.LayoutParams space8params = space8.getLayoutParams();
        space8params.width = 125;
        space8params.height = 125;
        space8.requestLayout();

        ViewGroup.LayoutParams space9params = space9.getLayoutParams();
        space9params.width = 125;
        space9params.height = 125;
        space9.requestLayout();

        ViewGroup.LayoutParams space10params = space10.getLayoutParams();
        space10params.width = 125;
        space10params.height = 125;
        space10.requestLayout();

        ViewGroup.LayoutParams space11params = space11.getLayoutParams();
        space11params.width = 125;
        space11params.height = 125;
        space11.requestLayout();

        ViewGroup.LayoutParams space12params = space12.getLayoutParams();
        space12params.width = 125;
        space12params.height = 125;
        space12.requestLayout();

        space1.setX(25);
        space1.setY(textY);

        space2.setX(150);
        space2.setY(textY);

        space3.setX(275);
        space3.setY(textY);

        space4.setX(400);
        space4.setY(textY);

        space5.setX(525);
        space5.setY(textY);

        space6.setX(650);
        space6.setY(textY);

        space7.setX(775);
        space7.setY(textY);

        space8.setX(900);
        space8.setY(textY);

        space9.setX(1015);
        space9.setY(textY);

        space10.setX(1150);
        space10.setY(textY);

        space11.setX(1275);
        space11.setY(textY);

        space12.setX(1400);
        space12.setY(textY);

        space1.setText("");
        space2.setText("");
        space3.setText("");
        space4.setText("");
        space5.setText("");
        space6.setText("");
        space7.setText("");
        space8.setText("");
        space9.setText("");
        space10.setText("");
        space11.setText("");
        space12.setText("");

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.endgamebutton:
                Intent intent = new Intent(this, ScoreScreen.class);
                startActivity(intent);
                break;

            case R.id.letter1:
                setAvailableSpace(letter1.getText());
                letter1.setEnabled(false);
                break;

            case R.id.letter2:
                setAvailableSpace(letter2.getText());
                letter2.setEnabled(false);
                break;

            case R.id.letter3:
                setAvailableSpace(letter3.getText());
                letter3.setEnabled(false);
                break;

            case R.id.letter4:
                setAvailableSpace(letter4.getText());
                letter4.setEnabled(false);
                break;

            case R.id.letter5:
                setAvailableSpace(letter5.getText());
                letter5.setEnabled(false);
                break;

            case R.id.letter6:
                setAvailableSpace(letter6.getText());
                letter6.setEnabled(false);
                break;

            case R.id.letter7:
                setAvailableSpace(letter7.getText());
                letter7.setEnabled(false);
                break;

            case R.id.letter8:
                setAvailableSpace(letter8.getText());
                letter8.setEnabled(false);
                break;

            case R.id.letter9:
                setAvailableSpace(letter9.getText());
                letter9.setEnabled(false);
                break;

            case R.id.letter10:
                setAvailableSpace(letter10.getText());
                letter10.setEnabled(false);
                break;

            case R.id.letter11:
                setAvailableSpace(letter11.getText());
                letter11.setEnabled(false);
                break;

            case R.id.letter12:
                setAvailableSpace(letter12.getText());
                letter12.setEnabled(false);
                break;
        }
    }

    private void setAvailableSpace(CharSequence letter) {

        if (space1.getText().equals(""))
        {
            space1.setText(letter);
        }
        else if (space2.getText().equals(""))
        {
            space2.setText(letter);
        }
        else if (space3.getText().equals(""))
        {
            space3.setText(letter);
        }
        else if (space4.getText().equals("") && wordLength > 3)
        {
            space4.setText(letter);
        }
        else if (space5.getText().equals("") && wordLength > 4)
        {
            space5.setText(letter);
        }
        else if (space6.getText().equals("") && wordLength > 5)
        {
            space6.setText(letter);
        }
        else if (space7.getText().equals("") && wordLength > 6)
        {
            space7.setText(letter);
        }
        else if (space8.getText().equals("") && wordLength > 7)
        {
            space8.setText(letter);
        }
        else if (space9.getText().equals("") && wordLength > 8)
        {
            space9.setText(letter);
        }
        else if (space10.getText().equals("") && wordLength > 9)
        {
            space10.setText(letter);
        }
        else if (space11.getText().equals("") && wordLength > 10)
        {
            space11.setText(letter);
        }
        else if (space12.getText().equals("") && wordLength > 11)
        {
            space12.setText(letter);
        }

    }
}
