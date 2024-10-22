package com.example.guessnumber;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class Guess extends AppCompatActivity {
    private TextView remainingGuess,guessHelp;
    private EditText editGuessNumber;
    private Button buttonCheck;
    private int counter=5;
    private int r_number;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_guess);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Random random = new Random();
        r_number = random.nextInt(101);
        Log.e("Rastgele sayı : " , String.valueOf(r_number));

        remainingGuess = findViewById(R.id.remainingGuess);
        guessHelp = findViewById(R.id.guessHelp);
        editGuessNumber = findViewById(R.id.editGuessNumber);
        buttonCheck = findViewById(R.id.buttonCheck);

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = counter-1;
                int guess = Integer.parseInt(editGuessNumber.getText().toString());
                if (guess==r_number){
                    Intent intent = new Intent(Guess.this,Result.class);
                    intent.putExtra("result",true);
                    startActivity(intent);
                    finish();
                    return;

                }
                if (guess>r_number){
                    guessHelp.setText("Decrease");
                    remainingGuess.setText("Remaining Guesses : " + counter);

                }
                if (guess<r_number){
                    guessHelp.setText("Increase");
                    remainingGuess.setText("Remaining Guesses : " + counter);

                }
                if (counter==0){
                    Intent intent = new Intent(Guess.this,Result.class);
                    intent.putExtra("result",false);
                    startActivity(intent);
                    finish();

                }
            }
        });

    }
}