package com.tsystems.jschool20.srvengine.api;

import com.tsystems.jschool20.srvengine.dtos.DTOOption;
import com.tsystems.jschool20.srvengine.dtos.DTOPerson;
import com.tsystems.jschool20.srvengine.entities.Option;

import java.util.Collection;

/**
 * Created by ruslbard on 02.04.2017.
 */
public interface OptionService {

    Collection<DTOOption> getAllOptions();
    Collection<DTOOption> getAllOptionsForRate(long id);
    DTOOption getOption(long id);
    void saveOption(DTOOption dto);
}
