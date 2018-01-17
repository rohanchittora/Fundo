package com.example.jwala.fundo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class Mediaplayer extends AppCompatActivity {

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            Intent i=new Intent(Mediaplayer.this,HomePage.class);
            startActivity(i);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
    MediaPlayer mp;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediaplayer);

        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);

        mp=MediaPlayer.create(this,R.raw.desi);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
            }
        });

    }
}
