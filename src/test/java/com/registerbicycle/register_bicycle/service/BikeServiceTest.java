package com.registerbicycle.register_bicycle.service;

import com.registerbicycle.register_bicycle.domain.BikeModel;
import com.registerbicycle.register_bicycle.domain.BikeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BikeServiceTest {

    private BikeService bikeService;
    private BikeRepository bikeRepository;

    @BeforeEach
    public void setUp() {

    }

    @Test
    void obter() {
    }

    @Test
    void incluir() {
    }

    @Test
    void listar() {
    }

    @Test
    void excluir() {
    }

    @Test
    void obterPorNome() {
    }

    @Test
    void atualizar() {
    }

    @Test
    void obterPorModelo() {
    }

    @Test
    void editprice() {
    }
}