package com.tsystems.jschool20.services;

import com.tsystems.jschool20.srvengine.dtos.TariffDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ruslbard on 29.03.2017.
 */
@Service
public class TariffService {

    public Collection<TariffDTO> getAllTariffs() {
        Collection<TariffDTO> tariffs = new ArrayList<TariffDTO>();
        tariffs.add(tariff("test tariff 1", 12.98));
        tariffs.add(tariff("test tariff 2", 112.98));
        return tariffs;
    }

    @Bean
    private TariffDTO tariff(String textname, Double price) {
        TariffDTO tariffDTO = new TariffDTO();
        tariffDTO.setTextname(textname);
        tariffDTO.setPrice(price);
        return tariffDTO;
    }
}
