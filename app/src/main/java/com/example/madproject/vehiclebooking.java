package com.example.madproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class vehiclebooking extends AppCompatActivity {


    Spinner Vtype,Vseats,Milage;

    Button btnBook;
    DatabaseReference reff;
    FirebaseDatabase Database;
    booking book;
    int maxId=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehiclebooking);

        Spinner guidSpinner1 = (Spinner) findViewById(R.id.Vtype);
        ArrayAdapter<String> gAdapter = new ArrayAdapter<String>(vehiclebooking.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.vType));
        gAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        guidSpinner1.setAdapter(gAdapter);

        Spinner guidSpinner2 = (Spinner) findViewById(R.id.Vseats);
        ArrayAdapter<String> gAdapter1 = new ArrayAdapter<String>(vehiclebooking.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.vType1));
        gAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        guidSpinner2.setAdapter(gAdapter1);

        Spinner guidSpinner3 = (Spinner) findViewById(R.id.Milage);
        ArrayAdapter<String> gAdapter2 = new ArrayAdapter<String>(vehiclebooking.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.vType2));
        gAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        guidSpinner3.setAdapter(gAdapter2);



        Vtype = (Spinner)findViewById(R.id.Vtype);
        Vseats = (Spinner)findViewById(R.id.Vseats);
        Milage = (Spinner)findViewById(R.id.Milage);
        btnBook = (Button)findViewById(R.id.btnCardPay);
        book = new booking();

        reff = Database.getInstance().getReference().child("booking");


        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()) {
                    maxId = (int)dataSnapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Vseat=Integer.parseInt(Vseats.getSelectedItem().toString().trim());
                book.setVseats(Vseat);
                book.setMilage(Milage.getSelectedItem().toString().trim());
                book.setVtype(Vtype.getSelectedItem().toString().trim());

                Toast.makeText(vehiclebooking.this,  "Data insert success",Toast.LENGTH_LONG).show();
                reff.child(String.valueOf(maxId+1)).setValue(book);
            }
        });



    }

}