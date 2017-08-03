package com.example.elashry.aseer.dataProccess;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.elashry.aseer.Activities.Home.s;
import static com.example.elashry.aseer.Activities.PaySchool.scp;
import static com.example.elashry.aseer.Activities.Select.y;
import static com.example.elashry.aseer.Adapters.AdapterSchool.addresssc;
import static com.example.elashry.aseer.Adapters.AdapterSchool.emailsc;
import static com.example.elashry.aseer.Adapters.AdapterSchool.faxsc;
import static com.example.elashry.aseer.Adapters.AdapterSchool.idsc;
import static com.example.elashry.aseer.Adapters.AdapterSchool.latitude;
import static com.example.elashry.aseer.Adapters.AdapterSchool.longitude;
import static com.example.elashry.aseer.Adapters.AdapterSchool.namesc;
import static com.example.elashry.aseer.Adapters.AdapterSchool.phonesc;


public class JsonParser {

    ArrayList<DataEncap> data;
    ArrayList<DataModel> mdata;
//    public static String namesc,phonesc,emailsc ,faxsc,addressc;
    public static String state;
    public static String exame;
    public static Double amount;
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
                if (s.equals(mainObjectArray.getString(KeyTags.fid))&&(y.equals("2")|y.equals("3"))){

                DataEncap enca = new DataEncap(
                        mainObjectArray.getString(KeyTags.sname),mainObjectArray.getString(KeyTags.exame), mainObjectArray.getString(KeyTags.subject),mainObjectArray.getString(KeyTags.month), mainObjectArray.getString(KeyTags.exam_degree));
                data.add(enca);
            exame=mainObjectArray.getString(KeyTags.exame);
                }}

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ArrayList<DataEncap> JsonProcessschool(String jsonFile) {

        data = new ArrayList<>();
        idsc = new ArrayList<>();
        namesc = new ArrayList<>();
        phonesc = new ArrayList<>();
        emailsc = new ArrayList<>();
        faxsc = new ArrayList<>();
        addresssc = new ArrayList<>();
        latitude = new ArrayList<>();
        longitude = new ArrayList<>();

        try {

            JSONArray jsonArray = new JSONArray(jsonFile);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject mainObjectArray = jsonArray.getJSONObject(i);
              if (!mainObjectArray.getString(KeyTags.school_id).equals("2")){

//                   namesc=mainObjectArray.getString(KeyTags.school_name);
//                   phonesc=mainObjectArray.getString(KeyTags.school_phone);
//                   emailsc=mainObjectArray.getString(KeyTags.school_email);
//                   faxsc=mainObjectArray.getString(KeyTags.school_phone);
//                   addressc=mainObjectArray.getString(KeyTags.school_email);
//                   latitudesc= Double.parseDouble(mainObjectArray.getString(KeyTags.school_latitude));
//                   longitudesc= Double.parseDouble(mainObjectArray.getString(KeyTags.school_longitude));

                   DataEncap enca = new DataEncap(
                           mainObjectArray.getString(KeyTags.school_id),  mainObjectArray.getString(KeyTags.school_name),mainObjectArray.getString(KeyTags.school_adress), mainObjectArray.getString(KeyTags.school_email),mainObjectArray.getString(KeyTags.school_fax), mainObjectArray.getString(KeyTags.school_phone),mainObjectArray.getString(KeyTags.school_type), mainObjectArray.getString(KeyTags.school_latitude),mainObjectArray.getString(KeyTags.school_longitude));
                    data.add(enca);
                      idsc.add(mainObjectArray.getString(KeyTags.school_id));
                  namesc.add(mainObjectArray.getString(KeyTags.school_name));
                  phonesc.add(mainObjectArray.getString(KeyTags.school_phone));
                  emailsc.add(mainObjectArray.getString(KeyTags.school_email));
                  addresssc.add(mainObjectArray.getString(KeyTags.school_adress));
                  faxsc.add(mainObjectArray.getString(KeyTags.school_fax));
                  latitude.add(mainObjectArray.getDouble(KeyTags.school_latitude));
                  longitude.add(mainObjectArray.getDouble(KeyTags.school_longitude));

           }
//                namesc=mainObjectArray.getString(KeyTags.school_name);
//                phonesc=mainObjectArray.getString(KeyTags.school_phone);
//                emailsc=mainObjectArray.getString(KeyTags.school_email);
//                faxsc=mainObjectArray.getString(KeyTags.school_phone);
//                addressc=mainObjectArray.getString(KeyTags.school_email);
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
                if (s.equals(mainObjectArray.getString(KeyTags.f_id))&&(y.equals("2")|y.equals("3"))){

                DataEncap enca = new DataEncap(
                        mainObjectArray.getString(KeyTags.sudname),mainObjectArray.getString(KeyTags.attstatue),mainObjectArray.getString(KeyTags.absentdate));
                data.add(enca);
                    state=mainObjectArray.getString(KeyTags.attstatue);

            }else {

                }
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
    public ArrayList<DataModel> JsonProcessEvent(String jsonFile) {

        mdata = new ArrayList<>();

        try {

            JSONArray jsonArray = new JSONArray(jsonFile);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject mainObjectArray = jsonArray.getJSONObject(i);

                DataModel enca = new DataModel(
                        mainObjectArray.getString(KeyTags.event_imgs),mainObjectArray.getString(KeyTags.event_title),mainObjectArray.getString(KeyTags.event_date),mainObjectArray.getString(KeyTags.school_id_fk));
                mdata.add(enca);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mdata;
    }
    public ArrayList<DataModel> JsonProcessPs(String jsonFile) {

        mdata = new ArrayList<>();

        try {

            JSONArray jsonArray = new JSONArray(jsonFile);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject mainObjectArray = jsonArray.getJSONObject(i);
                if (scp.contains(mainObjectArray.getString(KeyTags.school_fk))){

                DataModel enca = new DataModel(
                        mainObjectArray.getDouble(KeyTags.payset_amount),mainObjectArray.getString(KeyTags.payset_transport),mainObjectArray.getString(KeyTags.payset_stuff_kids),mainObjectArray.getString(KeyTags.payset_student_brother),mainObjectArray.getString(KeyTags.payset_full_pay),mainObjectArray.getString(KeyTags.pay_set_year),mainObjectArray.getString(KeyTags.payset_hijri_year));
                mdata.add(enca);
                    amount=mainObjectArray.getDouble(KeyTags.payset_amount);
                    amount=mainObjectArray.getDouble(KeyTags.payset_amount);

               }}


        } catch (JSONException e) {
            e.printStackTrace();
        }
//        if (sp.equals("14")){
//          x=   mdata.get(3);
//        }else if (sp.equals("8")){
//             x=  mdata.get(1);
//
//        }else if (sp.equals("3")){
//             x=   mdata.get(0);
//
//        }else if (sp.equals("9")){
//             x=   mdata.get(5);
//
//        }else if (sp.equals("18")){
//             x=    mdata.get(8);
//
//        }
        return mdata;

    }


    public ArrayList<DataEncap> getlist() {
        return data;
    }
    public ArrayList<DataModel> getmlist() {
        return mdata;
    }
}
