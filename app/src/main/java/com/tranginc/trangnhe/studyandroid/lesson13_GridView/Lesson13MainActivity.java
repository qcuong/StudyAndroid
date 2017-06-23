package com.tranginc.trangnhe.studyandroid.lesson13_GridView;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tranginc.trangnhe.studyandroid.R;

public class Lesson13MainActivity extends AppCompatActivity {
    private Button buttonSelect1, buttonSelect2;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson13_select);

        context = this;

        buttonSelect1 = (Button)findViewById(R.id.buttonSelect1);
        buttonSelect2 = (Button)findViewById(R.id.buttonSelect2);

        buttonSelect1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Lesson13WordActivity.class);
                context.startActivity(intent);
            }
        });
        buttonSelect2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(context, Lesson13PhotoActivity.class);
                context.startActivity(intent2);
            }
        });
    }


}
