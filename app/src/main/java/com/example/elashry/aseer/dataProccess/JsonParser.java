package com.example.elashry.aseer.dataProccess;

import android.widget.Toast;

import com.example.elashry.aseer.Activities.Home;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.elashry.aseer.Activities.Home.s;


public class JsonParser {

    ArrayList<DataEncap> data;
    ArrayList<DataModel> mdata;

    public ArrayList<DataEncap> JsonProcess(String jsonFile) {

        data = new ArrayList<>();

        try {

            JSONArray jsonArray = new JSONArray(jsonFile);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject mainObjectArray = jsonArray.getJSONObject(i);

                DataEncap encap = new DataEncap(
                        mainObjectArray.getString(KeyTags.imgKey), mainObjectArray.getString(KeyTags.titleKey), mainObjectArray.getString(KeyTags.dateKey), mainObjectArray.getString(KeyTags.descKey));

                data.add(encap);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }
    public ArrayList<DataEncap> JsonProcesstable(String jsonFile) {

        data = new ArrayList<>();

        try {

            JSONArray jsonArray = new JSONArray(jsonFile);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject mainObjectArray = jsonArray.getJSONObject(i);

                DataEncap enca = new DataEncap(
                        mainObjectArray.getString(KeyTags.img_Key), mainObjectArray.getString(KeyTags.titKey));
               data.add(enca);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }
    public ArrayList<DataEncap> JsonProcesslogin(String jsonFile) {

        data = new ArrayList<>();

        try {

            JSONArray jsonArray = new JSONArray(jsonFile);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject mainObjectArray = jsonArray.getJSONObject(i);

                DataEncap encap = new DataEncap(
                        mainObjectArray.getString( mainObjectArray.getString(KeyTags.id)));
                data.add(encap);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }
    public ArrayList<DataEncap> JsonProcessexams(String jsonFile) {

        data = new ArrayList<>();

        try {

            JSONArray jsonArray = new JSONArray(jsonFile);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject mainObjectArray = jsonArray.getJSONObject(i);

                DataEncap enca = new DataEncap(
                        mainObjectArray.getString(KeyTags.sname),mainObjectArray.getString(KeyTags.exame), mainObjectArray.getString(KeyTags.subject),mainObjectArray.getString(KeyTags.month), mainObjectArray.getString(KeyTags.max),mainObjectArray.getString(KeyTags.min));
                data.add(enca);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }
    public ArrayList<DataModel> JsonProcesswork(String jsonFile) {

        mdata = new ArrayList<>();

        try {

            JSONArray jsonArray = new JSONArray(jsonFile);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject mainObjectArray = jsonArray.getJSONObject(i);

                DataModel enca = new DataModel(
                        mainObjectArray.getString(KeyTags.imgwork),mainObjectArray.getString(KeyTags.wid));
                mdata.add(enca);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mdata;
    }
    public ArrayList<DataModel> JsonProcesspay(String jsonFile) {

        mdata = new ArrayList<>();

        try {

            JSONArray jsonArray = new JSONArray(jsonFile);

            for (int i = 0; i < jsonArray.length(); i++) {


                JSONObject mainObjectArray = jsonArray.getJSONObject(i);
                if (s.equals(mainObjectArray.getString(KeyTags.fr_id))){



                        DataModel enca = new DataModel(
                                mainObjectArray.getString(KeyTags.old_left), mainObjectArray.getString(KeyTags.old_left_paid), mainObjectArray.getString(KeyTags.first_class_payment), mainObjectArray.getString(KeyTags.first_class_paid), mainObjectArray.getString(KeyTags.first_transport), mainObjectArray.getString(KeyTags.second_class_payment), mainObjectArray.getString(KeyTags.second_class_paid), mainObjectArray.getString(KeyTags.second_transport));
                        mdata.add(enca);

            }else{

                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mdata;
    }

    public ArrayList<DataEncap> JsonProcessAbsent(String jsonFile) {

        data = new ArrayList<>();

        try {

            JSONArray jsonArray = new JSONArray(jsonFile);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject mainObjectArray = jsonArray.getJSONObject(i);

                DataEncap enca = new DataEncap(
                        mainObjectArray.getString(KeyTags.sudname),mainObjectArray.getString(KeyTags.attstatue),mainObjectArray.getString(KeyTags.absentdate));
                data.add(enca);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }
    public ArrayList<DataModel> JsonProcessSharf(String jsonFile) {

        mdata = new ArrayList<>();

        try {

            JSONArray jsonArray = new JSONArray(jsonFile);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject mainObjectArray = jsonArray.getJSONObject(i);

                DataModel enca = new DataModel(
                        mainObjectArray.getString(KeyTags.sharaf_name),mainObjectArray.getString(KeyTags.sharaf_img),mainObjectArray.getString(KeyTags.sharaf_rank));
                mdata.add(enca);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mdata;
    }


    public ArrayList<DataEncap> getlist() {
        return data;
    }
    public ArrayList<DataModel> getmlist() {
        return mdata;
    }
}
