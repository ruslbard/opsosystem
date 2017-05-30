package com.tsystems.jschool20.controllers;

import com.tsystems.jschool20.srvengine.api.PersonService;
import com.tsystems.jschool20.srvengine.dtos.DTOPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by ruslbard on 11.04.2017.
 */
@RestController
public class DataPersonsController {

    @Autowired
    private PersonService personService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, path = "/addNewPerson", consumes = "application/json", produces = "application/json")
    public DTOPerson addNewPerson(@RequestBody DTOPerson dto){

        return personService.addNewPerson(dto);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/operator/getPerson", produces = "application/json")
    public DTOPerson getPersonById(@RequestParam ("id") long id){

        return personService.getPersonById(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/operator/getAllPersons", produces = "application/json")
    public Collection<DTOPerson> getAllPersons(){

        return personService.getAllPersons();
    }


}
