package com.tranginc.trangnhe.studyandroid.lesson18_HandlerUsingPost;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.tranginc.trangnhe.studyandroid.R;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Lesson18MainActivity extends AppCompatActivity {

    Button btnUpdate;
    EditText editText;
    ListView lv;

    Handler handler = new Handler();
    ArrayList<Integer> arr = new ArrayList<>();
    ArrayAdapter<Integer> adapter = null;

    AtomicBoolean ab = new AtomicBoolean(false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson18_main);

        btnUpdate = (Button) findViewById(R.id.btupdate);
        editText = (EditText) findViewById(R.id.edupdate);
        lv = (ListView) findViewById(R.id.lvthemsoNgaunhien);


        adapter = new ArrayAdapter<Integer>(Lesson18MainActivity.this, android.R.layout.simple_list_item_1, arr);
        lv.setAdapter(adapter);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dostart();

            }
        });
    }

    private void dostart() {
        final int so = Integer.parseInt(editText.getText().toString());
        final Random rd = new Random();
        ab.set(false);

        Thread thcon = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < so && ab.get(); i++) {//vòng lặp để thực hiện cập nhập giao diện

                    SystemClock.sleep(150);//cho tiến trình ngừng 150 milisecond


                    Runnable mesg = new Runnable() {
                        @Override
                        public void run() {
                            //hàm này thuộc Main Thread để có thể cập nhập giao diện
                            //rd.nextInt(100) để trả về số ngẫu nhiên từ 0-->99
                            capnhatgiaodien(rd.nextInt(100));
                        }
                    };


                    handler.post(mesg);//gọi phương thức post để gửi message ra main Thread
                }
                //kết thúc vòng lặp thì gửi tiếp message ra Main Thread
                //để xác lập đã kết thúc tiến trình
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //gọi hàm hiển thị kết thúc ở Main Thread
                        thongbaoketthuc();
                    }
                });
            }
        });
        ab.set(true);
        thcon.start();//khởi tạo Tiến trình
    }

    private void thongbaoketthuc() {
        Toast.makeText(Lesson18MainActivity.this, "Xong roi...", Toast.LENGTH_LONG).show();
    }


    private void capnhatgiaodien(int i) {
        arr.add(i);//đưa dữ liệu mới gửi từ Child Thread gửi về vào arr
        adapter.notifyDataSetChanged();//cập nhập lại Listview:
    }
}
