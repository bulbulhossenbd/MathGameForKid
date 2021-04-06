package com.example.mathkid;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class TapDemActivity extends AppCompatActivity {

    ImageView imageViewQuayLai, imgSo1, imgSo2, imgSo3, imgSo4, imgSo5, imgSo6, imgSo7, imgSo8, imgSo9,imgSo0;
    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayer2;
    private MediaPlayer mediaPlayer3;
    private MediaPlayer mediaPlayer4;
    private MediaPlayer mediaPlayer5;
    private MediaPlayer mediaPlayer6;
    private MediaPlayer mediaPlayer7;
    private MediaPlayer mediaPlayer8;
    private MediaPlayer mediaPlayer9;
    private MediaPlayer mediaPlayer0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap_dem);

        DialogHDLam();
        //Ánh xạ
        imgSo1 = findViewById(R.id.imgSo1TapDem);
        imgSo2 = findViewById(R.id.imgSo2TapDem);
        imgSo3 = findViewById(R.id.imgSo3TapDem);
        imgSo4 = findViewById(R.id.imgSo4TapDem);
        imgSo5 = findViewById(R.id.imgSo5TapDem);
        imgSo6 = findViewById(R.id.imgSo6TapDem);
        imgSo7 = findViewById(R.id.imgSo7TapDem);
        imgSo8 = findViewById(R.id.imgSo8TapDem);
        imgSo9 = findViewById(R.id.imgSo9TapDem);
        imgSo0 = findViewById(R.id.imgSo0TapDem);
        mediaPlayer = MediaPlayer.create(this, R.raw.amthanhso1);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.amthanhso2);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.amthanhso3);
        mediaPlayer4 = MediaPlayer.create(this, R.raw.amthanhso4);
        mediaPlayer5 = MediaPlayer.create(this, R.raw.amthanhso5);
        mediaPlayer6 = MediaPlayer.create(this, R.raw.amthanhso6);
        mediaPlayer7 = MediaPlayer.create(this, R.raw.amthanhso7);
        mediaPlayer8 = MediaPlayer.create(this, R.raw.amthanhso8);
        mediaPlayer9 = MediaPlayer.create(this, R.raw.amthanhso9);
        mediaPlayer0 = MediaPlayer.create(this, R.raw.anhthanhso0);
        imageViewQuayLai = findViewById(R.id.imgQuayLaiCuaMHTapDem);

        imgSo0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(TapDemActivity.this, R.anim.demo);
                imgSo0.startAnimation(animation);
                mediaPlayer0.start();
            }
        });

        imgSo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(TapDemActivity.this, R.anim.demo);
                imgSo1.startAnimation(animation);
                mediaPlayer.start();
            }
        });
        imgSo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(TapDemActivity.this, R.anim.demo);
                imgSo2.startAnimation(animation);
                mediaPlayer2.start();
            }
        });
        imgSo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(TapDemActivity.this, R.anim.demo);
                imgSo3.startAnimation(animation);
                mediaPlayer3.start();
            }
        });
        imgSo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(TapDemActivity.this, R.anim.demo);
                imgSo4.startAnimation(animation);
                mediaPlayer4.start();
            }
        });
        imgSo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(TapDemActivity.this, R.anim.demo);
                imgSo5.startAnimation(animation);
                mediaPlayer5.start();
            }
        });
        imgSo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(TapDemActivity.this, R.anim.demo);
                imgSo6.startAnimation(animation);
                mediaPlayer6.start();
            }
        });
        imgSo7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(TapDemActivity.this, R.anim.demo);
                imgSo7.startAnimation(animation);
                mediaPlayer7.start();
            }
        });
        imgSo8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(TapDemActivity.this, R.anim.demo);
                imgSo8.startAnimation(animation);
                mediaPlayer8.start();
            }
        });
        imgSo9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(TapDemActivity.this, R.anim.demo);
                imgSo9.startAnimation(animation);
                mediaPlayer9.start();
            }
        });

        //Chuyển màn hình
        //Quay lại:
        imageViewQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentQuayLai = new Intent(TapDemActivity.this, ManHinhChinhActivity.class);
                ManHinhChaoActivity.mediaPlayer.start();
                startActivity(intentQuayLai);
            }
        });
    }

    public void DialogHDLam() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TapDemActivity.this);
        alertDialogBuilder.setView(R.layout.dialod_hdtapdem);
        alertDialogBuilder.setTitle("Hướng dẫn");
        alertDialogBuilder
                .setMessage("Bấm để chọn")
                .setCancelable(false)
                .setNegativeButton("Tiếp tục", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}