package com.example.elashry.aseer.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.example.elashry.aseer.Adapters.AdapterAbsent;
import com.example.elashry.aseer.Adapters.AdapterNotify;
import com.example.elashry.aseer.R;
import com.example.elashry.aseer.dataProccess.Connector;
import com.example.elashry.aseer.dataProccess.DataEncap;
import com.example.elashry.aseer.dataProccess.JsonParser;
import com.example.elashry.aseer.dataProccess.NotifyModel;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

import static com.example.elashry.aseer.Adapters.AdapterAbsent.s;
import static com.example.elashry.aseer.dataProccess.DataEncap.attstatue;
import static com.example.elashry.aseer.dataProccess.JsonParser.state;

public class Notification extends AppCompatActivity {
    final static String api = "http://wefakhail.org/fihaa/api/invoices";
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

