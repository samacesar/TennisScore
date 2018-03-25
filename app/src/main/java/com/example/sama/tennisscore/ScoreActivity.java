package com.example.sama.tennisscore;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Scroller;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    void matchPoint(int P1, int P2){
        if (P1>3 && (P1-P2)>=1){
            statusA.setText("MatchPoint");
            statusB.setText("");
        }
        if (P1>4 && P1-P2>1 ) {
            statusA.setText("P1 GANADOR");
            GP1+=1;
        }
        if (P2>3 && (P2-P1)>=1){
            statusB.setText("MatchPoint");
            statusA.setText("");
        }
        if (P2>4 && P2-P1>1 ) {
            statusB.setText("P2 GANADOR");
            GP2+=1;
        }
    }
    void deuce(int P1,int P2){
        if(P1 == 4 && P2 == 4){
            statusA.setText("DEUCE");
            statusB.setText("DEUCE");
        }
        if(P1==5 & P2 ==5){
            statusA.setText("DEUCE");
            statusB.setText("DEUCE");
            ScoreActivity.P1=4;
            ScoreActivity.P2=4;
            ptoP4.setTextColor(Color.BLUE);
            ptoP9.setTextColor(Color.BLUE);
        }
    }


    private Button btnP1;
    private Button btnP2;
    private TextView ptoP1;
    private TextView ptoP2;
    private TextView ptoP3;
    private TextView ptoP4;
    private TextView ptoP5;
    private TextView ptoP6;
    private TextView ptoP7;
    private TextView ptoP8;
    private TextView ptoP9;
    private TextView ptoP10;
    private TextView statusA;
    private TextView statusB;
    public static int P1 = 1;
    public static int P2 = 1;
    public static int GP1 = 1;
    public static int GP2 = 1;
    public static int SP1 = 1;
    public static int SP2 = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        statusA = (TextView)findViewById(R.id.statusA);
        statusB = (TextView)findViewById(R.id.statusB);
        btnP1 = (Button)findViewById(R.id.masP1);
        btnP2 = (Button)findViewById(R.id.masP2);
        ptoP1 = (TextView)findViewById(R.id.ptos1);
        ptoP2 = (TextView)findViewById(R.id.ptos2);
        ptoP3 = (TextView)findViewById(R.id.ptos3);
        ptoP4 = (TextView)findViewById(R.id.ptos4);
        ptoP5 = (TextView)findViewById(R.id.ptos5);
        ptoP6 = (TextView)findViewById(R.id.ptos6);
        ptoP7 = (TextView)findViewById(R.id.ptos7);
        ptoP8 = (TextView)findViewById(R.id.ptos8);
        ptoP9 = (TextView)findViewById(R.id.ptos9);
        ptoP10 = (TextView)findViewById(R.id.ptos10);



        btnP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (P1==5){
                    ptoP5.setTextColor(Color.RED);
                    P1 += 1;
                }
                if (P1==4){
                    ptoP4.setTextColor(Color.RED);
                    P1 += 1;
                }
                if (P1==3){
                    ptoP3.setTextColor(Color.RED);
                    P1 += 1;
                }
                if (P1==2){
                    ptoP2.setTextColor(Color.RED);
                    P1 += 1;
                }
                if (P1==1) {
                    ptoP1.setTextColor(Color.RED);
                    P1 += 1;
                }
                matchPoint(P1,P2);
                deuce(P1,P2);

            }
        });
        btnP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                if (P2==5){
                    ptoP10.setTextColor(Color.RED);
                    P2 += 1;
                }
                if (P2==4){
                    ptoP9.setTextColor(Color.RED);
                    P2 += 1;
                }
                if (P2==3){
                    ptoP8.setTextColor(Color.RED);
                    P2 += 1;
                }
                if (P2==2){
                    ptoP7.setTextColor(Color.RED);
                    P2 += 1;
                }
                if (P2==1) {
                    ptoP6.setTextColor(Color.RED);
                    P2 += 1;
                }
                matchPoint(P1,P2);
                deuce(P1,P2);

            }
        });
    }
}
/*
3 FACTORES
GAME
SET
MATCH

 */