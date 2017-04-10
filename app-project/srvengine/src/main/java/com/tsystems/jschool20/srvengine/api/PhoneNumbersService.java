package com.tsystems.jschool20.srvengine.api;

import com.tsystems.jschool20.srvengine.dtos.DTOPhoneNumber;

import java.util.Collection;

/**
 * Created by ruslbard on 11.04.2017.
 */
public interface PhoneNumbersService {

    Collection<DTOPhoneNumber> getAllPhoneNumbers();
}
