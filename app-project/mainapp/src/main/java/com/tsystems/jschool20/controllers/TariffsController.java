package com.tsystems.jschool20.controllers;

import com.tsystems.jschool20.srvengine.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by ruslbard on 28.03.2017.
 */
@Controller
public class TariffsController {

    @Autowired
    private TariffService tariffService;

    @RequestMapping("/tariffs")
    public String tarrifs(Model model){
        model.addAttribute("tariffs", tariffService.getAllTariffs());
        System.out.println("From TariffController");
        return "hello";
    }

    @ResponseBody
    @RequestMapping(path = "/tariffsJson", produces = "application/json")
    public Object tarrifsJson(){
        return tariffService.getAllTariffs();
    }

}
