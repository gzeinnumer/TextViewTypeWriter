package com.intishaka.textviewtypewriter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextViewTypeWriter textView = findViewById(R.id.tv);
        //Add a character every 150ms
        textView.setCharacterDelay(150);
        textView.animateText("Sample String");
    }
}