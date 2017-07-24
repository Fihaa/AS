package com.example.elashry.aseer.dataProccess;


import java.util.Calendar;

public class DataEncap {

    private String img;
    private String imgtable;
    private String desc;
    private String title;
    private String titletable;
    private String date;
    private String id;
    private String name;
    private String exam;
    private String sub;
    private String mon;
    private String max;
    private String min;
    private String imgwork;
    private String wid;
    private String sudname;
    private String attstatue;
    private String absentdate;


    public DataEncap() {
    }

    public DataEncap(String id) {
        this.id = id;
    }

    public DataEncap(String name, String exam, String sub, String mon, String max, String min) {
        this.name = name;
        this.exam = exam;
        this.sub = sub;
        this.mon = mon;
        this.max = max;
        this.min = min;
    }

    public DataEncap(String img, String title, String date, String desc) {

        this.img = img;
        this.title = title;
        this.date = date;
        this.desc = desc;

    }

    public DataEncap(String imgtable, String titletable) {
        this.imgtable = imgtable;
        this.titletable = titletable;
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
        img = "http://wefakhail.org/fihaa/uploads/thumbs/" + img;
        return img;
    }

    public String getDesc() {
        return desc;
    }

    public String getDate() {

        return date;
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

    public String getMax() {
        return max;
    }

    public String getMin() {
        return min;
    }

    public String getImgwork() {
        imgwork = "http://wefakhail.org/fihaa/uploads/thumbs/" + imgwork;

        return imgwork;
    }

    public String getWid() {
        return wid;
    }
}
