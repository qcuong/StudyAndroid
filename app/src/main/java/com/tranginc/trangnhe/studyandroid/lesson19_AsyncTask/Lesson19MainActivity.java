package com.tranginc.trangnhe.studyandroid.lesson19_AsyncTask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tranginc.trangnhe.studyandroid.R;

public class Lesson19MainActivity extends AppCompatActivity {

    Button btnStart;
    ProgressBar progressBar;
    TextView phantram;
    MyAsyncTask myAsyncTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson19_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        btnStart = (Button) findViewById(R.id.btnstart);
        phantram = (TextView) findViewById(R.id.tvphantram);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dostart();
            }
        });

    }

    private void dostart() {
        //truyền this (chính là MainActivity hiện tại) qua Child Thread
        myAsyncTask = new MyAsyncTask(this);

        //Kích hoạt Tiến trình khi gọi hàm này thì onPreExecute của mytt sẽ thực thi trước
        myAsyncTask.execute();
    }
}
