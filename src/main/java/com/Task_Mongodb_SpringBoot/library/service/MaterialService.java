package com.Task_Mongodb_SpringBoot.library.service;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;
import com.Task_Mongodb_SpringBoot.library.mapper.MaterialMapper;
import com.Task_Mongodb_SpringBoot.library.model.Material;
import com.Task_Mongodb_SpringBoot.library.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Formatter;
import java.util.List;

@Service
public class MaterialService implements MaterialServiceRepository{

    @Autowired
    private MaterialRepository materialRepository;

    private MaterialMapper materialMapper = new MaterialMapper();
    private Formatter dateFormater;

    @Override
    public List<MaterialDTO> findAll() {
        List<Material> materialList = materialRepository.findAll();
        return materialMapper.fromCollectionList(materialList);
    }

    @Override
    public MaterialDTO findById(String id) {
        Material material =materialRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Material not found")
        );

        return materialMapper.fromCollection(material);
    }

    @Override
    public MaterialDTO save(MaterialDTO materialDTO) {
        materialDTO.setAvailable(true);
        materialDTO.setLoanDateMaterial(LocalDate.now());
        Material material =materialMapper.fromDTO(materialDTO);
        return materialMapper.fromCollection(materialRepository.save(material));
    }

    @Override
    public MaterialDTO update(MaterialDTO materialDTO) {
        Material material = materialMapper.fromDTO(materialDTO);
        materialRepository.findById(material.getId()).orElseThrow(() -> new RuntimeException("Material not found"));
        return materialMapper.fromCollection(materialRepository.save(material));
    }

    @Override
    public void delete(String id) {
        materialRepository.deleteById(id);
    }
}
