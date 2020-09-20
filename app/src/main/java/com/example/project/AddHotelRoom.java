package com.example.project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddHotelRoom extends AppCompatActivity {

    ViewFlipper view_flipper;
    CheckBox chk1,chk2,chk3,chk4,chk5;
    EditText price,descrip,locat;
    Button add;
    DatabaseReference dbref;
    RoomModel room;
    int maxvalue = 001;
    //String roomID = "RM000";

    public void clearFields(){
        price.setText("");
        descrip.setText("");
        locat.setText("");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hotel_room);

        view_flipper = findViewById(R.id.v_flipper);
        int images[] = {R.drawable.ht1,R.drawable.ht2,R.drawable.ht3};
        for(int image:images){
            flipImages(image);
        }
        add = findViewById(R.id.add);

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

        //j = i;
        room = new RoomModel();

        dbref = FirebaseDatabase.getInstance().getReference().child("Rooms");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                maxvalue = Integer.parseInt(String.valueOf(dataSnapshot.getChildrenCount()));
                //roomID = String.valueOf(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
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

    @Override
    protected void onResume() {
        super.onResume();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbref = FirebaseDatabase.getInstance().getReference().child("Rooms");
                    try {
                        if (TextUtils.isEmpty(price.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "Enter the price", Toast.LENGTH_SHORT).show();
                        } else if (TextUtils.isEmpty(locat.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "Enter the Location", Toast.LENGTH_SHORT).show();
                        } else if (TextUtils.isEmpty(descrip.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "Enter the description", Toast.LENGTH_SHORT).show();
                        } else {
                            //Getting Inputs from the check Box
                            String result = " ";
                            if (chk1.isChecked()) {
                                result += "Free Wifi ,";
                            }
                            if (chk2.isChecked()) {
                                result += "Television ,";
                            }
                            if (chk3.isChecked()) {
                                result += "Air Conditioned ,";
                            }
                            if (chk4.isChecked()) {
                                result += "Shower ,";
                            }
                            if (chk5.isChecked()) {
                                result += "Tea-Maker ,";
                            }

                            //room.setId(Integer.parseInt(roomID)+1);
                            room.setId(maxvalue+1);
                            room.setFeatures(result.trim());
                            room.setPrice(price.getText().toString().trim());
                            room.setLocat(locat.getText().toString().trim());
                            room.setDescrip(descrip.getText().toString().trim());

                            dbref.child(String.valueOf(maxvalue+1)).setValue(room);
                            //dbref.child((roomID+1)).setValue(room);



                            Toast.makeText(getApplicationContext(), "Data added Successfully", Toast.LENGTH_SHORT).show();
                            clearFields();

                            //i++;
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }
}