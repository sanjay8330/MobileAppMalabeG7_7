package com.example.madproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class cardRet extends AppCompatActivity {
    TextView a;
    TextView b;
    TextView c;
    TextView d;
    TextView e;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_ret);

        a=(TextView) findViewById(R.id.cardNumR);
        b=(TextView) findViewById(R.id.seqNumR);
        c=(TextView) findViewById(R.id.exDateR);
        d=(TextView) findViewById(R.id.crdNameR);
        e=(TextView) findViewById(R.id.phnNumR);

        reff= FirebaseDatabase.getInstance().getReference().child("CardPay").child("1");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String cardN =dataSnapshot.child("cardNum").getValue().toString();
                String cardNam =dataSnapshot.child("crdName").getValue().toString();
                String exDa =dataSnapshot.child("exDate").getValue().toString();
                String phnNu =dataSnapshot.child("phnNum").getValue().toString();
                String seqNu =dataSnapshot.child("seqNum").getValue().toString();
                a.setText(cardN);
                b.setText(seqNu);
                c.setText(exDa);
                d.setText(cardNam);
                e.setText(phnNu);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });


    }
}