package com.example.myfirstapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myfirstapp.R;

public class textActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        Intent intent = getIntent();
        TextView tex = findViewById(R.id.textViewIntent);
        if(intent!=null){
            Uri uri = intent.getData();
            //String url = intent.getStringExtra(Intent.ACTION_VIEW);
            tex.setText(uri.toString());
        }

    }
}