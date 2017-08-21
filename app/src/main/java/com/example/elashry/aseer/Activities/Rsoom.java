package com.example.elashry.aseer.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elashry.aseer.Adapters.AdapterPayment;
import com.example.elashry.aseer.R;
import com.example.elashry.aseer.dataProccess.Connector;
import com.example.elashry.aseer.dataProccess.DataModel;
import com.example.elashry.aseer.dataProccess.JsonParser;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static com.example.elashry.aseer.Activities.Home.n;
import static com.example.elashry.aseer.dataProccess.JsonParser.firstpaid;
import static com.example.elashry.aseer.dataProccess.JsonParser.firstpay;
import static com.example.elashry.aseer.dataProccess.JsonParser.secondpaid;
import static com.example.elashry.aseer.dataProccess.JsonParser.secondpay;

public class Rsoom extends AppCompatActivity {
    final static String api = "http://anwaralfyaha.com/api/payment";
    JsonParser parser = new JsonParser();
    private RecyclerView recyclerView;
    private AdapterPayment adapter;
    TextView t ,pay,paid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsoom);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        t= (TextView) findViewById(R.id.name);
        pay= (TextView) findViewById(R.id.tpay);
        paid= (TextView) findViewById(R.id.tpaid);
        t.setText(n);


//        if (s.isEmpty()){
//            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
//
//        }


            Connector connector = new Connector();

        try {

            ArrayList<DataModel> arrayList = parser.JsonProcesspay(connector.execute(api).get());
            pay.setText(firstpay +secondpay+"");
            paid.setText(firstpaid+secondpaid+"");

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

        adapter = new AdapterPayment(parser.getmlist(), getApplicationContext(), this);

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
