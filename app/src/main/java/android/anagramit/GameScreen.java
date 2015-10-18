package android.anagramit;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.Display;
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
    TextView leveltext;
    TextView timertext;
    TextView scoretext;
    TextView space1;
    TextView space2;
    TextView space3;
    TextView space4;
    TextView space5;
    TextView space6;
    TextView space7;
    TextView space8;
    TextView space9;
    int levelNumber;
    int buttonY;
    int textY;
    int wordLength;
    int sideBorder;
    int screenWidth;
    int spacing;
    int timelimit;
    int currentScore;

    // Array of the words for each level
    // i.e. anagram[0] = level 1, anagram[1] = level 2, etc
    // Length of each word must be between 3 and 9
    String[] anagram = {"GAME", "ANDROID", "DRJACOBS"};
    String[] solutions = {"AB",
            "AD",
            "AE",
            "AG",
            "AI",
            "AM",
            "AN",
            "AR",
            "AS",
            "BA",
            "BO",
            "DA",
            "DI",
            "DO",
            "EA",
            "EM",
            "ID",
            "IN",
            "IO",
            "JA",
            "JO",
            "MA",
            "ME",
            "NA",
            "NO",
            "OB",
            "OD",
            "OI",
            "ON",
            "OR",
            "OS",
            "SO",
            "ABO",
            "ABS",
            "ADD",
            "ADO",
            "ADS",
            "AGE",
            "AID",
            "AIN",
            "AIR",
            "AME",
            "AND",
            "ANI",
            "ARB",
            "ARC",
            "ARD",
            "ARS",
            "BAC",
            "BAD",
            "BAR",
            "BAS",
            "BOA",
            "BOD",
            "BOR",
            "BOS",
            "BRA",
            "BRO",
            "CAB",
            "CAD",
            "CAR",
            "COB",
            "COD",
            "COR",
            "COS",
            "DAB",
            "DAD",
            "DAN",
            "DAS",
            "DID",
            "DIN",
            "DOB",
            "DOC",
            "DOD",
            "DON",
            "DOR",
            "DOS",
            "DSO",
            "GAE",
            "GAM",
            "GEM",
            "ION",
            "JAB",
            "JAR",
            "JOB",
            "JOR",
            "MAE",
            "MAG",
            "MEG",
            "NID",
            "NOD",
            "NOR",
            "OAR",
            "OBA",
            "OBS",
            "OCA",
            "ODA",
            "ODD",
            "ODS",
            "ORA",
            "ORB",
            "ORC",
            "ORD",
            "ORS",
            "RAD",
            "RAI",
            "RAJ",
            "RAN",
            "RAS",
            "RIA",
            "RID",
            "RIN",
            "ROB",
            "ROC",
            "ROD",
            "SAB",
            "SAC",
            "SAD",
            "SAR",
            "SOB",
            "SOC",
            "SOD",
            "ABOS",
            "ADOS",
            "AIRN",
            "ARBS",
            "ARCO",
            "ARCS",
            "ARDS",
            "ARID",
            "BACS",
            "BADS",
            "BARD",
            "BARS",
            "BOAR",
            "BOAS",
            "BODS",
            "BORA",
            "BORD",
            "BORS",
            "BRAD",
            "BRAS",
            "BROD",
            "BROS",
            "CABS",
            "CADS",
            "CARB",
            "CARD",
            "CARS",
            "COBS",
            "CODA",
            "CODS",
            "CORD",
            "CORS",
            "CRAB",
            "DABS",
            "DADO",
            "DARB",
            "DARI",
            "DARN",
            "DIDO",
            "DINO",
            "DOAB",
            "DOBS",
            "DOCS",
            "DONA",
            "DORB",
            "DORS",
            "DRAB",
            "DRAC",
            "DRAD",
            "EGMA",
            "GAME",
            "INRO",
            "IRON",
            "JABS",
            "JARS",
            "JOBS",
            "JORS",
            "MAGE",
            "MEGA",
            "NAOI",
            "NARD",
            "NODI",
            "NOIR",
            "NORI",
            "OARS",
            "OBAS",
            "OCAS",
            "ODAS",
            "ORAD",
            "ORBS",
            "ORCA",
            "ORCS",
            "ORDS",
            "OSAR",
            "RADS",
            "RAID",
            "RAIN",
            "RAND",
            "RANI",
            "RIAD",
            "RIND",
            "ROAD",
            "ROAN",
            "ROBS",
            "ROCS",
            "RODS",
            "ROIN",
            "SADO",
            "SARD",
            "SCAB",
            "SCAD",
            "SCAR",
            "SOAR",
            "SOBA",
            "SOCA",
            "SODA",
            "SOJA",
            "SORA",
            "SORB",
            "SORD",
            "ABORD",
            "ADDIO",
            "ADORN",
            "ANDRO",
            "ARCOS",
            "AROID",
            "BARDO",
            "BARDS",
            "BOARD",
            "BOARS",
            "BORAS",
            "BORDS",
            "BRADS",
            "BROAD",
            "BRODS",
            "CARBO",
            "CARBS",
            "CARDS",
            "CAROB",
            "COARB",
            "COBRA",
            "CODAS",
            "CORDS",
            "CRABS",
            "DANIO",
            "DARBS",
            "DINAR",
            "DOABS",
            "DOBRA",
            "DORAD",
            "DORBA",
            "DORBS",
            "DORSA",
            "DRABS",
            "DRACO",
            "DRAIN",
            "DROID",
            "NADIR",
            "NIDOR",
            "NORIA",
            "ORCAS",
            "OSCAR",
            "RADIO",
            "RADON",
            "RANID",
            "ROADS",
            "SAROD",
            "SCRAB",
            "SCROD",
            "SORDA",
            "ABORDS",
            "ADSORB",
            "BARDOS",
            "BOARDS",
            "BRASCO",
            "BROADS",
            "CARBOS",
            "CAROBS",
            "COARBS",
            "COBRAS",
            "DOBRAS",
            "DORBAS",
            "INROAD",
            "ORDAIN",
            "ANDROID",
            "ACRO",
            "SCRO",
            "ACR",
            "DOS"};

    boolean[] answerFound = {false, false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        timelimit = 180000;
        buttonY = 500;
        textY = 750;
        sideBorder = 5;
        currentScore = 0;

        // Get the width of the screen
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;

        // Get the text boxes from the XML file
        leveltext = (TextView) findViewById(R.id.leveltext);
        timertext = (TextView) findViewById(R.id.timertext);
        scoretext = (TextView) findViewById(R.id.scoretext);
        space1 = (TextView) findViewById(R.id.space1);
        space2 = (TextView) findViewById(R.id.space2);
        space3 = (TextView) findViewById(R.id.space3);
        space4 = (TextView) findViewById(R.id.space4);
        space5 = (TextView) findViewById(R.id.space5);
        space6 = (TextView) findViewById(R.id.space6);
        space7 = (TextView) findViewById(R.id.space7);
        space8 = (TextView) findViewById(R.id.space8);
        space9 = (TextView) findViewById(R.id.space9);

        // Get the End Game and Submit buttons from the XML
        endgamebutton = (Button) findViewById(R.id.endgamebutton);
        endgamebutton.setOnClickListener(this);

        submitbutton = (Button) findViewById(R.id.submitbutton);
        submitbutton.setOnClickListener(this);

        // Get the level number from the level select screen
        Intent intent = getIntent();
        levelNumber = intent.getIntExtra("level_num", 0) - 1;

        scoretext.setText("Score: 0");

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

        new CountDownTimer(timelimit, 1000) {

            public void onTick(long millisUntilFinished) {
                if (((millisUntilFinished % 60000 ) / 1000) < 10) {
                    timertext.setText("Time Remaining: " + millisUntilFinished / 60000 + ":0" + (millisUntilFinished % 60000) / 1000);
                }
                else {
                    timertext.setText("Time Remaining: " + millisUntilFinished / 60000 + ":" + (millisUntilFinished % 60000) / 1000);
                }

            }

            public void onFinish() {
                goToScoreScreen();
            }
        }.start();

    }

    private void goToScoreScreen() {
        Intent intent = new Intent(this, ScoreScreen.class);
        intent.putExtra("score", currentScore);
        startActivity(intent);
    }


    // The actions that will be performed when a specific button is pressed
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            // If the End Game button is pressed, go to the scorescreen
            case R.id.endgamebutton:
                Intent intent = new Intent(this, ScoreScreen.class);
                intent.putExtra("score", currentScore);
                startActivity(intent);
                break;

            // currently the submit button changes its test to show if the word is correct or not
            // this is just a aplce holder and should be changed.
            case R.id.submitbutton:
                checkAnswer();
                clearSpaces();
                break;

            // If a letter button is pressed, put that character in the next available text box,
            // and disable the button that was pressed
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

            default:
                break;
        }
    }

        private void clearSpaces() {
                space1.setText("");
                space2.setText("");
                space3.setText("");
                space4.setText("");
                space5.setText("");
                space6.setText("");
                space7.setText("");
                space8.setText("");
                space9.setText("");

                letter1.setEnabled(true);
                letter2.setEnabled(true);
                letter3.setEnabled(true);
                letter4.setEnabled(true);
                letter5.setEnabled(true);
                letter6.setEnabled(true);
                letter7.setEnabled(true);
                letter8.setEnabled(true);
                letter9.setEnabled(true);
        }

        private boolean checkAnswer() {
        String currentAnswer = "";
        if (space1.getText().equals("")) {
            return false;
        }
        if (!(space1.getText().equals("")))
        {
            currentAnswer = currentAnswer.concat((String) space1.getText());
        }
        if (!(space2.getText().equals("")))
        {
            currentAnswer = currentAnswer.concat((String) space2.getText());
        }
        if (!(space3.getText().equals("")))
        {
            currentAnswer = currentAnswer.concat((String) space3.getText());
        }
        if (!(space4.getText().equals("")))
        {
            currentAnswer = currentAnswer.concat((String) space4.getText());
        }
        if (!(space5.getText().equals("")))
        {
            currentAnswer = currentAnswer.concat((String) space5.getText());
        }
        if (!(space6.getText().equals("")))
        {
            currentAnswer = currentAnswer.concat((String) space6.getText());
        }
        if (!(space7.getText().equals("")))
        {
            currentAnswer = currentAnswer.concat((String) space7.getText());
        }
        if (!(space8.getText().equals("")))
        {
            currentAnswer = currentAnswer.concat((String) space8.getText());
        }
        if (!(space9.getText().equals("")))
        {
            currentAnswer = currentAnswer.concat((String) space9.getText());
        }

        boolean currentAnwserIsSolution = false;
        int i = 0;
        while (!currentAnwserIsSolution && (i < solutions.length))
        {
            if (solutions[i].equals(currentAnswer) && !answerFound[i]) {
                currentScore += 1;
                scoretext.setText("Score: " + currentScore);
                submitbutton.setText("correct");
                answerFound[i] = true;
                return true;
            }
            else if (solutions[i].equals(currentAnswer) && answerFound[i]) {
                submitbutton.setText("found");
                return true;
            }
            i++;
        }
        submitbutton.setText("false");
        return false;
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
