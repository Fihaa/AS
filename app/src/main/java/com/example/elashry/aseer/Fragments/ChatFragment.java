package com.example.elashry.aseer.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.elashry.aseer.Activities.Anshta;
import com.example.elashry.aseer.Activities.Arcmenu;
import com.example.elashry.aseer.Activities.Login;
import com.example.elashry.aseer.Adapters.AdapterTable;
import com.example.elashry.aseer.Adapters.adapterEvent;
import com.example.elashry.aseer.MyApp;
import com.example.elashry.aseer.R;
import com.example.elashry.aseer.dataProccess.Connector;
import com.example.elashry.aseer.dataProccess.DataEncap;
import com.example.elashry.aseer.dataProccess.DataModel;
import com.example.elashry.aseer.dataProccess.JsonParser;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import de.ailis.pherialize.MixedArray;
import de.ailis.pherialize.Pherialize;

import static com.example.elashry.aseer.Activities.Select.y;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment  {

    final static String api = "http://wefakhail.org/fihaa/api/events";
    JsonParser parser = new JsonParser();
    private RecyclerView recyclerView;
    private adapterEvent adapter;


    ImageView img1,img2;
    TextView title;
    public ChatFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calls, container, false);
        Connector connector = new Connector();

        try {

            ArrayList<DataModel> arrayList = parser.JsonProcessEvent(connector.execute(api).get());
            recyclerMain(view);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        return view;

    }
    private void recyclerMain(View v) {

      /*  recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new adapterEvent(parser.getmlist(), getContext(), (Anshta) getContext());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        adapter.notifyDataSetChanged();*/

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new adapterEvent(parser.getmlist(), getContext(), (Anshta) getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        adapter.notifyDataSetChanged();
       /* img1 = (ImageView) this.getActivity().findViewById(R.id.img1);
        img2 = (ImageView) this.getActivity().findViewById(R.id.img2);
        title = (TextView) this.getActivity().findViewById(R.id.tit);*/
       /* img1 = (ImageView) getActivity().findViewById(R.id.img1);
        img2 = (ImageView) getActivity().findViewById(R.id.img2);

        if (!TextUtils.isEmpty(id)&&y.equals("2")) {
            final List<JSONObject> list = new ArrayList<>();
            final JsonArrayRequest request = new JsonArrayRequest(api,

                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            try {
                                JSONObject object = new JSONObject();
                                for (int index = 0; index < response.length(); index++) {
                                    object = response.getJSONObject(index);
                                    if (id.toString().equals(object.get("student_national_id").toString()))
                                    {
                                        list.add(object);

                                        Toast.makeText(Login.this,"mmmmmmmm" , Toast.LENGTH_SHORT).show();

                                        break;

                                    }

                                }
                                if (list.size()>0)
                                {
                                    Toast.makeText(Login.this,object.get("student_id_pk").toString() , Toast.LENGTH_SHORT).show();

                                    Intent i=new Intent(Login.this,Arcmenu.class);
                                    i.putExtra("id",object.get("student_id_pk").toString());
                                    i.putExtra("name",object.get("student_name").toString());
                                    startActivity(i);
                                }
                                else

                                {
                                    Toast.makeText(Login.this,"this id not matched", Toast.LENGTH_SHORT).show();

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            MyApp.getInstance().addToRequestQueue(request, "jsonarray req");*/
    }

       /* MixedArray a = Pherialize.unserialize("a:2:{i:0;s:36:\"914cc8df6869c78731fbf47f3ff95c68.jpg\";i:1;s:36:\"1650ebae7f1b701df152240e70a4d161.jpg\";}").toArray();
        Toast.makeText(getContext(),a.getString(0)+"\n"+a.getString(1), Toast.LENGTH_SHORT).show();

        img1= (ImageView)getView().findViewById(R.id.img1);
        img2= (ImageView) getView().findViewById(R.id.img2);

        Picasso.with(getContext()).load("http://wefakhail.org/fihaa/uploads/thumbs/" +a.getString(0)).into(img1);

       Picasso.with(getContext()).load("http://wefakhail.org/fihaa/uploads/thumbs/" +a.getString(1)).into(img2);*/



     /*   Connector connector = new Connector();

        try {

            ArrayList<DataEncap> arrayList = parser.JsonProcesstable(connector.execute(api).get());
            recyclerMain();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
}
   /* @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    private void recyclerMain() {

        recyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new adapterEvent(parser.getmlist(), getContext(), (Anshta) getContext());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        adapter.notifyDataSetChanged();

    }
*/

