package com.tsystems.jschool20.srvengine.api;

import com.tsystems.jschool20.srvengine.dtos.DTOContract;
import com.tsystems.jschool20.srvengine.dtos.DTOContractDetail;

import java.util.Collection;

/**
 * Created by ruslbard on 09.04.2017.
 */
public interface ContractService {

    DTOContract saveNewContract(DTOContract newContract);
    Collection<DTOContractDetail> getAllContracts();
    Collection<DTOContractDetail> getContractsDetailByPersonId(long id);
    DTOContractDetail getContractDetailByPhoneNumber(String phoneNumber);
    void changeContractRateTo(String accountLogin, long newRateId);
    void changeContractRateTo(long contractId, long newRateId);
    void addOption (String accountLogin, long optionId);
    void addOption (long contractId, long optionId);
    void removeOption (String accountLogin, long optionId);
    void removeOption (long contractId, long optionId);
    void blockContractByOperator(long contractId);
    void unblockContractByOperator(long contractId);
    void blockContractByCommonUser(String accountLogin);
    void unblockContractByCommonUser(String accountLogin);
    DTOContractDetail getContractDetail(long contractId);

}