package com.example.registration.service;

import com.example.registration.model.Filter;
import com.example.registration.model.TransportTechnology;
import com.example.registration.model.TransportTechnologyEntity;
import com.example.registration.repository.TransportTechRepository;
import com.example.registration.repository.TransportTechnologyRepository;
import jakarta.validation.ValidationException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransportTechnologyService {

    private TransportTechnologyRepository transportTechnologyRepository;
    private TransportTechRepository repository;
    private ModelMapper mapper;

    @Autowired
    public TransportTechnologyService(ModelMapper mapper, TransportTechRepository repository, TransportTechnologyRepository transportTechnologyRepository) {
        this.transportTechnologyRepository = transportTechnologyRepository;
        this.repository = repository;
        this.mapper = mapper;
    }

    public TransportTechnologyEntity addTransportTechnology(TransportTechnology transportTechnology) {
        TransportTechnologyEntity transportTechnologyEntity = mapper.map(transportTechnology, TransportTechnologyEntity.class);

        if (transportTechnologyRepository.getTransportTechnoligysByNumber(transportTechnologyEntity.getNumber()) != null) {
            throw new ValidationException("Number: " + transportTechnologyEntity.getNumber() + " exist, but should be unique!");
        }

        return transportTechnologyRepository.save(transportTechnologyEntity);
    }

    public TransportTechnology changeTransportTechnology(TransportTechnology transportTechnology, Integer id) {
        TransportTechnologyEntity transportTechnologyEntity = mapper.map(transportTechnology, TransportTechnologyEntity.class);
        transportTechnologyEntity.setId(id);
        return mapper.map(transportTechnologyRepository.save(transportTechnologyEntity), TransportTechnology.class);
    }

    public List<TransportTechnology> getTransportTechnologyByFilter(Filter filter) {

        return repository.getTransportTechnologyByFilter(filter)
                .stream()
                .map(transportTechnologyEntity -> mapper.map(transportTechnologyEntity, TransportTechnology.class))
                .collect(Collectors.toList());
    }
}
