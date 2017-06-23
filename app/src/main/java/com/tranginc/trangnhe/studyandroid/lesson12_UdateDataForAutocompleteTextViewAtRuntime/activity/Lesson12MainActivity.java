package com.tranginc.trangnhe.studyandroid.lesson12_UdateDataForAutocompleteTextViewAtRuntime.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.tranginc.trangnhe.studyandroid.R;
import com.tranginc.trangnhe.studyandroid.lesson12_UdateDataForAutocompleteTextViewAtRuntime.model.MyArrayAdapter;
import com.tranginc.trangnhe.studyandroid.lesson12_UdateDataForAutocompleteTextViewAtRuntime.model.Student;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Lesson12MainActivity extends AppCompatActivity {
    private EditText editMa, editTen, editNgaySinh;
    private AutoCompleteTextView autoCompleteNS;
    private CheckBox chkGt;
    private ListView lvsinhvien;
    private Button btnNgaySinh, btnNhap;

    private Context mcContext;
    private ArrayList<Student> dsSV = new ArrayList<>();
    private MyArrayAdapter myArrayAdapter = null;

    private ArrayList<String> dsTinh = new ArrayList<>();
    private ArrayAdapter<String> autoAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson12_main);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        mcContext = this;
        editMa = (EditText) findViewById(R.id.editMa);
        editTen = (EditText) findViewById(R.id.editTen);
        autoCompleteNS = (AutoCompleteTextView) findViewById(R.id.autoCompleteNS);
        editNgaySinh = (EditText) findViewById(R.id.editNgaySinh);
        chkGt = (CheckBox) findViewById(R.id.chkGt);
        lvsinhvien = (ListView) findViewById(R.id.lvsinhvien);
        btnNgaySinh = (Button) findViewById(R.id.btnNgaySinh);
        btnNhap = (Button) findViewById(R.id.btnNhap);


        myArrayAdapter = new MyArrayAdapter(Lesson12MainActivity.this, R.layout.activity_lesson12_sinhvien_item_layout, dsSV);
        lvsinhvien.setAdapter(myArrayAdapter);

        autoAdapter = new ArrayAdapter<>(mcContext, android.R.layout.simple_list_item_1, dsTinh);
        autoCompleteNS.setAdapter(autoAdapter);
        fakeData();


        btnNgaySinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processBirthday();
            }
        });

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processInput();
            }
        });
    }

    private void processInput() {
        String ma = editMa.getText().toString();
        String ten = editTen.getText().toString();
        String ns = editNgaySinh.getText().toString();
        String noisinh = autoCompleteNS.getText().toString();
        boolean gt = chkGt.isSelected();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        try {
            Student s = new Student(ma, ten, gt, sdf.parse(ns), noisinh);
            dsSV.add(s);
            myArrayAdapter.notifyDataSetChanged();
            processAutoCompleteTextView(noisinh);
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void processBirthday() {
        DatePickerDialog.OnDateSetListener callBack = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                editNgaySinh.setText(dayOfMonth + "/" + month + "/" + year);
            }
        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, callBack, 1990, 2, 25);
        datePickerDialog.setTitle("Birthday");
        datePickerDialog.show();
    }

    public void processAutoCompleteTextView(String tinh) {
        if (!dsSV.contains(tinh)) {
            dsTinh.add(tinh);
            autoAdapter = new ArrayAdapter<String>(mcContext, android.R.layout.simple_list_item_1, dsTinh);
            autoCompleteNS.setAdapter(autoAdapter);
        }
    }

    public void fakeData() {
        Student s1 = new Student("1", "Đoàn Ái Nương", true, new Date(1980 - 1900, 2, 2), "TP. Hồ Chí Minh");
        Student s2 = new Student("2", "Nguyễn Thùy Trang", true, new Date(1982 - 1900, 3, 3), "Lâm Đồng");
        Student s3 = new Student("3", "Hoàng Văn Phúc", false, new Date(1970 - 1900, 4, 4), "Hà Nội");
        Student s4 = new Student("4", "Đinh Hồng Lợi", false, new Date(1972 - 1900, 4, 4), "Bắc Giang");
        Student s5 = new Student("5", "Nguyễn Hoàng Uyên", true, new Date(1970 - 1900, 4, 4), "Huế");
        dsSV.add(s1);
        dsSV.add(s2);
        dsSV.add(s3);
        dsSV.add(s4);
        dsSV.add(s5);

        dsTinh.add("TP. Hồ Chí Minh");
        dsTinh.add("Lâm Đồng");
        dsTinh.add("Hà Nội");
        dsTinh.add("Bắc Giang");
        dsTinh.add("Huế");

        autoAdapter.notifyDataSetChanged();
        myArrayAdapter.notifyDataSetChanged();
    }

}
