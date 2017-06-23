package com.tranginc.trangnhe.studyandroid.lesson3_ListView.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.tranginc.trangnhe.studyandroid.R;
import com.tranginc.trangnhe.studyandroid.lesson3_ListView.model.Employee;
import com.tranginc.trangnhe.studyandroid.lesson3_ListView.model.EmployeeFullTime;
import com.tranginc.trangnhe.studyandroid.lesson3_ListView.model.EmployeePartTime;

import java.util.ArrayList;

public class DuLieuObjectActivity extends AppCompatActivity {
    private EditText editMaNV, editTen;
    private RadioGroup rdgroup;
    Toast toast;

    private Button btnNhap;
    private ListView lvNV;
    private ArrayList<Employee> dsEmployees = new ArrayList<>();
    private ArrayAdapter<Employee> adapter = null;
    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson03_du_lieu_object);
        mContext = this;

        editMaNV = (EditText) findViewById(R.id.editMa);
        editTen = (EditText) findViewById(R.id.editTen);
        rdgroup = (RadioGroup) findViewById(R.id.radiogroud1);
        btnNhap = (Button) findViewById(R.id.btnnhap);
        lvNV = (ListView) findViewById(R.id.lvnhanvien);


        adapter = new ArrayAdapter<Employee>(mContext, android.R.layout.simple_list_item_1, dsEmployees);
        lvNV.setAdapter(adapter);


        btnNhap.setOnClickListener(new NhapNVListener());
    }

    class NhapNVListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            nhap();
        }
    }

    public void nhap() {
        int radId = rdgroup.getCheckedRadioButtonId();
        String id = editMaNV.getText() + "";
        String name = editTen.getText().toString();
        if (id.isEmpty()||name.isEmpty()) {
            if (toast != null) {
                toast.cancel();
            }
            toast = Toast.makeText(mContext, "Khong de trong", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        Employee employee = null;
        if (radId == R.id.radChinhthuc) {
            employee = new EmployeeFullTime();
        } else {
            employee = new EmployeePartTime();
        }

        employee.setId(id);
        employee.setName(name);
        dsEmployees.add(employee);
        adapter.notifyDataSetChanged();


        editTen.setText("");
        editMaNV.setText("");
        editMaNV.requestFocus();
    }

}

