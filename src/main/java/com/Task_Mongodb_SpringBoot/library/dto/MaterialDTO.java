package com.Task_Mongodb_SpringBoot.library.dto;

import java.time.LocalDate;

public class MaterialDTO {

    private String id;
    private String typeMaterial;
    private String name;
    private String thematicArea;
    private boolean isAvailable;
    private int numberCopyMaterial;
    private LocalDate borrowDateMaterial;

    public MaterialDTO() {
    }

    public MaterialDTO(String id, String typeMaterial, String name, String thematicArea, boolean isAvailable, int numberCopyMaterial, LocalDate borrowDateMaterial) {
        this.id = id;
        this.typeMaterial = typeMaterial;
        this.name = name;
        this.thematicArea = thematicArea;
        this.isAvailable = isAvailable;
        this.numberCopyMaterial = numberCopyMaterial;
        this.borrowDateMaterial = borrowDateMaterial;
    }

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

    public String getThematicArea() {
        return thematicArea;
    }

    public void setThematicArea(String thematicArea) {
        this.thematicArea = thematicArea;
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

    public LocalDate getBorrowDateMaterial() {
        return borrowDateMaterial;
    }

    public void setBorrowDateMaterial(LocalDate borrowDateMaterial) {
        this.borrowDateMaterial = borrowDateMaterial;
    }
}
