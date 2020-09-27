package com.example.project;

public class model
{
  String name,date,nic,address,cnumber,url,vehNum,vehDate,vehModel,vehColor,vehManuYear,vehNic,vehUrl;
    model()
    {

    }
    public model(String name, String date, String nic, String address, String cnumber, String url, String vehNum, String vehDate, String vehModel, String vehColor, String vehManuYear, String vehNic, String vehUrl) {
     this.name=name;
     this.date=date;
     this.nic=nic;
     this.date=date;
     this.address=address;
     this.cnumber=cnumber;
     this.url=url;
     this.vehNum=vehNum;
     this.vehDate=vehDate;
     this.vehModel=vehModel;
     this.vehColor=vehColor;
     this.vehManuYear=vehManuYear;
     this.vehNic=vehNic;
     this.vehUrl=vehUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getVehNum() {
        return vehNum;
    }

    public void setVehNum(String vehNum) {
        this.vehNum = vehNum;
    }

    public String getVehDate() {
        return vehDate;
    }

    public void setVehDate(String vehDate) {
        this.vehDate = vehDate;
    }

    public String getVehModel() {
        return vehModel;
    }

    public void setVehModel(String vehModel) {
        this.vehModel = vehModel;
    }

    public String getVehColor() {
        return vehColor;
    }

    public void setVehColor(String vehColor) {
        this.vehColor = vehColor;
    }

    public String getVehManuYear() {
        return vehManuYear;
    }

    public void setVehManuYear(String vehManuYear) {
        this.vehManuYear = vehManuYear;
    }

    public String getVehNic() {
        return vehNic;
    }

    public void setVehNic(String vehNic) {
        this.vehNic = vehNic;
    }

    public String getVehUrl() {
        return vehUrl;
    }

    public void setVehUrl(String vehUrl) {
        this.vehUrl = vehUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
