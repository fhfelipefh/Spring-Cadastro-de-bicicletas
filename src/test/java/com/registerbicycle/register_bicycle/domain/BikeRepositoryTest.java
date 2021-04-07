package com.registerbicycle.register_bicycle.domain;

import com.registerbicycle.register_bicycle.service.BikeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.http.MediaType;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;



import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@DataJpaTest
class BikeRepositoryTest {

    @Autowired
    private BikeRepository bikeRepository;
    private TestEntityManager entityManager;
    private List<BikeModel> bikeList;
    private BikeService bikeService;

    @BeforeEach
    void setUp() {
        BikeModel bikeTestador = new BikeModel();
        bikeTestador.setId(5L);
        bikeTestador.setDescription("Coelho da pascoa");
        bikeTestador.setModel("Monark");
        bikeTestador.setPrice(BigDecimal.valueOf(1000));
        bikeTestador.setPurchase_date(LocalDate.now());
        bikeTestador.setBuyer_name("José");
        bikeTestador.setName_of_the_store_where_you_bought_it("Monark 2");

        BikeModel bikeSeguinte = new BikeModel();
        bikeSeguinte.setId(6L);
        bikeSeguinte.setDescription("Coelho da pascoa");
        bikeSeguinte.setModel("Monark");
        bikeSeguinte.setPrice(BigDecimal.valueOf(1000));
        bikeSeguinte.setPurchase_date(LocalDate.now());
        bikeSeguinte.setBuyer_name("pedro");
        bikeSeguinte.setName_of_the_store_where_you_bought_it("Monark 2");

        bikeRepository.save(bikeTestador);
        bikeRepository.save(bikeSeguinte);
    }

    @AfterEach
    void tearDown() {
        bikeRepository.deleteAll();
    }




}