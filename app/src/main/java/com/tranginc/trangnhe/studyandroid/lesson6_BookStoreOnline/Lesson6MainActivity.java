package com.tranginc.trangnhe.studyandroid.lesson6_BookStoreOnline;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.tranginc.trangnhe.studyandroid.R;

public class Lesson6MainActivity extends AppCompatActivity {

    private EditText editTen, editSl;
    private CheckBox chkVip;
    TextView tvthanhtien, editTongKh, editTongKhVip, ediTongTT;
    ImageButton imgtrove;
    private DanhSachKhachHang danhsach = new DanhSachKhachHang();
    Button btnTT, btnTiep, btnThongke;
    Context mycContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson06_book_store_online);
        getControl();
        addevent();
        mycContext = this;
    }

    public void getControl() {
        editTen = (EditText) findViewById(R.id.editTen);
        editSl = (EditText) findViewById(R.id.editSl);
        editTongKh = (TextView) findViewById(R.id.editTongKh);
        editTongKhVip = (TextView) findViewById(R.id.editTongKhVip);
        ediTongTT = (TextView) findViewById(R.id.ediTongTT);
        tvthanhtien = (TextView) findViewById(R.id.tvthanhtien);
        chkVip = (CheckBox) findViewById(R.id.chklavip);
        btnTT = (Button) findViewById(R.id.btnTT);
        btnTiep = (Button) findViewById(R.id.btnTiep);
        btnThongke = (Button) findViewById(R.id.btnThongke);
        imgtrove = (ImageButton) findViewById(R.id.imgtrove);
    }

    public void addevent() {
        btnTT.setOnClickListener(new ProcessMyEvent());
        btnTiep.setOnClickListener(new ProcessMyEvent());
        btnThongke.setOnClickListener(new ProcessMyEvent());
        imgtrove.setOnClickListener(new ProcessMyEvent());
    }


    class ProcessMyEvent implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnTT:
                    doTinhTien();
                    break;
                case R.id.btnTiep:
                    doTiep();
                    break;
                case R.id.btnThongke:
                    doThongKe();
                    break;
                case R.id.imgtrove:
                    doThoat();
                    break;
            }
        }

        public void doTinhTien(){
            KhachHang kh = new KhachHang();
            kh.setTenKh(editTen.getText().toString());
            kh.setSlmua(Integer.parseInt(editSl.getText().toString()));
            kh.setVip(chkVip.isChecked());
            tvthanhtien.setText(kh.tinhThanhTien()+"");
            danhsach.addKhachHang(kh);
        }
        public void doTiep(){
            editTen.setText("");
            editSl.setText("");
            tvthanhtien.setText("");
            editTen.requestFocus();
        }
        public void doThongKe(){
            editTongKh.setText(danhsach.tongKhachHang()+"");
            editTongKhVip.setText(danhsach.tongKhachHangVip()+"");
            ediTongTT.setText(danhsach.tongDoanhThu()+"");
        }
        public void doThoat(){
            AlertDialog.Builder builder = new AlertDialog.Builder(mycContext);
            builder.setTitle("Thoát chương trình");
            builder.setMessage("Muốn thoát chương trình hả?");
            builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            builder.create().show();

        }

    }
}
