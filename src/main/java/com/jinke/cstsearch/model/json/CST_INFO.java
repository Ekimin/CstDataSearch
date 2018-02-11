package com.jinke.cstsearch.model.json;

public class CST_INFO {
    private int rounds;
    private String cstName;
    private String cardId;
    private String cstGuid;
    private String gender;
    private String mobile;
    private String cstType;
    private String address;


    private String tradeGUID;
    private String t2cGUID;

    //到访信息
    private String visitTime;
    private String visitWay; //认知途径
    //认购
    private String rgBldArea; //套内面积
    private String rgTnArea; //套内面积
    private String rgBldCjPrice; // 建面单价
    private String rgTnCjPrice; // 套内单价
    private String rgRoomTotal; // 总价
    private String rgYwblDate; //业务办理日期
    //签约
    private String contractGUID;//合同guid
    private String qyBldArea;
    private String qyTnArea;
    private String qyBldCjPrice;
    private String qyTnCjPrice;
    private String qyHtTotal;
    private String qySjBcTotal;
    private String ContractDate;
    private String qyyxType; //全员营销类型
    private String qyYwblDate;
    //产证
    private String serviceProcessGUID;
    private String steps;
    private String kinds;
    private String processName;
    private String jbr;//经办人
    private String rommGuid;
    private String processTime;
    //交房
    private String JFDate;
    private String JFStatus;


    public String getQyYwblDate() {
        return qyYwblDate;
    }

    public void setQyYwblDate(String qyYwblDate) {
        this.qyYwblDate = qyYwblDate;
    }

    public String getContractGUID() {
        return contractGUID;
    }

    public void setContractGUID(String contractGUID) {
        this.contractGUID = contractGUID;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public String getT2cGUID() {
        return t2cGUID;
    }

    public void setT2cGUID(String t2cGUID) {
        this.t2cGUID = t2cGUID;
    }

    public String getCstType() {
        return cstType;
    }

    public void setCstType(String cstType) {
        this.cstType = cstType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getCstName() {
        return cstName;
    }

    public void setCstName(String cstName) {
        this.cstName = cstName;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCstGuid() {
        return cstGuid;
    }

    public void setCstGuid(String cstGuid) {
        this.cstGuid = cstGuid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTradeGUID() {
        return tradeGUID;
    }

    public void setTradeGUID(String tradeGUID) {
        this.tradeGUID = tradeGUID;
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

    public String getRgBldArea() {
        return rgBldArea;
    }

    public void setRgBldArea(String rgBldArea) {
        this.rgBldArea = rgBldArea;
    }

    public String getRgTnArea() {
        return rgTnArea;
    }

    public void setRgTnArea(String rgTnArea) {
        this.rgTnArea = rgTnArea;
    }

    public String getRgBldCjPrice() {
        return rgBldCjPrice;
    }

    public void setRgBldCjPrice(String rgBldCjPrice) {
        this.rgBldCjPrice = rgBldCjPrice;
    }

    public String getRgTnCjPrice() {
        return rgTnCjPrice;
    }

    public void setRgTnCjPrice(String rgTnCjPrice) {
        this.rgTnCjPrice = rgTnCjPrice;
    }

    public String getRgRoomTotal() {
        return rgRoomTotal;
    }

    public void setRgRoomTotal(String rgRoomTotal) {
        this.rgRoomTotal = rgRoomTotal;
    }

    public String getRgYwblDate() {
        return rgYwblDate;
    }

    public void setRgYwblDate(String rgYwblDate) {
        this.rgYwblDate = rgYwblDate;
    }

    public String getQyBldArea() {
        return qyBldArea;
    }

    public void setQyBldArea(String qyBldArea) {
        this.qyBldArea = qyBldArea;
    }

    public String getQyTnArea() {
        return qyTnArea;
    }

    public void setQyTnArea(String qyTnArea) {
        this.qyTnArea = qyTnArea;
    }

    public String getQyBldCjPrice() {
        return qyBldCjPrice;
    }

    public void setQyBldCjPrice(String qyBldCjPrice) {
        this.qyBldCjPrice = qyBldCjPrice;
    }

    public String getQyTnCjPrice() {
        return qyTnCjPrice;
    }

    public void setQyTnCjPrice(String qyTnCjPrice) {
        this.qyTnCjPrice = qyTnCjPrice;
    }

    public String getQyHtTotal() {
        return qyHtTotal;
    }

    public void setQyHtTotal(String qyHtTotal) {
        this.qyHtTotal = qyHtTotal;
    }

    public String getQySjBcTotal() {
        return qySjBcTotal;
    }

    public void setQySjBcTotal(String qySjBcTotal) {
        this.qySjBcTotal = qySjBcTotal;
    }

    public String getContractDate() {
        return ContractDate;
    }

    public void setContractDate(String contractDate) {
        ContractDate = contractDate;
    }

    public String getQyyxType() {
        return qyyxType;
    }

    public void setQyyxType(String qyyxType) {
        this.qyyxType = qyyxType;
    }

    public String getServiceProcessGUID() {
        return serviceProcessGUID;
    }

    public void setServiceProcessGUID(String serviceProcessGUID) {
        this.serviceProcessGUID = serviceProcessGUID;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getKinds() {
        return kinds;
    }

    public void setKinds(String kinds) {
        this.kinds = kinds;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getJbr() {
        return jbr;
    }

    public void setJbr(String jbr) {
        this.jbr = jbr;
    }

    public String getRommGuid() {
        return rommGuid;
    }

    public void setRommGuid(String rommGuid) {
        this.rommGuid = rommGuid;
    }

    public String getProcessTime() {
        return processTime;
    }

    public void setProcessTime(String processTime) {
        this.processTime = processTime;
    }

    public String getJFDate() {
        return JFDate;
    }

    public void setJFDate(String JFDate) {
        this.JFDate = JFDate;
    }

    public String getJFStatus() {
        return JFStatus;
    }

    public void setJFStatus(String JFStatus) {
        this.JFStatus = JFStatus;
    }
}
