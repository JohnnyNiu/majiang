package com.majiang.scorecalculator;

import com.majiang.scorecalculator.model.FanItem;
import com.majiang.scorecalculator.model.dto.WinningDto;
import com.majiang.scorecalculator.service.Calculator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiaomingniu on 26/10/15.
 */
@RestController
public class MajiangController {

    @RequestMapping(value = "/jifan",
            method = RequestMethod.POST)
    public List jifan(@RequestBody WinningDto win) {
        Calculator calculator = new Calculator(win.getFanItems(), win.getWin(), win.getMenItems());
        return calculator.getPaymentDetail() ;
    }

    @Deprecated
    @RequestMapping(value = "/test",
            method = RequestMethod.POST)
    public String jifan(@RequestBody FanItem item) {
        return item.getFanItemType() + "--" +item.getNumber() ;
    }
}
