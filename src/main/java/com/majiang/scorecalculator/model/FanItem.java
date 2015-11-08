package com.majiang.scorecalculator.model;

/**
 * Created by xiaomingniu on 28/10/15.
 */
public class  FanItem {
    private FanItemType fanItemType;
    private int number;

    public FanItem() {
    }

    public FanItem(FanItemType fanItemType, int number) {
        if(fanItemType == null) {
            throw new NullPointerException("Fan item type can't be empty");
        }

        if(number<0) {
            throw new IllegalArgumentException("number of fanitem can't be less than 0");
        }

        this.fanItemType = fanItemType;
        this.number = number;
    }

    public int getFanValue(){
        if(fanItemType.fixed) {
            if(getNumber()>0)
                return fanItemType.fanValue;
            else
                return 0;
        } else {
            return fanItemType.fanValue * number;
        }
    }


    //todo: shouldn't expose
    public FanItemType getFanItemType() {
        return fanItemType;
    }

    //todo: shouldn't expose
    public void setFanItemType(FanItemType fanItemType) {
        this.fanItemType = fanItemType;
    }

    //todo: shouldn't expose
    public int getNumber() {
        return number;
    }

    //todo: shouldn't expose
    public void setNumber(int number) {
        this.number = number;
    }
}
