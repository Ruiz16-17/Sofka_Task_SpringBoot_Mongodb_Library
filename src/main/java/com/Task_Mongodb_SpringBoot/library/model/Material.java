package com.Task_Mongodb_SpringBoot.library.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class Material {

    @Id
    private String id;
    private String typeMaterial;
    private String thematicArea;
    private String name;
    private boolean isAvailable;
    private int numberCopyMaterial;
    private LocalDate borrowDateMaterial;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeMaterial() {
        return typeMaterial;
    }

    public void setTypeMaterial(String typeMaterial) {
        this.typeMaterial = typeMaterial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getNumberCopyMaterial() {
        return numberCopyMaterial;
    }

    public void setNumberCopyMaterial(int numberCopyMaterial) {
        this.numberCopyMaterial = numberCopyMaterial;
    }

    public String getThematicArea() {
        return thematicArea;
    }

    public void setThematicArea(String thematicArea) {
        this.thematicArea = thematicArea;
    }

    public LocalDate getBorrowDateMaterial() {
        return borrowDateMaterial;
    }

    public void setBorrowDateMaterial(LocalDate borrowDateMaterial) {
        this.borrowDateMaterial = borrowDateMaterial;
    }
}
