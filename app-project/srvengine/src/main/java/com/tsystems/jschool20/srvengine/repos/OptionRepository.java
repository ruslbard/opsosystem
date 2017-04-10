package com.tsystems.jschool20.srvengine.repos;

import com.tsystems.jschool20.srvengine.entites.Option;
import com.tsystems.jschool20.srvengine.entites.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ruslbard on 02.04.2017.
 */
@Transactional
public interface OptionRepository extends JpaRepository<Option, Long> {

    @Query("SELECT o FROM Option o")
    List<Option> findAll();

    @Query("SELECT o FROM Option o WHERE o.id = :id")
    Option findById(@Param("id") Long id);

}
