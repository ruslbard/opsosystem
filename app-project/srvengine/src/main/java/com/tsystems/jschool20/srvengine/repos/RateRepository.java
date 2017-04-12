package com.tsystems.jschool20.srvengine.repos;

import com.tsystems.jschool20.srvengine.entities.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ruslbard on 31.03.2017.
 */
@Transactional
public interface RateRepository extends JpaRepository<Rate, Long> {

    @Query("SELECT t FROM Rate t")
    List<Rate> findAll();

}
