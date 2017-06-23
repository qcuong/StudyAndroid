package com.tranginc.trangnhe.studyandroid.Lesson20_LayKetQuaTraVeCuaAsyncTask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tranginc.trangnhe.studyandroid.R;

public class Lesson20MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson20_main);
        Button b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                doStart();
            }
        });
    }

    private void doStart() {
        MyAsyncTask tt = new MyAsyncTask(this);//tạo 1 tiến trình
        EditText edt = (EditText) findViewById(R.id.editText1);
        int so = Integer.parseInt(edt.getText() + "");//lấy giá trị nhập từ EditText
        tt.execute(so);//thực thi tiến trình với đối số truyền vào là số nó được dùng trong đối số của doInBackground
    }
}
