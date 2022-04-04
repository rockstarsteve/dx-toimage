package com.dx.enums;

/**
 * Description:
 *
 * @author
 * @version 1.0
 * @copyright Copyright (c)
 * @since 2022/4/3
 */
public enum ItemType {

    SIMPLE("simple.html"), MIX("mix.html"),IMAGE_MIX("image_mix.html");

    private final String fileName;

    private ItemType(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

}
