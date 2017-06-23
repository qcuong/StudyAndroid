package com.tranginc.trangnhe.studyandroid.lesson10_Spinner_ListView.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.tranginc.trangnhe.studyandroid.R;
import com.tranginc.trangnhe.studyandroid.lesson10_Spinner_ListView.model.Catalog;
import com.tranginc.trangnhe.studyandroid.lesson10_Spinner_ListView.model.Product;

import java.util.ArrayList;

public class Lesson10MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private EditText masp, tensp;
    private ListView listView;
    private Button button;
    private Toast t;


    private ArrayList<Catalog> arraySpinner = new ArrayList<>();
    private ArrayAdapter<Catalog> adapterspinner = null;

    private ArrayList<Product> arraylistListview = new ArrayList<>();
    private ArrayAdapter<Product> adapterListview = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson10_main);


        getControl();
        fakeDataCatalog();
        processEvent();


    }

    public void getControl() {
        spinner = (Spinner) findViewById(R.id.spindanhmuc);
        masp = (EditText) findViewById(R.id.editmasp);
        tensp = (EditText) findViewById(R.id.edittensp);
        listView = (ListView) findViewById(R.id.listdanhsach);
        button = (Button) findViewById(R.id.buttonNhapSP);

        adapterspinner = new ArrayAdapter<Catalog>(Lesson10MainActivity.this, android.R.layout.simple_spinner_item, arraySpinner);
        adapterspinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterspinner);

        adapterListview = new ArrayAdapter<Product>(Lesson10MainActivity.this, android.R.layout.simple_list_item_1, arraylistListview);
        listView.setAdapter(adapterListview);


    }

    public void fakeDataCatalog() {
        Catalog cat1 = new Catalog("1", "SamSung");
        Catalog cat2 = new Catalog("2", "Iphone");
        Catalog cat3 = new Catalog("3", "Ipad");
        arraySpinner.add(cat1);
        arraySpinner.add(cat2);
        arraySpinner.add(cat3);
        adapterspinner.notifyDataSetChanged();
    }


    public void processEvent() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ma = masp.getText().toString();
                String ten = tensp.getText().toString();

                if (ma.isEmpty()) {
                    if (t != null)
                        t.cancel();
                    t = Toast.makeText(Lesson10MainActivity.this, "Mã không để trống", Toast.LENGTH_SHORT);
                    t.show();
                    return;
                }


                if (ten.isEmpty()) {
                    if (t != null)
                        t.cancel();
                    t = Toast.makeText(Lesson10MainActivity.this, "Tên không để trống", Toast.LENGTH_SHORT);
                    t.show();
                    return;
                }

                Product p = new Product(ma, ten);
                Catalog c = (Catalog) spinner.getSelectedItem();
                c.addProduct(p);
                loadListView(c);

                masp.setText("");
                masp.requestFocus();
                tensp.setText("");
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                loadListView(arraySpinner.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void loadListView(Catalog c) {
        arraylistListview.clear();
        arraylistListview.addAll(c.getListProduct());
        adapterListview.notifyDataSetChanged();
    }
}
