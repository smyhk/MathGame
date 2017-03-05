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

        int leftFactor = 0;
        int rightFactor = 0;
        int correct_answer = 0;
        int wrongAnswer1 = 0;
        int worngAnswer2 = 0;

        TextView mLeftFactor = (TextView) findViewById(R.id.left_factor);

        TextView mRightFactor = (TextView) findViewById(R.id.right_factor);

        Button mChoiceOne = (Button) findViewById(R.id.button_choice1);

        Button mChoiceTwo = (Button) findViewById(R.id.button_choice2);

        Button mChoiceThree = (Button) findViewById(R.id.button_choice3);
    }
}
