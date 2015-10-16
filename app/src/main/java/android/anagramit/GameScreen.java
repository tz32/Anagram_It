package android.anagramit;


import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.lang.Math;

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
    TextView clock;
    int levelNumber;
    int buttonY;
    int textY;
    int wordLength;
    int sideBorder;
    int screenWidth;
    int spacing;
    int solutionNumber;
    int time = 0;
    String guess = "";

    // Array of the words for each level
    // i.e. anagram[0] = level 1, anagram[1] = level 2, etc
    // Length of each word must be between 3 and 9
    String[] anagram = {"123", "1234", "12345", "123456", "ANAGRAM", "DRJACOBS", "123456789", "DESIGN", "DEVELOP", "TESTING"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Array of the words for each level
        // i.e. anagram[0] = level 1, anagram[1] = level 2, etc
        // Length of each word must be between 3 and 9
       // String[] anagram = {"123", "1234", "12345", "123456", "ANAGRAM", "DRJACOBS", "123456789", "DESIGN", "DEVELOP", "TESTING"};

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        // Get the width of the screen
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;

        // Get the text boxes from the XML file
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
        clock = (TextView) findViewById(R.id.textView9);

        // Get the End Game and Submit buttons from the XML
        endgamebutton = (Button) findViewById(R.id.endgamebutton);
        endgamebutton.setOnClickListener(this);

        submitbutton = (Button) findViewById(R.id.submitbutton);
        submitbutton.setOnClickListener(this);

        // Get the level number from the level select screen
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

        // Calculate the length of the word
        wordLength = anagram[levelNumber].length();

        // Set up the buttons depending on the length of the word
        initButtons(anagram, levelNumber);

        // Set the textbox for the level number
        leveltext.setText(Integer.toString(levelNumber + 1));

    }

    // The actions that will be performed when a specific button is pressed
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            // If the End Game button is pressed, go to the scorescreen
            case R.id.endgamebutton:
                Intent intent = new Intent(this, ScoreScreen.class);
                startActivity(intent);
                break;
            // currently the subbmit button changes its test to show if the word is correct or not
            // this is just a aplce holder and should be changed.
            case R.id.submitbutton:
                if(guess.equals(anagram[solutionNumber])) {
                    submitbutton.setText("correct");
                } else submitbutton.setText("false");

            // If a letter button is pressed, put that character in the next available text box,
            // and disable the button that was pressed
            case R.id.letter1:
                setAvailableSpace(letter1.getText());
                guess = guess + letter1.getText();
                letter1.setEnabled(false);
                break;

            case R.id.letter2:
                setAvailableSpace(letter2.getText());
                guess = guess + letter2.getText();
                letter2.setEnabled(false);
                break;

            case R.id.letter3:
                setAvailableSpace(letter3.getText());
                guess = guess + letter3.getText();
                letter3.setEnabled(false);
                break;

            case R.id.letter4:
                setAvailableSpace(letter4.getText());
                guess = guess + letter4.getText();
                letter4.setEnabled(false);
                break;

            case R.id.letter5:
                setAvailableSpace(letter5.getText());
                guess = guess + letter5.getText();
                letter5.setEnabled(false);
                break;

            case R.id.letter6:
                setAvailableSpace(letter6.getText());
                guess = guess + letter6.getText();
                letter6.setEnabled(false);
                break;

            case R.id.letter7:
                setAvailableSpace(letter7.getText());
                guess = guess + letter7.getText();
                letter7.setEnabled(false);
                break;

            case R.id.letter8:
                setAvailableSpace(letter8.getText());
                guess = guess + letter8.getText();
                letter8.setEnabled(false);
                break;

            case R.id.letter9:
                setAvailableSpace(letter9.getText());
                guess = guess + letter9.getText();
                letter9.setEnabled(false);
                break;

            default:
                break;
        }
    }

    // Place the letter in the button pressed in the next available text box,
    // then disable the button so it cannot be pushed again
    // If the text boxes are full, do nothing
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
    }

    // Set up the buttons depending on the length of the word
    private void initButtons(String[] anagram, int levelNumber) {

        switch (anagram[levelNumber].length())
        {
            case 3:
                setup3Buttons(anagram[levelNumber]);
                solutionNumber = levelNumber;
                break;

            case 4:
                setup4Buttons(anagram[levelNumber]);
                solutionNumber = levelNumber;
                break;

            case 5:
                setup5Buttons(anagram[levelNumber]);
                solutionNumber = levelNumber;
                break;

            case 6:
                setup6Buttons(anagram[levelNumber]);
                solutionNumber = levelNumber;
                break;

            case 7:
                setup7Buttons(anagram[levelNumber]);
                solutionNumber = levelNumber;
                break;

            case 8:
                setup8Buttons(anagram[levelNumber]);
                solutionNumber = levelNumber;
                break;

            case 9:
                setup9Buttons(anagram[levelNumber]);
                solutionNumber = levelNumber;
                break;

            default:
                break;

        }

    }

    // Set up Methods
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

        spacing = (screenWidth / (wordLength + 1));

        letter1.setX(spacing - 125);
        letter1.setY(buttonY);

        letter2.setX((spacing * 2) - 125);
        letter2.setY(buttonY);

        letter3.setX((spacing * 3) - 125);
        letter3.setY(buttonY);

        letter1.setText(word.subSequence(0, 1));
        letter2.setText(word.subSequence(1, 2));
        letter3.setText(word.subSequence(2, 3));

        ViewGroup.LayoutParams space1params = space1.getLayoutParams();
        space1params.width = 100;
        space1params.height = 100;
        space1.requestLayout();

        ViewGroup.LayoutParams space2params = space2.getLayoutParams();
        space2params.width = 100;
        space2params.height = 100;
        space2.requestLayout();

        ViewGroup.LayoutParams space3params = space3.getLayoutParams();
        space3params.width = 100;
        space3params.height = 100;
        space3.requestLayout();

        // setting the value of the clock. Just a test for now.
        clock.setText(Integer.toString(time));

        space1.setX(spacing - 100);
        space1.setY(textY);

        space2.setX((spacing * 2) - 100);
        space2.setY(textY);

        space3.setX((spacing * 3) - 100);
        space3.setY(textY);

        letter4.setVisibility(View.INVISIBLE);
        letter5.setVisibility(View.INVISIBLE);
        letter6.setVisibility(View.INVISIBLE);
        letter7.setVisibility(View.INVISIBLE);
        letter8.setVisibility(View.INVISIBLE);
        letter9.setVisibility(View.INVISIBLE);

        space4.setVisibility(View.INVISIBLE);
        space5.setVisibility(View.INVISIBLE);
        space6.setVisibility(View.INVISIBLE);
        space7.setVisibility(View.INVISIBLE);
        space8.setVisibility(View.INVISIBLE);
        space9.setVisibility(View.INVISIBLE);

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

        spacing = (screenWidth / (wordLength + 1));

        letter1.setX(spacing - 125);
        letter1.setY(buttonY);

        letter2.setX((spacing * 2) - 125);
        letter2.setY(buttonY);

        letter3.setX((spacing * 3) - 125);
        letter3.setY(buttonY);

        letter4.setX((spacing * 4) - 125);
        letter4.setY(buttonY);

        letter1.setText(word.subSequence(0, 1));
        letter2.setText(word.subSequence(1, 2));
        letter3.setText(word.subSequence(2, 3));
        letter4.setText(word.subSequence(3, 4));

        ViewGroup.LayoutParams space1params = space1.getLayoutParams();
        space1params.width = 100;
        space1params.height = 100;
        space1.requestLayout();

        ViewGroup.LayoutParams space2params = space2.getLayoutParams();
        space2params.width = 100;
        space2params.height = 100;
        space2.requestLayout();

        ViewGroup.LayoutParams space3params = space3.getLayoutParams();
        space3params.width = 100;
        space3params.height = 100;
        space3.requestLayout();

        ViewGroup.LayoutParams space4params = space4.getLayoutParams();
        space4params.width = 100;
        space4params.height = 100;
        space4.requestLayout();

        space1.setX(spacing - 100);
        space1.setY(textY);

        space2.setX((spacing * 2) - 100);
        space2.setY(textY);

        space3.setX((spacing * 3) - 100);
        space3.setY(textY);

        space4.setX((spacing * 4) - 100);
        space4.setY(textY);

        letter5.setVisibility(View.INVISIBLE);
        letter6.setVisibility(View.INVISIBLE);
        letter7.setVisibility(View.INVISIBLE);
        letter8.setVisibility(View.INVISIBLE);
        letter9.setVisibility(View.INVISIBLE);

        space5.setVisibility(View.INVISIBLE);
        space6.setVisibility(View.INVISIBLE);
        space7.setVisibility(View.INVISIBLE);
        space8.setVisibility(View.INVISIBLE);
        space9.setVisibility(View.INVISIBLE);

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

        spacing = (screenWidth / (wordLength + 1));

        letter1.setX(spacing - 125);
        letter1.setY(buttonY);

        letter2.setX((spacing * 2) - 125);
        letter2.setY(buttonY);

        letter3.setX((spacing * 3) - 125);
        letter3.setY(buttonY);

        letter4.setX((spacing * 4) - 125);
        letter4.setY(buttonY);

        letter5.setX((spacing * 5) - 125);
        letter5.setY(buttonY);

        letter1.setText(word.subSequence(0, 1));
        letter2.setText(word.subSequence(1, 2));
        letter3.setText(word.subSequence(2, 3));
        letter4.setText(word.subSequence(3, 4));
        letter5.setText(word.subSequence(4, 5));

        ViewGroup.LayoutParams space1params = space1.getLayoutParams();
        space1params.width = 100;
        space1params.height = 100;
        space1.requestLayout();

        ViewGroup.LayoutParams space2params = space2.getLayoutParams();
        space2params.width = 100;
        space2params.height = 100;
        space2.requestLayout();

        ViewGroup.LayoutParams space3params = space3.getLayoutParams();
        space3params.width = 100;
        space3params.height = 100;
        space3.requestLayout();

        ViewGroup.LayoutParams space4params = space4.getLayoutParams();
        space4params.width = 100;
        space4params.height = 100;
        space4.requestLayout();

        ViewGroup.LayoutParams space5params = space5.getLayoutParams();
        space5params.width = 100;
        space5params.height = 100;
        space5.requestLayout();

        space1.setX(spacing - 100);
        space1.setY(textY);

        space2.setX((spacing * 2) - 100);
        space2.setY(textY);

        space3.setX((spacing * 3) - 100);
        space3.setY(textY);

        space4.setX((spacing * 4) - 100);
        space4.setY(textY);

        space5.setX((spacing * 5) - 100);
        space5.setY(textY);

        letter6.setVisibility(View.INVISIBLE);
        letter7.setVisibility(View.INVISIBLE);
        letter8.setVisibility(View.INVISIBLE);
        letter9.setVisibility(View.INVISIBLE);

        space6.setVisibility(View.INVISIBLE);
        space7.setVisibility(View.INVISIBLE);
        space8.setVisibility(View.INVISIBLE);
        space9.setVisibility(View.INVISIBLE);

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

        spacing = (screenWidth / (wordLength + 1));

        letter1.setX(spacing - 125);
        letter1.setY(buttonY);

        letter2.setX((spacing * 2) - 125);
        letter2.setY(buttonY);

        letter3.setX((spacing * 3) - 125);
        letter3.setY(buttonY);

        letter4.setX((spacing * 4) - 125);
        letter4.setY(buttonY);

        letter5.setX((spacing * 5) - 125);
        letter5.setY(buttonY);

        letter6.setX((spacing * 6) - 125);
        letter6.setY(buttonY);

        letter1.setText(word.subSequence(0, 1));
        letter2.setText(word.subSequence(1, 2));
        letter3.setText(word.subSequence(2, 3));
        letter4.setText(word.subSequence(3, 4));
        letter5.setText(word.subSequence(4, 5));
        letter6.setText(word.subSequence(5, 6));

        ViewGroup.LayoutParams space1params = space1.getLayoutParams();
        space1params.width = 100;
        space1params.height = 100;
        space1.requestLayout();

        ViewGroup.LayoutParams space2params = space2.getLayoutParams();
        space2params.width = 100;
        space2params.height = 100;
        space2.requestLayout();

        ViewGroup.LayoutParams space3params = space3.getLayoutParams();
        space3params.width = 100;
        space3params.height = 100;
        space3.requestLayout();

        ViewGroup.LayoutParams space4params = space4.getLayoutParams();
        space4params.width = 100;
        space4params.height = 100;
        space4.requestLayout();

        ViewGroup.LayoutParams space5params = space5.getLayoutParams();
        space5params.width = 100;
        space5params.height = 100;
        space5.requestLayout();

        ViewGroup.LayoutParams space6params = space6.getLayoutParams();
        space6params.width = 100;
        space6params.height = 100;
        space6.requestLayout();

        space1.setX(spacing - 100);
        space1.setY(textY);

        space2.setX((spacing * 2) - 100);
        space2.setY(textY);

        space3.setX((spacing * 3) - 100);
        space3.setY(textY);

        space4.setX((spacing * 4) - 100);
        space4.setY(textY);

        space5.setX((spacing * 5) - 100);
        space5.setY(textY);

        space6.setX((spacing * 6) - 100);
        space6.setY(textY);

        letter7.setVisibility(View.INVISIBLE);
        letter8.setVisibility(View.INVISIBLE);
        letter9.setVisibility(View.INVISIBLE);

        space7.setVisibility(View.INVISIBLE);
        space8.setVisibility(View.INVISIBLE);
        space9.setVisibility(View.INVISIBLE);

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

        spacing = (screenWidth / (wordLength + 1));

        letter1.setX(spacing - 125);
        letter1.setY(buttonY);

        letter2.setX((spacing * 2) - 125);
        letter2.setY(buttonY);

        letter3.setX((spacing * 3) - 125);
        letter3.setY(buttonY);

        letter4.setX((spacing * 4) - 125);
        letter4.setY(buttonY);

        letter5.setX((spacing * 5) - 125);
        letter5.setY(buttonY);

        letter6.setX((spacing * 6) - 125);
        letter6.setY(buttonY);

        letter7.setX((spacing * 7) - 125);
        letter7.setY(buttonY);

        letter1.setText(word.subSequence(0, 1));
        letter2.setText(word.subSequence(1, 2));
        letter3.setText(word.subSequence(2, 3));
        letter4.setText(word.subSequence(3, 4));
        letter5.setText(word.subSequence(4, 5));
        letter6.setText(word.subSequence(5, 6));
        letter7.setText(word.subSequence(6, 7));

        ViewGroup.LayoutParams space1params = space1.getLayoutParams();
        space1params.width = 100;
        space1params.height = 100;
        space1.requestLayout();

        ViewGroup.LayoutParams space2params = space2.getLayoutParams();
        space2params.width = 100;
        space2params.height = 100;
        space2.requestLayout();

        ViewGroup.LayoutParams space3params = space3.getLayoutParams();
        space3params.width = 100;
        space3params.height = 100;
        space3.requestLayout();

        ViewGroup.LayoutParams space4params = space4.getLayoutParams();
        space4params.width = 100;
        space4params.height = 100;
        space4.requestLayout();

        ViewGroup.LayoutParams space5params = space5.getLayoutParams();
        space5params.width = 100;
        space5params.height = 100;
        space5.requestLayout();

        ViewGroup.LayoutParams space6params = space6.getLayoutParams();
        space6params.width = 100;
        space6params.height = 100;
        space6.requestLayout();

        ViewGroup.LayoutParams space7params = space7.getLayoutParams();
        space7params.width = 100;
        space7params.height = 100;
        space7.requestLayout();

        space1.setX(spacing - 100);
        space1.setY(textY);

        space2.setX((spacing * 2) - 100);
        space2.setY(textY);

        space3.setX((spacing * 3) - 100);
        space3.setY(textY);

        space4.setX((spacing * 4) - 100);
        space4.setY(textY);

        space5.setX((spacing * 5) - 100);
        space5.setY(textY);

        space6.setX((spacing * 6) - 100);
        space6.setY(textY);

        space7.setX((spacing * 7) - 100);
        space7.setY(textY);

        letter8.setVisibility(View.INVISIBLE);
        letter9.setVisibility(View.INVISIBLE);

        space8.setVisibility(View.INVISIBLE);
        space9.setVisibility(View.INVISIBLE);

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

        spacing = (screenWidth / (wordLength + 1));

        letter1.setX(spacing - 125);
        letter1.setY(buttonY);

        letter2.setX((spacing * 2) - 125);
        letter2.setY(buttonY);

        letter3.setX((spacing * 3) - 125);
        letter3.setY(buttonY);

        letter4.setX((spacing * 4) - 125);
        letter4.setY(buttonY);

        letter5.setX((spacing * 5) - 125);
        letter5.setY(buttonY);

        letter6.setX((spacing * 6) - 125);
        letter6.setY(buttonY);

        letter7.setX((spacing * 7) - 125);
        letter7.setY(buttonY);

        letter8.setX((spacing * 8) - 125);
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
        space1params.width = 100;
        space1params.height = 100;
        space1.requestLayout();

        ViewGroup.LayoutParams space2params = space2.getLayoutParams();
        space2params.width = 100;
        space2params.height = 100;
        space2.requestLayout();

        ViewGroup.LayoutParams space3params = space3.getLayoutParams();
        space3params.width = 100;
        space3params.height = 100;
        space3.requestLayout();

        ViewGroup.LayoutParams space4params = space4.getLayoutParams();
        space4params.width = 100;
        space4params.height = 100;
        space4.requestLayout();

        ViewGroup.LayoutParams space5params = space5.getLayoutParams();
        space5params.width = 100;
        space5params.height = 100;
        space5.requestLayout();

        ViewGroup.LayoutParams space6params = space6.getLayoutParams();
        space6params.width = 100;
        space6params.height = 100;
        space6.requestLayout();

        ViewGroup.LayoutParams space7params = space7.getLayoutParams();
        space7params.width = 100;
        space7params.height = 100;
        space7.requestLayout();

        ViewGroup.LayoutParams space8params = space8.getLayoutParams();
        space8params.width = 100;
        space8params.height = 100;
        space8.requestLayout();

        space1.setX(spacing - 100);
        space1.setY(textY);

        space2.setX((spacing * 2) - 100);
        space2.setY(textY);

        space3.setX((spacing * 3) - 100);
        space3.setY(textY);

        space4.setX((spacing * 4) - 100);
        space4.setY(textY);

        space5.setX((spacing * 5) - 100);
        space5.setY(textY);

        space6.setX((spacing * 6) - 100);
        space6.setY(textY);

        space7.setX((spacing * 7) - 100);
        space7.setY(textY);

        space8.setX((spacing * 8) - 100);
        space8.setY(textY);

        letter9.setVisibility(View.INVISIBLE);

        space9.setVisibility(View.INVISIBLE);

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

        ViewGroup.LayoutParams letter9params = letter9.getLayoutParams();
        letter9params.width = 125;
        letter9params.height = 125;
        letter9.requestLayout();

        spacing = (screenWidth / (wordLength + 1));

        letter1.setX(spacing - 125);
        letter1.setY(buttonY);

        letter2.setX((spacing * 2) - 125);
        letter2.setY(buttonY);

        letter3.setX((spacing * 3) - 125);
        letter3.setY(buttonY);

        letter4.setX((spacing * 4) - 125);
        letter4.setY(buttonY);

        letter5.setX((spacing * 5) - 125);
        letter5.setY(buttonY);

        letter6.setX((spacing * 6) - 125);
        letter6.setY(buttonY);

        letter7.setX((spacing * 7) - 125);
        letter7.setY(buttonY);

        letter8.setX((spacing * 8) - 125);
        letter8.setY(buttonY);

        letter9.setX((spacing * 9) - 125);
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
        space1params.width = 100;
        space1params.height = 100;
        space1.requestLayout();

        ViewGroup.LayoutParams space2params = space2.getLayoutParams();
        space2params.width = 100;
        space2params.height = 100;
        space2.requestLayout();

        ViewGroup.LayoutParams space3params = space3.getLayoutParams();
        space3params.width = 100;
        space3params.height = 100;
        space3.requestLayout();

        ViewGroup.LayoutParams space4params = space4.getLayoutParams();
        space4params.width = 100;
        space4params.height = 100;
        space4.requestLayout();

        ViewGroup.LayoutParams space5params = space5.getLayoutParams();
        space5params.width = 100;
        space5params.height = 100;
        space5.requestLayout();

        ViewGroup.LayoutParams space6params = space6.getLayoutParams();
        space6params.width = 100;
        space6params.height = 100;
        space6.requestLayout();

        ViewGroup.LayoutParams space7params = space7.getLayoutParams();
        space7params.width = 100;
        space7params.height = 100;
        space7.requestLayout();

        ViewGroup.LayoutParams space8params = space8.getLayoutParams();
        space8params.width = 100;
        space8params.height = 100;
        space8.requestLayout();

        ViewGroup.LayoutParams space9params = space9.getLayoutParams();
        space9params.width = 100;
        space9params.height = 100;
        space9.requestLayout();

        space1.setX(spacing - 100);
        space1.setY(textY);

        space2.setX((spacing * 2) - 100);
        space2.setY(textY);

        space3.setX((spacing * 3) - 100);
        space3.setY(textY);

        space4.setX((spacing * 4) - 100);
        space4.setY(textY);

        space5.setX((spacing * 5) - 100);
        space5.setY(textY);

        space6.setX((spacing * 6) - 100);
        space6.setY(textY);

        space7.setX((spacing * 7) - 100);
        space7.setY(textY);

        space8.setX((spacing * 8) - 100);
        space8.setY(textY);

        space9.setX((spacing * 9) - 100);
        space9.setY(textY);

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

}
