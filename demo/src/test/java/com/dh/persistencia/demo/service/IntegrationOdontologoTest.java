package com.dh.persistencia.demo.service;

import com.dh.persistencia.demo.dto.OdontologoDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import utils.JsonUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegrationOdontologoTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void registrarOdontologo() throws Exception {
        //Arrange
        OdontologoDto odontologoDto = new OdontologoDto("Maria", "Perez", 11011);
        //Act
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders
                        .post("/odontologos/registrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.asJsonString(odontologoDto)))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();
        //Asserts
        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }
}
