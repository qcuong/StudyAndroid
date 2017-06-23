package com.tranginc.trangnhe.studyandroid.lesson;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by myema on 16/02/2017.
 */

public class Utility {
    public static Toast toast = null;
    public static void showToast(Context context, String msg){
        if(toast != null){
            toast.cancel();
        }
        toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        toast.show();
    }


}
