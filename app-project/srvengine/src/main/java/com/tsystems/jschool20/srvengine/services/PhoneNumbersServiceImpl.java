package com.tsystems.jschool20.srvengine.services;

import com.tsystems.jschool20.srvengine.api.PhoneNumbersService;
import com.tsystems.jschool20.srvengine.dtos.DTOPhoneNumber;
import com.tsystems.jschool20.srvengine.entites.PhoneNumber;
import com.tsystems.jschool20.srvengine.repos.PhoneNumberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ruslbard on 11.04.2017.
 */
@Service
@Transactional
public class PhoneNumbersServiceImpl implements PhoneNumbersService{

    private final PhoneNumberRepository phoneNumberRepository;

    public PhoneNumbersServiceImpl(PhoneNumberRepository phoneNumberRepository){

        this.phoneNumberRepository = phoneNumberRepository;
    }

    public Collection<DTOPhoneNumber> getAllPhoneNumbers() {

        Collection<PhoneNumber> allPhoneNumbers = phoneNumberRepository.findAll();

        Collection<DTOPhoneNumber> dtos = new ArrayList<DTOPhoneNumber>(allPhoneNumbers.size());

        for (PhoneNumber phoneNumber : allPhoneNumbers) {

            DTOPhoneNumber dto = new DTOPhoneNumber();

            dto.setId(phoneNumber.getId());
            dto.setPhoneNumber(phoneNumber.getPhoneNumber());

            dtos.add(dto);

        }
        return dtos;
    }
}
