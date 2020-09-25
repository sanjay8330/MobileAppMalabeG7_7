package com.example.madproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EmailRet extends AppCompatActivity {
    TextView ab;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_ret);

        ab=(TextView) findViewById(R.id.emailRet);


                reff= FirebaseDatabase.getInstance().getReference().child("PayPal").child("1");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String Email =dataSnapshot.child("email").getValue().toString();
                        ab.setText(Email);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }

                });


    }
}