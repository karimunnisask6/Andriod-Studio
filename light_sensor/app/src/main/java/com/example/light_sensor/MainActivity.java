package com.example.light_sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    TextView tv;
    WebView wv;
    SensorManager sensorManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tv=(TextView) findViewById(R.id.tv22);
        wv=(WebView) findViewById(R.id.w1);
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int changedvalue=(int) sensorEvent.values[0];
        tv.setText(" "+changedvalue);
        wv.loadUrl("https://api.thingspeak.com/update?api_key=L7W0HK97552H50RF&field1=" +changedvalue);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT));
    }
}