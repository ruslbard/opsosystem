package com.tsystems.jschool20.srvengine.api;

import com.tsystems.jschool20.srvengine.dtos.DTOContract;
import com.tsystems.jschool20.srvengine.dtos.DTOContractDetail;

import java.util.Collection;

/**
 * Created by ruslbard on 09.04.2017.
 */
public interface ContractService {

    DTOContract saveNewContract(DTOContract newContract);
    Collection<DTOContractDetail> getContractsDetailByPersonId(long id);
    DTOContractDetail getContractDetailByPhoneNumber(String phoneNumber);
    void changeContractRateTo(long newRateId, String accountLogin);
    void addOption (long id);
    void removeOption (long id);
}