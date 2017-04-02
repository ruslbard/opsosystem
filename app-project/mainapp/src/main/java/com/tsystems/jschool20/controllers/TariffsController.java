package com.tsystems.jschool20.controllers;

import com.tsystems.jschool20.srvengine.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.LogManager;


/**
 * Created by ruslbard on 28.03.2017.
 */
@Controller
public class TariffsController {

    @Autowired
    private TariffService tariffService;

    @Autowired
    private OptionService optionService;

    private static final Logger logger = LoggerFactory.getLogger("com.tsystems.jschool20.srvengine.api.TariffService");

    @RequestMapping("/allTariffsListForm")
    public String tarrifs(Model model){
        logger.info("Enter in tariffs controller");
        model.addAttribute("tariffs", tariffService.getAllTariffs());
        System.out.println("From TariffController");
        return "tariffs";
    }

    @ResponseBody
    @RequestMapping(path = "/tariffsJson", produces = "application/json")
    public Object tarrifsJson(){
        return tariffService.getAllTariffs();
    }

    @RequestMapping("/addNewTariffForm")
    public String addNewTariffForm(Model model){

        model.addAttribute("options", optionService.getAllOptions());
        return "newTariffForm";
    }

    @RequestMapping("/addTariff")
    public String addNewTariff(Model model){
        model.addAttribute("newtariff", tariffService.createNewTariff("add new tariff", 46675));
        return "tariffcreated";
    }

}
