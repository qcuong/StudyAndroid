package com.tranginc.trangnhe.studyandroid.lesson7_ListAllSensor;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tranginc.trangnhe.studyandroid.R;

import java.util.List;

public class Lesson7MainActivity extends AppCompatActivity {

    private Context mContext;

    private ListView lvAllSensor;

    private List<Sensor> mList;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson07_main);

        mContext = this;

        lvAllSensor = (ListView) findViewById(R.id.lvAllSensor);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        lvAllSensor.setAdapter(new SensorAdapter(Lesson7MainActivity.this, R.layout.sensor_item_layout, mList));
    }

    class SensorAdapter extends ArrayAdapter<Sensor> {

        private List<Sensor> sensorList;
        private int resource;
        private Activity context;

        public SensorAdapter(Activity context, int resource, List<Sensor> sensorList) {
            super(context, resource, sensorList);

            this.sensorList = sensorList;
            this.resource = resource;
            this.context = context;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(resource, null);

            TextView tvName, tvVendor, tvVersion, tvNum;

            tvName = (TextView) convertView.findViewById(R.id.tvName);
            tvVendor = (TextView) convertView.findViewById(R.id.tvVendor);
            tvVersion = (TextView) convertView.findViewById(R.id.tvVersion);

            Sensor sensor = sensorList.get(position);

            tvName.setText(sensor.getName());
            tvVendor.setText("Vendor: " + sensor.getVendor());
            tvVersion.setText("Type  : " + sensor.getStringType());

            return convertView;
        }
    }
}
