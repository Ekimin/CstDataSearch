package com.jinke.cstsearch.model;

public class CstVisit {
    private String cstGuid;
    private String cstName;
    private String visitTime;
    private String visitWay; //认知途径
    private String mobile;

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

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitWay() {
        return visitWay;
    }

    public void setVisitWay(String visitWay) {
        this.visitWay = visitWay;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
