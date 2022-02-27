package com.eict.webbrowserapp;

import androidx.annotation.DrawableRes;

public class DefaultUrlEntity {

    private String name;

    private String url_name;
    private @DrawableRes int image_res;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl_name() {
        return url_name;
    }

    public void setUrl_name(String url_name) {
        this.url_name = url_name;
    }

    public int getImage_res() {
        return image_res;
    }

    public void setImage_res(int image_res) {
        this.image_res = image_res;
    }
}
