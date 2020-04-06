package com.example.image25022020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView mImg;
    Button mbtnNext,mbtnPrevious,mbtnRandom,mbtnAutonext,mtbAutoprevious;
    ArrayList<Integer> mArrayImageInteger;
    int mcount = 0;
    Random mrandom;
    int mIndexrandom=0;

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


    }
}
