package com.example.jwala.fundo;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

public class SensorMediaplayer extends AppCompatActivity implements SensorEventListener {

    MediaPlayer mp;
    Sensor s;
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_mediaplayer);

        mp=  MediaPlayer.create(this, R.raw.desi);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);

        s=sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener((SensorEventListener) this,s,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent){
        if (sensorEvent.values[0]>4){
            mp.start();
        }
        else{
            mp.pause();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            mp.stop();
            Intent i=new Intent(SensorMediaplayer.this,HomePage.class);
            startActivity(i);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}