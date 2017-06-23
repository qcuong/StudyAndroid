package com.tranginc.trangnhe.studyandroid.lesson13_GridView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.tranginc.trangnhe.studyandroid.R;

public class Lesson13WordActivity extends AppCompatActivity {
    private TextView tvTenDT;
    private GridView gridviewTenDT;
    private String arr[] = {"Ipad","Iphone","New Ipad", "SamSung","Nokia","Sony Ericson",
            "LG","Q-Mobile","HTC","Blackberry", "G Phone","FPT - Phone","HK Phone"};
    private ArrayAdapter<String> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson13_word);

        tvTenDT = (TextView)findViewById(R.id.tvTenDT);
        gridviewTenDT =(GridView)findViewById(R.id.gridviewTenDT);

        adapter = new ArrayAdapter<String>(Lesson13WordActivity.this, android.R.layout.simple_list_item_1, arr);
        gridviewTenDT.setAdapter(adapter);

        gridviewTenDT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvTenDT.setText(arr[position]);
            }
        });
    }
}
