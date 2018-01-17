package com.example.jwala.fundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class Game extends AppCompatActivity {

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            Intent i=new Intent(Game.this,HomePage.class);
            startActivity(i);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    String myChoice,cpuChoice,result;


    ImageView iv_cpu,iv_me,rock,paper,scissors;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        iv_cpu=(ImageView)findViewById(R.id.iv_cpu);
        iv_me=(ImageView)findViewById(R.id.iv_me);

        rock=(ImageView)findViewById(R.id.rock);
        paper=(ImageView)findViewById(R.id.paper);
        scissors=(ImageView)findViewById(R.id.scissors);

        r=new Random();

        rock.setOnClickListener(
                new View.OnClickListener(){
            @Override
            public void onClick(View v){
                myChoice="rock";
                iv_me.setImageResource(R.drawable.rock);
                calculate();
            }
        });
        paper.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                myChoice="paper";
                iv_me.setImageResource(R.drawable.paper);
                calculate();
            }
        });
        scissors.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                myChoice="scissors";
                iv_me.setImageResource(R.drawable.scissors);
                calculate();
            }
        });
    }
    public void calculate(){
        int cpu=r.nextInt(3);
        if (cpu==0){
            cpuChoice="rock";
                    iv_cpu.setImageResource(R.drawable.rock);
        }
        else if (cpu==1){
            cpuChoice="paper";
            iv_cpu.setImageResource(R.drawable.paper);
        }
        else if (cpu==2){
            cpuChoice="scissors";
            iv_cpu.setImageResource(R.drawable.scissors);
        }

        if(myChoice.equals(cpuChoice)){
            result="draw";
        }
        else if (myChoice.equals("rock")&&cpuChoice.equals("paper")){
            result="you lose";
        }
        else if (myChoice.equals("rock")&&cpuChoice.equals("scissors")){
            result="you win";
        }
        else if (myChoice.equals("scissors")&&cpuChoice.equals("paper")){
            result="you win";
        }
        else if (myChoice.equals("scissors")&&cpuChoice.equals("rock")){
            result="you lose";
        }
        else if (myChoice.equals("paper")&&cpuChoice.equals("rock")){
            result="you win";
        }
        else if (myChoice.equals("paper")&&cpuChoice.equals("scissors")){
            result="you lose";
        }

        Toast.makeText(Game.this, result, Toast.LENGTH_SHORT).show();
    }
}
