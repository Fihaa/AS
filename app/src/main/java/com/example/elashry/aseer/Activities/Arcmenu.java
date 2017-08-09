package com.example.elashry.aseer.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elashry.aseer.Adapters.AdapterSchool;
import com.example.elashry.aseer.R;
import com.example.elashry.aseer.dataProccess.Connector;
import com.example.elashry.aseer.dataProccess.DataEncap;
import com.example.elashry.aseer.dataProccess.JsonParser;
import com.sa90.materialarcmenu.StateChangeListener;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;



public class Arcmenu extends AppCompatActivity {

  public static   boolean x;
    ImageView item1,item2,item3,item11,item22,item33;
public static String i1,i2,i3,i11,i22,i33;;
    final static String api = "http://wefakhail.org/fihaa/api/schools";
    JsonParser parser = new JsonParser();
    private RecyclerView recyclerView;
    private AdapterSchool adapter;
    com.sa90.materialarcmenu.ArcMenu arcMenuAndroid;
    TextView name,phone ,address,email ,fax ,t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arc_menu);
        item1=(ImageView)findViewById(R.id.fab_arc_menu_1) ;

        item11=(ImageView)findViewById(R.id.fab_arc_menu_2) ;
        item22=(ImageView)findViewById(R.id.fab_arc_menu_3) ;
        item33=(ImageView)findViewById(R.id.fab_arc_menu_4) ;

        arcMenuAndroid = (com.sa90.materialarcmenu.ArcMenu) findViewById(R.id.arcmenu_android_example_layout);
        arcMenuAndroid.setStateChangeListener(new StateChangeListener() {
            @Override
            public void onMenuOpened() {
                //TODO something when menu is opened

                item1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        i11="3";
                        Intent i1 =new Intent(Arcmenu.this,PaySchool.class);
                        i1.putExtra("i1",i11);
                        startActivity(i1);
                        x=true;

                    }
                });





                item11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        i2="14";
                        Intent i1 =new Intent(Arcmenu.this,PaySchool.class);
                        i1.putExtra("i4",i2);
                        startActivity(i1);
                        x=true;

                    }
                });

                item22.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        i3="8";
                        Intent i1 =new Intent(Arcmenu.this,PaySchool.class);
                        i1.putExtra("i5",i3);
                        startActivity(i1);
                        x=true;

                    }
                });
                item33.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        i3="18";
                        Intent i1 =new Intent(Arcmenu.this,PaySchool.class);
                        i1.putExtra("i5",i3);
                        startActivity(i1);
                        x=true;

                    }
                });


            }

            @Override
            public void onMenuClosed() {
                //TODO something when menu is closed
            }
        });

        t1= (TextView) findViewById(R.id.t11);
        t2= (TextView) findViewById(R.id.t22);
        name= (TextView) findViewById(R.id.namesc);
        phone= (TextView) findViewById(R.id.phonesc);
        address= (TextView) findViewById(R.id.address);
        email= (TextView) findViewById(R.id.email);
        fax= (TextView) findViewById(R.id.fax);

        Connector connector = new Connector();

        try {

            ArrayList<DataEncap> arrayList = parser.JsonProcessschool(connector.execute(api).get());

//            name.setText(namesc);
//            phone.setText(phonesc);
//            address.setText(addressc);
//            email.setText(emailsc);
//            fax.setText(faxsc);
//            Toast.makeText(this, namesc, Toast.LENGTH_SHORT).show();

            recyclerMain();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
    private void recyclerMain() {

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AdapterSchool(parser.getlist(), getApplicationContext(), this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        adapter.notifyDataSetChanged();
    }



}


