package com.tranginc.trangnhe.studyandroid.lesson23_SQLiteManager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tranginc.trangnhe.studyandroid.R;

import java.util.ArrayList;

/**
 * Created by Trang Nhe on 25/04/2017.
 */

public class AdapterNhanVien extends BaseAdapter {
    //Activity la lop con cua Context
    Activity context;
    ArrayList<NhanVien> list;

    public AdapterNhanVien(Activity context, ArrayList<NhanVien> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    //so dong duoc adapter ve, truong hop list qua nhieu nhan vien thi khong nen tra ve size de phat sinh loi tran bo nho
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //Truyen layout cua mot row cho mot bien View
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.activity_lesson23_row, null);

        ImageView img = (ImageView) row.findViewById(R.id.anhnhanvien);
        TextView id = (TextView) row.findViewById(R.id.txtid);
        TextView ten = (TextView) row.findViewById(R.id.txtten);
        TextView sdt = (TextView) row.findViewById(R.id.txtsdt);
        Button sua = (Button) row.findViewById(R.id.btnsua);
        Button xoa = (Button) row.findViewById(R.id.btnxoa);

        //Ung voi moi View lay ra mot nhan vien de xet len giao dien
        final NhanVien nv = list.get(i);

        id.setText(nv.id+"");
        ten.setText(nv.ten);
        sdt.setText(nv.sdt);
        //Voi hinh anh thi dau tien phai decode no thanh bitmap
        //3 ts: mang byte, vi tri bat dau, chieu dai
        Bitmap hinhanh = BitmapFactory.decodeByteArray(nv.anh, 0, nv.anh.length);

        //set hinh len
        img.setImageBitmap(hinhanh);

        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //context la SQLiteManager se goi UpdateActivity
                Intent intent = new Intent(context, UpdateActivity.class);

                intent.putExtra("ID",nv.id);
                //startActivity khong phai la phuong thuc cua AdapterNhanVien ma la cua MainActivity(hay la AppCompatActivity)
                context.startActivity(intent);
            }
        });

        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder= new AlertDialog.Builder(context);
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setTitle("Xác nhận xóa");
                builder.setMessage("Bạn có chắc muốn xóa nhân viên này?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        delete(nv.id);
                    }
                });
                
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
                        
            }
        });

        return row;
    }

    private void delete(int id) {
        SQLiteDatabase database = Database.initDatabase(context, "EmployeeDB.sqlite");
        database.delete("NhanVien", "ID = ?", new String[]{id+""});
        list.clear();

        Cursor cursor = database.rawQuery("SELECT *FROM NhanVien", null);
        while(cursor.moveToNext()){
            int idnv = cursor.getInt(0);
            String tennv = cursor.getString(1);
            String sdtnv = cursor.getString(2);
            byte[] anh = cursor.getBlob(3);
            list.add(new NhanVien(idnv, tennv, sdtnv, anh));
            notifyDataSetChanged();
        }
    }
}
