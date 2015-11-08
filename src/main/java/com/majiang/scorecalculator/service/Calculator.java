package com.majiang.scorecalculator.service;

import com.majiang.scorecalculator.model.FanItem;
import com.majiang.scorecalculator.model.MenItem;
import com.majiang.scorecalculator.model.MenItems;
import com.majiang.scorecalculator.model.WinType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.majiang.scorecalculator.model.MenItem.*;
import static java.lang.Math.*;

/**
 * Created by xiaomingniu on 28/10/15.
 */
public class Calculator {
    private List<FanItem> fanItems;
    private WinType win;
    private MenItems menItems;


    public Calculator() {
        fanItems = new ArrayList<>();
        menItems = new MenItems();
    }

    public Calculator(List<FanItem> fanItems, WinType win, MenItems menItems) {
        this.fanItems = fanItems;
        this.win = win;
        this.menItems = menItems;
    }

    protected int getTotalFan(){
        return fanItems.stream().mapToInt(fanItem -> fanItem.getFanValue()).sum();
    }

    public void addFan(FanItem fanItem) {
        fanItems.add(fanItem);
    }

    public void setWin(WinType winType){
        this.win = winType;
    }

    public void addMenItem(MenItem item) {
        this.menItems.add(item);
    }

    public List getPaymentDetail() {
        int basePoint = calcPoints(getTotalFan());

        switch (win) {
            case DIAN:
                //dian, zhuang, putong
                return Arrays.asList(2 * basePoint * (haveMen(MEN_DIAN)?2:1),
                        2 * basePoint * (haveMen(MEN_ZHUANG)?2:1),
                        basePoint * (haveMen(MEN_PU_TONG)?2:1));
            case DIAN_ZHUANG:
                //dian, putong, putong
                return  Arrays.asList(4 * basePoint * (haveMen(MEN_DIAN)?2:1),
                        2 * basePoint * (haveMen(MEN_PU_TONG)?2:1),
                        2 * basePoint * (getMenCount(MEN_PU_TONG)==2?2:1));
            case ZHUANG_DIAN:
                //dian, putong, putong
                return  Arrays.asList(4 * basePoint * (haveMen(MEN_DIAN)?2:1),
                        basePoint * (haveMen(MEN_PU_TONG)?2:1),
                        basePoint * (getMenCount(MEN_PU_TONG)==2?2:1));
            case ZI_MO:
                //putong, putong, putong
                return  Arrays.asList(4*basePoint* (haveMen(MEN_ZHUANG)?2:1),
                        2 * basePoint * (haveMen(MEN_PU_TONG)?2:1),
                        2 * basePoint * (getMenCount(MEN_PU_TONG)==2?2:1));
            case ZHUANG_ZI_MO:
                //putong, putong, putong
                return Arrays.asList(4* basePoint * (getMenCount(MEN_PU_TONG)>=1?2:1),
                        4 * basePoint * (getMenCount(MEN_PU_TONG)>=2?2:1),
                        4 * basePoint * (getMenCount(MEN_PU_TONG)==3?2:1));
            default:
                throw new IllegalArgumentException("Win type is not defined:" + win);
        }
    }

    private int calcPoints(int fan) {
        return (int) pow(2, fan);
    }

    private boolean haveMen(MenItem item) {
        return menItems.count(item)>0;
    }
    private int getMenCount(MenItem item) {
        return menItems.count(item);
    }
}
