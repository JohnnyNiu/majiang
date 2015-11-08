package com.majiang.scorecalculator.model;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by xiaomingniu on 30/10/15.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MenItem {
    MEN_DIAN("闷点"),
    MEN_ZHUANG("闷庄"),
    MEN_PU_TONG("闷");

    private String label;

    MenItem(String label) {
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
