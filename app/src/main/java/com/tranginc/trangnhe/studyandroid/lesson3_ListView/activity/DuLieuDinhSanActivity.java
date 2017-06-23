package com.tranginc.trangnhe.studyandroid.lesson3_ListView.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tranginc.trangnhe.studyandroid.R;


public class DuLieuDinhSanActivity extends AppCompatActivity {
    private Context mContext;
    private TextView tvSelect;
    private String arr[] = {"Trang", "Cuong", "Dinh Cong Manh"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson03_du_lieu_dinh_san);
        mContext = this;

        ListView lv = (ListView) findViewById(R.id.lvPerson);

        //gan data vao ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, arr);

        //dua data vao LV
        lv.setAdapter(adapter);
        tvSelect = (TextView) findViewById(R.id.tvSelect);

        //thiet lap su kien cho LV
        lv.setOnItemClickListener(new LVItemClickListener());

    }

    class LVItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            tvSelect.setText("Position: " + position + ";   value = " + arr[position]);
        }
    }
}
