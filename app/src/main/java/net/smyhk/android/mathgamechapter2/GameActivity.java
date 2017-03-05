package net.smyhk.android.mathgamechapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    private int mLeftFactor;
    private int mRightFactor;
    private int mCorrectAnswer;
    private int mWrongAnswer1;
    private int mWrongAnswer2;
    private int answerGiven;
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

        mLeftFactor = 9;
        mRightFactor = 9;
        mCorrectAnswer = mLeftFactor * mRightFactor;
        mWrongAnswer1 = mCorrectAnswer + 1;
        mWrongAnswer2 = mCorrectAnswer - 1;
        mCurrentScore = 12;
        mCurrentLevel = 2;

        mLeftFactorTextView = (TextView) findViewById(R.id.left_factor);
        mLeftFactorTextView.setText(getString(R.string.left_factor, mLeftFactor));

        mRightFactorTextView = (TextView) findViewById(R.id.right_factor);
        mRightFactorTextView.setText(getString(R.string.right_factor, mRightFactor));

        mButtonChoiceOne = (Button) findViewById(R.id.button_choice1);
        mButtonChoiceOne.setText(getString(R.string.choice_one, mCorrectAnswer));
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
        });

        mButtonChoiceTwo = (Button) findViewById(R.id.button_choice2);
        mButtonChoiceTwo.setText(getString(R.string.choice_two, mWrongAnswer1));
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
        });

        mButtonChoiceThree = (Button) findViewById(R.id.button_choice3);
        mButtonChoiceThree.setText(getString(R.string.choice_three, mWrongAnswer2));
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
        });

        mCurrentScoreTextView = (TextView) findViewById(R.id.player_score);
        mCurrentScoreTextView.setText(getString(R.string.player_score, mCurrentScore));

        mCurrentLevelTextView = (TextView) findViewById(R.id.player_level);
        mCurrentLevelTextView.setText(getString(R.string.player_level, mCurrentLevel));
    }
}
