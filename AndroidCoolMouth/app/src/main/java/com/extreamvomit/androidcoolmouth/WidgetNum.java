package com.extreamvomit.androidcoolmouth;

import java.io.Serializable;

/**
 * Created by vesp on 15/12/23.
 */
public class WidgetNum implements Serializable {
    private static final long serialVersionUID = 1L; //シリアルバージョンID

    private int appWidgetId = -1;
    private String string_;
    private int number_;

    public String getString() {
        return string_;
    }

    public void setString(String string) {
        string_ = string;
    }

    public int getNumber() {
        return number_;
    }

    public void setNumber(int number) {
        number_ = number;
    }
}
