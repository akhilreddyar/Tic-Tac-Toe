package com.example.tic_tac_toe;

import android.widget.Button;

import java.util.Arrays;

public class MapClickToCoordinates {
    public Integer[] coordinatesMap(int pos){
        Integer[] out = new Integer[2];
        Arrays.fill(out,-1);
        switch(pos){
            case 1:
                out[0]=0;
                out[1]=0;
                break;
            case 2:
                out[0]=0;
                out[1]=1;
                break;
            case 3:
                out[0]=0;
                out[1]=2;
                break;
            case 4:
                out[0]=1;
                out[1]=0;
                break;
            case 5:
                out[0]=1;
                out[1]=1;
                break;
            case 6:
                out[0]=1;
                out[1]=2;
                break;
            case 7:
                out[0]=2;
                out[1]=0;
                break;
            case 8:
                out[0]=2;
                out[1]=1;
                break;
            case 9:
                out[0]=2;
                out[1]=2;
                break;
        }
        return out;
    }
    public int fromCorToPos(Integer[] in){
        if(in[0]==0&&in[1]==0)
            return 1;
        else if(in[0]==0&&in[1]==1)
            return 2;
        else if(in[0]==0&&in[1]==2)
            return 3;
        else if(in[0]==1&&in[1]==0)
            return 4;
        else if(in[0]==1&&in[1]==1)
            return 5;
        else if(in[0]==1&&in[1]==2)
            return 6;
        else if(in[0]==2&&in[1]==0)
            return 7;
        else if(in[0]==2&&in[1]==1)
            return 8;
        else 
            return 9;
        
    }
    public Button checkfromList(Button p1, Button p2, Button p3, Button p4, Button p5, Button p6, Button p7, Button p8, Button p9, int c1){
        switch (c1){
            case 1:
                return p1;
            case 2:
                return p2;
            case 3:
                return p3;
            case 4:
                return p4;
            case 5:
                return p5;
            case 6:
                return p6;
            case 7:
                return p7;
            case 8:
                return p8;
            case 9:
                return p9;
        }
        return p1;
    }
}
