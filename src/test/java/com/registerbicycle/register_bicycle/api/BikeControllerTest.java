package com.registerbicycle.register_bicycle.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.registerbicycle.register_bicycle.domain.BikeModel;
import com.registerbicycle.register_bicycle.service.BikeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.swing.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = BikeController.class)
class BikeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

   @MockBean
    private BikeService bikeService;

    private List<BikeModel> bikes = new ArrayList<>();

    @BeforeEach
    void setUp(){
        BikeModel bikeTestador = new BikeModel();
        bikeTestador.setId(5L);
        bikeTestador.setDescription("Coelho da pascoa");
        bikeTestador.setModel("Monark");
        bikeTestador.setPrice(BigDecimal.valueOf(1000));
        bikeTestador.setPurchase_date(LocalDate.now());
        bikeTestador.setBuyer_name("José");
        bikeTestador.setName_of_the_store_where_you_bought_it("Monark 2");
        bikes.add(bikeTestador);

        BikeModel bikeSeguinte = new BikeModel();
        bikeSeguinte.setId(6L);
        bikeSeguinte.setDescription("Coelho da pascoa");
        bikeSeguinte.setModel("Monark");
        bikeSeguinte.setPrice(BigDecimal.valueOf(1000));
        bikeSeguinte.setPurchase_date(LocalDate.now());
        bikeSeguinte.setBuyer_name("pedro");
        bikeSeguinte.setName_of_the_store_where_you_bought_it("Monark 2");
        bikes.add(bikeSeguinte);
    }

    @Test
    void devePesquisarPorModeloERetornarModelo() throws Exception {
        when(bikeService.obterPorModelo(any())).thenReturn(bikes);
        mockMvc.perform(get("/bikes")
                .param("Model", "Monark")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(5)))
                .andExpect(jsonPath("$[1].model", is("Monark")));
    }


    @Test
    void obter() {

    }

    @Test
    void listar() {
    }

    @Test
    void excluir() {
    }

    @Test
    void atualizar() {
    }



    @Test
    void editprice() {
    }

    @Test
    void testObter() {
    }

    @Test
    void testObter1() {
    }

    @Test
    void testObter2() {
    }

    @Test
    void testListar() {
    }

    @Test
    void testExcluir() {
    }

    @Test
    void testAtualizar() {
    }

    @Test
    void testIncluir() {
    }

    @Test
    void testEditprice() {
    }
}