package com.example.project;

public class RoomModel {
    private int id;
    private String type,features,descrip;
    private String price;

    public RoomModel(){

    }

    public RoomModel(int id, String type, String features, String descrip, String price) {
        this.id = id;
        this.type = type;
        this.features = features;
        this.descrip = descrip;
        this.price = price;
    }

    public RoomModel(String type, String features, String descrip, String price) {
        this.type = type;
        this.features = features;
        this.descrip = descrip;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
