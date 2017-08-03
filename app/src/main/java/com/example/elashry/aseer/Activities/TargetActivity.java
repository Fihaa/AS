package com.example.elashry.aseer.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.elashry.aseer.R;

public class TargetActivity extends AppCompatActivity {
    Button Cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        Cancel =(Button) findViewById(R.id.button2);

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(TargetActivity.this,nafic.class);
                startActivity(in);
            }
        });
    }
}
