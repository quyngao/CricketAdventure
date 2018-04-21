package com.vppank.cricketadventure.service.api.model;

public class Item {
    private int code;
    private String name;
    private int price;
    private int icon;

    public Item(int code, String name, int price, int icon) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.icon = icon;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
