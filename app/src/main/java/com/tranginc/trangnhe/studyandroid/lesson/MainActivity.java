package com.tranginc.trangnhe.studyandroid.lesson;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tranginc.trangnhe.studyandroid.Lesson20_LayKetQuaTraVeCuaAsyncTask.Lesson20MainActivity;
import com.tranginc.trangnhe.studyandroid.Lesson21KetHopAsyncTaskVaHandler.Lesson21MainActivity;
import com.tranginc.trangnhe.studyandroid.R;
import com.tranginc.trangnhe.studyandroid.lesson10_Spinner_ListView.activity.Lesson10MainActivity;
import com.tranginc.trangnhe.studyandroid.lesson11_AutoCompleteTextView.Lesson11MainActivity;
import com.tranginc.trangnhe.studyandroid.lesson12_UdateDataForAutocompleteTextViewAtRuntime.activity.Lesson12MainActivity;
import com.tranginc.trangnhe.studyandroid.lesson13_GridView.Lesson13MainActivity;
import com.tranginc.trangnhe.studyandroid.lesson14_Intent.Lesson14MainActivity;
import com.tranginc.trangnhe.studyandroid.lesson15_StartActivityForResult.Less15MainActivity;
import com.tranginc.trangnhe.studyandroid.lesson16_Time_DatePickerDialog.Lesson16MainActivity;
import com.tranginc.trangnhe.studyandroid.lesson17_HandlerUsingMessage.Lesson17MainActivity;
import com.tranginc.trangnhe.studyandroid.lesson17_HandlerUsingMessage.Lesson17VeButtonLucRuntime;
import com.tranginc.trangnhe.studyandroid.lesson18_HandlerUsingPost.Lesson18MainActivity;
import com.tranginc.trangnhe.studyandroid.lesson19_AsyncTask.Lesson19MainActivity;
import com.tranginc.trangnhe.studyandroid.lesson23_SQLiteManager.SQLiteManager;
import com.tranginc.trangnhe.studyandroid.lesson24_TabSelector.Lesson24_MainActivity;
import com.tranginc.trangnhe.studyandroid.lesson2_tinh_bmi.TinhBMIActivity;
import com.tranginc.trangnhe.studyandroid.lesson1_tonghaiso.TongHaiSoActivity;
import com.tranginc.trangnhe.studyandroid.lesson3_ListView.activity.Lesson3MainActivity;
import com.tranginc.trangnhe.studyandroid.lesson4_ListViewCustom.activity.Lesson4MainActivity;
import com.tranginc.trangnhe.studyandroid.lesson5_PersonalImformation.Lesson5MainActivity;
import com.tranginc.trangnhe.studyandroid.lesson6_BookStoreOnline.Lesson6MainActivity;
import com.tranginc.trangnhe.studyandroid.lesson7_ListAllSensor.Lesson7MainActivity;
import com.tranginc.trangnhe.studyandroid.lesson8_SensorExample.Lesson8MainActivity;
import com.tranginc.trangnhe.studyandroid.lesson9_Spinner.Lesson9MainActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private ListView lvLesson;

    private ArrayList<Lesson> lessons = new ArrayList<>();
    private LessonArrayAdapter lessonArrayAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        context = this;

        lvLesson = (ListView) findViewById(R.id.lvLesson);

        lessons.add(null);
        lessons.add(new Lesson("Tổng hai số", "EditText, Button, TextView"));
        lessons.add(new Lesson("Tính BMI", "LinearLayout, Toast, AlertDialog, onBackPressed"));
        lessons.add(new Lesson("ListView", "ArrayList Data, Object Data, XML Data, Exist Data"));
        lessons.add(new Lesson("Custom ListView", "Custom ListView"));
        lessons.add(new Lesson("Personal information", "AlertDialog, Radio, CheckBox"));
        lessons.add(new Lesson("BookStore Online", "Pratice TextView, EditText, CheckBox, Button and ImageButton"));
        lessons.add(new Lesson("List all sensor on device", "Sensor, SensorManager"));
        lessons.add(new Lesson("Sensor", "...."));
        lessons.add(new Lesson("Spinner", "Spinner"));
        lessons.add(new Lesson("Spinner and ListView", "Spinner and ListView"));
        lessons.add(new Lesson("Enter the city ", "AutoCompleteTextView, TextWatcher(beforeTextChanged, onTextChanged, afterTextChanged), update autocomplete's source"));
        lessons.add(new Lesson("Udate Data For AutocompleteTextView At Runtime ", "AutocompleteTextView, DatePickerDialog"));
        lessons.add(new Lesson("GridView", "GridView"));
        lessons.add(new Lesson("Intent", "Intent"));
        lessons.add(new Lesson("Intent StartAcitityForResult", "Intent StartAcitityForResult"));
        lessons.add(new Lesson("DatePickerDialog, TimePickerDialog", "DatePickerDialog, TimePickerDialog"));
        lessons.add(new Lesson("Handler", "Handler"));
        lessons.add(new Lesson("HandlerUsingPost", "HandlerUsingPost"));
        lessons.add(new Lesson("Handler Draw Button", "Handler Draw Button"));
        lessons.add(new Lesson("AsyncTask", "AsyncTask"));
        lessons.add(new Lesson("Lấy kết quả trả về từ AsyncTask", "Lấy kết quả trả về từ AsyncTask"));
        lessons.add(new Lesson("Kết hợp AsyncTask và Handler", "Kết hợp AsyncTask và Handler"));
        lessons.add(new Lesson("SQLiteManager", "SQLiteManager"));
        lessons.add(new Lesson("Tab Selector", "Tab Selector"));

        lessonArrayAdapter = new LessonArrayAdapter(MainActivity.this, R.layout.adapter_lessonarray, lessons);
        lvLesson.setAdapter(lessonArrayAdapter);

        lvLesson.setOnItemClickListener(new ItemListener());
    }


    class ItemListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if(position == 1){
                Intent intent = new Intent(context, TongHaiSoActivity.class);
                context.startActivity(intent);
                return;
            }

            if(position == 2){
                Intent intent = new Intent(context, TinhBMIActivity.class);
                context.startActivity(intent);
                return;
            }
            if(position == 3){
                Intent intent = new Intent(context, Lesson3MainActivity.class);
                context.startActivity(intent);
                return;
            }
            if(position == 4){
                Intent intent = new Intent(context, Lesson4MainActivity.class);
                context.startActivity(intent);
                return;
            }
            if(position == 5){
                Intent intent = new Intent(context, Lesson5MainActivity.class);
                context.startActivity(intent);
                return;
            }
            if(position == 6){
                Intent intent = new Intent(context, Lesson6MainActivity.class);
                context.startActivity(intent);
                return;
            }
            if(position == 7){
                Intent intent = new Intent(context, Lesson7MainActivity.class);
                context.startActivity(intent);
                return;
            }
            if(position == 8){
                Intent intent = new Intent(context, Lesson8MainActivity.class);
                context.startActivity(intent);
                return;
            }
            if(position == 9){
                Intent intent = new Intent(context, Lesson9MainActivity.class);
                context.startActivity(intent);
                return;
            }if(position == 10){
                Intent intent = new Intent(context, Lesson10MainActivity.class);
                context.startActivity(intent);
                return;
            }if(position == 11){
                Intent intent = new Intent(context, Lesson11MainActivity.class);
                context.startActivity(intent);
                return;
            }
            if(position == 12){
                Intent intent = new Intent(context, Lesson12MainActivity.class);
                context.startActivity(intent);
                return;
            }
            if(position == 13){
                Intent intent = new Intent(context, Lesson13MainActivity.class);
                context.startActivity(intent);
                return;
            }
            if(position == 14){
                Intent intent = new Intent(context, Lesson14MainActivity.class);
                context.startActivity(intent);
                return;
            }
            if(position == 15){
                Intent intent = new Intent(context, Less15MainActivity.class);
                context.startActivity(intent);
                return;
            }
            if(position == 16){
                Intent intent = new Intent(context, Lesson16MainActivity.class);
                context.startActivity(intent);
                return;
            }
            if(position == 17){
                Intent intent = new Intent(context, Lesson17MainActivity.class);
                context.startActivity(intent);
                return;
            }
            if(position == 18){
                Intent intent = new Intent(context, Lesson18MainActivity.class);
                context.startActivity(intent);
                return;
            }
            if(position == 19){
                Intent intent = new Intent(context, Lesson17VeButtonLucRuntime.class);
                context.startActivity(intent);
                return;
            }
            if(position == 20){
                Intent intent = new Intent(context, Lesson19MainActivity.class);
                context.startActivity(intent);
                return;
            }
            if(position == 21){
                Intent intent = new Intent(context, Lesson20MainActivity.class);
                context.startActivity(intent);
                return;
            }
            if(position == 22){
                Intent intent = new Intent(context, Lesson21MainActivity.class);
                context.startActivity(intent);
                return;
            }
            if(position == 23){
                Intent intent = new Intent(context, SQLiteManager.class);
                context.startActivity(intent);
                return;
            }
            if(position == 24){
                Intent intent = new Intent(context, Lesson24_MainActivity.class);
                context.startActivity(intent);
                return;
            }
        }
    }
}
