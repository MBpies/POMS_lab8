package com.example.myfirstapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myfirstapp.R;
import com.example.myfirstapp.viewmodel.DataInterface;

public class dbActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        TextView tv = findViewById(R.id.db_out_textView);

        tv.setText(DataInterface.getAllAsString(getBaseContext()));
    }
}