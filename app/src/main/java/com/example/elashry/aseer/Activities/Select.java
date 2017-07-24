package com.example.elashry.aseer.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.elashry.aseer.R;

public class Select extends AppCompatActivity {
    ImageView user,student,parent;

    public static String y;
    public static boolean x=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select);

        user= (ImageView) findViewById(R.id.loginuserId);
        student= (ImageView) findViewById(R.id.loginstudent);
        parent= (ImageView) findViewById(R.id.loginparent);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                y="1";
                Intent i =new Intent(Select.this,Login.class);
                startActivity(i);

            }
        });
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y="2";
                Intent i =new Intent(Select.this,Login.class);
                startActivity(i);
            }
        });

        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y="3";
                Intent i =new Intent(Select.this,Login.class);
                startActivity(i);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               x=true;
                y="4";
                // Click action
                Intent intent = new Intent(Select.this, Home.class);
                startActivity(intent);
            }
        });
    }
}
