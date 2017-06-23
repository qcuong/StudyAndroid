package com.tranginc.trangnhe.studyandroid.lesson;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tranginc.trangnhe.studyandroid.R;

import java.util.ArrayList;

/**
 * Created by myema on 12/02/2017.
 */

public class LessonArrayAdapter extends ArrayAdapter<Lesson> {

    private Activity activity;
    private int resource;
    private ArrayList<Lesson> lessons;

    public LessonArrayAdapter(Activity activity, int resource, ArrayList<Lesson> lessons) {
        super(activity, resource, lessons);
        this.activity = activity;
        this.resource = resource;
        this.lessons = lessons;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (position == 0) {
            LayoutInflater layoutInflater = activity.getLayoutInflater();
            convertView = layoutInflater.inflate(R.layout.main_guide_layout, null);
            return convertView;
        }

        LayoutInflater layoutInflater = activity.getLayoutInflater();
        convertView = layoutInflater.inflate(resource, null);


        if (position == lessons.size() - 1){
            LinearLayout lessonLinear = (LinearLayout) convertView.findViewById(R.id.lessonLinear);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);

            layoutParams.setMargins(30, 0, 30, 30);
            lessonLinear.setLayoutParams(layoutParams);
        }


        TextView titleLesson = (TextView) convertView.findViewById(R.id.titleLesson);
        TextView briefLesson = (TextView) convertView.findViewById(R.id.briefLesson);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

        Lesson lesson = lessons.get(position);

        titleLesson.setText(lesson.getTitle());
        briefLesson.setText(lesson.getBrief());
        imageView.setImageResource(R.drawable.lession);
        return convertView;

    }
}
