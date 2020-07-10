package com.example.diceroll;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final Random RANDOM = new Random();
    private Button rollDice;
    private ImageView imageViewLeft, imageViewRight;
    int result1;
    int result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollDice = (Button) findViewById(R.id.roll);

        imageViewLeft = (ImageView) findViewById(R.id.imageLeft);
        imageViewRight = (ImageView) findViewById(R.id.imageRight);

        if (savedInstanceState!= null) {
            result1 = savedInstanceState.getInt("Left");
            result2 = savedInstanceState.getInt("Right");
            save(result1, result2);
        }

        rollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = randomDice();
                int num2 = randomDice();

                result1 = getResources().getIdentifier("ic_inverted_dice_" + num1,
                                "drawable",
                                "com.example.diceroll");
                result2 = getResources().getIdentifier("ic_inverted_dice_" + num2,
                                "drawable",
                                "com.example.diceroll");

                save(result1, result2);
            }
        });
    }

    public static int randomDice(){
        return RANDOM.nextInt(6) + 1;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Left",result1);
        outState.putInt("Right",result2);
    }

    public void save(int result1, int result2){
        imageViewLeft.setImageResource(result1);
        imageViewRight.setImageResource(result2);
    }
}