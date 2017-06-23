package com.tranginc.trangnhe.studyandroid.lesson13_GridView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.tranginc.trangnhe.studyandroid.R;

public class Lesson13PhotoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private TextView tvMsg;
    private GridView gv;
    private TextView tvSoloMsg;
    private Integer[] mThumbIds;//mảng lưu danh sách các id hình ảnh có sẵn
    private MyImageAdapter adapter = null;//Adapter cho GridView
    private ImageView ivSoloPicture;//Vì không tạo thêm 1 Activity nên lấy luôn 2 Id ở bên activity_lesson13_onephoto.xml
    private Button btnback;
    private Bundle myBackupBundle;//Lưu Bundle backup cho MainActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myBackupBundle = savedInstanceState;//Lưu savedInstanceState trước vào myBackupBundle
        setContentView(R.layout.activity_lesson13_photo);

        tvMsg = (TextView) findViewById(R.id.tvMsg);
        gv = (GridView) findViewById(R.id.gridviewPhoto);

        //gán mảng các Id hình ảnh cho mThumbIds
        mThumbIds = new Integer[]{R.drawable.image2, R.drawable.image2, R.drawable.image2, R.drawable.image2, R.drawable.image2, R.drawable.image2,
                R.drawable.image2, R.drawable.image2, R.drawable.image2, R.drawable.image2, R.drawable.image2, R.drawable.image2, R.drawable.image2,
                R.drawable.image2, R.drawable.image2, R.drawable.image2};


        adapter = new MyImageAdapter(Lesson13PhotoActivity.this, mThumbIds);
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(Lesson13PhotoActivity.this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        showDetail(position);
    }

    private void showDetail(int position) {
        //khong mo activity moi ma chi thiet lap lai layout;
        setContentView(R.layout.activity_lesson13_onephoto);

        ////Vừa gọi hàm trên thì màn hình sẽ thay đổi qua cái mới
        //ta lấy các control trong layout mới này
        tvSoloMsg = (TextView) findViewById(R.id.tvSoloMsg);
        tvSoloMsg.setText("Image at " + position);
        ivSoloPicture = (ImageView) findViewById(R.id.ivSoloPicture);

        //thiết lập hình ảnh đang chọn lên ImageView mới
        ivSoloPicture.setImageResource(mThumbIds[position]);
        btnback = (Button) findViewById(R.id.btnback);

        //Thiết lập sự kiện click Back để phục hồi lại MainActivity
        //bằng cách gọi lại onCreate(myBackupBundle);


        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreate(myBackupBundle);
            }
        });

    }
}
