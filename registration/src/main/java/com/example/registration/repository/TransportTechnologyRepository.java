package com.example.registration.repository;

import com.example.registration.model.TransportTechnologyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransportTechnologyRepository  extends JpaRepository<TransportTechnologyEntity, Integer> {

    TransportTechnologyEntity getTransportTechnoligysByNumber(String number);

}
