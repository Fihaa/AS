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
import android.os.Handler;
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
import java.util.Locale;

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
    public static String school;
    public static String namesc,phonesc,emailsc;
    public static double latitudesc,longitudesc;

    public  static boolean log=true;
    View view;
    ProgressDialog progressDialog;
    private SharedPreferences spref,login_spref,usref,loginuserpref,prref,loginparentpref;


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

            loginuserpref = getSharedPreferences("loginusref",MODE_PRIVATE);
            boolean save_user_data = loginuserpref.getBoolean("save_user",false);
            if (save_user_data==true)
            {
                Intent intent = new Intent(Login.this, Home.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                SharedPreferences spref = getSharedPreferences("loginspref",MODE_PRIVATE);

                Toast.makeText(this, spref.getString("student_id",""), Toast.LENGTH_SHORT).show();
                Toast.makeText(this, spref.getString("student_name",""), Toast.LENGTH_SHORT).show();
                intent.putExtra("s",spref.getString("student_id","")) ;
                intent.putExtra("n",spref.getString("student_name",""));
                startActivity(intent);


            }

            usref = getSharedPreferences("SaveUserData",MODE_PRIVATE);

        }else if (y.equals("2")){
            login_spref = getSharedPreferences("loginspref",MODE_PRIVATE);
            boolean save_data = login_spref.getBoolean("save_student",false);
            if (save_data==true)
            {
                log=true;
                Intent intent = new Intent(Login.this, Home.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                SharedPreferences spref = getSharedPreferences("loginspref",MODE_PRIVATE);

                //Toast.makeText(this, spref.getString("student_id",""), Toast.LENGTH_SHORT).show();
               // Toast.makeText(this, spref.getString("student_name",""), Toast.LENGTH_SHORT).show();
                intent.putExtra("s",spref.getString("student_id","")) ;
                intent.putExtra("n",spref.getString("student_name",""));
                startActivity(intent);


            }

            spref = getSharedPreferences("SaveManagerData",MODE_PRIVATE);
            edtpass.setVisibility(View.GONE);
            view.setVisibility(View.GONE);
            edt1.setVisibility(View.GONE);
            edtn.setVisibility(View.VISIBLE);

        }else{
            edtpass.setVisibility(View.GONE);
            view.setVisibility(View.GONE);
            edt1.setVisibility(View.GONE);
            edtn.setVisibility(View.VISIBLE);
            loginparentpref = getSharedPreferences("loginprref",MODE_PRIVATE);
            boolean save_parent_data = loginparentpref.getBoolean("save_parent",false);
            if (save_parent_data==true)
            {
                Intent intent = new Intent(Login.this, Home.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                SharedPreferences spref = getSharedPreferences("loginspref",MODE_PRIVATE);

                //Toast.makeText(this, spref.getString("student_id",""), Toast.LENGTH_SHORT).show();
                // Toast.makeText(this, spref.getString("student_name",""), Toast.LENGTH_SHORT).show();
                intent.putExtra("s",spref.getString("student_id","")) ;
                intent.putExtra("n",spref.getString("student_name",""));
                startActivity(intent);


            }

            prref = getSharedPreferences("SaveParentData",MODE_PRIVATE);

        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                spref = getSharedPreferences("SaveManagerData",MODE_PRIVATE);
                usref = getSharedPreferences("SaveUserData",MODE_PRIVATE);
                prref = getSharedPreferences("SaveParentData",MODE_PRIVATE);

                final String id = edtn.getText().toString();
                final String email = edt1.getText().toString();

                final String pass = convertPassMd5(edtpass.getText().toString());

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
                                            school=object.get("school_id_fk").toString();

                                            if (id.toString().equals(object.get("student_national_id").toString()))
                                            {
                                                list.add(object);


                                                break;

                                            }

                                        }
                                        if (list.size()>0)
                                        {
String x=object.get("student_id_pk").toString();
                                            // MY_PREFS_NAME - a static String variable like:
                                            createShared("loginspref",x,object.get("student_name").toString());
                                            Intent i=new Intent(Login.this,Home.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            i.putExtra("id",object.get("student_id_pk").toString());
                                            i.putExtra("name",object.get("student_name").toString());
                                            log=false;
//                                            Toast.makeText(Login.this, phonesc, Toast.LENGTH_SHORT).show();
//                                            showProgress(view);

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

                                            }

                                        }
                                        if (list.size()>0)
                                        {
                                            createparentShared("loginprref",object.get("parent_identity").toString());
                                            Intent ii=new Intent(Login.this,Home.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);                                                                        ii.putExtra("name",object.get("student_name").toString());
                                            ii.putExtra("id",object.get("student_id_pk").toString());
                                            startActivity(ii);
                                            log=false;
//                                            Toast.makeText(Login.this,object.get("student_name").toString() , Toast.LENGTH_SHORT).show();
                                        //    Toast.makeText(Login.this, "mohhhh", Toast.LENGTH_SHORT).show();
                                            createShared("loginspref",object.get("student_id").toString(),object.get("student_name").toString());


                                            //   Toast.makeText(Login.this,object.get("student_name").toString() , Toast.LENGTH_SHORT).show();
                                          //  Toast.makeText(Login.this,object.get("student_national_id").toString() , Toast.LENGTH_SHORT).show();
                                            sid=object.get("student_id_fk").toString();

                                            final JsonArrayRequest mrequest = new JsonArrayRequest(student_url,

                                                    new Response.Listener<JSONArray>() {
                                                        @Override
                                                        public void onResponse(JSONArray response) {
                                                            try {
                                                                JSONObject object = new JSONObject();
                                                                for (int index = 0; index < response.length(); index++) {
                                                                    object = response.getJSONObject(index);

                                                                    if (sid.equals(object.get("student_id_pk").toString())){
                                                                        school=object.get("school_id_fk").toString();

                                                                       /* createparentShared("loginprref",object.get("parent_identity").toString());
                                                                        Intent ii=new Intent(Login.this,Home.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);                                                                        ii.putExtra("name",object.get("student_name").toString());
                                                                        ii.putExtra("id",object.get("student_id_pk").toString());
//                                            Toast.makeText(Login.this,object.get("student_name").toString() , Toast.LENGTH_SHORT).show();
                                                                        showProgress(view);
                                                                        startActivity(ii);*/
//                                                                        Toast.makeText(Login.this,object.get("student_name").toString() , Toast.LENGTH_SHORT).show();
                                                                    }
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
                                            MyApp.getInstance().addToRequestQueue(mrequest, "jsonarray req");
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

                                            if (email.toString().equals(object.get("user_username").toString())&&object.get("user_pass").toString().equals(pass))
                                            {
                                                list.add(object);
//                                                pDialog.setMessage("جارى تسجيل الدخول ...");
//                                                pDialog.show();

                                                break;

                                            }

                                        }
                                        if (list.size()>0)
                                        {
                                            createuserShared("loginusref",object.get("user_username").toString(),object.get("user_pass").toString());
                                            Intent i=new Intent(Login.this,Home.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);                                            y="1";
                                            i.putExtra("y", y);
                                            showProgress(view);
log=false;
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

    private void createShared(String shared_name,String student_id,String student_name)
    {
        SharedPreferences spref = getSharedPreferences(shared_name,MODE_PRIVATE);
        SharedPreferences.Editor editor = spref.edit();
        editor.putBoolean("save_student",true);
        editor.putString("student_id",student_id);
        editor.putString("student_name",student_name);

        editor.apply();
        editor.commit();
    }
    private void createuserShared(String shared_name,String usern_name,String user_pass)
    {
        SharedPreferences usref = getSharedPreferences(shared_name,MODE_PRIVATE);
        SharedPreferences.Editor editor = usref.edit();
        editor.putBoolean("save_user",true);
        editor.putString("usern_name",usern_name);
        editor.putString("user_pass",user_pass);

        editor.apply();
        editor.commit();
    }

    private void createparentShared(String shared_name,String parent_id)
    {
        SharedPreferences prref = getSharedPreferences(shared_name,MODE_PRIVATE);
        SharedPreferences.Editor editor = prref.edit();
        editor.putBoolean("save_parent",true);
        editor.putString("parent_id",parent_id);
        editor.apply();
        editor.commit();
    }

//    @Override
//    public boolean onSupportNavigateUp(){
//        finish();
//        return true;
//    }

    public  void showProgress(View view) {
        final int THREE_SECONDS = 2*1000;
        final ProgressDialog dlg = new ProgressDialog(this);

        if (Locale.getDefault().getLanguage().equals("en")){
            dlg.setMessage("Looding ...");

        }else{

            dlg.setMessage("جارى التحميل ...");

        }        dlg.setCancelable(true);
        dlg.setProgress(0);
        dlg.show();

//        final int totalProgressTime = 100;
//        final Thread t = new Thread() {
//            @Override
//            public void run() {
//                int jumpTime = 0;
//
//                while(jumpTime < totalProgressTime) {
//                    try {
//                        sleep(200);
//                        jumpTime += 5;
//                        dlg.setProgress(jumpTime);
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        t.start();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                dlg.dismiss();
            }
        }, THREE_SECONDS);
    }
}

