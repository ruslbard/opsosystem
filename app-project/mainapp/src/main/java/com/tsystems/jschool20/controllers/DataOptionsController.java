package com.tsystems.jschool20.controllers;

import com.tsystems.jschool20.srvengine.api.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ruslbard on 03.04.2017.
 */
@Controller
public class DataOptionsController {

    @Autowired
    private OptionService optionService;

    @ResponseBody
    @RequestMapping(value = "/getAllOptions", produces = "application/json")
    public Object getAllOptions(){
        return optionService.getAllOptions();
    }

}
