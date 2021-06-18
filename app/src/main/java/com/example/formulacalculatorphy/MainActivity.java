package com.example.formulacalculatorphy;

import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
               Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
               LinearLayout l1,l2,l3;
               EditText t1,t4,t5;
               TextView t2,t3,t6,t7;
               double speed,lorentz_factor,s1,l_1,l_2;
               double h,m,s,k,c = 300000000;
               Vibrator vibrator;
               Thread thread;
               Calendar calendar;
               SimpleDateFormat fth,ftm,fts,ft;
               String n;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        b10 = findViewById(R.id.button10);
        l1 = findViewById(R.id.linearlayout1);
        l2 = findViewById(R.id.linearlayout2);
        l3 = findViewById(R.id.linearlayout3);
        t1 = findViewById(R.id.speed);
        t2 = findViewById(R.id.result);
        t3 = findViewById(R.id.time);
        t4 = findViewById(R.id.edittext1);
        t5 = findViewById(R.id.edittext2);
        t6 = findViewById(R.id.TextView);
        t7 = findViewById(R.id.formula);

        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);

        fth = new SimpleDateFormat("KK");
        ftm = new SimpleDateFormat("mm");
        fts = new SimpleDateFormat("ss");
        ft = new SimpleDateFormat("KK:mm:ss");





        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l1.setVisibility(View.INVISIBLE);
                l2.setVisibility(View.VISIBLE);
            }});

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l2.setVisibility(View.INVISIBLE);
                l3.setVisibility(View.VISIBLE);
            }});
        b7.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                if (t4.getText().toString().equals("")){
                    Toast.makeText( MainActivity.this,
                            "Enter the speed.",Toast.LENGTH_SHORT).show();
                }else if (t5.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,
                            "Enter the lorentz factor.",Toast.LENGTH_SHORT).show();
                }else if (t4.getText().toString().equals("") && t5.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,
                            "Enter the values",Toast.LENGTH_SHORT).show();
                }else if (!t4.getText().toString().equals("") && !t5.getText().toString().equals("")){
                    s1 = Double.parseDouble(t4.getText().toString());
                    l_2 = Double.parseDouble(t5.getText().toString());


                    if (s1!=c) {
                        l_1 = 1 / Math.sqrt(1 - ((s1 * s1) / (c * c)));
                        l_1 = new Double(Double.valueOf((new DecimalFormat("#.############")).format(l_1)));


                        if (s1 < c && l_1 == l_2) {


                            t6.setVisibility(View.VISIBLE);
                            t6.setText(" Hurray...!!Entered lorentz factor is correct");
                            l3.setBackgroundColor(Color.GREEN);
                        } else if (s1 < c && l_1 != l_2) {

                            t6.setVisibility(View.VISIBLE);
                            t6.setText("The entered Lorentz factor value is incorrect" + "\n" +
                                    "The correct lorentz factor value for given speed is: " + l_1);
                            l3.setBackgroundColor(Color.RED);
                            vibrator.vibrate(500);

                        } else {
                           Toast.makeText(MainActivity.this,
                                   "Error in entering values..!",Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this,
                                "Invalid Input.",Toast.LENGTH_SHORT).show();
                    }
                }else if (t4.getText().toString().equals("") && !t5.getText().toString().equals("")){
                   Toast.makeText(MainActivity.this,
                           "Enter speed.",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,
                            "Error in inputing values.",Toast.LENGTH_SHORT).show();
                }


            }
        });
        b8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                t4.setText("");
                t5.setText("");
                l3.setBackgroundColor(Color.parseColor("#4fc3f7"));
                t6.setText("");

            }
        });


        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l2.setVisibility(View.INVISIBLE);
                l1.setVisibility(View.VISIBLE);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l3.setVisibility(View.INVISIBLE);
                l2.setVisibility(View.VISIBLE);
            }
        });

          b3.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {


                  if (!t1.getText().toString().equals("")){
                      speed = Double.parseDouble(t1.getText().toString());


                      if (speed<c){
                          lorentz_factor = 1/Math.sqrt(1-((speed*speed)/(c*c)));
                          lorentz_factor = new Double(Double.valueOf((new DecimalFormat("#.############")).format(lorentz_factor)));
                          t2.setText("Lorentz factor= "+lorentz_factor);
                      } else{
                          Toast.makeText(MainActivity.this,
                                  "Error in entering speed!",Toast.LENGTH_SHORT).show();
                      }
                  }else{
                      Toast.makeText(MainActivity.this,
                              "Enter the speed.",Toast.LENGTH_SHORT).show();
                  }

              }});
          b2.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  t3.setVisibility(View.VISIBLE);
                  b10.setVisibility(View.VISIBLE);
                  t7.setVisibility(View.VISIBLE);
                  thread = new Thread(){
                      @Override
                      public void run(){
                          while (!isInterrupted()){
                              try {
                                  Thread.sleep(1);
                                  runOnUiThread(new Runnable() {
                                      @Override
                                      public void run() {
                                          calendar = Calendar.getInstance();
                                          h = Double.parseDouble(fth.format(calendar.getTime()));
                                          m = Double.parseDouble(ftm.format(calendar.getTime()));
                                          s = Double.parseDouble(fts.format(calendar.getTime()));
                                          n = ft.format(calendar.getTime());
                                          double f = 1;
                                          for (int i=1;i<=h;i++){
                                              f = f*i;
                                          }
                                          k = f/((m*m*m)+s);
                                          t3.setText("Time: "+ n);
                                          t7.setText("Spi factor: "+ String.format("%.12f",k));


                                      }
                                  });
                              }catch (InterruptedException e){
                                  e.printStackTrace();
                              }
                          }
                      }
                  };
                  thread.start();


              }
          });
          b9.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  t1.setText("");
                  t2.setText("");
                  l3.setBackgroundColor(Color.parseColor("#4fc3f7"));
              }
          });
          b10.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  t3.setVisibility(View.INVISIBLE);
                  t7.setVisibility(View.INVISIBLE);
                  b10.setVisibility(View.INVISIBLE);
              }
          });
    }




}
















