package com.example.registration.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

/*
Обязательные поля транспортной техники:
марка, модель, категория, государственный номер, тип ТС, год выпуска, наличие прицепа.
 */

@Entity
@Table(name="transport_technology")
public class TransportTechnologyEntity  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String brand;

    private String model;

    private String category;

    private String number;

    private Date dateOfIssue;

    private Boolean isWithTrailer;

    public TransportTechnologyEntity() {

    }

    public TransportTechnologyEntity(Integer id, String brand, String model, String category, String number, Date dateOfIssue, Boolean isWithTrailer) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.category = category;
        this.number = number;
        this.dateOfIssue = dateOfIssue;
        this.isWithTrailer = isWithTrailer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Boolean getWithTrailer() {
        return isWithTrailer;
    }

    public void setWithTrailer(Boolean withTrailer) {
        isWithTrailer = withTrailer;
    }
}
