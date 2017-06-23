package com.tranginc.trangnhe.studyandroid.lesson1_tonghaiso;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tranginc.trangnhe.studyandroid.R;

public class TongHaiSoActivity extends AppCompatActivity {

    private EditText edA, edB;
    private TextView tvResult;
    private Button btnTinh;

    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson01_main);

        mContext = this;

        edA = (EditText) findViewById(R.id.ed_a);
        edB = (EditText) findViewById(R.id.ed_b);
        tvResult = (TextView) findViewById(R.id.tv_result);
        btnTinh = (Button) findViewById(R.id.bt_tinh);

        btnTinh.setOnClickListener(new TinhClickListener());
    }

    class TinhClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            try {
                long a = Long.parseLong(edA.getText().toString());
                long b = Long.parseLong(edB.getText().toString());
                tvResult.setText("" + (a + b));
            } catch (Exception e){
                tvResult.setText("Error");
                Toast.makeText(mContext, "a, b la so nguyen duong", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
