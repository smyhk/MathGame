package net.smyhk.android.mathgamechapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        int mLeftFactor = 9;
        int mRightFactor = 9;
        int mCorrect_answer = mLeftFactor * mRightFactor;
        int mWrongAnswer1 = mCorrect_answer + 1;
        int mWrongAnswer2 = mCorrect_answer - 1;

        TextView mLeftFactorTextView = (TextView) findViewById(R.id.left_factor);
        mLeftFactorTextView.setText("" + mLeftFactor);

        TextView mRightFactorTextView = (TextView) findViewById(R.id.right_factor);
        mRightFactorTextView.setText(" " + mRightFactor);

        Button mButtonChoiceOne = (Button) findViewById(R.id.button_choice1);
        mButtonChoiceOne.setText("" + mCorrect_answer);

        Button mButtonChoiceTwo = (Button) findViewById(R.id.button_choice2);
        mButtonChoiceTwo.setText("" + mWrongAnswer1);

        Button mButtonChoiceThree = (Button) findViewById(R.id.button_choice3);
        mButtonChoiceThree.setText("" + mWrongAnswer2);
    }
}
