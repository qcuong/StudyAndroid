package com.tranginc.trangnhe.studyandroid.lesson14_Intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tranginc.trangnhe.studyandroid.R;

public class Lesson14MainActivity extends AppCompatActivity {
    EditText soa, sob;
    Button btnkq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson14_main);


        soa = (EditText)findViewById(R.id.editsoa);
        sob = (EditText)findViewById(R.id.editsob);
        btnkq = (Button)findViewById(R.id.btnkq);

        btnkq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lesson14MainActivity.this, Lesson14ResultActivity.class);

                Bundle bundle = new Bundle();
                int a = Integer.parseInt(soa.getText().toString());
                int b = Integer.parseInt(sob.getText().toString());

                bundle.putInt("soa", a);
                bundle.putInt("sob", b);

                intent.putExtra("Mypackage", bundle);//Đưa Bundle vào Intent
                startActivity(intent);//Mở Activity ResultActivity
            }
        });
    }
}
