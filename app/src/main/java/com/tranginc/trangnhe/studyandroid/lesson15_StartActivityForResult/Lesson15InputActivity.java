package com.tranginc.trangnhe.studyandroid.lesson15_StartActivityForResult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.tranginc.trangnhe.studyandroid.R;

import java.util.ArrayList;

public class Lesson15InputActivity extends Activity {

    Button btnSave1,btnSave2;
    EditText editNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson15_input);

        btnSave1=(Button) findViewById(R.id.btnSave1);
        btnSave2=(Button) findViewById(R.id.btnSave2);
        editNumber=(EditText) findViewById(R.id.editNumber);


        btnSave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendtoMain(Less15MainActivity.RESULT_CODE_SAVE1);
            }
        });
        btnSave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendtoMain(Less15MainActivity.RESULT_CODE_SAVE2);
            }
        });


    }
    public void sendtoMain(int resultCode){
        Intent intent = getIntent();
        int value = Integer.parseInt(editNumber.getText().toString());
        intent.putExtra("data", value);
        setResult(resultCode, intent);
        finish();
    }
}
