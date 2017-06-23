package com.tranginc.trangnhe.studyandroid.lesson16_Time_DatePickerDialog.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by myema on 03/03/2017.
 */

public class JobInWeek {
    private String title;
    private String desciption;
    private Date dateFinish;
    private Date hourFinish;

    public JobInWeek(String title, String desciption, Date dateFinish,
                     Date hourFinish) {
        super();
        this.title = title;
        this.desciption = desciption;
        this.dateFinish = dateFinish;
        this.hourFinish = hourFinish;
    }

    public JobInWeek() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public Date getHourFinish() {
        return hourFinish;
    }

    public void setHourFinish(Date hourFinish) {
        this.hourFinish = hourFinish;
    }



    /**
     * lấy định dạng ngày
     *
     * @param d
     * @return
     */
    public String getDateFormat(Date d) {
        SimpleDateFormat dft = new SimpleDateFormat("dd/MM/yyyy");
        return dft.format(d);
    }

    /**
     * lấy định dạng giờ phút
     *
     * @param d
     * @return
     */
    public String getHourFormat(Date d) {
        SimpleDateFormat dft = new SimpleDateFormat("hh:mm a");
        return dft.format(d);
    }

    @Override
    public String toString() {
        return this.title + "-" +
                getDateFormat(this.dateFinish) + "-" +
                getHourFormat(this.hourFinish);
    }
}
