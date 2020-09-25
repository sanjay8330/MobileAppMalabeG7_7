package com.example.demofirebasetorecycler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class addDataVeh extends AppCompatActivity {

    EditText vehNum,vehDate,vehModel,vehColor,vehManuYear,vehNic,vehUrl;
    Button submitVeh,backVeh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data_veh);

        vehNum=(EditText)findViewById(R.id.inVehNum);
        vehDate=(EditText)findViewById(R.id.inVeheDate);
        vehModel=(EditText)findViewById(R.id.inVehModel);
        vehColor=(EditText)findViewById(R.id.inVehColor);
        vehManuYear=(EditText)findViewById(R.id.inVehManu);
        vehNic=(EditText)findViewById(R.id.InNicVehOw);
        vehUrl=(EditText)findViewById(R.id.InVehImg);

        backVeh=(Button)findViewById(R.id.vehBack);

        backVeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),VehMan.class));
                finish();
            }
        });

        submitVeh=(Button)findViewById(R.id.vehIns);
        submitVeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processinsert();
            }
        });
    }

    private void processinsert(){

        Map<String,Object> map=new HashMap<>();
        map.put("vehNum",vehNum.getText().toString());
        map.put("vehDate",vehDate.getText().toString());
        map.put("vehModel",vehModel.getText().toString());
        map.put("vehColor",vehColor.getText().toString());
        map.put("vehManuYear",vehManuYear.getText().toString());
        map.put("vehNic",vehNic.getText().toString());
        map.put("vehUrl",vehUrl.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("vehicle").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        vehNum.setText("");
                        vehDate.setText("");
                        vehModel.setText("");
                        vehColor.setText("");
                        vehManuYear.setText("");
                        vehNic.setText("");
                        vehUrl.setText("");
                        Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Toast.makeText(getApplicationContext(),"Could not insert",Toast.LENGTH_LONG).show();
                    }
                });

    }
}