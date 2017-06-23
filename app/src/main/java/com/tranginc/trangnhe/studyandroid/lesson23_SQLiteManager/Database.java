package com.tranginc.trangnhe.studyandroid.lesson23_SQLiteManager;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Trang Nhe on 25/04/2017.
 */

public class Database {
    //Cai dat database cho activity (Copy file sqlite tu trong thu muc assets cua project sang thu muc ung dung cua ta)
    public static SQLiteDatabase initDatabase(Activity activity, String databaseName){
        try {
            //Duong dan den thu muc data cua ung dung -> thu muc luu tru cac database -> den file databaseName
            String outFileName = activity.getApplicationInfo().dataDir + "/databases/" + databaseName;
            File f = new File(outFileName);
            //Kiem tra database da ton tai chua, neu chua thi copy database do
            if(!f.exists()) {
                // mo databaseName cua ta o thu muc assets
                InputStream e = activity.getAssets().open(databaseName);
                //Tao folder de chua database do
                File folder = new File(activity.getApplicationInfo().dataDir + "/databases/");
                if (!folder.exists()) {
                    folder.mkdir();
                }

                //Mo mot FileOutputstream myOutput
                FileOutputStream myOutput = new FileOutputStream(outFileName);
                byte[] buffer = new byte[1024];

                int length;
                //doc tat ca du lieu tu InputStream e vao myOutput
                while ((length = e.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }
                myOutput.flush();
                myOutput.close();
                e.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return activity.openOrCreateDatabase(databaseName, Context.MODE_PRIVATE, null);
    }
}
