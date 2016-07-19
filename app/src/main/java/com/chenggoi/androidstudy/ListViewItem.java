package com.chenggoi.androidstudy;

import android.widget.ListView;

/**
 * Created by chenggoi on 16-7-19.
 */

public class ListViewItem {
    private String name;
    private int imgId;

    public ListViewItem(String name, int imgId) {
        this.name = name;
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public int getImgId() {
        return imgId;
    }
}
