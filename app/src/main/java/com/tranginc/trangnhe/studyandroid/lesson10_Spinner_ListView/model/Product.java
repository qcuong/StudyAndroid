package com.tranginc.trangnhe.studyandroid.lesson10_Spinner_ListView.model;

/**
 * Created by myema on 14/02/2017.
 */

public class Product extends Goods{
    private Catalog Dmuc;

    public Catalog getDmuc() {
        return Dmuc;
    }

    public void setDmuc(Catalog dmuc) {
        Dmuc = dmuc;
    }

    public Product(String ma, String name, Catalog dmuc) {
        super(ma, name);
        Dmuc = dmuc;
    }

    public Product(String ma, String name) {
        super(ma, name);
    }

    public Product() {
        super();
    }

}
