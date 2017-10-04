package com.alatheer.anwaralfyaha.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.alatheer.anwaralfyaha.Adapters.AdapterSharf;
import com.alatheer.anwaralfyaha.R;
import com.alatheer.anwaralfyaha.dataProccess.Connector;
import com.alatheer.anwaralfyaha.dataProccess.DataModel;
import com.alatheer.anwaralfyaha.dataProccess.JsonParser;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;



public class Sharf extends AppCompatActivity {
    final static String api = "http://anwaralfyaha.com/api/ownerboard";
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

