package com.example.jwala.fundo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    ImageView cal,cam,quiz,game,media,sensor;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            Intent i=new Intent(HomePage.this,MainActivity.class);
            startActivity(i);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        cal=(ImageView)findViewById(R.id.calculator);
        cam=(ImageView)findViewById(R.id.camera);
        quiz=(ImageView)findViewById(R.id.quiz);
        game=(ImageView)findViewById(R.id.game);
        media=(ImageView)findViewById(R.id.media);
        sensor=(ImageView)findViewById(R.id.sensor);

        cal.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(HomePage.this,"Calculator",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HomePage.this,Calculator.class);
                startActivity(i);
                finish();
            }
        });


        cam.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(HomePage.this,"Camera",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HomePage.this,Camera.class);
                startActivity(i);
                finish();
            }
        });


        quiz.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(HomePage.this,"Quiz",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HomePage.this,Quiz.class);
                startActivity(i);
                finish();
            }
        });


        game.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(HomePage.this,"Rock Paper Scissor Game",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HomePage.this,Game.class);
                startActivity(i);
                finish();
            }
        });


        media.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(HomePage.this,"Mediaplayer",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HomePage.this,Mediaplayer.class);
                startActivity(i);
                finish();
            }
        });


        sensor.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(HomePage.this,"Light Sensor",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HomePage.this,SensorMediaplayer.class);
                startActivity(i);
                finish();
            }
        });

    }
}
