package com.tranginc.trangnhe.studyandroid.lesson3_ListView.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.tranginc.trangnhe.studyandroid.R;

import java.util.ArrayList;

public class DuLieuArrayListActivity extends AppCompatActivity {
    private Context mContext;
    private TextView tvSelect;
    private EditText editTen;
    private ListView lvPerson;
    private ArrayList<String> arr = new ArrayList<>();
    private Button btnThem;
    private Toast toast = null;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson03_du_lieu_array_list);
        mContext = this;
        tvSelect = (TextView) findViewById(R.id.tvSelect);
        editTen = (EditText) findViewById(R.id.edTen);
        lvPerson = (ListView) findViewById(R.id.lvPerson);
        btnThem = (Button) findViewById(R.id.btnThem);
        adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, arr);
        lvPerson.setAdapter(adapter);

        btnThem.setOnClickListener(new ThemOnClickListener());
        lvPerson.setOnItemClickListener(new LVItemClickListener());
        lvPerson.setOnItemLongClickListener(new LVItemLongClickListener());
    }

    class ThemOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            String s = editTen.getText().toString();
            if (s.isEmpty()) {
                if (toast != null) {
                    toast.cancel();
                }

                toast = Toast.makeText(mContext, "Ten khong duoc rong", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            arr.add(s);
            adapter.notifyDataSetChanged();
            editTen.requestFocus();
            editTen.selectAll();
        }
    }

    class LVItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            tvSelect.setText("Position: " + position + ";   value = " + arr.get(position));
        }
    }
    class LVItemLongClickListener implements AdapterView.OnItemLongClickListener{
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            final int pos = position;

            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            builder.setTitle("Muốn xóa không");
            builder.setMessage("Muốn xóa không hả?");
            builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    arr.remove(pos);
                    adapter.notifyDataSetChanged();
                }
            });

            builder.create().show();


            return false;
        }
    }
}
