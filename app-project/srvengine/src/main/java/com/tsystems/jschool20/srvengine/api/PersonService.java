package com.tsystems.jschool20.srvengine.api;

import com.tsystems.jschool20.srvengine.dtos.DTOPerson;

import java.util.Collection;

/**
 * Created by ruslbard on 11.04.2017.
 */
public interface PersonService {

    Collection<DTOPerson> getAllPersons();
    DTOPerson addNewPerson(DTOPerson dto);
    DTOPerson getPersonById(long id);
}
