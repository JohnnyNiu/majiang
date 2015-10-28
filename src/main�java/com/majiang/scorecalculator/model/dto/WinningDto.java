package com.majiang.scorecalculator.model.dto;

import com.majiang.scorecalculator.model.FanItem;
import com.majiang.scorecalculator.model.MenItems;
import com.majiang.scorecalculator.model.WinType;

import java.util.List;

/**
 * Created by xiaomingniu on 31/10/15.
 */
public class WinningDto {
    private List<FanItem> fanItems;
    private WinType win;
    private MenItems menItems;

    public WinningDto() {
    }

    public WinningDto(List<FanItem> fanItems, WinType win, MenItems menItems) {
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

    public MenItems getMenItems() {
        return menItems;
    }

    public void setMenItems(MenItems menItems) {
        this.menItems = menItems;
    }
}
