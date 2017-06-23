package com.tranginc.trangnhe.studyandroid.lesson19_AsyncTask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.tranginc.trangnhe.studyandroid.R;

/**
 * Created by Trang Nhe on 13/03/2017.
 */

public class MyAsyncTask extends AsyncTask<Void, Integer, Void>{
    Activity contextcha;
    public MyAsyncTask(Activity contextcha) {
        super();
        this.contextcha = contextcha;
    }

    @Override
    protected void onPreExecute() {//ham nay duoc goi dau tien
        super.onPreExecute();
        Toast.makeText(contextcha, "OnPreExecute", Toast.LENGTH_LONG).show();
    }
    @Override
    protected Void doInBackground(Void... voids) {//sau đó tới hàm doInBackground tuyệt đối không được cập nhật giao diện trong hàm này
        for(int i = 1; i <= 100; i++){
            SystemClock.sleep(100);//nghỉ 100 milisecond thì tiến hành update UI
            publishProgress(i);//khi gọi hàm này thì onProgressUpdate sẽ thực thi

        }
        return null;
    }
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        //thông qua contextCha để lấy được control trong MainActivity
        ProgressBar bar = (ProgressBar) contextcha.findViewById(R.id.progressBar1);

        //vì publishProgress chỉ truyền 1 đối số nên mảng values chỉ có 1 phần tử
        int chiso = values[0];
        bar.setProgress(chiso); //tăng giá trị của Progressbar lên

        TextView tv = (TextView)contextcha.findViewById(R.id.tvphantram);
        tv.setText(chiso+"%");//đồng thời hiện thị giá trị là % lên TextView
    }
    @Override
    protected void onPostExecute(Void aVoid) {//sau khi tiến trình thực hiện xong thì hàm này sảy ra
        super.onPostExecute(aVoid);
        Toast.makeText(contextcha, "onPostExecute", Toast.LENGTH_LONG).show();
    }

}
