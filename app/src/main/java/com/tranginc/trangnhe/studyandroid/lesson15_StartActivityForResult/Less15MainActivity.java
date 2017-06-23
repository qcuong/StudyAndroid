package com.tranginc.trangnhe.studyandroid.lesson15_StartActivityForResult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.tranginc.trangnhe.studyandroid.R;

import java.util.ArrayList;

public class Less15MainActivity extends AppCompatActivity {


    Button btnInputData;
    ListView lvData;
    public static final int REQUEST_CODE_INPUT=113;
    public static final int RESULT_CODE_SAVE1=115;
    public static final int RESULT_CODE_SAVE2=116;

    ArrayList<Integer> arrdata = new ArrayList<>();
    ArrayAdapter<Integer> adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson15_main);
        btnInputData = (Button)findViewById(R.id.btnopenactivity);
        lvData = (ListView)findViewById(R.id.lvdata);


        btnInputData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Mở Activity với REQUEST_CODE_INPUT
                Intent intent = new Intent(Less15MainActivity.this, Lesson15InputActivity.class);
                startActivityForResult(intent, REQUEST_CODE_INPUT);
            }
        });

        adapter = new ArrayAdapter<Integer>(Less15MainActivity.this, android.R.layout.simple_list_item_1, arrdata);
        lvData.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Kiểm tra có đúng requestCode =REQUEST_CODE_INPUT hay không
        //Vì ta có thể mở Activity với những RequestCode khác nhau
        if(requestCode == REQUEST_CODE_INPUT){
            //Kiểm trả ResultCode trả về, cái này ở bên InputDataActivity truyền về
            //có nó rồi thì xử lý trở lên thông thường

            switch (resultCode){
                case RESULT_CODE_SAVE1://giá trị từ InputDataActivity
                    int v1 = data.getIntExtra("data", 0);
                    arrdata.add(v1*v1);
                    adapter.notifyDataSetChanged();
                    break;
                case RESULT_CODE_SAVE2:
                    int v2 = data.getIntExtra("data", 0);
                    arrdata.add(v2);
                    adapter.notifyDataSetChanged();
                    break;

            }
        }
    }
}
