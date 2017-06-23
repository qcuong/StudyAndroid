package com.tranginc.trangnhe.studyandroid.lesson23_SQLiteManager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.tranginc.trangnhe.studyandroid.R;

import java.util.ArrayList;

public class SQLiteManager extends AppCompatActivity {
    final String DATABASE_NAME = "EmployeeDB.sqlite";
    SQLiteDatabase database;
    ListView listView;
    ArrayList<NhanVien> list;
    AdapterNhanVien adapterNhanVien;

    Button them;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson23_sqlite_manager);
        addControls();
        readData();
    }

    private void addControls() {
        listView = (ListView)findViewById(R.id.listnhanvien);
        them = (Button)findViewById(R.id.btnthemnv1);
        list = new ArrayList<>();
        adapterNhanVien = new AdapterNhanVien(this, list);//khoi tao adapter
        listView.setAdapter(adapterNhanVien);//set adapter cho listview

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SQLiteManager.this, UpdateActivity.class);
                startActivity(intent);
            }
        });
    }

    private void readData(){
        database = Database.initDatabase(this, DATABASE_NAME);
        //Khai bao mot con tro, chua tro vao dong nao ca
        //Cau lenh truy van tra ve cac dong du lieu
        Cursor cursor = database.rawQuery("SELECT * FROM NhanVien", null);
        //dat con tro tro vao dong dau tien cua database
        //cursor.moveToFirst();

        //Truoc khi doc du lieu vao thi xoa all du lieu di de khong trung du lieu
        list.clear();
        for(int i=0; i< cursor.getCount(); i++){
            cursor.moveToPosition(i);
            int id = cursor.getInt(0);
            String ten = cursor.getString(1);
            String sdt = cursor.getString(2);
            byte[] anh = cursor.getBlob(3);

            NhanVien nv = new NhanVien(id, ten, sdt, anh);
            list.add(nv);
            //adapter ve lai giao dien
            adapterNhanVien.notifyDataSetChanged();
        }
    }

}
