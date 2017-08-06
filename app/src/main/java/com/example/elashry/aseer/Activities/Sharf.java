package com.example.elashry.aseer.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.example.elashry.aseer.Adapters.AdapterPayment;
import com.example.elashry.aseer.Adapters.AdapterSharf;
import com.example.elashry.aseer.Models.ListRecycle;
import com.example.elashry.aseer.R;
import com.example.elashry.aseer.Adapters.RecycleAdapter;
import com.example.elashry.aseer.dataProccess.Connector;
import com.example.elashry.aseer.dataProccess.DataModel;
import com.example.elashry.aseer.dataProccess.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;



public class Sharf extends AppCompatActivity {
    final static String api = "http://wefakhail.org/fihaa/api/ownerboard";
    JsonParser parser = new JsonParser();
    private RecyclerView recyclerView;
    private AdapterSharf adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharf);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        Connector connector = new Connector();

        try {

            ArrayList<DataModel> arrayList = parser.JsonProcessSharf(connector.execute(api).get());
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

        adapter = new AdapterSharf(parser.getmlist(), getApplicationContext(), this);

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

