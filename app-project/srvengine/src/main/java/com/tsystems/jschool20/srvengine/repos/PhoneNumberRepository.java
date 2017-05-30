package com.tsystems.jschool20.srvengine.repos;

import com.tsystems.jschool20.srvengine.entities.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ruslbard on 09.04.2017.
 */
@Transactional
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {

    @Query("SELECT p FROM PhoneNumber p WHERE ISSUED <> 'Y'")
    List<PhoneNumber> findAll();
    PhoneNumber findOneByPhone(String phone);
    PhoneNumber findOneByPhoneAndIsIssued(String login, char isIssued);
}
