package com.tranginc.trangnhe.studyandroid.Lesson21KetHopAsyncTaskVaHandler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tranginc.trangnhe.studyandroid.R;

public class Lesson21MainActivity extends AppCompatActivity {

    Button btnstart;
    MyAsyncTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson21_ket_hop_async_task_va_handler);
        btnstart = (Button) findViewById(R.id.btnstart);

        btnstart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                doStart();
            }
        });
    }

    public void doStart() {
        String s = ((EditText) this.findViewById(R.id.editnumber)).getText().toString();
        int n = Integer.parseInt(s);//lấy số lượng từ EditText
        task = new MyAsyncTask(this);
        task.execute(n);
    }
}
