package com.example.jwala.fundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.jwala.fundo.Quiz.maxscore;

public class QuitQuiz extends AppCompatActivity {

    TextView t;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quit_quiz);

        t=(TextView)findViewById(R.id.textView5);
        img=(ImageView)findViewById(R.id.retry);

        t.setText("" + Quiz.maxscore());

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(QuitQuiz.this,Quiz.class);
                startActivity(i);
                finish();
            }
        });

    }


}
