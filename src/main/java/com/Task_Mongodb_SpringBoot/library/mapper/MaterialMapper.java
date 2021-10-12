package com.Task_Mongodb_SpringBoot.library.mapper;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;
import com.Task_Mongodb_SpringBoot.library.model.Material;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class MaterialMapper {

    public Material fromDTO(MaterialDTO materialDTO){
        Material material = new Material();
        material.setId(materialDTO.getId());
        material.setTypeMaterial(materialDTO.getTypeMaterial());
        material.setThematicArea(materialDTO.getThematicArea());
        material.setName(materialDTO.getName());
        material.setAvailable(materialDTO.isAvailable());
        material.setNumberCopyMaterial(materialDTO.getNumberCopyMaterial());
        material.setBorrowDateMaterial(materialDTO.getBorrowDateMaterial());

        return material;
    }

    public MaterialDTO fromCollection(Material material){
        MaterialDTO materialDTO = new MaterialDTO();
        materialDTO.setId(material.getId());
        materialDTO.setTypeMaterial(material.getTypeMaterial());
        materialDTO.setThematicArea(material.getThematicArea());
        materialDTO.setName(material.getName());
        materialDTO.setAvailable(material.isAvailable());
        materialDTO.setNumberCopyMaterial(material.getNumberCopyMaterial());
        materialDTO.setBorrowDateMaterial(material.getBorrowDateMaterial());

        return materialDTO;
    }

    public List<MaterialDTO> fromCollectionList(List<Material> collection){

        if(collection == null){
            return null;
        }

        List<MaterialDTO> materialDTOList = new ArrayList(collection.size());
        Iterator listTracks= collection.iterator();

        while (listTracks.hasNext()){
            Material material = (Material) listTracks.next();
            materialDTOList.add(fromCollection(material));
        }

        return materialDTOList;
    }

}
