package com.example.androidcatchkenny;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView score;
    TextView time;
    int sayi;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //yukaridaki tum degislkenleri tabibi ki uygualama acildigimda initilaye edeiorum
        score=findViewById(R.id.textView3);
        time=findViewById(R.id.textView);
        sayi=0;
        imageView=findViewById(R.id.imageView);
        imageView=findViewById(R.id.imageView2);
        imageView=findViewById(R.id.imageView3);
        imageView=findViewById(R.id.imageView4);
        imageView=findViewById(R.id.imageView5);
        imageView=findViewById(R.id.imageView6);
        imageView=findViewById(R.id.imageView7);
        imageView=findViewById(R.id.imageView8);
        imageView=findViewById(R.id.imageView9);

        //uygulama acilir acilmay hemen konometre baslasin.
        new CountDownTimer(15000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                time.setText("Time : "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }
    public void increaseScore (View view){
            sayi++;
            score.setText("score : "+sayi);
    }

}