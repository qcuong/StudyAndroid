package com.tranginc.trangnhe.studyandroid.lesson3_ListView.model;

/**
 * Created by myema on 08/02/2017.
 */

public class EmployeePartTime extends Employee {

    @Override
    public double TinhLuong() {
        // TODO Auto-generated method stub
        return 150;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() +" -->PartTime="+TinhLuong();
    }
}
