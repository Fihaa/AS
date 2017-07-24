package com.example.elashry.aseer.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.elashry.aseer.R;
import com.sa90.materialarcmenu.StateChangeListener;

public class Arcmenu extends AppCompatActivity {

    ImageView item1,item2,item3,item11,item22,item33;
public static String x;

    com.sa90.materialarcmenu.ArcMenu arcMenuAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arc_menu);
        item1=(ImageView)findViewById(R.id.fab_arc_menu_1) ;
        item2=(ImageView)findViewById(R.id.fab_arc_menu_2) ;
        item3=(ImageView)findViewById(R.id.fab_arc_menu_3) ;
        item11=(ImageView)findViewById(R.id.fab_arc_menu_11) ;
        item22=(ImageView)findViewById(R.id.fab_arc_menu_22) ;
        item33=(ImageView)findViewById(R.id.fab_arc_menu_33) ;

        arcMenuAndroid = (com.sa90.materialarcmenu.ArcMenu) findViewById(R.id.arcmenu_android_example_layout);
        arcMenuAndroid.setStateChangeListener(new StateChangeListener() {
            @Override
            public void onMenuOpened() {
                //TODO something when menu is opened

                item1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        x="1";
                        Intent i1 =new Intent(Arcmenu.this,MapsActivity.class);
                        i1.putExtra("x",x);
                        startActivity(i1);

                    }
                });

                item2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        x="2";
                        Intent i1 =new Intent(Arcmenu.this,MapsActivity.class);
                        i1.putExtra("x",x);
                        startActivity(i1);

                    }
                });

                item3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        x="3";
                        Intent i1 =new Intent(Arcmenu.this,MapsActivity.class);
                        i1.putExtra("x",x);                        startActivity(i1);

                    }
                });

                item11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        x="4";
                        Intent i1 =new Intent(Arcmenu.this,Home.class);
                        i1.putExtra("x",x);                        startActivity(i1);

                    }
                });

                item22.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        x="5";
                        Intent i1 =new Intent(Arcmenu.this,Home.class);
                        i1.putExtra("x",x);                        startActivity(i1);

                    }
                });

                item33.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        x="6";
                        Intent i1 =new Intent(Arcmenu.this,Home.class);
                        i1.putExtra("x",x);                        startActivity(i1);

                    }
                });






            }

            @Override
            public void onMenuClosed() {
                //TODO something when menu is closed
            }
        });




    }



}


