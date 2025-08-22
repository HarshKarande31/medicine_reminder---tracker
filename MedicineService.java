/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.medicine_reminder;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class MedicineService {
    
    private MedicineDAO medicineDAO = new MedicineDAO();
    
    public ArrayList<Medicines> findAll(){
        return medicineDAO.findAll();
    }
    
    public String insert(Medicines medicine) {
        return medicineDAO.insert(medicine);
    }
    
    public String delete(Medicines medicine){
        Medicines existingmedicine = medicineDAO.findById(medicine);
        if (existingmedicine == null) {
            return "No record found with provided ID.";
        }
        return medicineDAO.delete(existingmedicine);
    }
    
    public String update(Medicines newmedicine){
        Medicines existingmedicine = medicineDAO.findById(newmedicine);
        
        if(existingmedicine == null){
            return "No user found with provided ID.";
        }
        existingmedicine.setName(newmedicine.getName());
        existingmedicine.setStartDate(newmedicine.getStartDate());
        existingmedicine.setEndDate(newmedicine.getEndDate());
        existingmedicine.setMedicineTime(newmedicine.getMedicineTime());
        
        return medicineDAO.update(existingmedicine);
    }
    
    public Medicines findById(Integer id){
        Medicines medicine = new Medicines();
        medicine.setMedId(id);
        return medicineDAO.findById(medicine);
    }
}
