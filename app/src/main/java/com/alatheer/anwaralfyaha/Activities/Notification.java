package com.alatheer.anwaralfyaha.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.alatheer.anwaralfyaha.Adapters.AdapterNotify;
import com.alatheer.anwaralfyaha.R;
import com.alatheer.anwaralfyaha.dataProccess.Connector;
import com.alatheer.anwaralfyaha.dataProccess.JsonParser;
import com.alatheer.anwaralfyaha.dataProccess.NotifyModel;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Notification extends AppCompatActivity {
    final static String api = "http://anwaralfyaha.com/api/invoices";
    JsonParser parser = new JsonParser();
    private RecyclerView recyclerView;
    private AdapterNotify adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Connector connector = new Connector();

        try {

            ArrayList<NotifyModel> arrayList = parser.JsonProcessNotify(connector.execute(api).get());


            recyclerMain();

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

        adapter = new AdapterNotify(parser.getnlist(), getApplicationContext(), this);

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

