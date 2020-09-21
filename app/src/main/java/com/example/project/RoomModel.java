package com.example.project;

public class RoomModel {
    private int id;
    private String features, descrip, locat;
    private String price;
    private String imageName;
    private String imageURL;

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public RoomModel() {
    }

    public RoomModel(int id, String features, String descrip, String locat, String price,String imageName,String url) {
        this.id = id;
        this.features = features;
        this.descrip = descrip;
        this.locat = locat;
        this.price = price;
        this.imageName = imageName;
        this.imageURL = url;
    }

    public String getImageName() {
        return imageName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getLocat() {
        return locat;
    }

    public void setLocat(String locat) {
        this.locat = locat;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetails(){
        String details = "Room ID : "+ this.getId() +"\n" +"Room Features : "+this.getFeatures() + "\n" +"Room Location : "+ this.getLocat() + "\n" + "Room Price : "+ this.getPrice() + "\n" +"Room Description : "+ this.getDescrip() + "\n";
        return details;
    }
}