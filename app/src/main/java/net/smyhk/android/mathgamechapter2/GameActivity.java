package net.smyhk.android.mathgamechapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private int mCorrectAnswer;
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

        mCurrentScore = 0;
        mCurrentLevel = 1;

        mLeftFactorTextView = (TextView) findViewById(R.id.left_factor);

        mRightFactorTextView = (TextView) findViewById(R.id.right_factor);

        mButtonChoiceOne = (Button) findViewById(R.id.button_choice1);
        mButtonChoiceOne.setOnClickListener(this);

        mButtonChoiceTwo = (Button) findViewById(R.id.button_choice2);
        mButtonChoiceTwo.setOnClickListener(this);

        mButtonChoiceThree = (Button) findViewById(R.id.button_choice3);
        mButtonChoiceThree.setOnClickListener(this);

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
                break;
            case R.id.button_choice2:
                answerGiven = Integer.parseInt("" + mButtonChoiceTwo.getText());
                break;
            case R.id.button_choice3:
                answerGiven = Integer.parseInt("" + mButtonChoiceThree.getText());
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
                mButtonChoiceTwo.setText(getString(R.string.choice_two, mCorrectAnswer));
                mButtonChoiceThree.setText(getString(R.string.choice_three, mWrongAnswer2));
                mButtonChoiceOne.setText(getString(R.string.choice_one, mWrongAnswer1));
                break;
            case 2:
                mButtonChoiceThree.setText(getString(R.string.choice_three, mCorrectAnswer));
                mButtonChoiceOne.setText(getString(R.string.choice_one, mWrongAnswer1));
                mButtonChoiceTwo.setText(getString(R.string.choice_two, mWrongAnswer2));
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
