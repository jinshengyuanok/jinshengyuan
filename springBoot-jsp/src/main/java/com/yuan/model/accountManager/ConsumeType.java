package com.yuan.model.accountManager;

public class ConsumeType {
    private String consumeTypeCode;

    private String consumeTypeName;

    private String validFlag;

    public String getConsumeTypeCode() {
        return consumeTypeCode;
    }

    public void setConsumeTypeCode(String consumeTypeCode) {
        this.consumeTypeCode = consumeTypeCode == null ? null : consumeTypeCode.trim();
    }

    public String getConsumeTypeName() {
        return consumeTypeName;
    }

    public void setConsumeTypeName(String consumeTypeName) {
        this.consumeTypeName = consumeTypeName == null ? null : consumeTypeName.trim();
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag == null ? null : validFlag.trim();
    }
}