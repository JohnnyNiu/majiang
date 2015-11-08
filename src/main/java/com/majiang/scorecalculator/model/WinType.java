package com.majiang.scorecalculator.model;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by xiaomingniu on 28/10/15.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum WinType {
    ZI_MO("非庄 自摸"),
    DIAN_ZHUANG("点庄"),
    ZHUANG_DIAN("庄点"),
    DIAN("点和被点都不是庄"),
    ZHUANG_ZI_MO("庄自摸");

    private String label;

    WinType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getId() {
        return name();
    }
}
