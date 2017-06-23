package com.tranginc.trangnhe.studyandroid.lesson2_tinh_bmi;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tranginc.trangnhe.studyandroid.R;

public class TinhBMIActivity extends AppCompatActivity {

    private EditText edTen, edChieuCao, edCanNang, edKq, edChuandoan;
    private Button btTinh;
    private Context mContext;
    private Toast showtoast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson02_main);

        init();
        mContext = this;

    }


    public void init() {
        edTen = (EditText) findViewById(R.id.edTen);
        edChieuCao = (EditText) findViewById(R.id.edChieuCao);
        edCanNang = (EditText) findViewById(R.id.edCanNang);
        edKq = (EditText) findViewById(R.id.edKq);
        edChuandoan = (EditText) findViewById(R.id.edChuandoan);
        btTinh = (Button) findViewById(R.id.btTinh);

        btTinh.setOnClickListener(new TinhListener());
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(mContext)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Application")
                .setMessage("Are you sure you want to close?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    class TinhListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            try {
                float chieucao = Float.parseFloat(edChieuCao.getText().toString());
                float cannang = Float.parseFloat(edCanNang.getText().toString());
                String kq = "";

                float bmi = cannang / (chieucao * chieucao);
                if (bmi < 18) {
                    kq = "Người gầy";
                } else if (bmi < 25) {
                    kq = "Người bình thường";
                } else if (bmi < 30) {
                    kq = "Người béo phì độ I";
                } else if (bmi < 35) {
                    kq = "Người béo phì độ II";
                } else {
                    kq = "Người béo phì độ III";
                }

                edChuandoan.setText(kq);
                edKq.setText(bmi + "");
            } catch (Exception e) {
                edKq.setText("Error");
                edChuandoan.setText("Error");

                if (showtoast != null)
                    showtoast.cancel();

                showtoast = Toast.makeText(mContext, "Loi", Toast.LENGTH_SHORT);
                showtoast.show();
            }

        }
    }
}
