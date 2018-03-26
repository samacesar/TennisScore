package com.example.sama.tennisscore;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Scroller;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    void newMatch(){
        newGame();
        SP1=1;
        SP2=1;
        nSet=1;
        newSet();
        numGame.setText("GAME 1");
        numSet.setText("SET 1");
        nSetA.setText("00");
        nSetB.setText("00");

        winner.setVisibility(View.INVISIBLE);

    }

    void newSet(){
        if (SP1==3) {
            winner.setText("WINNER: "+inP1.getText());
            winner.setVisibility(View.VISIBLE);
        }
        if (SP2==3) {
            winner.setText("WINNER: "+inP2.getText());
            winner.setVisibility(View.VISIBLE);

        }
        GP1=1;
        GP2=1;
        nGameA.setText("00");
        nGameB.setText("00");
    }
    void newGame(){
        ptoP1.setTextColor(Color.GREEN);
        ptoP2.setTextColor(Color.GREEN);
        ptoP3.setTextColor(Color.GREEN);
        ptoP4.setTextColor(Color.BLUE);
        ptoP5.setTextColor(Color.BLUE);
        ptoP6.setTextColor(Color.GREEN);
        ptoP7.setTextColor(Color.GREEN);
        ptoP8.setTextColor(Color.GREEN);
        ptoP9.setTextColor(Color.BLUE);
        ptoP10.setTextColor(Color.BLUE);
        gamePointA.setText("00");
        gamePointB.setText("00");
        P1=1;
        P2=1;
        numGame.setText("GAME "+G);
    }
    void matchPoint(int P1, int P2){
        if (P1>3 && (P1-P2)>=1){
            statusA.setText("GAME POINT");
            statusA.setVisibility(View.VISIBLE);
            if(GP1==5){
                statusA.setText("SET POINT");
                statusA.setVisibility(View.VISIBLE);

                if(SP1==2){
                    statusA.setText("MATCH POINT");
                    statusA.setVisibility(View.VISIBLE);

                }
            }
            statusB.setText("");
        }
        if (P1>4 && P1-P2>1 ) {
            statusA.setText("P1 GAME");
            GP1+=1;
            G+=1;
            nGameA.setText("0"+(GP1-1));
            if(GP1>=6 && (GP1-GP2)>1){
                SP1+=1;
                nSetA.setText("0"+(SP1-1));
                nSet+=1;
                numSet.setText("SET "+nSet);
                numGame.setText("GAME 1");
                G=1;
                newSet();
            }
            newGame();

        }
        if (P2>3 && (P2-P1)>=1){
            statusB.setText("GAME POINT");
            statusB.setVisibility(View.VISIBLE);

            if(GP2==5){
                statusB.setText("SET POINT");
                statusB.setVisibility(View.VISIBLE);

                if(SP2==2){
                    statusB.setText("MATCH POINT");
                    statusB.setVisibility(View.VISIBLE);

                }
            }
            statusA.setText("");
        }
        if (P2>4 && P2-P1>1 ) {
            statusB.setText("P2 GAME");
            GP2+=1;
            G+=1;
            nGameB.setText("0"+(GP2-1));
            if(GP2>=6 && (GP2-GP1)>1){
                SP2+=1;
                nSetB.setText("0"+(SP2-1));
                nSet+=1;
                numSet.setText("SET "+nSet);
                numGame.setText("GAME 1");
                G=1;
                newSet();
            }
            newGame();
        }
    }
    void deuce(int P1,int P2){
        if(P1 == 4 && P2 == 4){
            statusA.setText("DEUCE");
            statusA.setVisibility(View.VISIBLE);
            statusB.setText("DEUCE");
            statusB.setVisibility(View.VISIBLE);
            deuceA=true;

        }
        if(P1==5 & P2 ==5){
            statusA.setText("DEUCE");
            statusB.setText("DEUCE");
            if(deuceA)gamePointA.setText("40");
            if(deuceB)gamePointB.setText("40");
            ScoreActivity.P1=4;
            ScoreActivity.P2=4;
            ptoP4.setTextColor(Color.BLUE);
            ptoP9.setTextColor(Color.BLUE);
            deuceB=true;
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
    private TextView gamePointA;
    private TextView gamePointB;
    private TextView numSet;
    private TextView numGame;
    boolean deuceA = false;
    boolean deuceB = false;
    public static int nSet =1;
    public static int G=1;
    public static int P1 = 1;
    public static int P2 = 1;
    public static int GP1 = 1;
    public static int GP2 = 1;
    public static int SP1 = 1;
    public static int SP2 = 1;
    private TextView nSetA;
    private TextView nGameA;
    private TextView nSetB;
    private TextView nGameB;
    private TextView winner;
    private EditText inP1;
    private EditText inP2;
    private TextView BP1;
    private TextView BP2;
    private Button RST;
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
        numSet  = (TextView)findViewById(R.id.nSet);
        numGame = (TextView)findViewById(R.id.nGame);
        nSetA  = (TextView)findViewById(R.id.SetsA);
        nGameA = (TextView)findViewById(R.id.gamesA);
        nSetB  = (TextView)findViewById(R.id.SetsB);
        nGameB = (TextView)findViewById(R.id.gamesB);
        winner = (TextView)findViewById(R.id.ganador);
        inP1 = (EditText)findViewById(R.id.P1in);
        inP2 = (EditText)findViewById(R.id.P2in);
        BP1 = (TextView)findViewById(R.id.P1B);
        BP2 = (TextView)findViewById(R.id.P2B);
        RST = (Button)findViewById(R.id.restart);
        gamePointA = (TextView)findViewById(R.id.puntosA);
        gamePointB = (TextView)findViewById(R.id.puntosB);

        RST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newMatch();
            }
        });

        btnP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BP1.setText(inP1.getText());
                BP2.setText(inP2.getText());
                if (P1==5){
                    ptoP5.setTextColor(Color.RED);
                    P1 += 1;
                    if(deuceA)gamePointA.setText("00");

                }
                if (P1==4){
                    ptoP4.setTextColor(Color.RED);
                    P1 += 1;
                    if(deuceA)gamePointA.setText("adv");

                }
                if (P1==3){
                    ptoP3.setTextColor(Color.RED);
                    P1 += 1;
                    gamePointA.setText("40");

                }
                if (P1==2){
                    ptoP2.setTextColor(Color.RED);
                    P1 += 1;
                    gamePointA.setText("30");

                }
                if (P1==1) {
                    ptoP1.setTextColor(Color.RED);
                    P1 += 1;
                    gamePointA.setText("15");
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
                    if(deuceB)gamePointB.setText("00");
                    P2 += 1;
                }
                if (P2==4){
                    ptoP9.setTextColor(Color.RED);
                    if(deuceB)gamePointB.setText("adv");
                    P2 += 1;
                }
                if (P2==3){
                    ptoP8.setTextColor(Color.RED);
                    P2 += 1;
                    gamePointB.setText("40");

                }
                if (P2==2){
                    ptoP7.setTextColor(Color.RED);
                    P2 += 1;
                    gamePointB.setText("30");

                }
                if (P2==1) {
                    ptoP6.setTextColor(Color.RED);
                    P2 += 1;
                    gamePointB.setText("15");

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