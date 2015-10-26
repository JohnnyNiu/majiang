package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaomingniu on 26/10/15.
 */
@RestController
public class FirstController {

    @RequestMapping("/")
    public String first() {
        return "hello world";
    }
}
