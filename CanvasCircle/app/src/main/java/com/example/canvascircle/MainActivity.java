package com.example.canvascircle;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_main);
        setContentView(new Myview(this));
    }

    private class Myview extends View {
        public Myview(Context context) {
            super(context);
    }

        @Override
        protected void onDraw(@NonNull Canvas canvas) {
            super.onDraw(canvas);
        }
    }