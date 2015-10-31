package com.majiang.wechat.model;

import com.majiang.scorecalculator.model.FanItem;
import com.majiang.scorecalculator.model.FanItemType;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by xiaomingniu on 28/10/15.
 */

@RunWith(MockitoJUnitRunner.class)
public class FanItemTest {

    @Test
    public void getCorrectFanValue_NotFixed(){
        FanItem fanItem = new FanItem(FanItemType.AN_KONG, 1);
        Assert.assertEquals(2, fanItem.getFanValue());
    }

    @Test
    public void getCorrectFanValue_Fixed(){
        FanItem fanItem = new FanItem(FanItemType.JIA, 5);
        Assert.assertEquals(1, fanItem.getFanValue());
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionWhenItemTypeIsNull() {
        new FanItem(null, 2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgExceptionWhenNumberIsLessThanZero() {
        new FanItem(FanItemType.PIAO, -3);
    }

}
