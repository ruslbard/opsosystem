package com.tsystems.jschool20.srvengine.services;

import com.tsystems.jschool20.srvengine.api.TariffService;
import com.tsystems.jschool20.srvengine.dtos.Tariff_DTO;
import com.tsystems.jschool20.srvengine.entites.Tariff;
import com.tsystems.jschool20.srvengine.repos.TariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

/**
 * Created by ruslbard on 29.03.2017.
 */
@Service
@Transactional
public class TariffServiceImpl implements TariffService {

    private final TariffRepository tariffRepository;

    @Autowired
    public TariffServiceImpl(TariffRepository tariffRepository){

        this.tariffRepository = tariffRepository;
    }



    public Collection<Tariff> getAllTariffs() {
//        System.out.println("Select all tariffs from TABLF TARIFFS");
//        Collection<Tariff_DTO> tariffs = new ArrayList<Tariff_DTO>();
////        Query query = emf.createQuery("from Tariffs");
//        Query query = emf.createQuery("from Tariffs");
//        query.getResultList();
////        tariffs.add(tariff("test tariff 1", 12.98));
////        tariffs.add(tariff("test tariff 2", 112.98));

        Collection<Tariff> tariffs = (tariffRepository.findAll());
        return tariffs;
    }

}
