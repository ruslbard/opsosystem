package com.tsystems.jschool20.controllers;

import com.tsystems.jschool20.srvengine.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Created by ruslbard on 28.03.2017.
 */
@Controller
public class RatesController {

    @Autowired
    private RateService rateService;

    private static final Logger logger = LoggerFactory.getLogger("com.tsystems.jschool20.srvengine.api.RateService");

    @RequestMapping("/allRatesListForm")
    public String rates(Model model){
        logger.info("Enter in rates controller");
        model.addAttribute("rates", rateService.getAllRates());
        System.out.println("From RateController");
        return "rates";
    }

    @ResponseBody
    @RequestMapping(path = "/ratesJson", produces = "application/json")
    public Object ratesJson(){
        return rateService.getAllRates();
    }

    @RequestMapping("/showNewRateForm")
    public String addNewRateForm(){

        return "newRateForm";
    }
}
