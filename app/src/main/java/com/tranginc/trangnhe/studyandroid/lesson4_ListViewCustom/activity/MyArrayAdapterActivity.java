package com.tranginc.trangnhe.studyandroid.lesson4_ListViewCustom.activity;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tranginc.trangnhe.studyandroid.R;
import com.tranginc.trangnhe.studyandroid.lesson4_ListViewCustom.model.Employee;

import java.util.ArrayList;

/**
 * Created by myema on 12/02/2017.
 */

public class MyArrayAdapterActivity extends ArrayAdapter<Employee> {
    private ImageView imageView;
    private TextView textView;

    Activity context = null;
    ArrayList<Employee> myArray = null;
    int layoutId;

    /**
     * Constructor này dùng để khởi tạo các giá trị từ MainActivity truyền vào
     *
     * @param context  : là Activity từ Main
     * @param layoutId : Là layout custom do ta tạo (my_item_layout.xml)
     * @param arr      : Danh sách nhân viên truyền từ Main
     */
    public MyArrayAdapterActivity(Activity context, int layoutId, ArrayList<Employee> arr) {
        super(context, layoutId, arr);
        this.context = context;
        this.myArray = arr;
        this.layoutId = layoutId;
    }


    /**
     * hàm dùng để custom layout, ta phải override lại hàm này từ MainActivity truyền vào
     *
     * @param position    : là vị trí của phần tử trong danh sách nhân viên
     * @param convertView : convertView, dùng nó để xử lý Item
     * @param parent      : Danh sách nhân viên truyền từ Main
     * @return View        : trả về chính convertView
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /**
         * bạn chú ý là ở đây Tôi không làm:
         * if(convertView == null)
         * {
         *      LayoutInflater inflater=
         *      context.getLayoutInflater();
         *      convertView=inflater.inflate(layoutId, null);
         * }
         * Lý do là ta phải xử lý xóa phần tử Checked, nếu dùng If thì nó lại checked cho các phần tử khác sau khi xóa
         * vì convertView lưu lại trạng thái trước đó
         */

        /*
        Layout XML files >> LayoutInflater >> View objects (Sử dụng được trong code Java)
        Khởi tạo một tệp tin XML bố trí vào các đối tượng {@link android.view.View} tương ứng.
        Nó dùng để inflate (bơm, nạp...) cái phần XML (Phần giao diện) vào View.
        Giả sử bạn muốn tạo một cái view, thì để biết cái view đó đang chịu trách nhiệm phần giao diện nào (XML)
            thì bạn phải inflate cái XML đó vào view.
        Một trường hợp rất thường gặp là khi bạn hiện thực CustomAdapter cho ListView. Trong method getView(),
            bạn cần phải inflate cái XML (ở đây là layout cho item) vào biến convertView thì ListView mới biết là
            phần giao diện nào của item cần được thể hiện ra màn hình.
        Lớp LayoutInflater này rất hữu ích nếu bạn dùng để tạo giao diện linh hoạt (có thể thêm bớt các view vào root view) chỉ
            bằng code thuần
       */

        //Sẽ trả ra một class inflate của thiết bị.
        LayoutInflater inflater = context.getLayoutInflater();
        //Sẽ trả ra 1 view được tạo ra tự động bằng cách truyền file xml R.layout.list_item vào cùng context
        //là ViewGroup sẽ dùng để chứa file layout.
        convertView = inflater.inflate(layoutId, null);

        if (myArray.size() > 0 && position >= 0) {
            textView = (TextView) convertView.findViewById(R.id.textView1);
            imageView = (ImageView) convertView.findViewById(R.id.image);
            Employee emp = myArray.get(position);

            textView.setText(emp.toString());

            if (emp.isGender()) {
                imageView.setImageResource(R.drawable.nu);
            } else {
                imageView.setImageResource(R.drawable.nam);
            }
        }
        return convertView;
    }
}