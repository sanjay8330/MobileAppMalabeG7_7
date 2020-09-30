package com.example.project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SalaryManage extends AppCompatActivity {

    EditText gid,bSal,bRate,NOT,totSal;
    Button btn;
    double totsal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_manage);

        btn = findViewById(R.id.salCalBut);

        gid = (EditText) findViewById(R.id.salRegNo);
        bSal = (EditText) findViewById(R.id.salBasSal);
        bRate = (EditText) findViewById(R.id.salBonRate);
        NOT = (EditText) findViewById(R.id.salNoOfT);
        totSal = (EditText) findViewById(R.id.TotSal);

    }

    @Override
    protected void onResume() {
        super.onResume();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                totsal = calctotsalary(Double.parseDouble(bSal.getText().toString()),Double.parseDouble(bRate.getText().toString()),Integer.parseInt(NOT.getText().toString()));
                totSal.setText(String.valueOf(totsal));

            }
        });

    }

    public double calctotsalary(double bassal, double rate, int trips){

        double initialsal;

        initialsal = bassal + (bassal*(rate/100));

        if(trips >=100 && trips<200){
            initialsal+=1000;
        }if(trips>=200){
            initialsal+=1500;
        }

        return initialsal;

    }


}