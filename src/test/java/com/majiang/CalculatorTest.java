package com.majiang;

import com.majiang.scorecalculator.model.FanItem;
import com.majiang.scorecalculator.model.FanItemType;
import com.majiang.scorecalculator.service.Calculator;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import  static com.majiang.scorecalculator.model.WinType.*;
import  static com.majiang.scorecalculator.model.FanItemType.*;
import  static com.majiang.scorecalculator.model.MenItem.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by xiaomingniu on 28/10/15.
 */

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {

    @Test
    public void getCorrectFanValue_NotFixed(){
        Calculator c = new Calculator();
        c.setWin(ZI_MO);
        c.addFan(new FanItem(JIA, 1));
        c.addFan(new FanItem(XUAN_FENG_GANG, 1));
        c.addFan(new FanItem(PIAO,1));
        c.addMenItem(MEN_ZHUANG);
        //base 6   zimo 1 menzhuang 2  --> 9/7/7
        assertEquals(c.getPaymentDetail().get(0), 512);
        assertEquals(c.getPaymentDetail().get(1), 128);
        assertEquals(c.getPaymentDetail().get(2), 128);
    }
}
