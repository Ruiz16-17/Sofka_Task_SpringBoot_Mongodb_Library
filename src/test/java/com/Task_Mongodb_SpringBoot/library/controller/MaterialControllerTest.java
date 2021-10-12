package com.Task_Mongodb_SpringBoot.library.controller;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;
import com.Task_Mongodb_SpringBoot.library.service.MaterialService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MaterialControllerTest{

    @MockBean
    private MaterialService materialService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET/ Material success")
    void testFindAllMaterial() throws Exception{

        MaterialDTO materialDTO = new MaterialDTO();
        materialDTO.setId("1");
        materialDTO.setTypeMaterial("Libro");
        materialDTO.setThematicArea("Guerra");
        materialDTO.setName("La Odisea");
        materialDTO.setNumberCopyMaterial(1);
        materialDTO.setAvailable(true);

        MaterialDTO materialDTO2 = new MaterialDTO();
        materialDTO2.setId("2");
        materialDTO2.setTypeMaterial("Libro");
        materialDTO2.setThematicArea("Guerra");
        materialDTO2.setName("La Odisea");
        materialDTO2.setNumberCopyMaterial(2);
        materialDTO2.setAvailable(true);

        MaterialDTO materialDTO3 = new MaterialDTO();
        materialDTO3.setId("3");
        materialDTO3.setTypeMaterial("Libro");
        materialDTO3.setThematicArea("Guerra");
        materialDTO3.setName("La Odisea");
        materialDTO3.setNumberCopyMaterial(3);
        materialDTO3.setAvailable(true);

        MaterialDTO materialDTO4 = new MaterialDTO();
        materialDTO4.setId("4");
        materialDTO4.setTypeMaterial("Revista");
        materialDTO4.setThematicArea("Noticias");
        materialDTO4.setName("Revista Semana");
        materialDTO4.setNumberCopyMaterial(1);
        materialDTO4.setAvailable(true);

        doReturn(Lists.newArrayList(
                materialDTO,
                materialDTO2,
                materialDTO3,
                materialDTO4
        )).when(materialService).findAll();

        mockMvc.perform(get("/material/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(header().string(HttpHeaders.LOCATION,"/material/list"))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].id",is("1")))
                .andExpect(jsonPath("$[0].typeMaterial",is("Libro")))
                .andExpect(jsonPath("$[0].thematicArea",is("Guerra")))
                .andExpect(jsonPath("$[0].name",is("La Odisea")))
                .andExpect(jsonPath("$[0].numberCopyMaterial",is(1)))
                .andExpect(jsonPath("$[0].available",is(true)));


    }
}