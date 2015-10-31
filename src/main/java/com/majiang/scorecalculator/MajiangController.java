package com.majiang.scorecalculator;

import com.majiang.scorecalculator.model.FanItem;
import com.majiang.scorecalculator.model.dto.PaymentDto;
import com.majiang.scorecalculator.model.dto.WinningDataDto;
import com.majiang.scorecalculator.service.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xiaomingniu on 26/10/15.
 */
@Controller
public class MajiangController {

    @RequestMapping(value = "/api/jifan",
            method = RequestMethod.POST)
    public @ResponseBody
    PaymentDto jifan(@RequestBody WinningDataDto win) {
        Calculator calculator = new Calculator(win.getFanItems(), win.getWin(), win.getMenItems());
        return new PaymentDto(calculator.getPaymentDetail()) ;
    }

    @RequestMapping(value = "/jifan",
            method = RequestMethod.GET)
    public String jifan() {
        return "jifanPage";
    }
}
