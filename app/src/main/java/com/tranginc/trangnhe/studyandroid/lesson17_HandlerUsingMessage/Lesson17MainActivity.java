package com.tranginc.trangnhe.studyandroid.lesson17_HandlerUsingMessage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tranginc.trangnhe.studyandroid.R;

import java.util.concurrent.atomic.AtomicBoolean;

public class Lesson17MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Handler handler;
    Button btnstart;
    TextView phantram;
    AtomicBoolean isrunning = new AtomicBoolean(false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson17_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        btnstart = (Button) findViewById(R.id.btnstart);
        phantram = (TextView) findViewById(R.id.tvphantram);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doStart();
            }
        });

        //viết lệnh cho handler class để nhận thông điệp gửi về từ tiến trình con
        //mọi thông điệp sẽ được xử lý trong handleMessage từ tiến trình con ta gửi Message về cho main thread
        handler = new Handler() {
            String s;

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                //msg.arg1 là giá trị được trả về trong message
                //của tiến trình con
                progressBar.setProgress(msg.arg1);
                phantram.setText(msg.arg1 + "%");
            }
        };
    }


    private void doStart() {
//        progressBar.setProgress(0);
//        phantram.setText(0+"%");
//        SystemClock.sleep(1000);
//
//        progressBar.setProgress(10);
//        phantram.setText(10+"%");
//        SystemClock.sleep(5000);
//
//        progressBar.setProgress(20);
//        phantram.setText(20+"%");
        //SystemClock.sleep(100);

//        for(int i = 1; i <= 100; i++){
//            SystemClock.sleep(100);
//            progressBar.setProgress(i);
//            phantram.setText(i+"%");
//        }
        isrunning.set(false);

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100 && isrunning.get(); i++) {

                    SystemClock.sleep(100);//cho tiến trình tạm ngừng 100 mili second

                    Message msg = handler.obtainMessage();//lấy message từ Main thread

                    msg.arg1 = i;//gán giá trị vào cho arg1 để gửi về Main thread

                    handler.sendMessage(msg);//gửi lại Message này về cho Main Thread
                }
            }
        });
        isrunning.set(true);
        th.start();
    }
}
