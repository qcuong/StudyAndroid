package com.tranginc.trangnhe.studyandroid.lesson11_AutoCompleteTextView;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.tranginc.trangnhe.studyandroid.R;
import com.tranginc.trangnhe.studyandroid.lesson.Utility;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Lesson11MainActivity extends AppCompatActivity {

    private AutoCompleteTextView singleComplete;
    private ListView lvCity;
    private Button btnOK;
    private Context mContext;

    private ArrayAdapter<String> lvCityAdapter = null;
    private ArrayAdapter<String> singleCompleteAdapter = null;


    private ArrayList<String> cities = new ArrayList<>();

    private ArrayList<String> arrayresult = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson11_main);
        mContext = this;
        cities.add("Hà Nội");
        cities.add("Huế");
        cities.add("Sài Gòn");
        cities.add("Hà Giang");
        cities.add("Hội An");
        cities.add("Kiên Giang");
        cities.add("Lâm Dồng");
        cities.add("Long Khánh");

        singleComplete = (AutoCompleteTextView) findViewById(R.id.autoCity);
        lvCity = (ListView) findViewById(R.id.lvCity);
        btnOK = (Button) findViewById(R.id.btnOK);


        // set adapter for listview
        lvCityAdapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1,arrayresult);
        lvCity.setAdapter(lvCityAdapter);

        // set adapter for auto
        singleCompleteAdapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, cities);
        singleComplete.setAdapter(singleCompleteAdapter);

        singleComplete.addTextChangedListener(new MyTextWatcher());
        btnOK.setOnClickListener(new ButtonOkOnclick());
        singleComplete.setOnItemClickListener(new SingleCompleteOnClick());
    }


    private class MyTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Log.i("Trangnhe", "Before---" + singleComplete.getText().toString());
        }

        @Override
        public void onTextChanged(CharSequence s1, int start, int before, int count) {
            Log.i("Trangnhe", "On---" + singleComplete.getText().toString());
        }

        @Override
        public void afterTextChanged(Editable s) {
            Log.i("Trangnhe", "After---" + singleComplete.getText().toString());
        }
    }

    private class ButtonOkOnclick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String s = singleComplete.getText().toString();
            if(s.isEmpty()){
                return;
            }

            if(!cities.contains(s)){
                cities.add(s);
                singleCompleteAdapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, cities);
                singleComplete.setAdapter(singleCompleteAdapter);
            }

            arrayresult.add(s);
            lvCityAdapter.notifyDataSetChanged();
            singleComplete.setText("");
            singleComplete.requestFocus();
        }
    }

    private class SingleCompleteOnClick implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String s = singleComplete.getText().toString();
            if(s.isEmpty()){
                return;
            }
            arrayresult.add(s);
            lvCityAdapter.notifyDataSetChanged();
            //singleComplete.setText("");
            singleComplete.requestFocus();
        }
    }
}
