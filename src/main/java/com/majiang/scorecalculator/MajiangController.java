package com.majiang.scorecalculator;

import com.majiang.scorecalculator.model.FanItem;
import com.majiang.scorecalculator.model.FanItemType;
import com.majiang.scorecalculator.model.MenItem;
import com.majiang.scorecalculator.model.WinType;
import com.majiang.scorecalculator.model.dto.PaymentDto;
import com.majiang.scorecalculator.model.dto.WinningDataDto;
import com.majiang.scorecalculator.service.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by xiaomingniu on 26/10/15.
 */
@Controller
public class MajiangController {

    @RequestMapping(value = "/api/jifan",
            method = POST)
    public @ResponseBody
    PaymentDto jifan(@RequestBody WinningDataDto win) {
        Calculator calculator = new Calculator(win.getFanItems(), win.getWin(), win.getMenItems());
        return new PaymentDto(calculator.getPaymentDetail()) ;
    }

    @RequestMapping(value = "/jifan",
            method = GET)
    public String jifan() {
        return "jifan/jifanPage";
    }

    @RequestMapping(value = "/test",
            method = GET)
    public String test() {
        return "view1/view1";
    }

    @RequestMapping(value = "/api/jifan/schema", method = GET)
    public @ResponseBody SchemaDto jifanSchema() {
        SchemaDto schemaDto = new SchemaDto();
        schemaDto.setFanItemTypes(Arrays.asList(FanItemType.values()));
        schemaDto.setWinTypes(Arrays.asList(WinType.values()));
        List<MenItem> menItems = new ArrayList<>();
        Collections.addAll(menItems, MenItem.values());
        menItems.add(MenItem.MEN_PU_TONG);
        menItems.add(MenItem.MEN_PU_TONG);
        schemaDto.setMenItems(menItems);
        return schemaDto;
    }
}
