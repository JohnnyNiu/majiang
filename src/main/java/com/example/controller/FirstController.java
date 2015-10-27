package com.example.controller;

import com.example.model.WechatRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaomingniu on 26/10/15.
 */
@RestController
public class FirstController {

    @RequestMapping(value = "/wechatTest",
            method = RequestMethod.POST,
            headers = {"content-type=application/xml"})
    public String wechatRequestTest(@RequestBody WechatRequest requestBody) {
        System.out.println(requestBody);
        return "wechatRequestTest succeed";
    }
}
