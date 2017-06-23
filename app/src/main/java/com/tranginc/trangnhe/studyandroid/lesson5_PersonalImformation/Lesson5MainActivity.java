package com.tranginc.trangnhe.studyandroid.lesson5_PersonalImformation;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.tranginc.trangnhe.studyandroid.R;

public class Lesson5MainActivity extends AppCompatActivity {

    private EditText editten, editcmt, editthongtin;
    private RadioGroup rgbangcap;
    private CheckBox cbdoccoding, cbdocsach, cbdocbao;
    private Button btnGui;
    private Context myContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson05_main);
        setTitle("Thông tin cá nhân");

        editten = (EditText) findViewById(R.id.editten);
        editcmt = (EditText) findViewById(R.id.editcmt);
        editthongtin = (EditText) findViewById(R.id.editthongtin);
        cbdoccoding = (CheckBox) findViewById(R.id.cbdoccoding);
        cbdocsach = (CheckBox) findViewById(R.id.cbdocsach);
        cbdocbao = (CheckBox) findViewById(R.id.cbdocbao);
        btnGui = (Button) findViewById(R.id.btnGui);
        myContext = this;
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doShowInformation();
            }
        });
    }

    public void doShowInformation(){

        //Kiem tra ten
        String ten = editten.getText().toString()+"";
        ten = ten.trim();
        if(ten.length() < 3){
            editten.requestFocus();
            editten.selectAll();
            Toast.makeText(this, "Ten phai lon hon hoac bang 3 ki tu", Toast.LENGTH_SHORT).show();
            return;
        }

        //Kiem tra cmt
        String cmt = editcmt.getText().toString()+"";
        cmt = cmt.trim();
        if(cmt.length() != 9){
            editcmt.requestFocus();
            editcmt.selectAll();
            Toast.makeText(this, "CMTND phai dung 9 ki tu", Toast.LENGTH_SHORT).show();
            return;
        }


        //Kiem tra radio bang cap
        rgbangcap = (RadioGroup) findViewById(R.id.rgbangcap);
        int chiso = rgbangcap.getCheckedRadioButtonId();
        if(chiso == -1){
            Toast.makeText(this, "Phai chon bang cap", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton rad = (RadioButton)findViewById(chiso);
        String bang = rad.getText()+"";


        //Kiem tra checkbox so thich
        String sothich = "";
        if(cbdocbao.isChecked()){
            sothich += "\n" + "\t" + cbdocbao.getText()+"\n";
        }
        if(cbdoccoding.isChecked()){
            sothich += "\t" +  cbdoccoding.getText()+"\n";
        }
        if(cbdocsach.isChecked()){
            sothich += "\t" + cbdocsach.getText()+"\n";
        }

        //Thong tin bo sung
        String bosung = editthongtin.getText()+"";

        //Hien thi dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thong tin ca nhan");
        builder.setPositiveButton("Dong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }) ;


        //Tao noi dung;
        String msg = "Ten: " + ten+"\n" + "CMTND: "+cmt+"\n" + "Bang cap: " + bang+"\n" + "So thich: " +sothich+"------------\n"
                +"Thong tin bo sung:\n"+ bosung+"\n"+"--------------";
        builder.setMessage(msg);//Thiet lap noi dung
        builder.create().show();//Hien thi Dialog

    }

}
