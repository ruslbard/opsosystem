package com.tsystems.jschool20.controllers;

import com.tsystems.jschool20.srvengine.api.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ruslbard on 13.04.2017.
 */
@Controller
public class OptionsController {

    @Autowired
    private OptionService optionService;

    @RequestMapping(path = "/operator/showAllOptionsForm")
    public String showAllOptionsForm(){

        return "allOptionsForm";
    }

    @RequestMapping(path = "/operator/showEditOptionForm")
    public String showEditOptionForm(Model model, @RequestParam long id){

        model.addAttribute("option", optionService.getOption(id));
        return "editOptionForm";
    }
}
