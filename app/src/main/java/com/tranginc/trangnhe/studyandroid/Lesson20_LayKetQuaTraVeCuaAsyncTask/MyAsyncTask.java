package com.tranginc.trangnhe.studyandroid.Lesson20_LayKetQuaTraVeCuaAsyncTask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.tranginc.trangnhe.studyandroid.R;

import java.util.ArrayList;

/**
 * Created by Trang Nhe on 13/03/2017.
 */

/**
 * AsyncTask<Integer, Integer, ArrayList<Integer>>
 * Integer: Truyền vào lúc thực thi tiến trình
 * Integer: Giá trị để Cập nhật giao diện
 * ArrayList<Integer>: Kết quả trả về sau khi kết thúc tiến trình
 */
public class MyAsyncTask extends AsyncTask<Integer, Integer, ArrayList<Integer>> {

    Activity activityCha;
    ListView lv = null;
    ArrayList<Integer> arrCuaListview = new ArrayList<Integer>();
    ArrayAdapter<Integer> adapterCuaListview = null;

    public MyAsyncTask(Activity activityCha) {
        super();

        this.activityCha = activityCha;
        lv = (ListView) activityCha.findViewById(R.id.listView1);
        adapterCuaListview = new ArrayAdapter<Integer>(activityCha, android.R.layout.simple_list_item_1, arrCuaListview);
        lv.setAdapter(adapterCuaListview); //gán Adapter cho listview
    }

    public int fib(int n) {
        if (n <= 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //muốn khởi tạo gì đó trước khi thực thi thì có thể làm ở đây
        Toast.makeText(activityCha, "Bắt đầu chạy tiến trình ", Toast.LENGTH_LONG).show();
    }

    @Override
    protected ArrayList<Integer> doInBackground(Integer... integers) {
        int so = integers[0]; //khi bắt đầu thực thi đối số 1 sẽ ở đây: integers[0]

        ArrayList<Integer> arrTongCacSoFib = new ArrayList<Integer>(); //khai báo ArrayList lưu trữ tập các số nguyên

        for (int i = 1; i <= so; i++) {
            SystemClock.sleep(150);
            int f = fib(i);//lấy số fibonacci tại vị trí thứ i
            arrTongCacSoFib.add(f); //lưu vào danh sách
            publishProgress(f); //cập nhập số fibonacci lên listview

        }
        //trả về danh sách, nó sẽ được lưu trữ trong hàm onPostExecute
        return arrTongCacSoFib;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        arrCuaListview.add(values[0]);//lấy giá trị truyền từ publishProgress
        adapterCuaListview.notifyDataSetChanged();//cập nhật lại giao diện
    }


    //integers chính là ArrayList lưu trữ chuỗi Fibonacci
    @Override
    protected void onPostExecute(ArrayList<Integer> integers) {
        super.onPostExecute(integers);
        int tong = 0;
        for (int v : integers) {
            tong += v;
        }
        Toast.makeText(activityCha, "Tong =" + tong, Toast.LENGTH_LONG).show();
        TextView txt = (TextView) activityCha.findViewById(R.id.textView1);
        txt.setText(tong + "");
    }

}
