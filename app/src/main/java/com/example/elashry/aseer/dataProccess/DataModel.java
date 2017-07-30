package com.example.elashry.aseer.dataProccess;

/**
 * Created by elashry on 7/18/2017.
 */

public class DataModel {

    private String old_left;
    private String old_left_paid;
    private String first_class_payment;
    private String first_class_paid;
    private String first_transport;
    private String second_class_payment;
    private String second_class_paid;
    private String second_transport;
    private String fr_id;

    private String sharaf_rank;
    private String sharaf_name;
    private String sharaf_img;

    private String event_imgs;
    private String event_title;
    private String event_date;
    private String school_id_fk;

    private Double payset_amount;
    private String payset_transport;
    private String payset_stuff_kids;
    private String payset_student_brother;
    private String payset_full_pay;
    private String pay_set_year;
    private String payset_hijri_year;

    public DataModel(String event_imgs, String event_title, String event_date, String school_id_fk) {
        this.event_imgs = event_imgs;
        this.event_title = event_title;
        this.event_date = event_date;
        this.school_id_fk = school_id_fk;
    }

    public DataModel(Double payset_amount, String payset_transport, String payset_stuff_kids, String payset_student_brother, String payset_full_pay, String pay_set_year, String payset_hijri_year) {
        this.payset_amount = payset_amount;
        this.payset_transport = payset_transport;
        this.payset_stuff_kids = payset_stuff_kids;
        this.payset_student_brother = payset_student_brother;
        this.payset_full_pay = payset_full_pay;
        this.pay_set_year = pay_set_year;
        this.payset_hijri_year = payset_hijri_year;
    }

    public Double getPayset_amount() {
        return payset_amount;
    }

    public String getPayset_transport() {
        return payset_transport;
    }

    public String getPayset_stuff_kids() {
        return payset_stuff_kids;
    }

    public String getPayset_student_brother() {
        return payset_student_brother;
    }

    public String getPayset_full_pay() {
        return payset_full_pay;
    }

    public String getPay_set_year() {
        return pay_set_year;
    }

    public String getPayset_hijri_year() {
        return payset_hijri_year;
    }

    public String getEvent_imgs() {

        return event_imgs;
    }

    public String getEvent_title() {
        return event_title;
    }

    public String getEvent_date() {
        return event_date;
    }

    public String getSchool_id_fk() {
        return school_id_fk;
    }

    public DataModel(String sharaf_name, String sharaf_img, String sharaf_rank) {
        this.sharaf_name = sharaf_name;
        this.sharaf_img = sharaf_img;
        this.sharaf_rank = sharaf_rank;
    }

    public String getSharaf_name() {
        return sharaf_name;
    }

    public String getSharaf_img() {
        sharaf_img = "http://wefakhail.org/fihaa/uploads/thumbs/" + sharaf_img;
        return sharaf_img;
    }

    public String getSharaf_rank() {
        return sharaf_rank;
    }


    private String imgwork;
    private String wid;

    public DataModel() {
    }

    public DataModel(String imgwork, String wid) {
        this.imgwork = imgwork;
        this.wid = wid;
    }

    public DataModel(String old_left, String old_left_paid, String first_class_payment, String first_class_paid, String first_transport, String second_class_payment, String second_class_paid, String second_transport) {
        this.old_left = old_left;
        this.old_left_paid = old_left_paid;
        this.first_class_payment = first_class_payment;
        this.first_class_paid = first_class_paid;
        this.first_transport = first_transport;
        this.second_class_payment = second_class_payment;
        this.second_class_paid = second_class_paid;
        this.second_transport = second_transport;
    }

    public String getImgwork() {
        imgwork = "http://wefakhail.org/fihaa/uploads/thumbs/" + imgwork;
        return imgwork;    }

    public String getWid() {
        return wid;
    }

    public String getFr_id() {
        return fr_id;
    }

    public String getOld_left() {
        return old_left;
    }

    public String getOld_left_paid() {
        return old_left_paid;
    }

    public String getFirst_class_payment() {
        return first_class_payment;
    }

    public String getFirst_class_paid() {
        return first_class_paid;
    }

    public String getFirst_transport() {
        return first_transport;
    }

    public String getSecond_class_payment() {
        return second_class_payment;
    }

    public String getSecond_class_paid() {
        return second_class_paid;
    }

    public String getSecond_transport() {
        return second_transport;
    }
}
