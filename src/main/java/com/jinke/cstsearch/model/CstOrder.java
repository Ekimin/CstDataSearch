package com.jinke.cstsearch.model;

public class CstOrder {
    private String cstGuid;
    private String cstName;
    private String bldArea; //套内面积
    private String tnArea; //套内面积
    private String bldCjPrice; // 建面单价
    private String tnCjPrice; // 套内单价
    private String roomTotal; // 总价
    private String ywblDate; //业务办理日期

    public String getCstGuid() {
        return cstGuid;
    }

    public void setCstGuid(String cstGuid) {
        this.cstGuid = cstGuid;
    }

    public String getCstName() {
        return cstName;
    }

    public void setCstName(String cstName) {
        this.cstName = cstName;
    }

    public String getBldArea() {
        return bldArea;
    }

    public void setBldArea(String bldArea) {
        this.bldArea = bldArea;
    }

    public String getTnArea() {
        return tnArea;
    }

    public void setTnArea(String tnArea) {
        this.tnArea = tnArea;
    }

    public String getBldCjPrice() {
        return bldCjPrice;
    }

    public void setBldCjPrice(String bldCjPrice) {
        this.bldCjPrice = bldCjPrice;
    }

    public String getTnCjPrice() {
        return tnCjPrice;
    }

    public void setTnCjPrice(String tnCjPrice) {
        this.tnCjPrice = tnCjPrice;
    }

    public String getRoomTotal() {
        return roomTotal;
    }

    public void setRoomTotal(String roomTotal) {
        this.roomTotal = roomTotal;
    }

    public String getYwblDate() {
        return ywblDate;
    }

    public void setYwblDate(String ywblDate) {
        this.ywblDate = ywblDate;
    }
}
