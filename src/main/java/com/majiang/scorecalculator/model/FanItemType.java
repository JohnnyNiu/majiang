package com.majiang.scorecalculator.model;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by xiaomingniu on 28/10/15.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum FanItemType {

    XUAN_FENG_GANG("旋风杠",2, false),
    KONG("杠",1,false),
    AN_KONG("暗杠", 2, false),
    JIA("夹",1, true),
    SHOU_BA_YI("手把一", 2, true),
    HAI_LAO("海底捞", 2, true),
    MEN_DA_SAN("闷大三", 3, true),
    Mao("毛", 1, false),
    PIAO("飘", 3, true),
    GANG_KAI("杠开", 2, true),
    LIU_LEI("流泪", 2, true);

    public String label;

    public int fanValue;

    public boolean fixed;

    FanItemType(String label, int fanValue, boolean fixed) {
        this.label = label;
        this.fanValue = fanValue;
        this.fixed = fixed;
    }

    public String getId(){
        return this.name();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getFanValue() {
        return fanValue;
    }

    public void setFanValue(int fanValue) {
        this.fanValue = fanValue;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }
}
