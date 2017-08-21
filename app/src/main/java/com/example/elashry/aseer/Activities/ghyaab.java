package com.example.elashry.aseer.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.example.elashry.aseer.Adapters.AdapterAbsent;
import com.example.elashry.aseer.R;
import com.example.elashry.aseer.dataProccess.Connector;
import com.example.elashry.aseer.dataProccess.DataEncap;
import com.example.elashry.aseer.dataProccess.JsonParser;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

import static com.example.elashry.aseer.Adapters.AdapterAbsent.s;
import static com.example.elashry.aseer.dataProccess.DataEncap.attstatue;
import static com.example.elashry.aseer.dataProccess.JsonParser.state;

public class ghyaab extends AppCompatActivity {
    final static String api = "http://anwaralfyaha.com/api/attendance";
    JsonParser parser = new JsonParser();
    private RecyclerView recyclerView;
    private AdapterAbsent adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghyaab);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Connector connector = new Connector();

        try {

            ArrayList<DataEncap> arrayList = parser.JsonProcessAbsent(connector.execute(api).get());
            //   Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
         //      Toast.makeText(this, attstatue, Toast.LENGTH_SHORT).show();

//            if (attstatue.equals("")) {
//               // if (Locale.getDefault().getLanguage().equals("en")) {
//                    Toast.makeText(this, "no absent for this student", Toast.LENGTH_SHORT).show();
//
//               // } else {
//                    Toast.makeText(this, "لا يوجد لهذا الطالب غياب", Toast.LENGTH_SHORT).show();
//
//
//               //a }
//            }  else {

                recyclerMain();

           // }
            } catch(InterruptedException e){
                e.printStackTrace();
            } catch(ExecutionException e){
                e.printStackTrace();
            }

    }
    private void recyclerMain() {

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AdapterAbsent(parser.getlist(), getApplicationContext(), this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        adapter.notifyDataSetChanged();

    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}

