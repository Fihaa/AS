package com.example.elashry.aseer.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.example.elashry.aseer.Adapters.AdapterExam;
import com.example.elashry.aseer.Adapters.AdapterNews;
import com.example.elashry.aseer.R;
import com.example.elashry.aseer.dataProccess.Connector;
import com.example.elashry.aseer.dataProccess.DataEncap;
import com.example.elashry.aseer.dataProccess.JsonParser;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static com.example.elashry.aseer.Activities.Home.n;

public class Elmstwa extends AppCompatActivity {
    final static String api = "http://wefakhail.org/fihaa/api/exams";
    JsonParser parser = new JsonParser();
    private RecyclerView recyclerView;
    private AdapterExam adapter;
    DataEncap d=new DataEncap();
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elmstwa);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        name= (TextView) findViewById(R.id.txtname);
        name.setText(n);

        Connector connector = new Connector();

        try {

            ArrayList<DataEncap> arrayList = parser.JsonProcessexams(connector.execute(api).get());
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

        adapter = new AdapterExam(parser.getlist(), getApplicationContext(), this);

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

