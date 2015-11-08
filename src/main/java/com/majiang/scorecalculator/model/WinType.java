package com.majiang.scorecalculator.model;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by xiaomingniu on 28/10/15.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum WinType {
    DIAN_ZHUANG("点庄"),
    ZHUANG_DIAN("庄点"),
    DIAN("点(非庄)"),
    ZI_MO("自摸(非庄)"),
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
