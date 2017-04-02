package com.tsystems.jschool20.srvengine.api;

import com.tsystems.jschool20.srvengine.entites.AbstractOption;
import com.tsystems.jschool20.srvengine.entites.Option;

import java.util.Collection;

/**
 * Created by ruslbard on 02.04.2017.
 */
public interface OptionService {

    Collection<AbstractOption> getAllOptions();
    Collection<Option> getIncludeOptions(long optionId);
    Collection<Option> getExcludeOptions(long optionId);

}
