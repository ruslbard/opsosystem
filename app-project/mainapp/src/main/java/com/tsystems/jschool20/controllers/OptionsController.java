package com.tsystems.jschool20.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ruslbard on 13.04.2017.
 */
@Controller
public class OptionsController {

    @RequestMapping(path = "/showAllOptionsForm")
    public String showAllOptionsForm(){

        return "allOptionsForm";
    }
}
