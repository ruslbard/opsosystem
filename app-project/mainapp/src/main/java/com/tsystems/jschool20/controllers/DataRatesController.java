package com.tsystems.jschool20.controllers;

import com.tsystems.jschool20.srvengine.api.RateService;
import com.tsystems.jschool20.srvengine.dtos.DTOOption;
import com.tsystems.jschool20.srvengine.dtos.DTORate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by ruslbard on 06.04.2017.
 */
@RestController
public class DataRatesController {

    @Autowired
    private RateService rateService;

    Logger logger = LoggerFactory.getLogger(DataRatesController.class.getCanonicalName());

    @RequestMapping(method = RequestMethod.POST, path = "/addNewRate", consumes = "application/json")
    public void addNewRate(@RequestBody DTORate dto){

        logger.info("Add new rate controller method.");
        logger.debug(dto.toString());
        rateService.createNewRate(dto);

    }

    @RequestMapping(method = RequestMethod.POST, path = "/saveEditRate", consumes = "application/json")
    public void saveEditRate(@RequestBody DTORate dto){

        logger.info("Add new rate controller method.");
        logger.debug(dto.toString());
        rateService.saveEditRate(dto);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAllRates", produces = "application/json")
    public Collection<DTORate> getAllRates(){

        return rateService.getAllRates();
    }

}
