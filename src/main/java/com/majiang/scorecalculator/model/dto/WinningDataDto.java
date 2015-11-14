package com.majiang.scorecalculator.model.dto;

import com.majiang.scorecalculator.model.FanItem;
import com.majiang.scorecalculator.model.MenItem;
import com.majiang.scorecalculator.model.WinType;

import java.util.List;

/**
 * Created by xiaomingniu on 31/10/15.
 */
public class WinningDataDto {
    private List<FanItem> fanItems;
    private WinType win;
    private List<MenItem> menItems;

    public WinningDataDto() {
    }

    public WinningDataDto(List<FanItem> fanItems, WinType win, List<MenItem> menItems) {
        this.fanItems = fanItems;
        this.win = win;
        this.menItems = menItems;
    }

    public List<FanItem> getFanItems() {
        return fanItems;
    }

    public void setFanItems(List<FanItem> fanItems) {
        this.fanItems = fanItems;
    }

    public WinType getWin() {
        return win;
    }

    public void setWin(WinType win) {
        this.win = win;
    }

    public List<MenItem> getMenItems() {
        return menItems;
    }

    public void setMenItems(List<MenItem> menItems) {
        this.menItems = menItems;
    }
}
