package com.tranginc.trangnhe.studyandroid.lesson23_SQLiteManager;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.tranginc.trangnhe.studyandroid.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class UpdateActivity extends AppCompatActivity {
    final String DATABASE_NAME = "EmployeeDB.sqlite";
    int id = -1;
    Button btnChonhinh, btnChuphinh, btnLuu, btnHuy, btnthem;
    EditText ten, sdt;
    ImageView anhdaidien;

    final int REQUEST_TAKE_PHOTO = 123;
    final int REQUEST_CHOOSE_PHOTO = 321;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson23_update);
        addcontrols();
        addEvents();
        //initUI();
    }

    //lay thong tin nhan vien muon cap nhat day len giao dien
    private void initUI() {
        Intent intent = getIntent();
        //khong tim duoc thi tra ve -1
        id = intent.getIntExtra("ID", -1);
        SQLiteDatabase database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM NhanVien where ID = ?", new String[]{id+""});
        cursor.moveToFirst();
        String tennv = cursor.getString(1);
        String sdtnv = cursor.getString(2);
        byte[] anh = cursor.getBlob(3);

        Bitmap bitmap = BitmapFactory.decodeByteArray(anh, 0, anh.length);
        anhdaidien.setImageBitmap(bitmap);
        ten.setText(tennv);
        sdt.setText(sdtnv);
    }

    private void addcontrols() {
        btnChonhinh = (Button) findViewById(R.id.btnchonhinh);
        btnChuphinh = (Button) findViewById(R.id.btnchuphinh);
        btnLuu = (Button) findViewById(R.id.btnluu1);
        btnHuy = (Button) findViewById(R.id.btncancle);
        ten = (EditText)findViewById(R.id.eten1);
        sdt = (EditText)findViewById(R.id.esdt1);
        anhdaidien = (ImageView)findViewById(R.id.themanh);
    }

    private void takePicture(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_TAKE_PHOTO);
    }

    private void choosePhoto(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        //setType sẽ tìm tất cả hình ảnh trong máy, thường là bộ nhớ trong của máy.﻿
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_CHOOSE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //RESULT_OK là 1 biến kiểu int của Android cung cấp, để so sánh với trạng thái chọn hình hoặc chụp hình thành công
        if(requestCode == RESULT_OK){
            if(requestCode == REQUEST_CHOOSE_PHOTO){
                //tra ve mot Uri, intent ten la data
                Uri imageUri = data.getData();
                try {
                    InputStream is = getContentResolver().openInputStream(imageUri);
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    anhdaidien.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }else if(requestCode == REQUEST_TAKE_PHOTO){
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                anhdaidien.setImageBitmap(bitmap);
            }
        }
    }

    private void addEvents(){
        btnChonhinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosePhoto();
            }
        });
        btnChuphinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicture();
            }
        });
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update();
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel();
            }
        });
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert();
            }
        });
    }
    private void update(){
        String tennv = ten.getText().toString();
        String sodtnv = sdt.getText().toString();
        byte[] anh = getByteArrayFromImageView(anhdaidien);

        ContentValues contentValues = new ContentValues();
        contentValues.put("Ten", tennv);
        contentValues.put("SDT", sodtnv);
        contentValues.put("Anh", anh);

        SQLiteDatabase database = Database.initDatabase(this, DATABASE_NAME);
        database.update("NhanVien", contentValues, "id = ?", new String[]{id+""});
        Intent intent = new Intent(this, SQLiteManager.class);
        startActivity(intent);
    }
    private void insert(){
        String tennv = ten.getText().toString();
        String sodtnv = sdt.getText().toString();
        byte[] anh = getByteArrayFromImageView(anhdaidien);

        ContentValues contentValues = new ContentValues();
        contentValues.put("Ten", tennv);
        contentValues.put("SDT", sodtnv);
        contentValues.put("Anh", anh);

        SQLiteDatabase database = Database.initDatabase(this, DATABASE_NAME);
        database.insert("NhanVien", null, contentValues);
        Intent intent = new Intent(this, SQLiteManager.class);
        startActivity(intent);
    }
    private void cancel(){
        Intent intent = new Intent(this, SQLiteManager.class);
        startActivity(intent);
    }
    private byte[] getByteArrayFromImageView(ImageView imgv){

        BitmapDrawable drawable = (BitmapDrawable) imgv.getDrawable();
        Bitmap bmp = drawable.getBitmap();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

}
