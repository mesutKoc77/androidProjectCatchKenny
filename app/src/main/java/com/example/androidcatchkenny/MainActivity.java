package com.example.androidcatchkenny;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

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

    ImageView[] imageViewArray;

    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //yukaridaki tum degislkenleri tabibi ki uygualama acildigimda initilaye edeiorum
        score=findViewById(R.id.textView3);
        time=findViewById(R.id.textView);
        sayi=0;
        imageView=findViewById(R.id.imageView);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);
        imageView5=findViewById(R.id.imageView5);
        imageView6=findViewById(R.id.imageView6);
        imageView7=findViewById(R.id.imageView7);
        imageView8=findViewById(R.id.imageView8);
        imageView9=findViewById(R.id.imageView9);

        imageViewArray=new ImageView[]{imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9};
        hideImages();


        //uygulama acilir acilmay hemen konometre baslasin.
        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                time.setText("Time : "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                time.setText("Time Off");
                handler.removeCallbacks(runnable);//artik calismayi durdur yani runnaable i durdur.
                for (ImageView image: imageViewArray){
                    image.setVisibility(View.INVISIBLE);
                }
                AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Restart?");
                alert.setMessage("Are you sure to restart Game?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //restart
                        restartGame();
                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                        Toast.makeText(MainActivity.this,"Game Over !",Toast.LENGTH_SHORT).show();

                    }
                });
                alert.show();

            }
        }.start();
    }
    public void increaseScore (View view){
            sayi++;
            score.setText("score : "+sayi);
    }

    public void hideImages(){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {

                for ( ImageView image :imageViewArray
                ) {
                    image.setVisibility(View.INVISIBLE);
                }

                Random random=new Random();
                int i=random.nextInt(9);
                imageViewArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,1000);

            }
        };
        handler.post(runnable);



    }

    public void restartGame() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

}