package com.tranginc.trangnhe.studyandroid.Lesson21KetHopAsyncTaskVaHandler;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.tranginc.trangnhe.studyandroid.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Trang Nhe on 13/03/2017.
 */

public class MyAsyncTask extends AsyncTask<Integer, Integer, ArrayList<Integer>> {

    private LinearLayout llrandom, llprime;
    private Random rd = new Random();
    private Activity context;

    public MyAsyncTask(Activity activity) {
        super();
        this.context = activity;

        //lấy các control trong MainThread
        this.llrandom = (LinearLayout) context.findViewById(R.id.llrandomnumber);
        this.llprime = (LinearLayout) context.findViewById(R.id.llprimenumber);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(context, "Start here", Toast.LENGTH_SHORT).show();
        //khi bắt đầu thực thi tiến trình thì tiến hành xóa toàn bộ control bên trong
        this.llrandom.removeAllViews();
        this.llprime.removeAllViews();
    }

    @Override
    protected ArrayList<Integer> doInBackground(Integer... integers) {

        ArrayList<Integer> list = new ArrayList<Integer>();//danh sach so nguyen to

        int step = 1;
        int n = integers[0];
        while (isCancelled() == false && step <= n) {//vòng lặp chạy hết n số button truyền vào

            step++;
            SystemClock.sleep(100);

            int x = rd.nextInt(100) + 1;//lấy số ngẫu nhiên

            publishProgress(x);//gọi cập nhật giao diện

            if (isPrime(x))//nếu là số nguyên tố thì lưu vào danh sách
                list.add(x);
        }

        return list;//trả về danh sách số nguyên tố
    }

    private boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public void doRawPrime(int x) {//hàm vẽ các Button là chứa các số nguyên tố

        Button btn = new Button(context);
        btn.setWidth(100);
        btn.setHeight(30);
        btn.setText(x + "");

        this.llprime.addView(btn);//đưa Button vào view bên phải màn hình
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        Integer item = values[0];//lấy giá trị truyền vào trong doInBackground

        Button btn = new Button(context);//tạo Button với Text có giá trị là số ngẫu nhiên
        btn.setWidth(100);
        btn.setHeight(30);
        btn.setText(item + "");

        this.llrandom.addView(btn);//đưa button lên view bên trái màn hình
    }

    @Override
    protected void onPostExecute(ArrayList<Integer> integers) {
        super.onPostExecute(integers);

        final ArrayList<Integer> list = integers;//sau khi tiến trình kết thúc thì hàm này sẽ được thực thi lấy về danh sách các số nguyên tố

        final Handler handler = new Handler();//tiến hành dùng Handler class để thực hiện
        Thread th = new Thread(new Runnable() {
            public void run() {

                for (int i = 0; i < list.size(); i++) {//lặp để vẽ các Button là số nguyên tố
                    final int x = list.get(i);
                    SystemClock.sleep(100);
                    handler.post(new Runnable() {
                        public void run() {
                            doRawPrime(x);
                        }
                    });
                }
                handler.post(new Runnable() {
                    public void run() {
                        Toast.makeText(context, "Finish", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        th.start();
    }
}
