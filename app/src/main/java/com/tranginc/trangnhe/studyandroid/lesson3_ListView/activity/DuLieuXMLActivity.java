package com.tranginc.trangnhe.studyandroid.lesson3_ListView.activity;

/**
 * Created by myema on 12/02/2017.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tranginc.trangnhe.studyandroid.R;

/**
 * Created by myema on 08/02/2017.
 */

public class DuLieuXMLActivity extends AppCompatActivity {
    private Context mContext;
    private TextView tvSelect;
    private ListView listView;
    private String arr[];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson03_du_lieu_dinh_san);
        mContext = this;
        arr = getResources().getStringArray(R.array.myarray);

        listView = (ListView) findViewById(R.id.lvPerson);

        //gan data vao ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, arr);

        //dua data vao LV
        listView.setAdapter(adapter);
        tvSelect = (TextView) findViewById(R.id.tvSelect);

        //thiet lap su kien cho LV
        listView.setOnItemClickListener(new LVItemClickListener());

    }

    class LVItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            tvSelect.setText("Position: " + position + ";   value = " + arr[position]);
        }
    }
}
