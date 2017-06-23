package com.tranginc.trangnhe.studyandroid.lesson3_ListView.model;

/**
 * Created by myema on 08/02/2017.
 */

public class EmployeeFullTime extends Employee {

    @Override
    public double TinhLuong() {
        return 500;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() +" -->FullTime="+TinhLuong();
    }
}