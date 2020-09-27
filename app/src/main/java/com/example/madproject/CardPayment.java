package com.example.madproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CardPayment extends AppCompatActivity {

    EditText CardNum,SeqNum,ExDate,phnNum,crdName;
    Button btnCardPay;
    DatabaseReference reff;
    FirebaseDatabase Database;
    int maxId=0;
    CardPay CPay;
    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_pay);

        CardNum = (EditText)findViewById(R.id.CardNum);
        SeqNum = (EditText)findViewById(R.id.SeqNum);
        ExDate = (EditText)findViewById(R.id.ExDate);
        phnNum = (EditText)findViewById(R.id.phnNum);
        crdName = (EditText)findViewById(R.id.crdName);
        btnCardPay = (Button)findViewById(R.id.btnCardPay);

        CPay = new CardPay();

        reff = Database.getInstance().getReference().child("CardPay");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()) {
                    maxId = (int)dataSnapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(CardPayment.this,  "Error Found",Toast.LENGTH_LONG).show();
            }
        });

        btnCardPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (SeqNum.length()==0){
                    SeqNum.setError("Enter CVV");
                }
                else if (ExDate.length()==0){
                    ExDate.setError("Enter Expire Date");
                }
                else if (phnNum.length()==0){
                    phnNum.setError("Enter Phone Number");
                }
                else if (crdName.length()==0){
                    crdName.setError("Enter Name On Card");
                }
                else{

                    Float CardNu = Float.parseFloat(CardNum.getText().toString().trim());
                    CPay.setCardNum(CardNu);
                    CPay.setSeqNum(SeqNum.getText().toString().trim());
                    CPay.setExDate(ExDate.getText().toString().trim());
                    CPay.setPhnNum(phnNum.getText().toString().trim());
                    CPay.setCrdName(crdName.getText().toString().trim());
                    reff.child(String.valueOf(maxId+1)).setValue(CPay);

                    Toast.makeText(CardPayment.this,  "Data Gone success",Toast.LENGTH_LONG).show();
                }

            }
        });
        button = (Button) findViewById(R.id.buttoncdret);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardPayment.this,cardRet.class);
                startActivity(intent);
            }
        });



    }
}