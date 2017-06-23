package com.tranginc.trangnhe.studyandroid.lesson14_Intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tranginc.trangnhe.studyandroid.R;

public class Lesson14ResultActivity extends AppCompatActivity {

    TextView tvkq;
    Button btnquaylai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson14_result);

        tvkq = (TextView) findViewById(R.id.txtketqua);
        btnquaylai = (Button) findViewById(R.id.btnBack);

        /*
        lệnh này cho phép lấy Intent start Activity này.
        Tức là lấy Intent mà ta khai báo bên MainActivity để start ResultActivity.
        */
        Intent callerIntent = getIntent();//lấy intent gọi Activity này
        //có intent rồi thì lấy Bundle dựa vào MyPackage
        Bundle packageFromCaller = callerIntent.getBundleExtra("Mypackage");
        //Có Bundle rồi thì lấy các thông số dựa vào soa, sob
        int soa = packageFromCaller.getInt("soa");
        int sob = packageFromCaller.getInt("sob");

        int kq = giaipt(soa, sob);
        tvkq.setText(kq + "");

        btnquaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public int giaipt(int a, int b) {
        return a + b;
    }


}
