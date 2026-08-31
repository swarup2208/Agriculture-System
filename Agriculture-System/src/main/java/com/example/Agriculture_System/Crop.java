package com.example.Agriculture_System;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "crops")
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String farmerName;
    private String cropName;
    private String season;
    private Double landArea;
    private Double expectedYield;

    public Crop() {}

    public Crop(String farmerName, String cropName, String season, Double landArea, Double expectedYield) {
        this.farmerName = farmerName;
        this.cropName = cropName;
        this.season = season;
        this.landArea = landArea;
        this.expectedYield = expectedYield;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFarmerName() { return farmerName; }
    public void setFarmerName(String farmerName) { this.farmerName = farmerName; }

    public String getCropName() { return cropName; }
    public void setCropName(String cropName) { this.cropName = cropName; }

    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }

    public Double getLandArea() { return landArea; }
    public void setLandArea(Double landArea) { this.landArea = landArea; }

    public Double getExpectedYield() { return expectedYield; }
    public void setExpectedYield(Double expectedYield) { this.expectedYield = expectedYield; }
}