package com.example.registration.controller;

import com.example.registration.model.Filter;
import com.example.registration.model.TransportTechnology;
import com.example.registration.model.TransportTechnologyEntity;
import com.example.registration.service.TransportTechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
поиск конкретного ТС (или списка ТС) по имеющимся данным (например по категории и модели).
1) возможность создания и редактирования ТС;
2) при добавлении нового ТС должна производиться проверка на наличие уже имеющегося государственного номера ТС.
 */

@RequestMapping("transport_technology")
@RestController
public class TransportTechnologyController {
    private TransportTechnologyService registrationService;

    @Autowired
    public TransportTechnologyController(TransportTechnologyService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public ResponseEntity<TransportTechnologyEntity> addTransportTechnology(@RequestBody TransportTechnology transportTechnology)
    {
        return new ResponseEntity<>(registrationService.addTransportTechnology(transportTechnology),HttpStatus.OK);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<TransportTechnology>  changeTransportTechnology(@PathVariable Integer id, @RequestBody TransportTechnology transportTechnology)
    {
        return new ResponseEntity<>(registrationService.changeTransportTechnology(transportTechnology, id),HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public  ResponseEntity<List<TransportTechnology>> getTransportTechnologyByFilter(@RequestBody Filter filter)
    {
        return new ResponseEntity<>(registrationService.getTransportTechnologyByFilter(filter),HttpStatus.OK);
    }


}
