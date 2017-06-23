package com.tranginc.trangnhe.studyandroid.lesson9_Spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.tranginc.trangnhe.studyandroid.R;

public class Lesson9MainActivity extends AppCompatActivity {

    private TextView textView;
    private Spinner spinner;
    private ArrayAdapter<String> adapter = null;
    private String arr[] = {"Hàng điện tử", "Hàng hóa chất", "Hàng gia dụng"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson09_main);

        textView = (TextView) findViewById(R.id.text1);
        spinner = (Spinner)findViewById(R.id.spinnerchon);



        adapter = new ArrayAdapter<String>(Lesson9MainActivity.this, android.R.layout.simple_spinner_item, arr);

        //hien thi danh sach cho spinner
        //adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //thiet lap adapter cho spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new XuLy());

    }
    class XuLy implements AdapterView.OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            textView.setText(arr[position]);
        }

        public void onNothingSelected(AdapterView<?> arg0) {
            textView.setText("");
        }
    }
}
