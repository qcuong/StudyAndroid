package com.tranginc.trangnhe.studyandroid.lesson25_IntentFull.model;

/**
 * Created by myema on 04/05/2017.
 */


//Enum này để thiết lập chức vụ cho nhân viên
//Muốn gán được như thế này: TruongPhong("Trưởng Phòng")
//thì phải có constructor ChucVu(String cv)
public enum ChucVu {
    TruongPhong("Trưởng Phòng"),
    PhoPhong("Phó Phòng"),
    NhanVien("Nhân Viên");

    private String cv;

    ChucVu(String cv) {
        this.cv = cv;
    }

    public String getChucVu() {
        return this.cv;
    }
}
