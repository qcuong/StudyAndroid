package com.tranginc.trangnhe.studyandroid.lesson17_HandlerUsingMessage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.tranginc.trangnhe.studyandroid.R;

import java.util.concurrent.atomic.AtomicBoolean;

public class Lesson17VeButtonLucRuntime extends AppCompatActivity {

    Handler handler;
    AtomicBoolean atomic = null;
    LinearLayout layoutdevebutton;
    Button btnOk;
    EditText edtOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson17_ve_button_luc_runtime);

        //lấy LinearLayout chứa Button ra
        layoutdevebutton = (LinearLayout) findViewById(R.id.linear);
        btnOk = (Button) findViewById(R.id.btdraw);
        edtOk = (EditText) findViewById(R.id.eddraw);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //Nhận nhãn của Button được gửi về từ tiến trình con
                String nhanButton = msg.obj.toString();

                //khởi tạo 1 Button
                Button b = new Button(Lesson17VeButtonLucRuntime.this);

                //thiết lập nhãn cho Button
                b.setText(nhanButton);

                //thiết lập kiểu Layout : Width, Height
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                b.setLayoutParams(params);//thiết lập layout cho Button
                layoutdevebutton.addView(b);//đưa Button vào layoutdevebutton
            }
        };
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dostart();

            }
        });
    }

    private void dostart() {
        atomic = new AtomicBoolean(false);
        final int sobutton = Integer.parseInt(edtOk.getText().toString());
        Thread thcon = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < sobutton && atomic.get(); i++) {
                    SystemClock.sleep(200);

                    //lấy message từ Main Thread
                    Message msg = handler.obtainMessage();


                    //gán dữ liệu cho msg Mainthread, lưu vào biến obj
                    //chú ý ta có thể lưu bất kỳ kiểu dữ liệu nào vào obj
                    msg.obj = "Button thu " + i;

                    handler.sendMessage(msg);//gửi trả lại message cho Mainthread
                }
            }
        });
        atomic.set(true);
        thcon.start();

    }
}
