package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    Button btn;
    Button upd;
    Button del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn = findViewById(R.id.buttonadd);
        upd = findViewById(R.id.button14);
        del = findViewById(R.id.button15);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                        startActivity(intent);
                    }
                });

        upd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity2.this,MainActivity4.class);
                        startActivity(intent);
                    }
                });

        del.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity2.this,MainActivity5.class);
                        startActivity(intent);
                    }
                });


    }
}