package com.example.rich;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.richbox.EichText.RichEditer;

public class Main2Activity extends AppCompatActivity {
    private RichEditer richEditer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        richEditer=findViewById(R.id.richEditer);
        String context=getIntent().getStringExtra("context");
        richEditer.parseHtml(context);
    }
}
