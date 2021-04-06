package com.example.mathkid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CongTruActivity extends AppCompatActivity {
    ImageView imgLoa;
    ImageView imageViewQuayLai;
    FrameLayout frameLayoutPhepCong, frameLayoutPhepTru;
    static boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cong_tru);
        //Ánh xạ
        ManHinhChaoActivity.mediaPlayer.start();
        imgLoa  = findViewById(R.id.imgLoaMHCongTru);
        imageViewQuayLai = findViewById(R.id.imgQuayLaiCuaMHCongTru);
        frameLayoutPhepCong = findViewById(R.id.frameLOPhepCong);
        frameLayoutPhepTru = findViewById(R.id.frameLOPhepTru);
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
        //Chuyển màn hình
        //Quay lại:
        imageViewQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentQuayLai = new Intent(CongTruActivity.this, ManHinhChinhActivity.class);
                ManHinhChaoActivity.mediaPlayer.pause();
                startActivity(intentQuayLai);
            }
        });
        //Phép cộng:
        frameLayoutPhepCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPhepCong = new Intent(CongTruActivity.this, PhepCongActivity.class);
                startActivity(intentPhepCong);
            }
        });
        //Phép trừ:
        frameLayoutPhepTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPhepTru = new Intent(CongTruActivity.this, PhepTruActivity.class);
                startActivity(intentPhepTru);
            }
        });

    }
}