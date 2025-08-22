package com.qt.medicine_reminder;



public class Medicines {
    
    private int medId;
    private String name;
    private String startDate;
    private String endDate;
    private String medicineTime;
    private String createdAt;
    private String modifiedAt;

    public Medicines() {
    }

    public Medicines(int medId, String name, String startDate, String endDate, String medicineTime, String createdAt, String modifiedAt) {
        this.medId = medId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.medicineTime = medicineTime;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public int getMedId() {
        return medId;
    }

    public void setMedId(int medId) {
        this.medId = medId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getMedicineTime() {
        return medicineTime;
    }

    public void setMedicineTime(String medicineTime) {
        this.medicineTime = medicineTime;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override
    public String toString() {
        return "Medicines{" + "medId=" + medId + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + ", medicineTime=" + medicineTime + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + '}';
    }
    
}