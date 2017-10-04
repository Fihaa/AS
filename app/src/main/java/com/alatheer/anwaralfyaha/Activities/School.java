package com.alatheer.anwaralfyaha.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.alatheer.anwaralfyaha.Adapters.AdapterSchool;
import com.alatheer.anwaralfyaha.R;
import com.alatheer.anwaralfyaha.dataProccess.JsonParser;


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

