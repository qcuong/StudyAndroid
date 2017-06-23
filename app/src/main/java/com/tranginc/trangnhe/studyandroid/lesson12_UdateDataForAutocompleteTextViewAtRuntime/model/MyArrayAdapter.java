package com.tranginc.trangnhe.studyandroid.lesson12_UdateDataForAutocompleteTextViewAtRuntime.model;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tranginc.trangnhe.studyandroid.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by myema on 16/02/2017.
 */

public class MyArrayAdapter extends ArrayAdapter<Student> {

    private Activity context;
    private int resource;
    private ArrayList<Student> dsSV = new ArrayList<>();

    public MyArrayAdapter(Activity context, int resource, ArrayList<Student> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.dsSV = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            //gan layout vao Activity
            convertView = context.getLayoutInflater().inflate(resource, null);
        }

        TextView tvMavaTen, tvThongtinkhac;
        tvMavaTen = (TextView) convertView.findViewById(R.id.txtMaVaTen);
        tvThongtinkhac = (TextView) convertView.findViewById(R.id.txtThongTinKhac);

        Student s = dsSV.get(position);
        tvMavaTen.setText(s.getId() + " - " + s.getName());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        tvThongtinkhac.setText((s.getGender() ? "Nữ - " : "Nam - ") + sdf.format(s.getBirthday()) + " - " + s.getPlaceOfBirth());
        return convertView;
    }
}
