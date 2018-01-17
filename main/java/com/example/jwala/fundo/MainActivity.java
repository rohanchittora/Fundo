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

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b1;
    String s1,s2,s3;
    TextView t1;


  /*  @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            Intent i=new Intent(MainActivity.this,MainActivity.class);
            startActivity(i);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText)findViewById(R.id.username);
        e2=(EditText)findViewById(R.id.password);
      //  e3=(EditText)findViewById(R.id.password2);

        b1=(Button)findViewById(R.id.loginButton);

        t1=(TextView)findViewById(R.id.textView1);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this, SignupActivity.class);
                startActivity(i);
                finish();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
               // s3=e3.getText().toString();

                if (s1.equals("")||s2.equals(""))
                    Toast.makeText(MainActivity.this,"Fill all credentials!",Toast.LENGTH_SHORT).show();
                else{
                    SQLiteDatabase data=openOrCreateDatabase("New",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists camp(email varchar, name varchar, password varchar)");
                    String s4="select * from camp where  name='"+s1+"'and password='"+s2+"'";
                    Cursor cursor=data.rawQuery(s4,null);
                    if (cursor.getCount()>0){
                        Toast.makeText(MainActivity.this,"Logging you in",Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(MainActivity.this,HomePage.class);
                        startActivity(i);
                        finish();
                    }
                    else{
                     //   data.execSQL("insert into camp values('"+s1+"','"+s2+"')");
                        Toast.makeText(MainActivity.this,"Please Signup",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });



    }
}
