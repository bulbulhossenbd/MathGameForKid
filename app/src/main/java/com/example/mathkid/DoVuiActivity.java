package com.example.mathkid;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
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

public class DoVuiActivity extends AppCompatActivity {
    ImageView imgLoa;
    ImageView imageViewQuayLai, imgDA1DV, imgDA2DV, imgDA3DV, imgDamMay1DV, imgDamMay2DV, imgDamMay3DV;
    int i = 1;
    int Tong =2;
    int dung;
    int sai;
    TextView cauHoiDoVui,tvDoVui;
    public static MediaPlayer mediaPlayer0, mediaPlayer1,mediaPlayer2,mediaPlayer3,mediaPlayer4,mediaPlayer5,
            mediaPlayer6,mediaPlayer7,mediaPlayer8,mediaPlayer9,mediaPlayer10,mediaPlayer11,mediaPlayer12
            ,mediaPlayer13,mediaPlayer14,mediaPlayer15,mediaPlayer16,mediaPlayer17,mediaPlayer18,mediaPlayer19;
    static boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_vui);
        imgLoa  = findViewById(R.id.imgLoaDoVui);
        cauHoiDoVui = findViewById(R.id.tvCauHoiDoVui);
        tvDoVui = findViewById(R.id.tvDoVui);
        imgDA1DV = findViewById(R.id.imgDapAn1DV);
        imgDA2DV = findViewById(R.id.imgDapAn2DV);
        imgDA3DV = findViewById(R.id.imgDapAn3DV);
        imgDamMay1DV = findViewById(R.id.imgDamMay1DV);
        imgDamMay2DV = findViewById(R.id.imgDamMay2DV);
        imgDamMay3DV = findViewById(R.id.imgDamMay3DV);
        imageViewQuayLai = findViewById(R.id.imgQuayLaiCuaMHDoVui);
        ManHinhChaoActivity.mediaPlayer.start();
         mediaPlayer0 = MediaPlayer.create(this, R.raw.cau0);
         mediaPlayer1 = MediaPlayer.create(this, R.raw.cau1);
         mediaPlayer2 = MediaPlayer.create(this, R.raw.cau2);
         mediaPlayer3 = MediaPlayer.create(this, R.raw.cau3);
         mediaPlayer4 = MediaPlayer.create(this, R.raw.cau4);
         mediaPlayer5 = MediaPlayer.create(this, R.raw.cau5);
         mediaPlayer6 = MediaPlayer.create(this, R.raw.cau6);
         mediaPlayer7 = MediaPlayer.create(this, R.raw.cau7);
         mediaPlayer8 = MediaPlayer.create(this, R.raw.cau8);
         mediaPlayer9 = MediaPlayer.create(this, R.raw.cau9);
         mediaPlayer10 = MediaPlayer.create(this, R.raw.cau10);
         mediaPlayer11 = MediaPlayer.create(this, R.raw.cau11);
         mediaPlayer12 = MediaPlayer.create(this, R.raw.cau12);
         mediaPlayer13 = MediaPlayer.create(this, R.raw.cau13);
         mediaPlayer14 = MediaPlayer.create(this, R.raw.cau14);
         mediaPlayer15 = MediaPlayer.create(this, R.raw.cau15);
         mediaPlayer16 = MediaPlayer.create(this, R.raw.cau16);
         mediaPlayer17 = MediaPlayer.create(this, R.raw.cau17);
         mediaPlayer18 = MediaPlayer.create(this, R.raw.cau18);
         mediaPlayer19 = MediaPlayer.create(this, R.raw.cau19);
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
        imgDA1DV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Tong == 0 || Tong == 3 || Tong == 6 || Tong == 9) {
                    imgDamMay1DV.setImageResource(R.drawable.anhxanh);
                    imgDamMay2DV.setImageResource(R.drawable.maydo);
                    imgDamMay3DV.setImageResource(R.drawable.maydo);
                    dung++;
                    MyRunnable myRunnable = new MyRunnable();
                    myRunnable.start();
                } else {
                    imgDamMay1DV.setImageResource(R.drawable.maydo);
                    sai++;
                    MyRunnable myRunnable = new MyRunnable();
                    myRunnable.start();
                }
                Service();
            }
        });

        imgDA2DV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Tong == 1 || Tong == 4 || Tong == 7) {
                    imgDamMay2DV.setImageResource(R.drawable.anhxanh);
                    imgDamMay1DV.setImageResource(R.drawable.maydo);
                    imgDamMay3DV.setImageResource(R.drawable.maydo);
                    dung++;
                    MyRunnable myRunnable = new MyRunnable();
                    myRunnable.start();
                } else {
                    imgDamMay2DV.setImageResource(R.drawable.maydo);
                    sai++;
                    MyRunnable myRunnable = new MyRunnable();
                    myRunnable.start();
                }
                Service();
            }
        });
        imgDA3DV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Tong == 2 || Tong == 5 || Tong == 8) {
                    imgDamMay3DV.setImageResource(R.drawable.anhxanh);
                    imgDamMay2DV.setImageResource(R.drawable.maydo);
                    imgDamMay1DV.setImageResource(R.drawable.maydo);
                    dung++;
                    MyRunnable myRunnable = new MyRunnable();
                    myRunnable.start();
                } else {
                    imgDamMay3DV.setImageResource(R.drawable.maydo);
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
                Intent intentQuayLai = new Intent(DoVuiActivity.this, ManHinhChinhActivity.class);
                ManHinhChaoActivity.mediaPlayer.pause();
                startActivity(intentQuayLai);
            }
        });
    }
    public void myRandomCauHoi() {
        int cauHoi;
        Random random = new Random();
        cauHoi = random.nextInt(20);
        switch (cauHoi) {
            case 0:
                cauHoiDoVui.setText("Điền số thích hợp vào chỗ trống (...): \n 5+4-... = 5+1");
                mediaPlayer0.start();
                Tong = 3;
                Log.e("AAA","so 0");
                break;
            case 1:
                cauHoiDoVui.setText("Nhà bạn Huy nuôi 7 con gà, mẹ bạn Huy bán đi 6 con gà. Hỏi nhà \n bạn Huy còn tất cả bao nhiêu con gà ?");
                mediaPlayer1.start();
                Tong = 1;
                Log.e("AAA","so 1");
                break;
            case 2:
                cauHoiDoVui.setText("Đàn gà nhà Lan mỗi ngày đẻ được 5 quả trứng, mẹ rán 2 quả, còn lại \n mẹ mang ra chợ bán. Hỏi mẹ Lan mang đi bán mấy quả trứng ?");
                mediaPlayer2.start();
                Tong = 3;
                Log.e("AAA","so 2");
                break;
            case 3:
                cauHoiDoVui.setText("Mẹ mua cho Bi 5 quả bóng bay, bố mua thêm cho Bi 2 quả. hỏi Bi có bao nhiêu bóng bay ?");
                mediaPlayer3.start();
                Log.e("AAA","so 3");
                Tong = 7;
                break;
            case 4:
                cauHoiDoVui.setText("Điền số thích hợp vào chỗ trống (...): \n 5+2=...-1");
                mediaPlayer4.start();
                Log.e("AAA","so 4");
                Tong = 8;
                break;
            case 5:
                cauHoiDoVui.setText("Điền số thích hợp vào chỗ trống (...): \n 5+...=7-4+3");
                mediaPlayer5.start();
                Log.e("AAA","so 5");
                Tong = 1;
                break;
            case 6:
                cauHoiDoVui.setText("Mai có 8 quả táo. Mai cho Hoa và Bình mỗi bạn 4. Vậy Mai còn lại bao nhiêu quả táo ?");
                mediaPlayer6.start();
                Log.e("AAA","so 6");
                Tong = 0;
                break;
            case 7:
                cauHoiDoVui.setText("Tìm một số biết số đó cộng với 3 được số liền trước của 8");
                mediaPlayer7.start();
                Log.e("AAA","so 7");
                Tong = 4;
                break;
            case 8:
                cauHoiDoVui.setText("Cô giáo có 2 phần quà, cô tặng cho bé 1 phần quà. Hỏi cô còn lại bao nhiêu phần quả ?");
                mediaPlayer8.start();
                Log.e("AAA","so 8");
                Tong = 1;
                break;
            case 9:
                cauHoiDoVui.setText("Thùy có 5 đôi găng tay, Thùy cho chị 3 đôi. Hỏi Thùy còn bao nhiêu chiếc găng tay ?");
                mediaPlayer9.start();
                Log.e("AAA","so 9");
                Tong = 2;
                break;
            case 10:
                cauHoiDoVui.setText("Nhà An có 6 con gà trống và 1 gà mái. Hỏi số gà trống nhiều hơn số gà mái bao nhiêu con ?");
                mediaPlayer10.start();
                Log.e("AAA","so 10");
                Tong = 5;
                break;
            case 11:
                cauHoiDoVui.setText("Điền số thích hợp vào chỗ trống (...): \n 3+6=...");
                mediaPlayer11.start();
                Log.e("AAA","so 11");
                Tong = 9;
                break;
            case 12:
                cauHoiDoVui.setText("Lan có 3 chiếc giày, Linh có 3 chiếc giày. Hỏi cả hai bạn có tất cả có bao nhiêu chiếc giày ? ");
                mediaPlayer12.start();
                Log.e("AAA","so 12");
                Tong = 6;
                break;
            case 13:
                cauHoiDoVui.setText("An ăn hết 5 quả táo, Bình ăn hết 1 quả táo. Hỏi cả hai bạn ăn hết bao nhiêu quả táo ?");
                mediaPlayer13.start();
                Log.e("AAA","so 13");
                Tong = 6;
                break;
            case 14:
                cauHoiDoVui.setText("Mẹ có 5 cái kẹo chia cho 2 anh em. Anh được ít hơn em 1 cái. Hỏi anh được bao nhiêu cái kẹo ?");
                mediaPlayer14.start();
                Log.e("AAA","so 14");
                Tong = 2;
                break;
            case 15:
                cauHoiDoVui.setText("có 9 tách cà phê, chỉ có 1 cái muống. Vậy còn thiếu bao nhiêu cái muỗng ?");
                mediaPlayer15.start();
                Log.e("AAA","so 15");
                Tong = 8;
                break;
            case 16:
                cauHoiDoVui.setText("Bé có 6 quả bóng, bé cho bị 3 quả bóng. Hỏi bé còn lại mấy quả bóng ?");
                mediaPlayer16.start();
                Log.e("AAA","so 16");
                Tong = 3;
                break;
            case 17:
                cauHoiDoVui.setText("Hương có 2 bông hoa, Lan có 7 bông hoa. Hỏi cả hai bạn có bao nhiêu bông hoa ?");
                mediaPlayer17.start();
                Log.e("AAA","so 17");
                Tong = 9;
                break;
            case 18:
                cauHoiDoVui.setText("Hoa có 4 quả bóng bay, Hoa nhỡ tay làm vỡ 3 quả, hỏi Hoa còn bao nhiêu quả bóng bay ?");
                mediaPlayer18.start();
                Log.e("AAA","so 18");
                Tong = 1;
                break;
            case 19:
                cauHoiDoVui.setText("Hồng có 9 cái kẹo, Hồng cho Mai 3 cái, cho Lan 3 cái. Hỏi Hồng còn lại bao nhiêu cái kẹo ?");
                mediaPlayer19.start();
                Log.e("AAA","so 19");
                Tong = 3;
                break;
        }
    }
    public void myRandomDapAn(int Tong) {
        switch (Tong) {
            case 0:
                imgDA1DV.setImageResource(R.drawable.so0);
                break;
            case 1:
                imgDA2DV.setImageResource(R.drawable.so1);
                break;
            case 2:
                imgDA3DV.setImageResource(R.drawable.so2);
                break;
            case 3:
                imgDA1DV.setImageResource(R.drawable.so3);
                break;
            case 4:
                imgDA2DV.setImageResource(R.drawable.so4);
                break;
            case 5:
                imgDA3DV.setImageResource(R.drawable.so5);
                break;
            case 6:
                imgDA1DV.setImageResource(R.drawable.so6);
                break;
            case 7:
                imgDA2DV.setImageResource(R.drawable.so7);
                break;
            case 8:
                imgDA3DV.setImageResource(R.drawable.so8);
                break;
            case 9:
                imgDA1DV.setImageResource(R.drawable.so9);
                break;
        }
    }
    private class MyRunnable extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
                imgDamMay3DV.setImageResource(R.drawable.dammay);
                imgDamMay2DV.setImageResource(R.drawable.dammay);
                imgDamMay1DV.setImageResource(R.drawable.dammay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void DialogHDLam() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(DoVuiActivity.this);
        alertDialogBuilder.setView(R.layout.dialog_hddovui);
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
        myRandomCauHoi();
        myRandomDapAn(Tong);
        Log.e("BBB", "tong 3:  " + Tong);
        i++;
        tvDoVui.setText("Câu " + i + "/10");
        if (i > 10) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(DoVuiActivity.this);
            final View view1 = LayoutInflater.from(DoVuiActivity.this).inflate(R.layout.dialog_ket_qua, null);
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
                    tvDoVui.setText("Câu " + i + "/10");
                    alertDialog.cancel();
                }
            });
            quayLai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(DoVuiActivity.this,ManHinhChinhActivity.class);
                    startActivity(intent);
                }
            });

        }
        Log.e("AAA", "Đúng: " + dung);
        Log.e("AAA", "Sai: " + sai);
    }
}