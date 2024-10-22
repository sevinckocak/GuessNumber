package com.example.guessnumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Result extends AppCompatActivity {
    private TextView textViewResult;
    private Button buttonRestart;
    private ImageView imageViewResult;
    private boolean result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textViewResult = findViewById(R.id.textViewResult);
        buttonRestart = findViewById(R.id.buttonRestart);
        imageViewResult = findViewById(R.id.imageViewResult);
        result = getIntent().getBooleanExtra("result",false);
        if (result){
            textViewResult.setText("You won the game");
            imageViewResult.setImageResource(R.mipmap.winner_foreground);
        }
        else {
            textViewResult.setText("You lost the game");
            imageViewResult.setImageResource(R.mipmap.lost_foreground);
        }
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result.this,MainActivity.class);
                startActivity(intent);
                finish();
            }

        });
    }
}