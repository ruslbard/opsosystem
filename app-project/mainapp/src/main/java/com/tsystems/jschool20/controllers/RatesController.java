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

    @RequestMapping("/operator/showAllRatesForm")
    public String rates(){
        logger.info("Enter in rates controller");
        return "allRatesForm";
    }

    @RequestMapping("/operator")
    public String operatorMainForm(){
        logger.info("Operator main form");
        return "redirect:/operator/showAllRatesForm";
    }

    @RequestMapping("/operator/showAddNewRateForm")
    public String addNewRateForm(){

        return "addNewRateForm";
    }

    @RequestMapping("/operator/showEditRateForm")
    public String editRateForm(Model model, @RequestParam long id){

        model.addAttribute("rate", rateService.getRate(id));
        return "editRateForm";
    }


}
