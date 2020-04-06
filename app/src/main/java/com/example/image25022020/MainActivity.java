package com.example.image25022020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView mImg;
    Button mbtnNext,mbtnPrevious,mbtnRandom,mbtnAutonext,mtbAutoprevious,mbtnpause;
    ArrayList<Integer> mArrayImageInteger;
    int mcount = 0;
    Random mrandom;
    int mIndexrandom=0;
    CountDownTimer mcountdowntimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImg = findViewById(R.id.imageview1);
        mbtnNext = findViewById(R.id.buttonnext);
        mbtnPrevious = findViewById(R.id.buttonprevious);
        mbtnRandom = findViewById(R.id.buttonRandom);
        mbtnAutonext = findViewById(R.id.buttonAutonext);
        mtbAutoprevious = findViewById(R.id.buttonautopreviuos);
        mbtnpause=findViewById(R.id.buttonpause);

        //Tạo mảng hình
        mArrayImageInteger = new ArrayList<>();
        mArrayImageInteger.add(R.drawable.hinh1);
        mArrayImageInteger.add(R.drawable.hinh2);
        mArrayImageInteger.add(R.drawable.hinh3);
        mArrayImageInteger.add(R.drawable.hinh4);
        mArrayImageInteger.add(R.drawable.hinh5);

        mbtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //c1:
                mcount = mcount >= mArrayImageInteger.size() -1 ? 0 : ++mcount;
                //mImg.setImageResource(mArrayImageInteger.get(count));
                //c2:
//                if (count >= mArrayImageInteger.size()-1){
//                    count=0;
//                }
                mImg.setImageResource(mArrayImageInteger.get(++mcount));
            }
        });
        mbtnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcount = mcount <=0? mArrayImageInteger.size() -1 : --mcount;
                mImg.setImageResource(mArrayImageInteger.get(mcount));

            }
        });

        mbtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mrandom = new Random();
                mIndexrandom = mrandom.nextInt(mArrayImageInteger.size());
                mcount = mIndexrandom;
                mImg.setImageResource(mArrayImageInteger.get(mIndexrandom));
            }
        });
        mbtnAutonext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcountdowntimer= new CountDownTimer(5000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        mcount = mcount >= mArrayImageInteger.size() -1 ? 0 : ++mcount;
                        mImg.setImageResource(mArrayImageInteger.get(mcount));

                    }

                    @Override
                    public void onFinish() {
                        mcountdowntimer.start();

                    }
                };
                mcountdowntimer.start();
            }
        });
        mtbAutoprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcountdowntimer=new CountDownTimer(5000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        mcount = mcount <=0? mArrayImageInteger.size() -1 : --mcount;
                        mImg.setImageResource(mArrayImageInteger.get(mcount));

                    }

                    @Override
                    public void onFinish() {
                        mcountdowntimer.start();

                    }
                };
                mcountdowntimer.start();
            }
        });
        mbtnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcountdowntimer.cancel();
            }
        });


    }
}
