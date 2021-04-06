package com.example.mathkid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ManHinhChinhActivity extends AppCompatActivity {
    ImageView imgHome,imgLoaManHinhChinh;
    FrameLayout frameLayoutCongTru, frameLayoutDoVui, frameLayoutTapDem, frameLayoutGiaiTri;
    static boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chinh);
        //Ánh xạ
        ManHinhChaoActivity.mediaPlayer.start();
        imgHome = findViewById(R.id.imgHome);
        imgLoaManHinhChinh = findViewById(R.id.imgLoaMHChinh);
        frameLayoutCongTru = findViewById(R.id.frameLOCongtru);
        frameLayoutDoVui = findViewById(R.id.frameLODoVui);
        frameLayoutTapDem = findViewById(R.id.frameLOTapDem);
        frameLayoutGiaiTri = findViewById(R.id.frameLOGiaiTri);
        //Chuyển màn hình
        imgLoaManHinhChinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    ManHinhChaoActivity.mediaPlayer.start();
                    imgLoaManHinhChinh.setImageResource(R.drawable.hinhloa);
                    flag = false;
                } else {
                    ManHinhChaoActivity.mediaPlayer.pause();
                    imgLoaManHinhChinh.setImageResource(R.drawable.unloa);
                    flag = true;
                }
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(ManHinhChinhActivity.this, ManHinhChaoActivity.class);
                ManHinhChaoActivity.mediaPlayer.pause();
                startActivity(intentHome);
            }
        });
        //Cộng trừ
        frameLayoutCongTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCongTru = new Intent(ManHinhChinhActivity.this, CongTruActivity.class);
                startActivity(intentCongTru);
            }
        });
        //Đố vui
        frameLayoutDoVui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCongTru = new Intent(ManHinhChinhActivity.this, DoVuiActivity.class);
                startActivity(intentCongTru);
            }
        });
        //Tập đếm
        frameLayoutTapDem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCongTru = new Intent(ManHinhChinhActivity.this, TapDemActivity.class);
                ManHinhChaoActivity.mediaPlayer.pause();
                startActivity(intentCongTru);
            }
        });
        //Giải trí
        frameLayoutGiaiTri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCongTru = new Intent(ManHinhChinhActivity.this, MHChaoGameActivity.class);
                startActivity(intentCongTru);
            }
        });

    }
}