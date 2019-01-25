/*************
 Developer: Kyle Lester
 App: Order and Chaos
 Tested On: Pixel 2
 **************/
package com.kylelester.orderandchaos;

import android.app.Activity;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameActivity extends Activity implements View.OnClickListener{
    private boolean oc = true;
    private int turnCounter = 1;
    private boolean oneATurn = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

        hmap.put(11, R.id.A1_imageButton);
        hmap.put(12, R.id.A2_imageButton);
        hmap.put(13, R.id.A3_imageButton);
        hmap.put(14, R.id.A4_imageButton);
        hmap.put(15, R.id.A5_imageButton);
        hmap.put(16, R.id.A6_imageButton);
        hmap.put(21, R.id.B1_imageButton);
        hmap.put(22, R.id.B2_imageButton);
        hmap.put(23, R.id.B3_imageButton);
        hmap.put(24, R.id.B4_imageButton);
        hmap.put(25, R.id.B5_imageButton);
        hmap.put(26, R.id.B6_imageButton);
        hmap.put(31, R.id.C1_imageButton);
        hmap.put(32, R.id.C2_imageButton);
        hmap.put(33, R.id.C3_imageButton);
        hmap.put(34, R.id.C4_imageButton);
        hmap.put(35, R.id.C5_imageButton);
        hmap.put(36, R.id.C6_imageButton);
        hmap.put(41, R.id.D1_imageButton);
        hmap.put(42, R.id.D2_imageButton);
        hmap.put(43, R.id.D3_imageButton);
        hmap.put(44, R.id.D4_imageButton);
        hmap.put(45, R.id.D5_imageButton);
        hmap.put(46, R.id.D6_imageButton);
        hmap.put(51, R.id.E1_imageButton);
        hmap.put(52, R.id.E2_imageButton);
        hmap.put(53, R.id.E3_imageButton);
        hmap.put(54, R.id.E4_imageButton);
        hmap.put(55, R.id.E5_imageButton);
        hmap.put(56, R.id.E6_imageButton);
        hmap.put(61, R.id.F1_imageButton);
        hmap.put(62, R.id.F2_imageButton);
        hmap.put(63, R.id.F3_imageButton);
        hmap.put(64, R.id.F4_imageButton);
        hmap.put(65, R.id.F5_imageButton);
        hmap.put(66, R.id.F6_imageButton);

        for(int i = 1; i <= 6; i++){
            String y = "" + i;
            for(int x = 1; x <= 6; x++){
                String z = y + x;
                Log.i("!!!!!",z);
                findViewById(hmap.get(Integer.parseInt(z))).setOnClickListener(this);
            }
        }
        OrderOrChaos orderOrChaos = new OrderOrChaos();
        Button button = findViewById(R.id.order_button);
        button.setOnClickListener(orderOrChaos);

        button = findViewById(R.id.chaos_button);
        button.setOnClickListener(orderOrChaos);

        EndTurn endTurn = new EndTurn(hmap);
        button = findViewById(R.id.endTurn_button);
        button.setOnClickListener(endTurn);

    }


    @Override
    public void onClick(View view){
        ImageButton button;

        //switch
        if(oneATurn && (view.getTag() == null)) {
            switch (view.getId()) {
                case R.id.A1_imageButton:
                    button = findViewById(R.id.A1_imageButton);
                    if (oc) {
                        button.setImageResource(R.drawable.oc_topleft_white_32);
                        button.setTag("Order");
                    } else {
                        button.setImageResource(R.drawable.oc_topleft_black_32);
                        button.setTag("Chaos");
                    }
                    Log.i("!!!!!!!!!","" + button.getId());
                    oneATurn = false;
                    break;
                case R.id.F1_imageButton:
                    button = findViewById(R.id.F1_imageButton);
                    if (oc) {
                        button.setImageResource(R.drawable.oc_topright_white_32);
                        button.setTag("Order");

                    } else {
                        button.setImageResource(R.drawable.oc_topright_black_32);
                        button.setTag("Chaos");

                    }
                    Log.i("!!!!!!!!!","" + button.getId());
                    oneATurn = false;
                    break;
                case R.id.A6_imageButton:
                    button = findViewById(R.id.A6_imageButton);
                    if (oc) {
                        button.setImageResource(R.drawable.oc_bottomleft_white_32);
                        button.setTag("Order");


                    } else {
                        button.setImageResource(R.drawable.oc_bottomleft_black_32);
                        button.setTag("Chaos");
                    }
                    Log.i("!!!!!!!!!","" + button.getId());
                    oneATurn = false;
                    break;
                case R.id.F6_imageButton:
                    button = findViewById(R.id.F6_imageButton);
                    if (oc) {
                        button.setImageResource(R.drawable.oc_bottomright_white_32);
                        button.setTag("Order");

                    } else {
                        button.setImageResource(R.drawable.oc_bottomright_black_32);
                        button.setTag("Chaos");
                    }
                    Log.i("!!!!!!!!!","" + button.getId());
                    oneATurn = false;
                    break;
                case R.id.E1_imageButton:
                case R.id.D1_imageButton:
                case R.id.C1_imageButton:
                case R.id.B1_imageButton:
                    button = findViewById(view.getId());
                    if (oc) {
                        button.setImageResource(R.drawable.oc_topline_white_32);
                        button.setTag("Order");

                    } else {
                        button.setImageResource(R.drawable.oc_topline_black_32);
                        button.setTag("Chaos");
                    }
                    Log.i("!!!!!!!!!","" + button.getId());
                    oneATurn = false;
                    break;
                case R.id.A5_imageButton:
                case R.id.A4_imageButton:
                case R.id.A3_imageButton:
                case R.id.A2_imageButton:
                    button = findViewById(view.getId());
                    if (oc) {
                        button.setImageResource(R.drawable.oc_leftline_white_32);
                        button.setTag("Order");

                    } else {
                        button.setImageResource(R.drawable.oc_leftline_black_32);
                        button.setTag("Chaos");
                    }
                    Log.i("!!!!!!!!!","" + button.getId());
                    oneATurn = false;
                    break;
                case R.id.B6_imageButton:
                case R.id.C6_imageButton:
                case R.id.D6_imageButton:
                case R.id.E6_imageButton:
                    button = findViewById(view.getId());
                    if (oc) {
                        button.setImageResource(R.drawable.oc_bottomline_white_32);
                        button.setTag("Order");

                    } else {
                        button.setImageResource(R.drawable.oc_bottomline_black_32);
                        button.setTag("Chaos");
                    }
                    Log.i("!!!!!!!!!","" + button.getId());
                    oneATurn = false;
                    break;
                case R.id.F2_imageButton:
                case R.id.F3_imageButton:
                case R.id.F4_imageButton:
                case R.id.F5_imageButton:
                    button = findViewById(view.getId());
                    if (oc) {
                        button.setImageResource(R.drawable.oc_rightline_white_32);
                        button.setTag("Order");
                        Log.i("!!!!!!!",(String)button.getTag());

                    } else {
                        button.setImageResource(R.drawable.oc_rightline_black_32);
                        button.setTag("Chaos");
                    }
                    Log.i("!!!!!!!!!","" + button.getId());
                    oneATurn = false;
                    break;
                case R.id.B2_imageButton:
                case R.id.B3_imageButton:
                case R.id.B4_imageButton:
                case R.id.B5_imageButton:
                case R.id.C2_imageButton:
                case R.id.C3_imageButton:
                case R.id.C4_imageButton:
                case R.id.C5_imageButton:
                case R.id.D2_imageButton:
                case R.id.D3_imageButton:
                case R.id.D4_imageButton:
                case R.id.D5_imageButton:
                case R.id.E2_imageButton:
                case R.id.E3_imageButton:
                case R.id.E4_imageButton:
                case R.id.E5_imageButton:
                    button = findViewById(view.getId());
                    if (oc) {
                        button.setImageResource(R.drawable.oc_middle_white_32);
                        button.setTag("Order");

                    } else {
                        button.setImageResource(R.drawable.oc_middle_black_32);
                        button.setTag("Chaos");
                    }
                    Log.i("!!!!!!!!!","" + button.getId());
                    oneATurn = false;
                    break;
            }
        }
    }

    class OrderOrChaos implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.order_button){oc = true;
            }else if(view.getId() == R.id.chaos_button){oc = false;
            }
        }
    }

    class EndTurn implements View.OnClickListener {

        private final HashMap hmap;

        public EndTurn(HashMap hmap) {
            this.hmap = hmap;
        }

        @Override
        public void onClick(View view) {
            TextView textView = findViewById(R.id.turn_textView);
            boolean orderWinOrder = false;
            boolean orderWinChaos = false;
            boolean chaosWin = false;
            for (int i = 1; i <= 6; i++) {
                String y = "" + i;
                int limit = 6;
                for (int x = 1; x <= limit; x++) {
                    String z = y + x;
                    int iz = Integer.parseInt(z);

                    orderWinOrder = CheckForFiveInRow(iz, "Order");
                    orderWinChaos = CheckForFiveInRow(iz, "Chaos");
                    if (orderWinOrder || orderWinChaos) {
                        Log.i("!!!!!","BREAK");
                        break;
                    }
                }
                if (orderWinOrder || orderWinChaos) {
                    Log.i("!!!!!","BREAK2");
                    break;
                }
            }

            chaosWin = CheckForFullField();

            if (orderWinOrder || orderWinChaos) {
                textView.setText("The Winner Is Order!");
                textView.setTextColor(Color.WHITE);
            } else if(chaosWin){
                textView.setText("The Winner Is Chaos!");
                textView.setTextColor(Color.BLACK);
            } else if (!(turnCounter % 2 == 0)) {
                textView.setText("It is Chaos's turn");
                textView.setTextColor(Color.BLACK);
            } else {
                textView.setText("It is Order's turn");
                textView.setTextColor(Color.WHITE);
            }
            turnCounter++;
            oneATurn = true;
        }

        private boolean CheckForFullField() {
            ImageButton button;
            List<Integer> full = new ArrayList<>();
            for(int i = 1; i <= 6; i++){
                String y = "" + i;
                for(int x = 1; x <= 6; x++){
                    String z = y + x;
                    button = findViewById((Integer) hmap.get(Integer.parseInt(z)));
                    if((button.getTag() == "Order") || (button.getTag() == "Chaos")){
                        full.add(Integer.parseInt(z));
                        if(full.size() == 36){
                            Log.i("!!!!!", "Chaos RETURN TRUE");
                            return true;
                        }
                    }

                }
            }
            return false;
        }

        private boolean CheckForFiveInRow(int current, String OC) {
            ImageButton button;
            String sfnum = Integer.toString(current).substring(0, 1);
            int fnum = Integer.parseInt(sfnum);
            int snum = Integer.parseInt(Integer.toString(current).substring(1, 2));

            //check the rows
            int x = 1;
            snum = Integer.parseInt(Integer.toString(current).substring(1, 2));
            String tag;
            snum += 10;
            List<Integer> order = new ArrayList<>();
            for (int i = snum; x <= 6; i += 10) {
                button = findViewById((Integer) hmap.get(i));
                tag = (String) button.getTag();
                Log.i("!!!!!!!", tag + OC);
                if (button.getTag() == OC) {
                    order.add(i);
                    Log.i("!!!", Integer.toString(i));
                    if (order.size() == 5) {
                        String numberNum = "";
                        for (int y = 0; y < order.size(); y++) {
                            numberNum = numberNum + Integer.toString(order.get(y)).substring(0, 1);
                            Log.i("!!!!!", numberNum);
                            Log.i("!!!!!!", Integer.toString(order.get(y)));
                            if (numberNum.equals("12345") || numberNum.equals("23456")) {
                                Log.i("!!!!!", "RETURN TRUE");
                                return true;
                            }
                        }
                    }
                }
                x++;
            }

            //check the columns
            x = 1;
            sfnum = Integer.toString(current).substring(0, 1);
            sfnum = sfnum + 1;
            fnum = Integer.parseInt(sfnum);
            order.clear();
            for (int i = fnum; x <= 6; i++) {
                button = findViewById((Integer) hmap.get(i));
                if (button.getTag() == OC) {
                    order.add(i);
                    Log.i("!!!", Integer.toString(i));
                    if (order.size() == 5) {
                        String numberNum = "";
                        for (int y = 0; y < order.size(); y++) {
                            numberNum = numberNum + Integer.toString(order.get(y)).substring(1, 2);
                            Log.i("!!!!!", numberNum);
                            Log.i("!!!!!!", Integer.toString(order.get(y)));
                            if (numberNum.equals("12345") || numberNum.equals("23456")) {
                                Log.i("!!!!!", "RETURN TRUE");
                                return true;
                            }
                        }
                    }
                }
                x++;
            }

            //check diagonal right
            order.clear();
            int tempEndRight = current;
            for (int u = 1; u <= 6; u++) {
                Log.i("!tempEnd","" + tempEndRight + " " + current);
                int fTempEnd = Integer.parseInt(Integer.toString(tempEndRight).substring(0, 1));
                Log.i("!fTempEnd","" + tempEndRight + " " + fTempEnd);
                int sTempEnd = Integer.parseInt(Integer.toString(tempEndRight).substring(1, 2));
                Log.i("!sTempEnd","" + tempEndRight + " " + sTempEnd);
                if(fTempEnd <= 6 && sTempEnd <= 6){
                    button = findViewById((Integer) hmap.get(tempEndRight));
                    if (button.getTag() == OC) {
                        order.add(tempEndRight);
                        if (order.size() == 5) {
                            String numberNum = "";
                            for (int l = 0; l < order.size(); l++) {
                                numberNum = numberNum + Integer.toString(order.get(l)).substring(0, 1);
                                Log.i("!!!!!", numberNum);
                                Log.i("!!!!!!", Integer.toString(order.get(l)));
                                if (numberNum.equals("12345") || numberNum.equals("23456")) {
                                    Log.i("!!!!!", "RETURN TRUE " + numberNum);
                                    return true;
                                    }
                            }

                        }

                    }

                }else{break;}
                tempEndRight += 11;

            }

            //check diagnal left
            order.clear();
            int tempEndLeft = current;
            for (int u = 1; u <= 6; u++) {
                if (tempEndLeft >= 11) {
                    Log.i("!tempEndLeft", "" + tempEndLeft + " " + current);
                    int fTempEnd = Integer.parseInt(Integer.toString(tempEndLeft).substring(0, 1));
                    Log.i("!fTempEndLeft", "" + tempEndLeft + " " + fTempEnd);
                    int sTempEnd = Integer.parseInt(Integer.toString(tempEndLeft).substring(1, 2));
                    Log.i("!sTempEndLeft", "" + tempEndLeft + " " + sTempEnd);

                    if (fTempEnd <= 6 && sTempEnd <= 6) {
                        button = findViewById((Integer) hmap.get(tempEndLeft));
                        if (button.getTag() == OC) {
                            order.add(tempEndLeft);
                            if (order.size() == 5) {
                                String numberNum = "";
                                for (int l = 0; l < order.size(); l++) {
                                    numberNum = numberNum + Integer.toString(order.get(l)).substring(0, 1);
                                    Log.i("!!!!!", numberNum);
                                    Log.i("!!!!!!", Integer.toString(order.get(l)));
                                    if (numberNum.equals("54321") || numberNum.equals("65432")) {
                                        Log.i("!!!!!", "RETURN TRUE " + numberNum);
                                        return true;
                                    }
                                }
                            }
                        }
                    } else {
                        break;
                    }

                    tempEndLeft = tempEndLeft - 10;
                    tempEndLeft++;
                }
            }

            return false;

        }
    }
}


