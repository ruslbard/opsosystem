package com.tsystems.jschool20.controllers;

import com.tsystems.jschool20.srvengine.api.TariffService;
import com.tsystems.jschool20.srvengine.entites.DTOTariff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ruslbard on 06.04.2017.
 */
@RestController
public class DataTariffController {

    @Autowired
    private TariffService tariffService;

    @RequestMapping(method = RequestMethod.POST, path = "/addTariff", consumes = "application/json")
    public void addNewTariff(@RequestBody DTOTariff dto){

        System.out.println(dto.toString());
        tariffService.createNewTariff(dto);

    }
}
