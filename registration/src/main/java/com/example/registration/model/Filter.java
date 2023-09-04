package com.example.registration.model;

import lombok.Data;

import java.util.Date;

@Data
public class Filter {

    private String brand;

    private String model;

    private String category;

    private String number;

    private Date dateOfIssue;

    private Boolean isWithTrailer;
}
