package com.tranginc.trangnhe.studyandroid.lesson4_ListViewCustom.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.tranginc.trangnhe.studyandroid.R;
import com.tranginc.trangnhe.studyandroid.lesson4_ListViewCustom.model.Employee;

import java.util.ArrayList;

public class Lesson4MainActivity extends AppCompatActivity {
    private TextView editMa, editTen;
    private RadioGroup radioGroup;
    private CheckBox checkBox;
    private Button btnNhap;
    private ListView listView;

    private ArrayList<Employee> arrayList = new ArrayList<>();
    private MyArrayAdapterActivity myArrayAdapterActivity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson04_main);


        editMa = (EditText) findViewById(R.id.editMa);
        editTen = (EditText) findViewById(R.id.editTen);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroud1);
        btnNhap = (Button) findViewById(R.id.btnnhap);
        listView = (ListView) findViewById(R.id.lvNhanvien);
        checkBox = (CheckBox) findViewById(R.id.cbchon);

        myArrayAdapterActivity = new MyArrayAdapterActivity(Lesson4MainActivity.this, R.layout.activity_lesson04_my_item_layout, arrayList);
        listView.setAdapter(myArrayAdapterActivity);//gán Adapter vào Lisview
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ma = editMa.getText().toString();
                String ten = editTen.getText().toString();
                boolean gioitinh = false;// nam = false;

                if (radioGroup.getCheckedRadioButtonId() == R.id.radnu) {
                    gioitinh = true;
                }

                Employee em = new Employee();
                em.setId(ma);
                em.setGender(gioitinh);
                em.setName(ten);
                arrayList.add(em);
                myArrayAdapterActivity.notifyDataSetChanged();

                editMa.setText("");
                editTen.setText("");
                editMa.requestFocus();
            }
        });

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = listView.getChildCount() - 1; i >= 0; i--) {

                    //lấy ra dòng thứ i trong ListView
                    //Dòng thứ i sẽ có 3 phần tử: ImageView, TextView, Checkbox
                    View va = listView.getChildAt(i);
                    //Ta chỉ lấy CheckBox ra kiểm tra
                    CheckBox chk = (CheckBox) va.findViewById(R.id.checkbox);
                    if (chk.isChecked()) {
                        arrayList.remove(i);
                    }
                    myArrayAdapterActivity.notifyDataSetChanged();
                }
            }


        });
    }

}
