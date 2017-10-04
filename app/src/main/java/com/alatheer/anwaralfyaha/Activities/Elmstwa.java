package com.alatheer.anwaralfyaha.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;
import com.alatheer.anwaralfyaha.Adapters.AdapterExam;
import com.alatheer.anwaralfyaha.R;
import com.alatheer.anwaralfyaha.dataProccess.Connector;
import com.alatheer.anwaralfyaha.dataProccess.DataEncap;
import com.alatheer.anwaralfyaha.dataProccess.JsonParser;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static com.alatheer.anwaralfyaha.Activities.Home.n;


public class Elmstwa extends AppCompatActivity {
    final static String api = "http://anwaralfyaha.com/api/exams";
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
           // Toast.makeText(this, exame, Toast.LENGTH_SHORT).show();

//        if (exame.equals("")){
//            Toast.makeText(this, "mmmmmmmmmmmmmm", Toast.LENGTH_SHORT).show();
//        }else {
//            Toast.makeText(this, exame, Toast.LENGTH_SHORT).show();}
            recyclerMain();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
      //  if (exam_degree.equals("")){
         //   if (Locale.getDefault().getLanguage().equals("en")) {
          //      Toast.makeText(this, "no degree", Toast.LENGTH_SHORT).show();

          //  } else {
            //    Toast.makeText(this, "لم يقيم بعد  ", Toast.LENGTH_SHORT).show();


          //  }
       // }else {

     //   }
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

