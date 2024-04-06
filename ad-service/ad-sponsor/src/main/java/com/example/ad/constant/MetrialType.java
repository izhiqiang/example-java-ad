package com.example.ad.constant;

import lombok.Getter;

@Getter
public enum MetrialType {

    JPG(1, "jpg"),

    BMP(2, "bmp"),

    MP4(3, "mp4"),

    AVI(4, "avi"),

    TXT(5, "txt");
    private int type;

    private String desc;

    MetrialType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
