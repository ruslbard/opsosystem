package com.tsystems.jschool20.srvengine.repos;

import com.tsystems.jschool20.srvengine.entites.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.JoinTable;
import java.util.List;

/**
 * Created by ruslbard on 02.04.2017.
 */
@Transactional
public interface OptionRepository extends JpaRepository<Option, Long> {

    @Query("SELECT o FROM OPTIONS o")
    List<Option> findAll();

//    @Query("SELECT o FROM Options o, INCLUDE_OPTIONS WHERE o.ID  ")
//    List<Option> findAllIncludeOptions(Long id);
}
