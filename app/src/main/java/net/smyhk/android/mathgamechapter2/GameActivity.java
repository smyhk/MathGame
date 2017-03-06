package net.smyhk.android.mathgamechapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    //private int mLeftFactor;
    //private int mRightFactor;
    private int mCorrectAnswer;
    //private int mWrongAnswer1;
    //private int mWrongAnswer2;
    //private int answerGiven;
    private int mCurrentScore;
    private int mCurrentLevel;

    private TextView mLeftFactorTextView;
    private TextView mRightFactorTextView;
    private TextView mCurrentScoreTextView;
    private TextView mCurrentLevelTextView;

    private Button mButtonChoiceOne;
    private Button mButtonChoiceTwo;
    private Button mButtonChoiceThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //mLeftFactor = 9;
        //mRightFactor = 9;
        //mCorrectAnswer = mLeftFactor * mRightFactor;
        //mWrongAnswer1 = mCorrectAnswer + 2;
        //mWrongAnswer2 = mCorrectAnswer - 2;
        mCurrentScore = 0;
        mCurrentLevel = 1;

        mLeftFactorTextView = (TextView) findViewById(R.id.left_factor);
        //mLeftFactorTextView.setText(getString(R.string.left_factor, mLeftFactor));

        mRightFactorTextView = (TextView) findViewById(R.id.right_factor);
        //mRightFactorTextView.setText(getString(R.string.right_factor, mRightFactor));

        mButtonChoiceOne = (Button) findViewById(R.id.button_choice1);
        mButtonChoiceOne.setOnClickListener(this);
        /*mButtonChoiceOne.setText(getString(R.string.choice_one, mCorrectAnswer));
        mButtonChoiceOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerGiven = Integer.parseInt("" + mButtonChoiceOne.getText());

                // validate answer
                if (answerGiven == mCorrectAnswer) {
                    Toast.makeText(getApplicationContext(),
                            "Well done!", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(getApplicationContext(),
                            "Sorry, try again.", Toast.LENGTH_LONG).show();
                }
            }
        }); */

        mButtonChoiceTwo = (Button) findViewById(R.id.button_choice2);
        mButtonChoiceTwo.setOnClickListener(this);
        /*mButtonChoiceTwo.setText(getString(R.string.choice_two, mWrongAnswer1));
        mButtonChoiceTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerGiven = Integer.parseInt("" + mButtonChoiceTwo.getText());

                // validate answer
                if (answerGiven == mCorrectAnswer) {
                    Toast.makeText(getApplicationContext(),
                            "Well done!", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(getApplicationContext(),
                            "Sorry, try again.", Toast.LENGTH_LONG).show();
                }
            }
        }); */

        mButtonChoiceThree = (Button) findViewById(R.id.button_choice3);
        mButtonChoiceThree.setOnClickListener(this);
        /* mButtonChoiceThree.setText(getString(R.string.choice_three, mWrongAnswer2));
        mButtonChoiceThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerGiven = Integer.parseInt("" + mButtonChoiceTwo.getText());

                // validate answer
                if (answerGiven == mCorrectAnswer) {
                    Toast.makeText(getApplicationContext(),
                            "Well done!", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(getApplicationContext(),
                            "Sorry, try again.", Toast.LENGTH_LONG).show();
                }
            }
        }); */

        mCurrentScoreTextView = (TextView) findViewById(R.id.player_score);
        mCurrentScoreTextView.setText(getString(R.string.player_score, mCurrentScore));

        mCurrentLevelTextView = (TextView) findViewById(R.id.player_level);
        mCurrentLevelTextView.setText(getString(R.string.player_level, mCurrentLevel));

        setQuestion();
    } // end onCreate

    @Override
    public void onClick(View view) {
        int answerGiven = 0;
        switch (view.getId()) {
            case R.id.button_choice1:
                answerGiven = Integer.parseInt("" + mButtonChoiceOne.getText());

                /*// validate answer
                if (answerGiven == mCorrectAnswer) {
                    Toast.makeText(getApplicationContext(),
                            "Well done!", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(getApplicationContext(),
                            "Sorry, try again.", Toast.LENGTH_LONG).show();
                } */
                break;
            case R.id.button_choice2:
                answerGiven = Integer.parseInt("" + mButtonChoiceTwo.getText());

                /*// validate answer
                if (answerGiven == mCorrectAnswer) {
                    Toast.makeText(getApplicationContext(),
                            "Well done!", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(getApplicationContext(),
                            "Sorry, try again.", Toast.LENGTH_LONG).show();
                } */
                break;
            case R.id.button_choice3:
                answerGiven = Integer.parseInt("" + mButtonChoiceThree.getText());

                /*// validate answer
                if (answerGiven == mCorrectAnswer) {
                    Toast.makeText(getApplicationContext(),
                            "Well done!", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(getApplicationContext(),
                            "Sorry, try again.", Toast.LENGTH_LONG).show();
                } */
                break;
        }
        updateScoreAndLevel(answerGiven);
    }

    public void setQuestion() {
        int numberRange = mCurrentLevel * 3;
        Random randomInt = new Random();

        int mLeftFactor = randomInt.nextInt(numberRange + 1);
        int mRightFactor = randomInt.nextInt(numberRange + 1);

        mCorrectAnswer = mLeftFactor * mRightFactor;
        int mWrongAnswer1 = mCorrectAnswer + 2;
        int mWrongAnswer2 = mCorrectAnswer - 2;

        mLeftFactorTextView.setText(getString(R.string.left_factor, mLeftFactor));
        mRightFactorTextView.setText(getString(R.string.right_factor, mRightFactor));

        // set multi choice buttons
        int buttonLayout = randomInt.nextInt(3);
        switch (buttonLayout) {
            case 0:
                mButtonChoiceOne.setText(getString(R.string.choice_one, mCorrectAnswer));
                mButtonChoiceTwo.setText(getString(R.string.choice_two, mWrongAnswer1));
                mButtonChoiceThree.setText(getString(R.string.choice_three, mWrongAnswer2));
                break;
            case 1:
                mButtonChoiceTwo.setText(getString(R.string.choice_two, mWrongAnswer1));
                mButtonChoiceThree.setText(getString(R.string.choice_three, mWrongAnswer2));
                mButtonChoiceOne.setText(getString(R.string.choice_one, mCorrectAnswer));
                break;
            case 2:
                mButtonChoiceThree.setText(getString(R.string.choice_three, mWrongAnswer2));
                mButtonChoiceOne.setText(getString(R.string.choice_one, mCorrectAnswer));
                mButtonChoiceTwo.setText(getString(R.string.choice_two, mWrongAnswer1));
                break;
        }
    } // end setQuestion

    public void updateScoreAndLevel(int answerGiven) {
        if (isCorrect(answerGiven)) {
            for (int i = 1; i <= mCurrentLevel; i++) {
                mCurrentScore = mCurrentScore + i;
            }
            mCurrentLevel++;
        } else {
            mCurrentScore = 0;
            mCurrentLevel = 1;
        }
        // update score and level TextViews
        mCurrentScoreTextView.setText(getString(R.string.player_score, mCurrentScore));
        mCurrentLevelTextView.setText(getString(R.string.player_level, mCurrentLevel));

        setQuestion();
    } // end updateScoreAndLevel

    public boolean isCorrect(int answerGiven) {
        boolean correctTrueOrFalse;

        // validate answer
        if (answerGiven == mCorrectAnswer) {
            Toast.makeText(getApplicationContext(),
                    "Well done!", Toast.LENGTH_LONG).show();
            correctTrueOrFalse = true;
        } else{
            Toast.makeText(getApplicationContext(),
                    "Sorry, try again.", Toast.LENGTH_LONG).show();
            correctTrueOrFalse = false;
        }
        return correctTrueOrFalse;
    }
}
