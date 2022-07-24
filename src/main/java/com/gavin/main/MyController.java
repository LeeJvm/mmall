package com.gavin.main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 17428 on 2022/7/23.
 */


@RestController
public class MyController {


    @RequestMapping(method = RequestMethod.GET,path = "/hello")
    public String test() {
        return "hello1";

    }



}
