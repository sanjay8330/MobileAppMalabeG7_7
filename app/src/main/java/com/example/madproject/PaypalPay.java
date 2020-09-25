package com.example.madproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;




public class PaypalPay extends AppCompatActivity {

    EditText Email;
    Button btnPal;
    DatabaseReference reff;
    FirebaseDatabase Database;
    int maxId=0;
    PayPal Pay;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paypal_pay);




        button = (Button) findViewById(R.id.btnView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaypalPay.this,EmailRet.class);
                startActivity(intent);
            }
        });

        Email = (EditText)findViewById(R.id.Email);
        btnPal = (Button)findViewById(R.id.btnPal);
        Pay = new PayPal();

        reff = Database.getInstance().getReference().child("PayPal");

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

        btnPal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Email.length()==0){
                    Email.setError("Enter Email");
                }
                else{
                    Toast.makeText(PaypalPay.this,  "Data insert success",Toast.LENGTH_LONG).show();
                }

                PayPal.setEmail(Email.getText().toString().trim());

                reff.child(String.valueOf(maxId+1)).setValue(Pay);
            }


        });

    }
    public void loadweb(View view){

        Intent intent= new Intent(this, WebAct.class);
        startActivity(intent);

        }



}