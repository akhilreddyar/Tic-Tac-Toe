package com.example.tic_tac_toe;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener  {
    Button  p1=null,p2=null,p3=null,p4=null,p5=null,p6=null,p7=null,p8=null,p9=null,reset=null;
    Board board=null;
    Vibrator vibe=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2);
         vibe = (Vibrator) MainActivity.this.getSystemService(Context.VIBRATOR_SERVICE);

        Bundle b = getIntent().getExtras();
        try {
            if (b.getBoolean("status")) {
                board = new Board();
                init();
            }
        }
        catch (NullPointerException e){
        }
        board = new Board();
        init();
        reset = (Button)findViewById(R.id.button_Reset_Board);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                board = new Board();
                init();
                vibe.vibrate(120);
            }
        });
        }
    public void init(){
        p1 = (Button)findViewById(R.id.button_slot_1);
        p2 = (Button)findViewById(R.id.button_slot_2);
        p3 = (Button)findViewById(R.id.button_slot_3);
        p4 = (Button)findViewById(R.id.button_slot_4);
        p5 = (Button)findViewById(R.id.button_slot_5);
        p6 = (Button)findViewById(R.id.button_slot_6);
        p7 = (Button)findViewById(R.id.button_slot_7);
        p8 = (Button)findViewById(R.id.button_slot_8);
        p9 = (Button)findViewById(R.id.button_slot_9);
        p1.setOnClickListener(this);
        p2.setOnClickListener(this);
        p3.setOnClickListener(this);
        p4.setOnClickListener(this);
        p5.setOnClickListener(this);
        p6.setOnClickListener(this);
        p7.setOnClickListener(this);
        p8.setOnClickListener(this);
        p9.setOnClickListener(this);
        p1.setTextColor(Color.BLACK);
        p2.setTextColor(Color.BLACK);
        p3.setTextColor(Color.BLACK);
        p4.setTextColor(Color.BLACK);
        p5.setTextColor(Color.BLACK);
        p6.setTextColor(Color.BLACK);
        p7.setTextColor(Color.BLACK);
        p8.setTextColor(Color.BLACK);
        p9.setTextColor(Color.BLACK);
        p1.setText("?");
        p2.setText("?");
        p3.setText("?");
        p4.setText("?");
        p5.setText("?");
        p6.setText("?");
        p7.setText("?");
        p8.setText("?");
        p9.setText("?");
    }
    @Override
    public void onClick(View v) {
        vibe.vibrate(50);
        int id = v.getId();
    MapClickToCoordinates  cor = new MapClickToCoordinates();
    int cpos =-1;
    switch (id){
        case R.id.button_slot_1:
            cpos = 1;
            break;
        case R.id.button_slot_2:
            cpos = 2;
            break;
        case R.id.button_slot_3:
            cpos = 3;
            break;
        case R.id.button_slot_4:
            cpos = 4;
            break;
        case R.id.button_slot_5:
            cpos = 5;
            break;
        case R.id.button_slot_6:
            cpos = 6;
            break;
        case R.id.button_slot_7:
            cpos = 7;
            break;
        case R.id.button_slot_8:
            cpos = 8;
            break;
        case R.id.button_slot_9:
            cpos = 9;
            break;
        default:
            break;
    }
    if(cpos!=-1){
        Button preesed = cor.checkfromList(p1,p2,p3,p4,p5,p6,p7,p8,p9,cpos);
        preesed.setText("O");
        preesed.setTextColor(Color.BLUE);
        board.place(cor.coordinatesMap(cpos), Board.CellState.O);
        preesed.setClickable(false);
        if(board.checkWon()==null){
            Integer[] cur = AI.getBestMove(board);
            board.place(cur, Board.CellState.X);
            int c1 = cor.fromCorToPos(cur);
            Button curPress = cor.checkfromList(p1,p2,p3,p4,p5,p6,p7,p8,p9,c1);
            curPress.setTextColor(Color.RED);
            curPress.setClickable(false);
            curPress.setText("X");
        }
    }
        Intent next = new Intent(MainActivity.this,Winner.class);

        if (board.checkWon() == AI.ai) {
            Log.i("action1","AI WON!");
            next.putExtra("value","AI   WON");
            startActivity(next);
        } else if (board.checkWon() == AI.human) {
            Log.i("action2","YOU WON!");
            next.putExtra("value","YOU WON");
            vibe.vibrate(300);
            startActivity(next);
        } else if(board.checkWon()!=null){
            Log.i("action3","TIE");
            next.putExtra("value","TIE!...");
            vibe.vibrate(200);
            startActivity(next);
        }
    }
}
