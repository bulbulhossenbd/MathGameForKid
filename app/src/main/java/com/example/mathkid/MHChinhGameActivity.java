package com.example.mathkid;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MHChinhGameActivity extends AppCompatActivity {
    Button btnQuayLai;

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_m_h_chinh_game);
//        DialogHDLam();
//        btnQuayLai = findViewById(R.id.btnQuayLaiGame);
//        btnQuayLai.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentQuayLaiMHChinh = new Intent(MHChinhGameActivity.this, ManHinhChinhActivity.class);
//                startActivity(intentQuayLaiMHChinh);
//            }
//        });
//    }
    Intent context;
    ImageView quaylai, reset;
    private ImageView box11, box12, box13;
    private ImageView box21, box22, box23;
    private ImageView box31, box32, box33;

    private TextView text11, text12, text13;
    private TextView text21, text22, text23;
    private TextView text31, text32, text33;

    private LinearLayout khungman;
    private int scores = 0;
    private int matrix[][], luumatrix[][];
    private TextView diemso, diemcao;

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play2048);
        anhxa();
        context = getIntent();
        khoitao();
        final GestureDetector gestureDetector = new GestureDetector(this, new CuChiManHinh());
        khungman.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });
        quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                trove1buoc();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RESETGAME();
            }
        });
    }

    public void RESETGAME() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage("Bạn có muốn chơi lại!!").setPositiveButton("Có", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                khoitao();
            }
        })
                .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                }).show();
    }

    public void khoitao() {
        scores = 0;
        for (int i = 0; i < 16; i++) {
            matrix[i / 4][i % 4] = 0;
        }
        randdomnumber();
        randdomnumber();
//        setLuumatrix();
        setBOX();
    }

    void anhxa() {
        matrix = new int[4][4];
//        luumatrix = new int[4][4];
        diemso = (TextView) findViewById(R.id.diemso);
        diemcao = (TextView) findViewById(R.id.diemcao);
        khungman = (LinearLayout) findViewById(R.id.khungchoi);

        box11 = (ImageView) findViewById(R.id.box11);
        box12 = (ImageView) findViewById(R.id.box12);
        box13 = (ImageView) findViewById(R.id.box13);

        box21 = (ImageView) findViewById(R.id.box21);
        box22 = (ImageView) findViewById(R.id.box22);
        box23 = (ImageView) findViewById(R.id.box23);

        box31 = (ImageView) findViewById(R.id.box31);
        box32 = (ImageView) findViewById(R.id.box32);
        box33 = (ImageView) findViewById(R.id.box33);

        text11 = (TextView) findViewById(R.id.text11);
        text12 = (TextView) findViewById(R.id.text12);
        text13 = (TextView) findViewById(R.id.text13);

        text21 = (TextView) findViewById(R.id.text21);
        text22 = (TextView) findViewById(R.id.text22);
        text23 = (TextView) findViewById(R.id.text23);

        text31 = (TextView) findViewById(R.id.text31);
        text32 = (TextView) findViewById(R.id.text32);
        text33 = (TextView) findViewById(R.id.text33);

        quaylai = (ImageView) findViewById(R.id.exitGame);
        reset = (ImageView) findViewById(R.id.resetGame);
    }

//    public void trove1buoc() {
//        boolean check = true;
//        for (int i = 1; i < 25; i++) {
//            if (matrix[i / 5][i % 5] != luumatrix[i / 5][i % 5]) {
//                check = false;
//                break;
//            }
//        }
//        if (check == true) {
//            Toast.makeText(this, "Không thể quay lại", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        for (int i = 1; i < 16; i++) matrix[i / 4][i % 4] = luumatrix[i / 5][i % 5];
//        setBOX();
//    }

    public void setBOX() {
        diemso.setText(String.valueOf(scores));
        diemcao.setText(String.valueOf(scores));
        box11.setImageResource(getBackground(matrix[1][1]));
        box12.setImageResource(getBackground(matrix[1][2]));
        box13.setImageResource(getBackground(matrix[1][3]));

        box21.setImageResource(getBackground(matrix[2][1]));
        box22.setImageResource(getBackground(matrix[2][2]));
        box23.setImageResource(getBackground(matrix[2][3]));

        box31.setImageResource(getBackground(matrix[3][1]));
        box32.setImageResource(getBackground(matrix[3][2]));
        box33.setImageResource(getBackground(matrix[3][3]));

        String matrixS[][] = new String[4][4];
        for (int i = 0; i < 16; i++) {
            if (matrix[i / 4][i % 4] == 0) {
                matrixS[i / 4][i % 4] = "";
            } else {
                matrixS[i / 4][i % 4] = String.valueOf(matrix[i / 4][i % 4]);
            }
        }

        setSizetext();

        text11.setText(matrixS[1][1]);
        text12.setText(matrixS[1][2]);
        text13.setText(matrixS[1][3]);

        text21.setText(matrixS[2][1]);
        text22.setText(matrixS[2][2]);
        text23.setText(matrixS[2][3]);

        text31.setText(matrixS[3][1]);
        text32.setText(matrixS[3][2]);
        text33.setText(matrixS[3][3]);
    }

    public void setSizetext() {
        if (matrix[1][1] <= 512) text11.setTextSize(35);
        else text11.setTextSize(25);
        if (matrix[2][1] <= 512) text21.setTextSize(35);
        else text21.setTextSize(25);
        if (matrix[3][1] <= 512) text31.setTextSize(35);
        else text31.setTextSize(25);


        if (matrix[1][2] <= 512) text12.setTextSize(35);
        else text12.setTextSize(25);
        if (matrix[2][2] <= 512) text22.setTextSize(35);
        else text22.setTextSize(25);
        if (matrix[3][2] <= 512) text32.setTextSize(35);
        else text32.setTextSize(25);


        if (matrix[1][3] <= 512) text13.setTextSize(35);
        else text13.setTextSize(25);
        if (matrix[2][3] <= 512) text23.setTextSize(35);
        else text23.setTextSize(25);
        if (matrix[3][3] <= 512) text33.setTextSize(35);
        else text33.setTextSize(25);

    }

    public int getBackground(int n) {
        if (n == 0) return R.drawable.box0;
        switch (n % 2048) {
            case 2:
                return R.drawable.box2;
            case 4:
                return R.drawable.box4;
            case 8:
                return R.drawable.box8;
            case 16:
                return R.drawable.box16;
            case 32:
                return R.drawable.box32;
            case 64:
                return R.drawable.box64;
            case 128:
                return R.drawable.box128;
            case 256:
                return R.drawable.box256;
            case 512:
                return R.drawable.box512;
            case 1024:
                return R.drawable.box1024;
            case 0:
                return R.drawable.box2048;
        }
        return 0;
    }

    public void randdomnumber() {
        Random random = new Random();
        while (true) {
            int i = random.nextInt(3) + 1, j = random.nextInt(3) + 1;
            if (matrix[i][j] == 0) {
                //Nếu còn dư 2 ô giá trị ngẫu nhiên luôn luôn là 2.
                if (random.nextInt(8) < 7) {
                    matrix[i][j] = 2;
                } else {
                    matrix[i][j] = 4;
                }
                break;
            }
        }
    }

//    public void setLuumatrix() {
//        for (int i = 1; i < 16; i++) {
//            luumatrix[i / 4][i % 4] = matrix[i / 4][i % 4];
//        }
//
//    }

    public void gameove() {
        for (int i = 1; i < 4; i++)
            for (int j = 1; j < 4; j++)
                if (matrix[i][j] == 0)
                    return;
        boolean check = false;
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 3; j++) {
                if (matrix[i][j] == matrix[i][j + 1]) check = true;
                if (matrix[j][i] == matrix[j + 1][i]) check = true;
            }
        }
        if (check == false) {
            final Dialog dialog = new Dialog(this);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.game_over);
            dialog.show();
            final Button menu = (Button) dialog.findViewById(R.id.menu);
            Button Again = (Button) dialog.findViewById(R.id.Again);
            TextView diemso = (TextView) dialog.findViewById(R.id.diemso);
            TextView diemcao = (TextView) dialog.findViewById(R.id.diemcao);
            diemso.setText("New " + String.valueOf(scores));

            menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MHChinhGameActivity.this, MHChaoGameActivity.class));
                }
            });
            Again.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    khoitao();
                    dialog.cancel();
                }
            });
        }
    }

    public void DialogHDLam() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MHChinhGameActivity.this);
        alertDialogBuilder.setView(R.layout.dialog_hdgame);
        alertDialogBuilder.setTitle("Hướng dẫn");
        alertDialogBuilder
                .setMessage("Hướng dẫn có gif")
                .setCancelable(false)
                .setNegativeButton("Tiếp tục", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    class CuChiManHinh extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean check = false;
//            setLuumatrix();
            if (e1.getX() - e2.getX() > 100 && Math.abs(e1.getY() - e2.getY()) < Math.abs(e1.getX() - e2.getX()) && Math.abs(velocityX) > 100) {
                for (int i = 1; i < 4; i++) {
                    for (int j = 1; j < 3; j++) {
                        if (matrix[i][j] != 0) {
                            for (int k = j + 1; k < 4; k++) {
                                if (matrix[i][k] == matrix[i][j]) {
                                    check = true;
                                    matrix[i][j] += matrix[i][k];
                                    scores += matrix[i][j];
                                    matrix[i][k] = 0;
                                    j = k;
                                    break;
                                } else if (matrix[i][k] != 0) break;
                            }
                        }
                    }
                    for (int j = 1; j < 3; j++) {
                        if (matrix[i][j] == 0) {
                            for (int k = j + 1; k < 4; k++) {
                                if (matrix[i][k] != 0) {
                                    check = true;
                                    matrix[i][j] = matrix[i][k];
                                    matrix[i][k] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
            } else if (e2.getX() - e1.getX() > 100 && Math.abs(e1.getY() - e2.getY()) < Math.abs(e1.getX() - e2.getX()) && Math.abs(velocityX) > 100) {
                for (int i = 1; i < 4; i++) {
                    for (int j = 3; j > 1; j--) {

                        if (matrix[i][j] != 0) {
                            for (int k = j - 1; k > 0; k--) {
                                if (matrix[i][k] == matrix[i][j]) {
                                    check = true;
                                    matrix[i][j] += matrix[i][k];
                                    scores += matrix[i][j];
                                    matrix[i][k] = 0;
                                    j = k;
                                    break;
                                } else if (matrix[i][k] != 0) break;
                            }
                        }
                    }
                    for (int j = 3; j > 1; j--) {
                        if (matrix[i][j] == 0) {
                            for (int k = j - 1; k > 0; k--) {
                                if (matrix[i][k] != 0) {
                                    check = true;
                                    matrix[i][j] = matrix[i][k];
                                    matrix[i][k] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            //vuot len
            else if (e1.getY() - e2.getY() > 100 && Math.abs(e1.getX() - e2.getX()) < Math.abs(e1.getY() - e2.getY()) && Math.abs(velocityY) > 100) {
                for (int i = 1; i < 4; i++) {
                    for (int j = 1; j < 3; j++) {
                        if (matrix[j][i] != 0) {
                            for (int k = j + 1; k < 4; k++) {
                                if (matrix[k][i] == matrix[j][i]) {
                                    check = true;
                                    matrix[j][i] += matrix[k][i];
                                    scores += matrix[j][i];
                                    matrix[k][i] = 0;
                                    j = k;
                                    break;
                                }
                                if (matrix[k][i] != 0) break;
                            }
                        }
                    }
                    for (int j = 1; j < 3; j++) {
                        if (matrix[j][i] == 0) {
                            for (int k = j + 1; k < 4; k++) {
                                if (matrix[k][i] != 0) {
                                    check = true;
                                    matrix[j][i] = matrix[k][i];
                                    matrix[k][i] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            //vuot xuong
            else if (e2.getY() - e1.getY() > 100 && Math.abs(e1.getX() - e2.getX()) < Math.abs(e1.getY() - e2.getY()) && Math.abs(velocityY) > 100) {
                for (int i = 1; i < 4; i++) {
                    for (int j = 3; j > 1; j--) {
                        if (matrix[j][i] != 0) {
                            for (int k = j - 1; k > 0; k--) {
                                if (matrix[k][i] == matrix[j][i]) {
                                    check = true;
                                    matrix[j][i] += matrix[k][i];
                                    scores += matrix[j][i];
                                    matrix[k][i] = 0;
                                    j = k;
                                    break;
                                } else if (matrix[k][i] != 0) break;
                            }
                        }
                    }
                    for (int j = 3; j > 1; j--) {
                        if (matrix[j][i] == 0) {
                            for (int k = j - 1; k > 0; k--) {
                                if (matrix[k][i] != 0) {
                                    check = true;
                                    matrix[j][i] = matrix[k][i];
                                    matrix[k][i] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (check == true) randdomnumber();
            gameove();
            setBOX();
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}