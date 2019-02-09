package com.yuan.model.accountManager;

import java.math.BigDecimal;
import java.util.Date;

public class ConsumeRecord {
    private String id;

    private String goodsName;

    private Integer goodsAmount;

    private BigDecimal goodsPrice;

    private BigDecimal money;

    private String userId;

    private String consumeTypeCode;

    private Date consumeDate;

    private String remark;

    private String validFlag;

    //非实体映射字段
    private String userName;

    private String consumeTypeName;

    private String createDatetime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Integer getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Integer goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getConsumeTypeCode() {
        return consumeTypeCode;
    }

    public void setConsumeTypeCode(String consumeTypeCode) {
        this.consumeTypeCode = consumeTypeCode == null ? null : consumeTypeCode.trim();
    }

    public Date getConsumeDate() {
        return consumeDate;
    }

    public void setConsumeDate(Date consumeDate) {
        this.consumeDate = consumeDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag == null ? null : validFlag.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getConsumeTypeName() {
        return consumeTypeName;
    }

    public void setConsumeTypeName(String consumeTypeName) {
        this.consumeTypeName = consumeTypeName;
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
    }
}