package com.registerbicycle.register_bicycle.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "bike")
public class BikeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String model;
    private BigDecimal price;
  //@Column(name = "purchase_date")
    private LocalDate purchase_date;
    private String buyer_name;
    private String name_of_the_store_where_you_bought_it;

    public Long getId() { return id; }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) { this.model = model; }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) { this.price = price; }

    public LocalDate getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(LocalDate purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getBuyer_name() {
        return buyer_name;
    }

    public void setBuyer_name(String buyer_name) {
        this.buyer_name = buyer_name;
    }

    public String getName_of_the_store_where_you_bought_it() {
        return name_of_the_store_where_you_bought_it;
    }

    public void setName_of_the_store_where_you_bought_it(String name_of_the_store_where_you_bought_it) {
        this.name_of_the_store_where_you_bought_it = name_of_the_store_where_you_bought_it;
    }

}
