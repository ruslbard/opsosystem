package com.tsystems.jschool20.controllers;

import com.tsystems.jschool20.srvengine.api.*;
import com.tsystems.jschool20.srvengine.entites.DTOTariff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.LogManager;


/**
 * Created by ruslbard on 28.03.2017.
 */
@Controller
public class TariffsController {

    @Autowired
    private TariffService tariffService;

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

    @RequestMapping("/showNewTariffForm")
    public String addNewTariffForm(){

        return "newTariffForm";
    }
}
