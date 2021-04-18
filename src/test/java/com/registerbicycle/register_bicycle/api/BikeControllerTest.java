package com.registerbicycle.register_bicycle.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.registerbicycle.register_bicycle.domain.BikeModel;
import com.registerbicycle.register_bicycle.service.BikeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.web.servlet.function.RequestPredicates.path;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = BikeController.class)
class BikeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

   @MockBean
    private BikeService bikeService;
    private  BikeModel bike1,bike2;
    private List<BikeModel> bikes = new ArrayList<>();
    private List<BikeModel> bikelist;

    @SpyBean
    private BikeService BikeService;

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



        BikeModel bikeSeguinte = new BikeModel();
        bikeSeguinte.setId(6L);
        bikeSeguinte.setDescription("Coelho da pascoa");
        bikeSeguinte.setModel("Monark");
        bikeSeguinte.setPrice(BigDecimal.valueOf(1000));
        bikeSeguinte.setPurchase_date(LocalDate.now());
        bikeSeguinte.setBuyer_name("pedro");
        bikeSeguinte.setName_of_the_store_where_you_bought_it("Monark 2");

        bikes.add(bikeTestador);
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
   public void obtervazio() throws Exception {
        mockMvc.perform(get("/bikes/5"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void deveEditaroPreço() throws Exception {
        BikeModel ultrabike = new BikeModel();
        ultrabike.setId(8L);
        ultrabike.setDescription("Coelho de natal");
        ultrabike.setModel("Monark Ultra");
        ultrabike.setPrice(BigDecimal.valueOf(10000));
        ultrabike.setPurchase_date(LocalDate.now());
        ultrabike.setBuyer_name("peter");
        ultrabike.setName_of_the_store_where_you_bought_it("Monark 2");
        bikes.add(ultrabike);

        BikeModel biketest = new BikeModel();
        biketest.setId(8L);
        biketest.setPrice(BigDecimal.valueOf(50));

        System.out.println(ultrabike);

        var id = 8;

        mockMvc.perform(put("/bikes/{id}",id)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(biketest)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/bikes/{id}",id))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void testListar() {

    }

    @Test
    void testExcluir() throws Exception {
        BikeModel ultrabike = new BikeModel();
        ultrabike.setId(8L);
        ultrabike.setDescription("Coelho de natal");
        ultrabike.setModel("Monark Ultra");
        ultrabike.setPrice(BigDecimal.valueOf(10000));
        ultrabike.setPurchase_date(LocalDate.now());
        ultrabike.setBuyer_name("peter");
        ultrabike.setName_of_the_store_where_you_bought_it("Monark 2");
        bikes.add(ultrabike);

        mockMvc.perform(delete("/bikes/{id}",8L)
                .contentType("application/json"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/bikes/8"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void testAtualizar() {

    }

    @Test
    void incluirBike() throws Exception {
        BikeModel novaBike = new BikeModel();
        novaBike.setId(9L);
        novaBike.setDescription("Vistoria em analise");
        novaBike.setModel("Monark");
        novaBike.setPrice(BigDecimal.valueOf(1630));
        novaBike.setPurchase_date(LocalDate.now());
        novaBike.setBuyer_name("José pedro");
        novaBike.setName_of_the_store_where_you_bought_it("Monark 4");

        MvcResult mvcResult = mockMvc.perform(post("/bikes/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(novaBike)))
                .andExpect(status().isCreated())
                .andReturn();
    }


}