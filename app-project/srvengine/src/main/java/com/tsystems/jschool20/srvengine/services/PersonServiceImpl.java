package com.tsystems.jschool20.srvengine.services;

import com.tsystems.jschool20.srvengine.api.PersonService;
import com.tsystems.jschool20.srvengine.dtos.DTOPerson;
import com.tsystems.jschool20.srvengine.entites.Person;
import com.tsystems.jschool20.srvengine.repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by ruslbard on 11.04.2017.
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository){

        this.personRepository = personRepository;
    }

    public static Person entityFactory(DTOPerson dto){

        Person entity = new Person();

        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setPassSerias(dto.getPassSerias());
        entity.setPassNumber(dto.getPassNumber());
        entity.setPassIssuedBy(dto.getPassIssuedBy());
        entity.setPassIssuedDate(dto.getPassIssuedDate());
        entity.setEmail(dto.getEmail());

        return entity;
    }

    public static DTOPerson dtoFactory(Person entity){

        DTOPerson dto = new DTOPerson();

        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setDateOfBirth(entity.getDateOfBirth());
        dto.setPassSerias(entity.getPassSerias());
        dto.setPassNumber(entity.getPassNumber());
        dto.setPassIssuedBy(entity.getPassIssuedBy());
        dto.setPassIssuedDate(entity.getPassIssuedDate());
        dto.setEmail(entity.getEmail());

        return dto;
    }

    public Collection<DTOPerson> getAllPerson() {
        return null;
    }

    public void addNewPerson(DTOPerson dto) {
        personRepository.save(PersonServiceImpl.entityFactory(dto));
    }

    public DTOPerson getPersonById(long id) {

        return PersonServiceImpl.dtoFactory(personRepository.findOne(id));
    }
}
