package com.tranginc.trangnhe.studyandroid.lesson16_Time_DatePickerDialog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.tranginc.trangnhe.studyandroid.R;
import com.tranginc.trangnhe.studyandroid.lesson16_Time_DatePickerDialog.model.JobInWeek;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Lesson16MainActivity extends AppCompatActivity {
    TextView txtDate, txtTime;
    EditText editCv, editNd;
    Button btnDate, btnTime, btnAdd;
    ListView lvCv;
    Calendar cal;
    Date dateFinish;
    Date hourFinish;

    ArrayList<JobInWeek> arr = new ArrayList<>();
    ArrayAdapter<JobInWeek> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson16_main);
        getcontrols();
        getDefaultInfor();//Hàm lấy các thông số mặc định khi lần đầu tiền chạy ứng dụng
        addEvents();
    }

    private void addEvents() {
        btnDate.setOnClickListener(new MyButtonEvent());
        btnTime.setOnClickListener(new MyButtonEvent());
        btnAdd.setOnClickListener(new MyButtonEvent());
        lvCv.setOnItemClickListener(new MyListViewEvent());
        lvCv.setOnItemLongClickListener(new MyListViewEvent());
    }

    private void getDefaultInfor() {
        //lấy ngày hiện tại của hệ thống
        cal = Calendar.getInstance();
        SimpleDateFormat dft = null;

        //Định dạng ngày/tháng/năm
        dft = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dft.format(cal.getTime());

        //hiển thị lên giao diện
        txtDate.setText(strDate);

        //định dạng giờ/phút am/pm
        dft = new SimpleDateFormat("hh:mm:a");
        String strTime = dft.format(cal.getTime());

        txtTime.setText(strTime);

        //lấy giờ 24h để lập trình theo Tag
        dft = new SimpleDateFormat("HH:mm");
        txtTime.setTag(dft.format(cal.getTime()));


        editCv.requestFocus();
        //gán cal.getTime() cho ngày hoàn thành và giờ hoàn thành
        dateFinish = cal.getTime();
        hourFinish = cal.getTime();

    }

    private void getcontrols() {
        txtDate = (TextView) findViewById(R.id.edngayht);
        txtTime = (TextView) findViewById(R.id.edgioht);
        editCv = (EditText) findViewById(R.id.edcv);
        editNd = (EditText) findViewById(R.id.ednd);
        btnDate = (Button) findViewById(R.id.btnDate);
        btnTime = (Button) findViewById(R.id.btnTime);
        btnAdd = (Button) findViewById(R.id.btThemCV);
        lvCv = (ListView) findViewById(R.id.lvCV1);

        adapter = new ArrayAdapter<JobInWeek>(Lesson16MainActivity.this, android.R.layout.simple_list_item_1, arr);
        lvCv.setAdapter(adapter);
    }

    private class MyButtonEvent implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnDate:
                    showDatePickerDialog();
                    break;
                case R.id.btnTime:
                    showTimePickerDialog();
                    break;
                case R.id.btThemCV:
                    addCV();
                    break;
            }

        }
    }

    private void addCV() {
        String title=editCv.getText()+"";
        String description=editNd.getText()+"";
        JobInWeek job=new JobInWeek(title, description, dateFinish, hourFinish);
        arr.add(job);
        adapter.notifyDataSetChanged();
        //sau khi cập nhật thì reset dữ liệu và cho focus tới editCV
        editCv.setText("");
        editNd.setText("");
        editCv.requestFocus();
    }

    private void showTimePickerDialog() {
        //callback listener rất là hữu dụng, dựa vào nó mà ta luôn kiểm tra được sự thay đổi dữ liệu trong các Dialog
        TimePickerDialog.OnTimeSetListener callback = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //Xử lý lưu giờ và am, pm
                String s = hourOfDay+":"+minute;
                int hourtam = hourOfDay;
                if(hourtam > 12){
                    hourtam -= 12;
                }
                txtTime.setText(hourtam+":"+minute+(hourOfDay>12?" PM":" AM"));
                //luu gio thuc vao Tag
                txtTime.setTag(s);

                //luu vet lai gio vao hourFinish
                cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
                cal.set(Calendar.MINUTE, minute);
                hourFinish = cal.getTime();
            }
        };

        //các lệnh dưới này xử lý ngày giờ trong TimePickerDialog
        //sẽ giống với trên TextView khi mở nó lên
        String s = txtTime.getTag().toString();
        String strarr[] = s.split(":");
        int gio = Integer.parseInt(strarr[0]);
        int phut = Integer.parseInt(strarr[1]);
        TimePickerDialog time = new TimePickerDialog(Lesson16MainActivity.this, callback, gio, phut, true);
        time.setTitle("Chọn giờ hoàn thành");
        time.show();

    }

    private void showDatePickerDialog() {
        DatePickerDialog.OnDateSetListener callback = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //Mỗi lần thay đổi ngày tháng năm thì cập nhật lại TextView Date
                txtDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);

                //Lưu vết lại biến ngày hoàn thành
                cal.set(year, month, dayOfMonth);
                dateFinish = cal.getTime();
            }
        };
        //các lệnh dưới này xử lý ngày giờ trong DatePickerDialog
        //sẽ giống với trên TextView khi mở nó lên
        String s = txtDate.getText().toString();
        String strArrtmp[] = s.split("/");

        int ngay = Integer.parseInt(strArrtmp[0]);
        int thang = Integer.parseInt(strArrtmp[1]) -1;
        int nam = Integer.parseInt(strArrtmp[2]);
        DatePickerDialog pic = new DatePickerDialog(Lesson16MainActivity.this, callback, nam, thang, ngay);
        pic.setTitle("Chọn ngày hoàn thành");
        pic.show();


    }

    private class MyListViewEvent implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(Lesson16MainActivity.this, arr.get(position).getDesciption(), Toast.LENGTH_LONG).show();
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            arr.remove(arr.get(position));
            adapter.notifyDataSetChanged();
            return false;
        }
    }
}
