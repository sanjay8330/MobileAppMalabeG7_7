package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditRooms extends AppCompatActivity {

    public String ID;
    TextView txt1;
    EditText edPrice,edlocat,eddescip;
    CheckBox chk1,chk2,chk3,chk4,chk5;
    Button btn1,btn2;
    RoomModel roomModel;

    Module module;
    DatabaseReference db,readdf,updateref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_rooms);

        db = FirebaseDatabase.getInstance().getReference().child("Rooms");
        Intent secIntent = getIntent();
        ID = secIntent.getStringExtra("RoomID");

        txt1 = findViewById(R.id.txt);
        btn1 = findViewById(R.id.btndelete);
        btn2 = findViewById(R.id.btnupdate);
        edPrice = findViewById(R.id.txtPrice);
        edlocat = findViewById(R.id.txtLocat);
        eddescip = findViewById(R.id.txtDes);

        chk1 = findViewById(R.id.checkBox15);//Free wifi
        chk2 = findViewById(R.id.checkBox16);//Air conditioned
        chk3 = findViewById(R.id.checkBox17);//Television
        chk4 = findViewById(R.id.checkBox18);//Shower
        chk5 = findViewById(R.id.checkBox19);//Tea maker

        txt1.setText(ID);
        final int childID = Integer.valueOf(ID.toString().trim());
        module = (Module)getApplicationContext();

        btn1.setOnClickListener(new View.OnClickListener() {

            String rmID = ID.toString().trim();
            @Override
            public void onClick(View view) {
                db.child("Rooms").child(rmID).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        db.child(rmID).removeValue();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                Toast.makeText(EditRooms.this, "Deleted Successfully!!!!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EditRooms.this,ViewRooms.class);
                startActivity(intent);
            }
        });

        String roomID = ID.toString().trim();
        //Read data and set to fields
        readdf = FirebaseDatabase.getInstance().getReference().child("Rooms").child(roomID);
        readdf.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String features = dataSnapshot.child("features").getValue().toString();

                if(features.contains("Free Wifi")){
                    chk1.setChecked(true);
                }if(features.contains("Air Conditioned")){
                    chk2.setChecked(true);
                }if(features.contains("Television")){
                    chk3.setChecked(true);
                }if(features.contains("Shower")){
                    chk4.setChecked(true);
                }if(features.contains("Tea-Maker")){
                    chk5.setChecked(true);
                }

                edPrice.setText(dataSnapshot.child("price").getValue().toString());
                edlocat.setText(dataSnapshot.child("locat").getValue().toString());
                eddescip.setText(dataSnapshot.child("descrip").getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //Update the value
        btn2.setOnClickListener(new View.OnClickListener() {

            String rmID2 = ID.toString().trim();
            String result = " ";
            @Override
            public void onClick(View view) {
                try {
                    if (TextUtils.isEmpty(edPrice.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Enter the price", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(edlocat.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Enter the Location", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(eddescip.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Enter the description", Toast.LENGTH_SHORT).show();
                    } else {
                        //Getting Inputs from the check Box
                        //String result = " ";
                        if (chk1.isChecked()) {
                            result += "Free Wifi ,";
                        }
                        if (chk2.isChecked()) {
                            result += "Air Conditioned ,";
                        }
                        if (chk3.isChecked()) {
                            result += "Television ,";
                        }
                        if (chk4.isChecked()) {
                            result += "Shower ,";
                        }
                        if (chk5.isChecked()) {
                            result += "Tea-Maker ,";
                        }

                        db.child("Rooms").child(rmID2).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                db = FirebaseDatabase.getInstance().getReference();
                                db.child("Rooms").child(rmID2).child("id").setValue(childID);
                                db.child("Rooms").child(rmID2).child("features").setValue(result.trim());
                                db.child("Rooms").child(rmID2).child("price").setValue(edPrice.getText().toString().trim());
                                db.child("Rooms").child(rmID2).child("locat").setValue(edlocat.getText().toString().trim());
                                db.child("Rooms").child(rmID2).child("descrip").setValue(eddescip.getText().toString().trim());
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                        Toast.makeText(EditRooms.this, "Data Updated Successfully!!!!!!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(EditRooms.this,ViewRooms.class);
                        startActivity(intent);
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Something went wrong"+e, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}