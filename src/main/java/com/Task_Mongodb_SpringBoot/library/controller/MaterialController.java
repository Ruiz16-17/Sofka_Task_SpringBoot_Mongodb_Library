package com.Task_Mongodb_SpringBoot.library.controller;

import com.Task_Mongodb_SpringBoot.library.dto.MaterialDTO;
import com.Task_Mongodb_SpringBoot.library.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping("/list")
    public ResponseEntity<List<MaterialDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(materialService.findAll());
    }

    @GetMapping("/listByThematicArea/{search}")
    public ResponseEntity<List<MaterialDTO>> findAllMaterialByThematicArea(@PathVariable("search") String search){
        return ResponseEntity.status(HttpStatus.OK).body(materialService.findAllMaterialByThematicArea(search));
    }

    @GetMapping("/listTypeMaterial/{search}")
    public ResponseEntity<List<MaterialDTO>> findAllMaterialByTypeMaterial(@PathVariable("search") String search){
        return ResponseEntity.status(HttpStatus.OK).body(materialService.findAllMaterialByTypeMaterial(search));
    }

    @GetMapping("/listMaterialAvailable/{name}")
    public ResponseEntity<String> findAllByName(@PathVariable("name") String name){
        return ResponseEntity.status(HttpStatus.OK).body(materialService.availableMaterial(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialDTO> findById(@PathVariable("id") String id){
        return ResponseEntity.status(HttpStatus.OK).body(materialService.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<MaterialDTO> save(@RequestBody MaterialDTO materialDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(materialService.save(materialDTO));

    }

    @PutMapping("/update")
    public ResponseEntity<MaterialDTO> update(@RequestBody MaterialDTO materialDTO){
        if(materialDTO.getId() != null){

            return new ResponseEntity(materialService.update(materialDTO), HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/borrow/{id}")
    public ResponseEntity<String> borrowMaterial(@PathVariable("id") String id){
        if(id != null){

            return ResponseEntity.status(HttpStatus.OK).body(materialService.borrowMaterial(id));
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/return/{id}")
    public ResponseEntity<String> returnMaterial(@PathVariable("id") String id){
        if(id != null){

            return ResponseEntity.status(HttpStatus.OK).body(materialService.returnMaterial(id));
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id){
        try {
            materialService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
