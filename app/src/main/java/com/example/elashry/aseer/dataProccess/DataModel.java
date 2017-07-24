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
