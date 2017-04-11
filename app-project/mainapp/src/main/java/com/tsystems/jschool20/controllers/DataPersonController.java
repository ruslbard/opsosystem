package com.tsystems.jschool20.controllers;

import com.tsystems.jschool20.srvengine.api.PersonService;
import com.tsystems.jschool20.srvengine.dtos.DTOPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ruslbard on 11.04.2017.
 */
@RestController
public class DataPersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.POST, path = "/addNewPerson", consumes = "application/json")
    public Object addNewPerson(@RequestBody DTOPerson dto){

        personService.addNewPerson(dto);
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getPerson", produces = "application/json")
    public DTOPerson getPersonById(@RequestParam ("id") long id){

        return personService.getPersonById(id);
    }
}
