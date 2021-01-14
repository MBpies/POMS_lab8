package com.example.myfirstapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.myfirstapp.R;

public class ImageActivity extends AppCompatActivity {
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        image = findViewById(R.id.imageView);
    }
    public void rotate(View view){
        image.startAnimation(AnimationUtils.loadAnimation(this,R.anim.rotate_anim));
    }
    public void translate(View view){
        image.startAnimation(AnimationUtils.loadAnimation(this,R.anim.translate_anim));
    }
    public void scale(View view){
        image.startAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_anim));
    }
    public void alpha(View view){
        image.startAnimation(AnimationUtils.loadAnimation(this,R.anim.alpha_anim));
    }

}