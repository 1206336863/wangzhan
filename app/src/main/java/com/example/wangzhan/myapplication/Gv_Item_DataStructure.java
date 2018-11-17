package com.example.wangzhan.myapplication;

import java.io.Serializable;

public class Gv_Item_DataStructure  implements Serializable {
    private String title,discount;
    private  int imageId;

    public Gv_Item_DataStructure(String title, String discount, int imageId) {
        this.title = title;
        this.discount = discount;
        this.imageId = imageId;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getTitle() {
        return title;
    }

    public String getDiscount() {
        return discount;
    }

    public int getImageId() {
        return imageId;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
