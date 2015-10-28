package com.majiang.scorecalculator.model;

/**
 * Created by xiaomingniu on 28/10/15.
 */
public enum FanItemType {

    XUAN_FENG_GANG("",2, false),
    KONG("",1,false),
    AN_KONG("", 2, false),
    JIA("",1, true),
    SHOU_BA_YI("", 2, true),
    HAI_LAO("", 2, true),
    MEN_DA_SAN("", 3, true),
    Mao("", 1, false),
    PIAO("", 3, true),
    GANG_KAI("", 2, true),
    LIU_LEI("", 2, true);

    public String name;

    public int fanValue;

    public boolean fixed;

    FanItemType(String name, int fanValue, boolean fixed) {
        this.name = name;
        this.fanValue = fanValue;
        this.fixed = fixed;
    }
}
