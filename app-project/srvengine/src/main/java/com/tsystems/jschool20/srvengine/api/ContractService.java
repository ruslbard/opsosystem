package com.tsystems.jschool20.srvengine.api;

import com.tsystems.jschool20.srvengine.dtos.DTOContract;
import com.tsystems.jschool20.srvengine.dtos.DTOContractDetail;

/**
 * Created by ruslbard on 09.04.2017.
 */
public interface ContractService {

    DTOContract saveNewContract(DTOContract newContract);
    DTOContractDetail getContractDetailByPersonId(long id);
}
