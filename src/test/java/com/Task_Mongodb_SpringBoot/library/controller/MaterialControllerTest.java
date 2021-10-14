package com.Task_Mongodb_SpringBoot.library.controller;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;
import com.Task_Mongodb_SpringBoot.library.repository.MaterialRepository;
import com.Task_Mongodb_SpringBoot.library.service.MaterialService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.util.Optional;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MaterialControllerTest {

    @MockBean
    private MaterialService materialService;

    @MockBean
    private MaterialRepository materialRepository;

    @Autowired
    private MockMvc mockMvc;

    MaterialDTO materialDTO = new MaterialDTO("1", "Libro", "La Odisea", "Guerra", true, 1, null);
    MaterialDTO materialDTO2 = new MaterialDTO("2", "Libro", "La Odisea", "Guerra", true, 2, null);
    MaterialDTO materialDTO3 = new MaterialDTO("3", "Libro", "La Odisea", "Guerra", true, 3, null);
    MaterialDTO materialDTO4 = new MaterialDTO("4", "Revista", "Revista Semana", "Noticias", true, 1, null);

    @Test
    @DisplayName("GET/ Material success")
    void testFindAllMaterialSuccess() throws Exception {

        doReturn(Lists.newArrayList(
                materialDTO,
                materialDTO2,
                materialDTO3,
                materialDTO4
        )).when(materialService).findAll();

        mockMvc.perform(get("/material/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(header().string(HttpHeaders.LOCATION, "/material/list"))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].id", is("1")))
                .andExpect(jsonPath("$[0].typeMaterial", is("Libro")))
                .andExpect(jsonPath("$[0].thematicArea", is("Guerra")))
                .andExpect(jsonPath("$[0].name", is("La Odisea")))
                .andExpect(jsonPath("$[0].numberCopyMaterial", is(1)))
                .andExpect(jsonPath("$[0].available", is(true)))
                .andExpect(jsonPath("$[3].id", is("4")))
                .andExpect(jsonPath("$[3].typeMaterial", is("Revista")))
                .andExpect(jsonPath("$[3].thematicArea", is("Noticias")))
                .andExpect(jsonPath("$[3].name", is("Revista Semana")))
                .andExpect(jsonPath("$[3].numberCopyMaterial", is(1)))
                .andExpect(jsonPath("$[3].available", is(true)));

    }

    @Test
    @DisplayName("GET/ Material not found")
    void testFindAllMaterialNotFound() throws Exception {

        doReturn(null).when(materialService).findById("1");

        mockMvc.perform(get("/material/{id}", "1"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("POST/ Save Material")
    void testSaveMaterial() throws Exception {

        MaterialDTO materialDTOPost = new MaterialDTO();
        materialDTOPost.setId("1");
        materialDTOPost.setTypeMaterial("Libro");
        materialDTOPost.setThematicArea("Guerra");
        materialDTOPost.setName("La Odisea");
        materialDTOPost.setNumberCopyMaterial(1);
        materialDTOPost.setAvailable(true);

        MaterialDTO materialDTOReturn = new MaterialDTO();
        materialDTOReturn.setId("1");
        materialDTOReturn.setTypeMaterial("Libro");
        materialDTOReturn.setThematicArea("Guerra");
        materialDTOReturn.setName("La Odisea");
        materialDTOReturn.setNumberCopyMaterial(1);
        materialDTOReturn.setAvailable(true);

        doReturn(materialDTOReturn).when(materialService).save(any());

        mockMvc.perform(post("/material/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(materialDTOPost)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(header().string(HttpHeaders.LOCATION, "/material/save"))
                //.andExpect(header().string(HttpHeaders.ETAG, "\"1\""))
                .andExpect(jsonPath("$.id", is("1")))
                .andExpect(jsonPath("$.typeMaterial", is("Libro")))
                .andExpect(jsonPath("$.thematicArea", is("Guerra")))
                .andExpect(jsonPath("$.name", is("La Odisea")))
                .andExpect(jsonPath("$.numberCopyMaterial", is(1)))
                .andExpect(jsonPath("$.available", is(true)));

    }

    @Test
    @DisplayName("GET/ Update Material")
    void testUpdateMaterial() throws Exception {

        MaterialDTO materialDTOSave = new MaterialDTO();
        materialDTOSave.setId("1");
        materialDTOSave.setTypeMaterial("Libro");
        materialDTOSave.setThematicArea("Guerra");
        materialDTOSave.setName("La Odisea");
        materialDTOSave.setNumberCopyMaterial(1);
        materialDTOSave.setAvailable(true);

        MaterialDTO materialDTOUpdate = new MaterialDTO();
        materialDTOUpdate.setId("1");
        materialDTOUpdate.setTypeMaterial("Revista");
        materialDTOUpdate.setThematicArea("Noticias");
        materialDTOUpdate.setName("Revista Semana");
        materialDTOUpdate.setAvailable(true);

        doReturn(materialDTOUpdate).when(materialService).update(any());

        mockMvc.perform(put("/material/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(materialDTOSave)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(header().string(HttpHeaders.LOCATION, "/material/update"))
                .andExpect(jsonPath("$.typeMaterial", is("Revista")))
                .andExpect(jsonPath("$.thematicArea", is("Noticias")))
                .andExpect(jsonPath("$.name", is("Revista Semana")))
                .andExpect(jsonPath("$.available", is(true)));

    }

    static String asJsonString(final Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}