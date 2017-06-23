package com.tranginc.trangnhe.studyandroid.lesson3_ListView.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tranginc.trangnhe.studyandroid.R;

public class Lesson3MainActivity extends AppCompatActivity {

    private Button btnDuLieuDinhSan, btnDuLieuXML, btnDuLieuArrayList, btnDuLieuObject;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson03_main);

        mContext = this;

        btnDuLieuDinhSan = (Button) findViewById(R.id.btnDuLieuDinhSan);
        btnDuLieuXML = (Button) findViewById(R.id.btnDuLieuXML);
        btnDuLieuArrayList = (Button)findViewById(R.id.btnDuLieuArrayList);
        btnDuLieuObject = (Button)findViewById(R.id.btnDuLieuObject);

        btnDuLieuArrayList.setOnClickListener(new ButtonClickListener());
        btnDuLieuDinhSan.setOnClickListener(new ButtonClickListener());
        btnDuLieuXML.setOnClickListener(new ButtonClickListener());
        btnDuLieuObject.setOnClickListener(new ButtonClickListener());
    }



    class ButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int viewid = v.getId();
            Intent intent;
            switch (viewid){
                case R.id.btnDuLieuDinhSan:
                    intent = new Intent(mContext, DuLieuDinhSanActivity.class);
                    mContext.startActivity(intent);

                    Log.i("tranglog",  "btn du lieu dinh san");
                    break;
                case R.id.btnDuLieuXML:
                    intent = new Intent(mContext,DuLieuXMLActivity.class);
                    mContext.startActivity(intent);
                    Log.i("tranglog",  "btn du lieu xml");
                    break;
                case R.id.btnDuLieuArrayList:
                    intent = new Intent(mContext,DuLieuArrayListActivity.class);
                    mContext.startActivity(intent);
                    Log.i("tranglog",  "btn du lieu arrylist");
                    break;
                case R.id.btnDuLieuObject:
                    intent = new Intent(mContext, DuLieuObjectActivity.class);
                    mContext.startActivity(intent);
                    Log.i("tranglog", "btn du lieu object");
                    break;

            }
        }
    }
}
