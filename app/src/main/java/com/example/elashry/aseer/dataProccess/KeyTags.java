package com.example.elashry.aseer.dataProccess;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KeyTags {

    public static final String titleKey = "new_title";
    public static final String descKey = "news_details";
    public static final String imgKey = "new_image";
    @SerializedName("news_date_add")
    @Expose
    public static final String dateKey = "news_date_add";

    public static final String titKey = "timetable_title";
    public static final String img_Key = "timetable_images";

    public static final String id="student_national_id";

    public static final String sname = "student_name";
    public static final String exame = "exam_title";
    public static final String subject = "subject_title";
    public static final String month = "exam_month";
    public static final String max="exam_max_degree";
    public static final String min="exam_min_degree";

    public static final String imgwork="homework_image";
    public static final String wid="homework_id_pk";

    public static final String sudname="student_name";

    public static final String attstatue="attend_statue";
    public static final String absentdate="absence_date";

    public static final String old_left = "old_left";
    public static final String old_left_paid = "old_left_paid";
    public static final String first_class_payment = "first_class_payment";
    public static final String first_class_paid = "first_class_paid";
    public static final String first_transport="first_transport";
    public static final String second_class_payment="second_class_payment";
    public static final String second_class_paid="second_class_paid";
    public static final String second_transport="second_transport";
    public static final String fr_id="student_id_fk";

    public static final String sharaf_name = "student_name";
    public static final String sharaf_img = "student_photo";
    public static final String sharaf_rank="student_rank";
}
