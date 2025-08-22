package com.qt.medicine_reminder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MedicineDAO {

    public ArrayList<Medicines> findAll() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Medicines> medicinesList = new ArrayList<>();
        String sql = "SELECT * FROM medicines";

        try {
            connection = UserDB.connectDB();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                medicinesList.add(new Medicines(
                        rs.getInt("med_id"),
                        rs.getString("med_name"),
                        rs.getString("start_date"),
                        rs.getString("end_date"),
                        rs.getString("medicine_time"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                ));
            }
        } catch (Exception e) {
            System.out.println("MedicineDAO.findAll() : " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return medicinesList;
    }

    public String insert(Medicines medicine) {
        String message = null;
        Connection con = null;
        PreparedStatement ps = null;
        // Corrected SQL statement for the 'medicines' table
        String sql = "INSERT INTO medicines(med_name, start_date, end_date, medicine_time) VALUES(?,?,?,?)";

        try {
            con = UserDB.connectDB();
            ps = con.prepareStatement(sql);

            ps.setString(1, medicine.getName());
            ps.setString(2, medicine.getStartDate());
            ps.setString(3, medicine.getEndDate());
            ps.setString(4, medicine.getMedicineTime());

            int rows = ps.executeUpdate();
            if (rows >= 1) {
                message = "Data is successfully inserted";
            }
        } catch (Exception e) {
            System.out.print("MedicineDAO.insert: " + e.getMessage());
            message = e.getMessage();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return message;
    }

    public String delete(int medId) {
        String message;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM medicines WHERE med_id = ?";

        try {
            con = UserDB.connectDB();
            ps = con.prepareStatement(sql);
            ps.setInt(1, medId);

            int rows = ps.executeUpdate();
            message = (rows > 0) ? "Data deleted successfully" : "No medicine found with the given ID.";
        } catch (Exception e) {
            System.out.println("MedicineDAO.delete: " + e.getMessage());
            message = "Unable to delete: " + e.getMessage();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return message;
    }

    public String update(Medicines medicine) {
        String message;
        Connection conn = null;
        PreparedStatement ps = null;
        // Corrected column name from 'name' to 'med_name'
        String sql = "UPDATE medicines SET med_name = ?, start_date = ?, end_date = ?, medicine_time = ? WHERE med_id = ?";

        try {
            conn = UserDB.connectDB();
            ps = conn.prepareStatement(sql);

            ps.setString(1, medicine.getName());
            ps.setString(2, medicine.getStartDate());
            ps.setString(3, medicine.getEndDate());
            ps.setString(4, medicine.getMedicineTime());
            ps.setInt(5, medicine.getMedId());

            int rows = ps.executeUpdate();
            message = (rows > 0) ? "Data updated successfully" : "Update failed";
        } catch (Exception e) {
            System.out.println("MedicineDAO.update: " + e.getMessage());
            message = "Unable to update: " + e.getMessage();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return message;
    }

    // New, more convenient findById method
    public Medicines findById(int medId) {
        Medicines existingMedicine = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM medicines WHERE med_id = ?";

        try {
            conn = UserDB.connectDB();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, medId);
            rs = ps.executeQuery();

            if (rs.next()) {
                existingMedicine = new Medicines(
                        rs.getInt("med_id"),
                        rs.getString("med_name"),
                        rs.getString("start_date"),
                        rs.getString("end_date"),
                        rs.getString("medicine_time"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                );
            }
        } catch (Exception e) {
            System.out.println("MedicineDAO.findById(int): " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return existingMedicine;
    }

    public ArrayList<Medicines> findMedicinesDueNow(String date, String time) {
        ArrayList<Medicines> dueMedicines = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // This query checks if the current date is between the start and end date
        // and if the medicine time matches the current minute.
        String sql = "SELECT * FROM medicines WHERE ? BETWEEN start_date AND end_date AND medicine_time = ?";

        try {
            conn = UserDB.connectDB();
            ps = conn.prepareStatement(sql);
            ps.setString(1, date);
            ps.setString(2, time);
            rs = ps.executeQuery();

            while (rs.next()) {
                dueMedicines.add(new Medicines(
                        rs.getInt("med_id"),
                        rs.getString("med_name"),
                        rs.getString("start_date"),
                        rs.getString("end_date"),
                        rs.getString("medicine_time"),
                        rs.getString("created_at"),
                        rs.getString("modified_at")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error finding due medicines: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dueMedicines;
    }
}
