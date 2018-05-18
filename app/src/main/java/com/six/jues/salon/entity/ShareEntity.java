package com.six.jues.salon.entity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Android Studio .
 * 作者：zhong
 * 日期：2018/5/15
 * 邮箱：15206394364@163.com
 * 介绍：
 * 修订：====================
 */
public class ShareEntity {
    private String title;
    private String description;
    private String url;
    private Bitmap image;
    private String text;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Resources res, int id) {
        this.image = BitmapFactory.decodeResource(res, id);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
