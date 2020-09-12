package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class main_homepage extends AppCompatActivity {

    ViewFlipper view_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_homepage);

        view_flipper = findViewById(R.id.v_flipper);
        int images[] = {R.drawable.carbook,R.drawable.guidebook,R.drawable.hotelbook};
        for(int image:images){
            flipImages(image);
        }
    }

    public void flipImages(int image){
        ImageView imgview = new ImageView(this);
        imgview.setBackgroundResource(image);

        view_flipper.addView(imgview);
        view_flipper.setFlipInterval(4000);
        view_flipper.setAutoStart(true);

        view_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        view_flipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }
}