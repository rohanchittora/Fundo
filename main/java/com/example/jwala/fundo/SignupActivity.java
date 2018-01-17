package com.example.jwala.fundo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    EditText e1,e2,e3;
    Button b1;
    String s1,s2,s3;
    TextView t1;


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            Intent i=new Intent(SignupActivity.this,MainActivity.class);
            startActivity(i);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        e1=(EditText)findViewById(R.id.email);
        e2=(EditText)findViewById(R.id.username2);
        e3=(EditText)findViewById(R.id.password2);

        b1=(Button)findViewById(R.id.signupButton2);

        t1=(TextView)findViewById(R.id.textView);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(SignupActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();

                if (s1.equals("")||s2.equals("")||s3.equals(""))
                    Toast.makeText(SignupActivity.this,"Fill all credentials!",Toast.LENGTH_SHORT).show();
                else{
                    SQLiteDatabase data=openOrCreateDatabase("New",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists camp( email varchar, name varchar, password varchar)");
                    String s4="select * from camp where  email='"+s1+"'and name='"+s2+"'and password='"+s3+"'";
                    Cursor cursor=data.rawQuery(s4,null);
                    if (cursor.getCount()>0){
                        Toast.makeText(SignupActivity.this,"User already exists",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        data.execSQL("insert into camp values('"+s1+"','"+s2+"','"+s3+"')");
                        Toast.makeText(SignupActivity.this,"Signup successfull!",Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(SignupActivity.this,HomePage.class);
                        startActivity(i);
                        finish();
                    }
                }
            }
        });



    }
}
