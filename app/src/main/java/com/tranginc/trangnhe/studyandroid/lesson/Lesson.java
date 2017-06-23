package com.tranginc.trangnhe.studyandroid.lesson;

/**
 * Created by myema on 12/02/2017.
 */

public class Lesson {
    private String title;
    private String brief;

    public Lesson(String title, String brief) {
        this.brief = brief;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }
}
