package com.tsystems.jschool20.controllers;

import com.tsystems.jschool20.srvengine.api.PhoneNumbersService;
import com.tsystems.jschool20.srvengine.dtos.DTOPhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by ruslbard on 11.04.2017.
 */
@RestController
public class DataPhoneNumbersController {

    private PhoneNumbersService phoneNumbersService;

    @Autowired
    public DataPhoneNumbersController(PhoneNumbersService phoneNumbersService){

        this.phoneNumbersService = phoneNumbersService;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/operator/getAllPhoneNumbers", produces = "application/json")
    public Collection<DTOPhoneNumber> getAllPhoneNumbers(){

        return phoneNumbersService.getAllPhoneNumbers();
    }


}
