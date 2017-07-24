package com.example.elashry.aseer.Activities;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.elashry.aseer.MyApp;
import com.example.elashry.aseer.R;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import static com.example.elashry.aseer.Activities.Select.y;


public class Login extends AppCompatActivity {
    private final String student_url ="http://wefakhail.org/fihaa/api/students";
    private final String user_url ="http://wefakhail.org/fihaa/api/users";
    private final String parents_url ="http://wefakhail.org/fihaa/api/parents";

    private Effectstype effect;
    Button b1;
//    final static String api = "http://wefakhail.org/fihaa/api/students";
//    JsonParser parser = new JsonParser();
EditText edt1,edtn , edtpass;
    public static String sid;
    View view;
    ProgressDialog progressDialog;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    public static SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        b1= (Button) findViewById(R.id.loginBtn);
        edt1= (EditText) findViewById(R.id.login_emailid);
        edtn= (EditText) findViewById(R.id.login_emailidn);
        edtpass= (EditText) findViewById(R.id.login_password);
        view =findViewById(R.id.vpass);


        if (y.equals("1")){
            edtpass.setVisibility(View.VISIBLE);
            view.setVisibility(View.VISIBLE);
            edtn.setVisibility(View.GONE);
            edt1.setVisibility(View.VISIBLE);



        }else{
            edtpass.setVisibility(View.GONE);
            view.setVisibility(View.GONE);
            edt1.setVisibility(View.GONE);
            edtn.setVisibility(View.VISIBLE);

        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final String id = edtn.getText().toString();
                final String email = edt1.getText().toString();

                final String pass = convertPassMd5(edtpass.getText().toString());

                SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
                String restoredText = prefs.getString("text", null);
                if (restoredText != null) {
                    String idName = prefs.getString("idName",  "No name defined"); //0 is the default value.
                }
                if (isOnline()){

                if (!TextUtils.isEmpty(id)&&y.equals("2")) {
                    final List<JSONObject> list = new ArrayList<>();
                    final JsonArrayRequest request = new JsonArrayRequest(student_url,

                            new Response.Listener<JSONArray>() {
                                @Override
                                public void onResponse(JSONArray response) {
                                    try {
                                        JSONObject object = new JSONObject();
                                        for (int index = 0; index < response.length(); index++) {
                                            object = response.getJSONObject(index);

                                            sid=object.get("student_id_pk").toString();
                                            if (id.toString().equals(object.get("student_national_id").toString()))
                                            {
                                                list.add(object);


                                                break;

                                            }

                                        }
                                        if (list.size()>0)
                                        {

                                            // MY_PREFS_NAME - a static String variable like:
                                            editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                                            editor.putString("idName", "1149159053");
                                            editor.apply();
                                            Intent i=new Intent(Login.this,Home.class);
                                            i.putExtra("id",object.get("student_id_pk").toString());
                                            i.putExtra("name",object.get("student_name").toString());
                                        //    Toast.makeText(Login.this,object.get("student_id_pk").toString() , Toast.LENGTH_SHORT).show();
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
                    MyApp.getInstance().addToRequestQueue(request, "jsonarray req");
                }else if (!TextUtils.isEmpty(id)&&y.equals("3")){
                    final List<JSONObject> list = new ArrayList<>();
                    final JsonArrayRequest request = new JsonArrayRequest(parents_url,

                            new Response.Listener<JSONArray>() {
                                @Override
                                public void onResponse(JSONArray response) {
                                    try {
                                        JSONObject object = new JSONObject();
                                        for (int index = 0; index < response.length(); index++) {
                                            object = response.getJSONObject(index);
                                            if (id.toString().equals(object.get("parent_identity").toString()))
                                            {

                                                list.add(object);


                                                break;

                                            }else{

                                            }

                                        }
                                        if (list.size()>0)
                                        {
                                         //   Toast.makeText(Login.this,object.get("student_name").toString() , Toast.LENGTH_SHORT).show();
                                          //  Toast.makeText(Login.this,object.get("student_national_id").toString() , Toast.LENGTH_SHORT).show();

                                            Intent ii=new Intent(Login.this,Home.class);
                                            ii.putExtra("id",object.get("student_id_pk").toString());
//                                            Toast.makeText(Login.this,object.get("student_name").toString() , Toast.LENGTH_SHORT).show();
                                            startActivity(ii);
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
                    MyApp.getInstance().addToRequestQueue(request, "jsonarray req");
                }
                else
                    if(!TextUtils.isEmpty(email)&&!TextUtils.isEmpty(pass)&&y.equals("1")){
                    final List<JSONObject> list = new ArrayList<>();
                    final JsonArrayRequest request = new JsonArrayRequest(user_url,

                            new Response.Listener<JSONArray>() {
                                @Override
                                public void onResponse(JSONArray response) {
                                    try {
                                        JSONObject object = new JSONObject();
                                        for (int index = 0; index < response.length(); index++) {
                                            object = response.getJSONObject(index);
//                                            String pa= convertPassMd5(pass.toString());
//                                            Toast.makeText(Login.this,pa,Toast.LENGTH_LONG).show();

                                            if (email.toString().equals(object.get("user_email").toString())&&object.get("user_pass").toString().equals(pass))
                                            {
                                                list.add(object);
//                                                pDialog.setMessage("جارى تسجيل الدخول ...");
//                                                pDialog.show();

                                                break;

                                            }

                                        }
                                        if (list.size()>0)
                                        {
                                            Intent i=new Intent(Login.this,Home.class);                                                y="1";
                                            i.putExtra("y", y);

                                            startActivity(i);
                                        }
                                        else

                                        {      //  Toast.makeText(Login.this,pass,Toast.LENGTH_LONG).show();

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
                    MyApp.getInstance().addToRequestQueue(request, "jsonarray req");
                }
                }else {
                    try {
                        AlertDialog alertDialog = new AlertDialog.Builder(Login.this).create();

                        alertDialog.setTitle("Info");
                        alertDialog.setMessage("Internet not available, Cross check your internet connectivity and try again");
                        alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
                        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                finish();

                            }
                        });

                        alertDialog.show();
                    }
                    catch(Exception e)
                    {
                    }
                }
            }
        });


    }
    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            Toast.makeText(this, "No Internet connection!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    /**
     * This is method for convert the string value into MD5
     */
    public static String convertPassMd5(String pass) {

        String password = null;
        MessageDigest mdEnc;
        try {
            mdEnc = MessageDigest.getInstance("MD5");
            mdEnc.update(pass.getBytes(), 0, pass.length());
            pass = new BigInteger(1, mdEnc.digest()).toString(16);
            while (pass.length() < 32) {
                pass = "0" + pass;
            }
            password = pass;
        }
        catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
        return password;
    }


//    @Override
//    public boolean onSupportNavigateUp(){
//        finish();
//        return true;
//    }
}

