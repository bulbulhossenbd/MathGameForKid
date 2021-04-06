package com.example.mathkid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MHChaoGameActivity extends AppCompatActivity {
    Button btnBDG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        btnBDG = findViewById(R.id.btnBatDauGame);
        btnBDG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGame = new Intent(MHChaoGameActivity.this, MHChinhGameActivity.class);
                startActivity(intentGame);
            }
        });
    }


}