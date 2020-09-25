package com.example.demofirebasetorecycler;

public class modelVeh {


    private static String vehNum,vehDate,vehModel,vehColor,vehManuYear,vehNic,vehUrl;

    modelVeh()
    {

    }

    public modelVeh(String vehNum,String vehDate,String vehModel,String vehColor,String vehManuYear,String vehNic,String vehUrl) {
        this.vehNum=vehNum;
        this.vehDate=vehDate;
        this.vehModel=vehModel;
        this.vehColor=vehColor;
        this.vehManuYear=vehManuYear;
        this.vehNic=vehNic;
        this.vehUrl=vehUrl;
    }

    public  static String getVehNum() {
        return vehNum;
    }

    public void setVehNum(String vehNum) {
        this.vehNum = vehNum;
    }

    public static String getVehDate() {
        return vehDate;
    }

    public void setVehDate(String vehDate) {
        this.vehDate = vehDate;
    }

    public  static String getVehModel() {
        return vehModel;
    }

    public void setVehModel(String vehModel) {
        this.vehModel = vehModel;
    }

    public static String getVehColor() {
        return vehColor;
    }

    public void setVehColor(String vehColor) {
        this.vehColor = vehColor;
    }

    public static String getVehManuYear() {
        return vehManuYear;
    }

    public void setVehManuYear(String vehManuYear) {
        this.vehManuYear = vehManuYear;
    }

    public static String getVehNic() {
        return vehNic;
    }

    public void setVehNic(String vehNic) {
        this.vehNic = vehNic;
    }

    public static String getVehUrl() {
        return vehUrl;
    }

    public void setVehUrl(String vehUrl) {
        this.vehUrl = vehUrl;
    }
}
