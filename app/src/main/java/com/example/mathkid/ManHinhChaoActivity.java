package com.example.mathkid;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ManHinhChaoActivity extends AppCompatActivity {
    static boolean flag = false;
    Button buttonBatDau;
    ImageView imgThoatApp;
    ImageView imgLoa, imgLogo;
    public static MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyRunnable myRunnable = new MyRunnable();
        myRunnable.start();

        //Ánh xạ
        imgLogo = findViewById(R.id.imgLogoKML);
        imgLoa = findViewById(R.id.imgLoaManHinhChao);
        mediaPlayer = MediaPlayer.create(this, R.raw.nhacnen);
        imgThoatApp = findViewById(R.id.imgThoatMHChao);
        buttonBatDau = findViewById(R.id.btnBatDau);
        mediaPlayer.start();
        //Chuyển màn hình
        imgLoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    mediaPlayer.start();
                    imgLoa.setImageResource(R.drawable.hinhloa);
                    flag = false;
                } else {
                    mediaPlayer.pause();
                    imgLoa.setImageResource(R.drawable.unloa);
                    flag = true;
                }
            }
        });
        buttonBatDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManHinhChaoActivity.this, ManHinhChinhActivity.class);
                mediaPlayer.pause();
                startActivity(intent);
            }
        });

        //Thoát App
        imgThoatApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ManHinhChaoActivity.this);
                alertDialogBuilder.setTitle("Thoát ứng dụng?");
                alertDialogBuilder
                        .setMessage("Chọn 'đồng ý' để thoát!")
                        .setCancelable(false)
                        .setPositiveButton("Đồng ý",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        moveTaskToBack(true);
                                        android.os.Process.killProcess(android.os.Process.myPid());
                                        System.exit(1);
                                    }
                                })

                        .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }

    public int PlayAction() {
        mediaPlayer.start();
        return 1;
    }

//    public int pauseAction() {
//        mediaPlayer.pause();
//        imgLoa.setImageResource(R.drawable.unloa);
//        return -1;
//    }

    private class MyRunnable extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                imgLogo = findViewById(R.id.imgLogoKML);
                Animation animation = AnimationUtils.loadAnimation(ManHinhChaoActivity.this, R.anim.demo);
                imgLogo.startAnimation(animation);
                PlayAction();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}