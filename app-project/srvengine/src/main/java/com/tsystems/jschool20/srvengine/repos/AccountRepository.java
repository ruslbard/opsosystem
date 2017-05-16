package com.tsystems.jschool20.srvengine.repos;

import com.tsystems.jschool20.srvengine.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ruslbard on 12.04.2017.
 */
@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT a FROM Account a WHERE LOGIN = :login")
    Account findOneByLogin(@Param("login") String login);

}
