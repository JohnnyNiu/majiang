package com.majiang.scorecalculator;

import com.majiang.scorecalculator.model.FanItemType;
import com.majiang.scorecalculator.model.MenItem;
import com.majiang.scorecalculator.model.WinType;

import java.util.List;

/**
 * Created by xiaomingniu on 8/11/15.
 */
public class SchemaDto {
    List<FanItemType> fanItemTypes;
    List<WinType> winTypes;
    List<MenItem> menItems;

    public List<FanItemType> getFanItemTypes() {
        return fanItemTypes;
    }

    public void setFanItemTypes(List<FanItemType> fanItemTypes) {
        this.fanItemTypes = fanItemTypes;
    }

    public List<WinType> getWinTypes() {
        return winTypes;
    }

    public void setWinTypes(List<WinType> winTypes) {
        this.winTypes = winTypes;
    }

    public List<MenItem> getMenItems() {
        return menItems;
    }

    public void setMenItems(List<MenItem> menItems) {
        this.menItems = menItems;
    }
}
