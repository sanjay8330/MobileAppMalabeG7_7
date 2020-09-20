package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    Button btn1;

    Module module;
    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_rooms);

        db = FirebaseDatabase.getInstance().getReference().child("Rooms");
        Intent secIntent = getIntent();
        ID = secIntent.getStringExtra("RoomID");

        txt1 = findViewById(R.id.txt);
        btn1 = findViewById(R.id.btndelete);

        txt1.setText(ID);

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
    }

    public void changeFragment(View view){

        Fragment fragment;

        if(view == findViewById(R.id.btnupdate)){

            fragment = new UpdateFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment,fragment);
            ft.commit();
        }else if(view == findViewById(R.id.btndelete)){
            fragment = new DeleteFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment,fragment);
            ft.commit();
        }
    }
}