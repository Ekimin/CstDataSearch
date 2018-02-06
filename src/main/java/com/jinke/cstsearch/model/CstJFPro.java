package com.jinke.cstsearch.model;

/**
 * 交房信息
 */
public class CstJFPro {
    private String cstName;
    private String cardId;
    private String JFDate;
    private String JFStatus;
    private String tradeGUID;

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

    public String getTradeGUID() {
        return tradeGUID;
    }

    public void setTradeGUID(String tradeGUID) {
        this.tradeGUID = tradeGUID;
    }
}
