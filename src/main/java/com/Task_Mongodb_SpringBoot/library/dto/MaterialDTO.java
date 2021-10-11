package com.Task_Mongodb_SpringBoot.library.dto;

import java.time.LocalDate;

public class MaterialDTO {

    private String id;
    private String typeMaterial;
    private String name;
    private boolean isAvailable;
    private int numberCopyMaterial;
    private LocalDate loanDateMaterial;

    public MaterialDTO() {
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

    public LocalDate getLoanDateMaterial() {
        return loanDateMaterial;
    }

    public void setLoanDateMaterial(LocalDate loanDateMaterial) {
        this.loanDateMaterial = loanDateMaterial;
    }
}
