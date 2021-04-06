package com.example.mathkid;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class PhepTruActivity extends AppCompatActivity {
    ImageView imgLoa;
    ImageView imageViewQuayLai, imgDA1PT, imgs1PT, imgs2PT, imgDA2PT, imgDA3PT, imgDamMay1PT, imgDamMay2PT, imgDamMay3PT;
    int i = 1;
    int Tong =2;
    int dung;
    int sai;
    static boolean flag = false;
    TextView tvpheptru;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phep_tru);
        imageViewQuayLai = findViewById(R.id.imgQuayLaiCuaMHPhepTru);
        imgDA1PT = findViewById(R.id.imgDapAn1PT);
        imgDA2PT= findViewById(R.id.imgDapAn2PT);
        imgDA3PT= findViewById(R.id.imgDapAn3PT);
        imgs1PT= findViewById(R.id.imgSoThuNhatPT);
        imgs2PT= findViewById(R.id.imgSoThuHaiPT);
        imgDamMay1PT= findViewById(R.id.imgDamMay1PT);
        imgDamMay2PT= findViewById(R.id.imgDamMay2PT);
        imgDamMay3PT = findViewById(R.id.imgDamMay3PT);
        tvpheptru = findViewById(R.id.tvPhepTru);
        imgLoa  = findViewById(R.id.imgLoaPhepTru);
        ManHinhChaoActivity.mediaPlayer.start();
        imgLoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    ManHinhChaoActivity.mediaPlayer.start();
                    imgLoa.setImageResource(R.drawable.hinhloa);
                    flag = false;
                } else {
                    ManHinhChaoActivity.mediaPlayer.pause();
                    imgLoa.setImageResource(R.drawable.unloa);
                    flag = true;
                }
            }
        });
        DialogHDLam();
        //Ánh xạ
        imgDA1PT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Tong == 0 || Tong == 3 || Tong == 6 || Tong == 9) {
                    imgDamMay1PT.setImageResource(R.drawable.anhxanh);
                    imgDamMay2PT.setImageResource(R.drawable.maydo);
                    imgDamMay3PT.setImageResource(R.drawable.maydo);
                    dung++;
                    MyRunnable myRunnable = new MyRunnable();
                    myRunnable.start();
                } else {
                    imgDamMay1PT.setImageResource(R.drawable.maydo);
                    sai++;
                    MyRunnable myRunnable = new MyRunnable();
                    myRunnable.start();
                }
                Service();
            }
        });

        imgDA2PT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Tong == 1 || Tong == 4 || Tong == 7) {
                    imgDamMay2PT.setImageResource(R.drawable.anhxanh);
                    imgDamMay1PT.setImageResource(R.drawable.maydo);
                    imgDamMay3PT.setImageResource(R.drawable.maydo);
                    dung++;
                    MyRunnable myRunnable = new MyRunnable();
                    myRunnable.start();
                } else {
                    imgDamMay2PT.setImageResource(R.drawable.maydo);
                    sai++;
                    MyRunnable myRunnable = new MyRunnable();
                    myRunnable.start();
                }
                Service();
            }
        });
        imgDA3PT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Tong == 2 || Tong == 5 || Tong == 8) {
                    imgDamMay3PT.setImageResource(R.drawable.anhxanh);
                    imgDamMay2PT.setImageResource(R.drawable.maydo);
                    imgDamMay1PT.setImageResource(R.drawable.maydo);
                    dung++;
                    MyRunnable myRunnable = new MyRunnable();
                    myRunnable.start();
                } else {
                    imgDamMay3PT.setImageResource(R.drawable.maydo);
                    sai++;
                    MyRunnable myRunnable = new MyRunnable();
                    myRunnable.start();
                }
                Service();
            }
        });
        //Chuyển màn hình
        //Quay lại:
        imageViewQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentQuayLai = new Intent(PhepTruActivity.this, CongTruActivity.class);
                ManHinhChaoActivity.mediaPlayer.pause();
                startActivity(intentQuayLai);
            }
        });
    }

    public int myRandomso1() {
        int so1;
        Random random = new Random();
        so1 = random.nextInt(10);
        switch (so1) {
            case 0:
                imgs1PT.setImageResource(R.drawable.so0);
                break;
            case 1:
                imgs1PT.setImageResource(R.drawable.so1);
                break;
            case 2:
                imgs1PT.setImageResource(R.drawable.so2);
                break;
            case 3:
                imgs1PT.setImageResource(R.drawable.so3);
                break;
            case 4:
                imgs1PT.setImageResource(R.drawable.so4);
                break;
            case 5:
                imgs1PT.setImageResource(R.drawable.so5);
                break;
            case 6:
                imgs1PT.setImageResource(R.drawable.so6);
                break;
            case 7:
                imgs1PT.setImageResource(R.drawable.so7);
                break;
            case 8:
                imgs1PT.setImageResource(R.drawable.so8);
                break;
            case 9:
                imgs1PT.setImageResource(R.drawable.so9);
                break;
        }
        return so1;
    }

    public int myRandomso2() {
        int so2;
        Random random = new Random();
        so2 = random.nextInt(10);
        switch (so2) {
            case 0:
                imgs2PT.setImageResource(R.drawable.so0);
                break;
            case 1:
                imgs2PT.setImageResource(R.drawable.so1);
                break;
            case 2:
                imgs2PT.setImageResource(R.drawable.so2);
                break;
            case 3:
                imgs2PT.setImageResource(R.drawable.so3);
                break;
            case 4:
                imgs2PT.setImageResource(R.drawable.so4);
                break;
            case 5:
                imgs2PT.setImageResource(R.drawable.so5);
                break;
            case 6:
                imgs2PT.setImageResource(R.drawable.so6);
                break;
            case 7:
                imgs2PT.setImageResource(R.drawable.so7);
                break;
            case 8:
                imgs2PT.setImageResource(R.drawable.so8);
                break;
            case 9:
                imgs2PT.setImageResource(R.drawable.so9);
                break;
        }
        return so2;
    }

    public void myRandomDapAn(int Tong) {
        switch (Tong) {
            case 0:
                imgDA1PT.setImageResource(R.drawable.so0);
                break;
            case 1:
                imgDA2PT.setImageResource(R.drawable.so1);
                break;
            case 2:
                imgDA3PT.setImageResource(R.drawable.so2);
                break;
            case 3:
                imgDA1PT.setImageResource(R.drawable.so3);
                break;
            case 4:
                imgDA2PT.setImageResource(R.drawable.so4);
                break;
            case 5:
                imgDA3PT.setImageResource(R.drawable.so5);
                break;
            case 6:
                imgDA1PT.setImageResource(R.drawable.so6);
                break;
            case 7:
                imgDA2PT.setImageResource(R.drawable.so7);
                break;
            case 8:
                imgDA3PT.setImageResource(R.drawable.so8);
                break;
            case 9:
                imgDA1PT.setImageResource(R.drawable.so9);
                break;
        }
    }

    private class MyRunnable extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
                imgDamMay3PT.setImageResource(R.drawable.dammay);
                imgDamMay2PT.setImageResource(R.drawable.dammay);
                imgDamMay1PT.setImageResource(R.drawable.dammay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void DialogHDLam() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PhepTruActivity.this);
        alertDialogBuilder.setView(R.layout.dialog_hdpheptru);
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
    public void Service() {
        do {
            Tong = myRandomso1() - myRandomso2();
        }while (Tong<0);
        myRandomDapAn(Tong);
        Log.e("BBB", "tong 3:  " + Tong);
        i++;
        tvpheptru.setText("Câu " + i + "/15");
        if (i > 15) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PhepTruActivity.this);
            final View view1 = LayoutInflater.from(PhepTruActivity.this).inflate(R.layout.dialog_ket_qua, null);
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setView(view1);
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            Button choiLai = view1.findViewById(R.id.Again);
            Button quayLai = view1.findViewById(R.id.menu);
            TextView cauDung = view1.findViewById(R.id.tvCauDung);
            TextView cauSai = view1.findViewById(R.id.tvCauSai);
            cauDung.setText("Số câu đúng: "+dung);
            cauSai.setText("Số câu sai: "+sai);
            choiLai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    i = 1;
                    dung =0;
                    sai = 0;
                    tvpheptru.setText("Câu " + i + "/15");
                    alertDialog.cancel();
                }
            });
            quayLai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(PhepTruActivity.this,ManHinhChinhActivity.class);
                    startActivity(intent);
                }
            });

        }
        Log.e("AAA","Đúng: "+dung);
        Log.e("AAA","Sai: "+sai);
    }
}