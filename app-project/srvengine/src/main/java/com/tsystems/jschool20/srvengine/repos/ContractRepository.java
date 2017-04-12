package com.tsystems.jschool20.srvengine.repos;

import com.tsystems.jschool20.srvengine.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ruslbard on 09.04.2017.
 */
@Transactional
public interface ContractRepository extends JpaRepository<Contract, Long>{

    Contract findContractByPersonId(long id);
}
