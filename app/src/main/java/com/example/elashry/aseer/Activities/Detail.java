package com.example.elashry.aseer.Activities;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elashry.aseer.R;
import com.squareup.picasso.Picasso;

public class Detail extends AppCompatActivity {

    TextView desc, tilte ,date;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        desc = (TextView) findViewById(R.id.text_desc);
        tilte = (TextView) findViewById(R.id.text_title);
        date = (TextView) findViewById(R.id.date);
        imageView = (ImageView) findViewById(R.id.news_image);

        Intent intent = getIntent();

        desc.setText(intent.getStringExtra("desc"));
        tilte.setText(intent.getStringExtra("title"));
        date.setText(intent.getStringExtra("date"));
        Picasso.with(this).load("http://wefakhail.org/fihaa/uploads/thumbs/" +intent.getStringExtra("image")).into(imageView);

    }
}