package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.project.Database.DBHandler;

public class AddHotelRoom extends AppCompatActivity {

    ViewFlipper view_flipper;
    RadioGroup rg;
    CheckBox chk1,chk2,chk3,chk4,chk5;
    EditText price,descrip,locat;
    Button add;
    DBHandler db;
    Context cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hotel_room);

        view_flipper = findViewById(R.id.v_flipper);
        int images[] = {R.drawable.ht1,R.drawable.ht2,R.drawable.ht3};
        for(int image:images){
            flipImages(image);
        }

        cont = this;
        add = findViewById(R.id.button13);

        /*Radio Buton Input*/
        rg = (RadioGroup) findViewById(R.id.rg);


        /*String Value Inputs*/
        price = findViewById(R.id.txt1);
        descrip = findViewById(R.id.txt2);
        locat = findViewById(R.id.txt3);

        /*CheckBox Inputs*/
        chk1 = (CheckBox)findViewById(R.id.checkBox);
        chk2 = (CheckBox)findViewById(R.id.checkBox2);
        chk3 = (CheckBox)findViewById(R.id.checkBox3);
        chk4 = (CheckBox)findViewById(R.id.checkBox4);
        chk5 = (CheckBox)findViewById(R.id.checkBox5);
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

    public void addRoom(View view) {
        //Getting Inputs from the check Box
        String result =" ";
        if(chk1.isChecked()){
            result += "Free Wifi\n";
        }
        if(chk2.isChecked()){
            result += "Television\n";
        }
        if(chk3.isChecked()){
            result += "Air Conditioned\n";
        }
        if(chk4.isChecked()){
            result += "Shower\n";
        }
        if(chk5.isChecked()){
            result += "Tea-Maker";
        }

        //Radio Button
        String value = ((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();

        //String Values
        String pri = price.getText().toString();
        String des = descrip.getText().toString();
        String loc = locat.getText().toString();
        db = new DBHandler(this);
        long res = db.addRecord(value,result,loc,pri,des);

        if(res>0){
            Toast toast = Toast.makeText(getApplicationContext(),"Data Added Successfully!!!!",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}