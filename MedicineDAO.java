/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.medicine_reminder;

/**
 *
 * @author HP
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MedicineDAO {

    public ArrayList<Medicines> findAll() {
        Connection connection = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        ArrayList<Medicines> medicinesList = new ArrayList<>();

        String sql = "SELECT * FROM medicines";

        try {
            connection = UserDB.connectDB();
            cs = connection.prepareCall(sql);
            rs = cs.executeQuery();

            while (rs.next()) {
                medicinesList.add(new Medicines(
                        rs.getInt("med_id"),
                        rs.getString("med_name"),
                        rs.getString("start_date"),
                        rs.getString("end_date"),
                        rs.getString("medicineTime"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                ));
            }
        } catch (Exception e) {
            System.out.println("MedicineDAO.findALL() : " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (cs != null) {
                    cs.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
        }
        return medicinesList;
    }
    
    public String insert(Medicines medicine) {
        String message = null;
        Connection con = null;
        CallableStatement cs = null;
        String sql = "Insert into user(med_id, med_name, start_date, end_date, medicine_time) Values(?,?,?,?,?)";

        try {
            con= UserDB.connectDB();
            cs = con.prepareCall(sql);

            cs.setInt(1 ,medicine.getMedId());
            cs.setString(2, medicine.getName());
            cs.setString(3, medicine.getStartDate());
            cs.setString(4, medicine.getEndDate());
            cs.setString(5, medicine.getMedicineTime());

            int rows = cs.executeUpdate();
            if (rows >= 1) {
                message = "Data is successfully inserted";
            }
        } catch (Exception e) {
            System.out.print("MedicineDAO.insert: " + e.getMessage());
            message = e.getMessage();
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (con != null);
            } catch (Exception e) {
            }
        }
        return message;
    }
    
    public String delete(Medicines medicine) {
        String message;
        Connection con = null;
        CallableStatement cs = null;

        String sql = "DELETE FROM medicines WHERE med_id = ?";

        try {
            con = UserDB.connectDB();
            cs = con.prepareCall(sql);
            cs.setInt(1, medicine.getMedId());

            int rows = cs.executeUpdate();
            message = (rows > 0) ? "Data deleted successfully" : "No student found with the given ID.";

        } catch (Exception e) {
            System.out.println("StudentDAO.delete: " + e.getMessage());
            message = "Unable to delete: " + e.getMessage();
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception ignored) {
            }
        }
        return message;
    }
    
    public String update(Medicines medicine) {
        String message;
        Connection conn = null;
        CallableStatement cs = null;

        String sql = "UPDATE medicines SET name = ?, start_date = ?, end_date = ?, medicine_time = ? WHERE med_id = ?";

        try {
            conn = UserDB.connectDB();
            cs = conn.prepareCall(sql);

            cs.setString(1, medicine.getName());
            cs.setString(2, medicine.getStartDate());
            cs.setString(3, medicine.getEndDate());
            cs.setString(4, medicine.getMedicineTime());
            cs.setInt(5, medicine.getMedId());

            int rows = cs.executeUpdate();
            message = (rows > 0) ? "Data updated successfully" : "Update failed";

        } catch (Exception e) {
            System.out.println("StudentDAO.update: " + e.getMessage());
            message = "Unable to update: " + e.getMessage();
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }

        return message;
    }
    
    public Medicines findById(Medicines medicine) {
        Medicines existingmedicine = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM medicines WHERE med_id = ?";

        try {
            conn = UserDB.connectDB();
            cs = conn.prepareCall(sql);
            cs.setInt(1, medicine.getMedId());
            rs = cs.executeQuery();

            if (rs.next()) {
                existingmedicine = new Medicines(
                        rs.getInt("med_id"),
                        rs.getString("name"),
                        rs.getString("start_date"),
                        rs.getString("end_date"),
                        rs.getString("medicine_time"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                );
            }

        } catch (Exception e) {
            System.out.println("StudentDAO.findById: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cs != null) {
                    cs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ignored) {
            }
        }

        return existingmedicine;
    }
}
