package com.example.elashry.aseer.dataProccess;


import com.example.elashry.aseer.Activities.Login;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.*;
import java.text.*;

public class DataEncap {

    private String img;
    private String imgtable;
    private String desc;
    private String title;
    private String titletable;
    private long date;
    private String id;
    private String name;
    private String exam;
    private String sub;
    private String mon;
    public static String exam_degree;
    private String efid;
    private String imgwork;
    private String wid;
    private String sudname;
    public static String attstatue;
    private String absentdate;
    private String fid;

    public  String school_id ;

    public  String school_name ;
    public  String school_adress ;
    public  String school_email;
    public  String school_fax ;
    public  String school_phone ;
    public  String school_type;
    public  String school_latitude ;
    public  String school_longitude ;



    public DataEncap() {
    }

    public DataEncap(String id) {
        this.id = id;
    }

    public DataEncap(String name, String exam, String sub, String mon, String exam_degree) {
        this.name = name;
        this.exam = exam;
        this.sub = sub;
        this.mon = mon;
        this.exam_degree = exam_degree;
    }

    public DataEncap(String img, String title, long date, String desc) {

        this.img = img;
        this.title = title;
        this.date = date;
        this.desc = desc;

    }

    public DataEncap(String school_id,String school_name, String school_adress, String school_email, String school_fax, String school_phone, String school_type, String school_latitude, String school_longitude) {
        this.school_id = school_id;
        this.school_name = school_name;
        this.school_adress = school_adress;
        this.school_email = school_email;
        this.school_fax = school_fax;
        this.school_phone = school_phone;
        this.school_type = school_type;
        this.school_latitude = school_latitude;
        this.school_longitude = school_longitude;
    }

    public String getSchool_id() {
        return school_id;
    }

    public String getExam_degree() {
        return exam_degree;
    }

    public String getSchool_name() {
        return school_name;
    }

    public String getSchool_adress() {
        return school_adress;
    }

    public String getSchool_email() {
        return school_email;
    }

    public String getSchool_fax() {
        return school_fax;
    }

    public String getSchool_phone() {
        return school_phone;
    }

    public String getSchool_type() {
        return school_type;
    }

    public String getSchool_latitude() {
        return school_latitude;
    }

    public String getSchool_longitude() {
        return school_longitude;
    }

    public DataEncap(String imgtable, String titletable) {
        this.imgtable = imgtable;
        this.titletable = titletable;
    }

    public String getEfid() {
        return efid;
    }

    public String getFid() {
        return fid;
    }
//    public DataEncap(String imgwork, String wid) {
//        this.imgwork = imgwork;
//        this.wid = wid;
//    }

    public String getImgtable() {
        imgtable = "http://wefakhail.org/fihaa/uploads/thumbs/" + imgtable;
        return imgtable;
    }

    public String getTitletable() {
        return titletable;
    }

    public DataEncap(String sudname, String attstatue, String absentdate) {
        this.sudname = sudname;
        this.attstatue = attstatue;
        this.absentdate = absentdate;
    }

    public String getSudname() {
        return sudname;
    }

    public String getAttstatue() {

        if (attstatue.equals("0")) {
            attstatue = "غائب";

        } else {
            attstatue = "حاضر";
        }


        return attstatue;
    }

    public String getAbsentdate() {


        return absentdate;
    }


    public String getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public String getDesc() {
        return desc;
    }

    public String getDate() {
        Date mdate = new Date(date);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       // format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        String formatted = format.format(mdate);
  return formatted;

    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getExam() {
        return exam;
    }

    public String getSub() {
        return sub;
    }

    public String getMon() {
        return mon;
    }



    public String getImgwork() {
        imgwork = "http://wefakhail.org/fihaa/uploads/thumbs/" + imgwork;

        return imgwork;
    }

    public String getWid() {
        return wid;
    }



//    public class Test {
//        public static void main(String[] args) throws InterruptedException {
//            Date date = new Date(1318386508000L);
//            DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//            format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
//            String formatted = format.format(date);
//            System.out.println(formatted);
//            format.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
//            formatted = format.format(date);
//            System.out.println(formatted);
//        }
//    }
}
