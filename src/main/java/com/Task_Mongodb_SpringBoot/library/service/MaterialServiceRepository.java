package com.Task_Mongodb_SpringBoot.library.service;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;

import java.util.List;

public interface MaterialServiceRepository {

    public List<MaterialDTO> findAll();
    public MaterialDTO findById(String id) throws Exception;
    public MaterialDTO save(MaterialDTO materialDTO);
    public MaterialDTO update(MaterialDTO materialDTO);
    public void delete(String id);

}
