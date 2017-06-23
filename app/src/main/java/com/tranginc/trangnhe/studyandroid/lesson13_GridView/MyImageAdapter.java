package com.tranginc.trangnhe.studyandroid.lesson13_GridView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.tranginc.trangnhe.studyandroid.lesson12_UdateDataForAutocompleteTextViewAtRuntime.model.MyArrayAdapter;

/**
 * Created by myema on 17/02/2017.
 */

public class MyImageAdapter extends BaseAdapter{

    private Context context;
    private Integer []mThumbIds;


    public MyImageAdapter(Context context) {
        this.context = context;
    }

    public MyImageAdapter(Context context, Integer[] mThumbIds) {
        this.context = context;
        this.mThumbIds = mThumbIds;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null){
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8,8);
        }else{
            imageView = (ImageView) convertView;
        }
        //lấy đúng vị trí hình ảnh được chọn
        //gán lại ImageResource
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
}
