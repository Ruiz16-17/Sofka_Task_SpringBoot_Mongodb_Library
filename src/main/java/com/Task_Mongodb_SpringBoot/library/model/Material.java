package com.Task_Mongodb_SpringBoot.library.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class Material {

    @Id
    private String id;
    private String typeMaterial;
    private String name;
    private boolean isAvailable;
    private int NumberCopyMaterial;
    private LocalDate loanDateMaterial;

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
        return NumberCopyMaterial;
    }

    public void setNumberCopyMaterial(int numberCopyMaterial) {
        this.NumberCopyMaterial = numberCopyMaterial;
    }

    public LocalDate getLoanDateMaterial() {
        return loanDateMaterial;
    }

    public void setLoanDateMaterial(LocalDate loanDateMaterial) {
        this.loanDateMaterial = loanDateMaterial;
    }
}
