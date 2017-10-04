package com.alatheer.anwaralfyaha.dataProccess;

/**
 * Created by elashry on 8/6/2017.
 */

public class NotifyModel {
    String invoice_id;
   String invoice_payment;
     String invoice_left;
 String invoice_date;

    public NotifyModel(String invoice_id, String invoice_payment, String invoice_left, String invoice_date) {
        this.invoice_id = invoice_id;
        this.invoice_payment = invoice_payment;
        this.invoice_left = invoice_left;
        this.invoice_date = invoice_date;
    }

    public NotifyModel() {
    }

    public String getInvoice_id() {
        return invoice_id;
    }

    public String getInvoice_payment() {
        return invoice_payment;
    }

    public String getInvoice_left() {
        return invoice_left;
    }

    public String getInvoice_date() {
        return invoice_date;
    }
}
