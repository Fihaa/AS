package com.example.elashry.aseer.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.example.elashry.aseer.Adapters.AdapterPayment;
import com.example.elashry.aseer.Adapters.AdapterSchool;
import com.example.elashry.aseer.Adapters.AdapterSharf;
import com.example.elashry.aseer.Models.ListRecycle;
import com.example.elashry.aseer.R;
import com.example.elashry.aseer.Adapters.RecycleAdapter;
import com.example.elashry.aseer.dataProccess.Connector;
import com.example.elashry.aseer.dataProccess.DataEncap;
import com.example.elashry.aseer.dataProccess.DataModel;
import com.example.elashry.aseer.dataProccess.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;



public class School extends AppCompatActivity {
    final static String api = "http://anwaralfyaha.com/api/schools";
    JsonParser parser = new JsonParser();
    private RecyclerView recyclerView;
    private AdapterSchool adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

//        Connector connector = new Connector();
//
//        try {
//
//            ArrayList<DataEncap> arrayList = parser.JsonProcessschool(connector.execute(api).get());
//            Toast.makeText(this,arrayList.toString(), Toast.LENGTH_SHORT).show();
//
//            recyclerMain();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

    }
//    private void recyclerMain() {
//
//        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(layoutManager);
//
//        adapter = new AdapterSchool(parser.getlist(), getApplicationContext(), this);
//
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
//        adapter.notifyDataSetChanged();
//
//
//    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}

