package com.yotwei.blog.enity;

/**
 * Created by YotWei on 2018/7/13.
 */
public class ArticleCatalog {

    private int typeId;
    private String name;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ArticleCatalog{" +
                "typeId=" + typeId +
                ", name='" + name + '\'' +
                '}';
    }
}
