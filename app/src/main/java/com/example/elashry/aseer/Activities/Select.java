package com.example.elashry.aseer.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.elashry.aseer.R;

import java.util.Locale;

public class Select extends AppCompatActivity {
    ImageView user,student,parent;

    public boolean isFirstStart;
    Context mcontext;
    public static String y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Locale.getDefault().getLanguage().equals("en")) {
            setContentView(R.layout.eselect);

        } else {
            setContentView(R.layout.select);


        }
        user= (ImageView) findViewById(R.id.loginuserId);
        student= (ImageView) findViewById(R.id.loginstudent);
        parent= (ImageView) findViewById(R.id.loginparent);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //  Intro App Initialize SharedPreferences
                SharedPreferences getSharedPreferences = PreferenceManager
                        .getDefaultSharedPreferences(getBaseContext());

                //  Create a new boolean and preference and set it to true
                isFirstStart = getSharedPreferences.getBoolean("firstStart", true);

                //  Check either activity or app is open very first time or not and do action
                if (isFirstStart) {

                    //  Launch application introduction screen
                    Intent i = new Intent(Select.this, MyIntro.class);
                    startActivity(i);
                    SharedPreferences.Editor e = getSharedPreferences.edit();
                    e.putBoolean("firstStart", false);
                    e.apply();
                }
            }
        });
        t.start();


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
                y="4";
                // Click action
                Intent intent = new Intent(Select.this, Home.class);
                startActivity(intent);
            }
        });
    }
}
