package com.example.jwala.fundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;



public class Quiz extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary=new QuestionLibrary();

    private TextView mscoreview;
    private TextView mquestionview;
    private Button mbutton1;
    private Button mbutton2;
    private Button mbutton3,mbutton4,mbutton5;

    private String mAnswer;
    public static int mScore=0;
    public int mQuestionNumber=0;



    Random r;


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            Intent i=new Intent(Quiz.this,HomePage.class);
            startActivity(i);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mScore=0;

         final int p[];
        p = new int[QuestionLibrary.max()];

        mscoreview = (TextView) findViewById(R.id.score);
        mquestionview = (TextView) findViewById(R.id.question);
        mbutton1 = (Button) findViewById(R.id.choice1);
        mbutton2 = (Button) findViewById(R.id.choice2);
        mbutton3 = (Button) findViewById(R.id.choice3);
        mbutton4= (Button)findViewById(R.id.quit);
        mbutton5=(Button)findViewById(R.id.skip);

        r=new Random();

        updatequestion(p);


        mbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mbutton1.getText() == mAnswer) {
                    ++mScore;
                    Toast.makeText(Quiz.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    --mScore;
                    Toast.makeText(Quiz.this, "Wrong", Toast.LENGTH_SHORT).show();
                }
                updatescore(mScore);
             //   if (mQuestionNumber < QuestionLibrary.max()){
                updatequestion(p);
             /*   }
                else{
                    Intent i=new Intent(Quiz.this,QuitQuiz.class);
                    startActivity(i);
                    finish();
                }*/
            }
        });




        mbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
                if (mbutton2.getText() == mAnswer) {
                    ++mScore;
                    Toast.makeText(Quiz.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    --mScore;
                    Toast.makeText(Quiz.this, "Wrong", Toast.LENGTH_SHORT).show();
                }
                updatescore(mScore);
              //  if (mQuestionNumber < mQuestionLibrary.max()){
                updatequestion(p);
             /*   }
                else{
                    Intent i=new Intent(Quiz.this,QuitQuiz.class);
                    startActivity(i);
                    finish();
                }*/
            }
        });


        mbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
                if (mbutton3.getText() == mAnswer) {
                    ++mScore;
                    Toast.makeText(Quiz.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    --mScore;
                    Toast.makeText(Quiz.this, "Wrong", Toast.LENGTH_SHORT).show();
                }
                updatescore(mScore);
        //        if (mQuestionNumber < mQuestionLibrary.max()){
                updatequestion(p);
           /*     }
                else{
                    Intent i=new Intent(Quiz.this,QuitQuiz.class);
                    startActivity(i);
                    finish();
                }*/
            }
        });

        mbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Quiz.this,QuitQuiz.class);
                startActivity(i);
                finish();
            }
        });

        mbutton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatequestion(p);
           //     n++;
            }
        });

    }

    public static int maxscore(){
        return mScore;
    }

        private void updatescore(int point){
        mscoreview.setText(""+mScore);
    }
    int n=0;


    public void updatequestion(int p[]){
if (n<QuestionLibrary.max()) {



    mQuestionNumber = r.nextInt(QuestionLibrary.max());


    if (p[mQuestionNumber] == 0) {


        p[mQuestionNumber] = 1;

        mquestionview.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mbutton1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        mbutton2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        mbutton3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));

        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
        n++;
    } else {
        updatequestion(p);
    }
}
        else
{
    Intent i=new Intent(Quiz.this,QuitQuiz.class);
    startActivity(i);
    finish();
}



       // mQuestionNumber++;
    }


}
