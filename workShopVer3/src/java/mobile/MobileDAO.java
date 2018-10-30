/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobile;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import user.UserDTO;
import util.DBUtil;

/**
 *
 * @author hp
 */
public class MobileDAO implements Serializable {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    private void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }

            if (stm != null) {
                stm.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {

        }

    }
    private List<MobileDTO> listMobiles;

    public List<MobileDTO> getListMobiles() {
        return listMobiles;
    }

    public void setListMobiles(List<MobileDTO> listMobiles) {
        this.listMobiles = listMobiles;
    }

    public void searchInRange(float min, float max) {
        UserDTO result = null;
        try {
            con = DBUtil.makeConnection();
            String sql = "select * from tbl_Mobile where price >= ? and price <= ?";
            stm = con.prepareStatement(sql);
            stm.setFloat(1, min);
            stm.setFloat(2, max);
            rs = stm.executeQuery();
            while (rs.next()) {
                String mobileId = rs.getString("mobileId");
                String description = rs.getString("description");
                float price = rs.getFloat("price");
                String mobileName = rs.getString("mobileName");
                int yearOfProduction = rs.getInt("yearOfProduction");
                int quantity = rs.getInt("quantity");
                boolean notSale = rs.getBoolean("notSale");
                if (this.listMobiles == null) {
                    this.listMobiles = new ArrayList<>();
                }
                MobileDTO dto = new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale);
                this.listMobiles.add(dto);
            }

        } catch (NamingException name) {
        } catch (SQLException sql) {
        } finally {
            closeConnection();
        }
    }

    public void searchAll() {
        UserDTO result = null;
        try {
            con = DBUtil.makeConnection();
            String sql = "select * from tbl_Mobile ";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String mobileId = rs.getString("mobileId");
                String description = rs.getString("description");
                float price = rs.getFloat("price");
                String mobileName = rs.getString("mobileName");
                int yearOfProduction = rs.getInt("yearOfProduction");
                int quantity = rs.getInt("quantity");
                boolean notSale = rs.getBoolean("notSale");
                if (this.listMobiles == null) {
                    this.listMobiles = new ArrayList<>();
                }
                MobileDTO dto = new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale);
                this.listMobiles.add(dto);
            }

        } catch (NamingException name) {
        } catch (SQLException sql) {
        } finally {
            closeConnection();
        }
    }

    public void searchById(String id) {
        UserDTO result = null;
        try {
            con = DBUtil.makeConnection();
            String sql = "select * from tbl_Mobile where mobileId = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                String mobileId = rs.getString("mobileId");
                String description = rs.getString("description");
                float price = rs.getFloat("price");
                String mobileName = rs.getString("mobileName");
                int yearOfProduction = rs.getInt("yearOfProduction");
                int quantity = rs.getInt("quantity");
                boolean notSale = rs.getBoolean("notSale");
                if (this.listMobiles == null) {
                    this.listMobiles = new ArrayList<>();
                }
                MobileDTO dto = new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale);
                this.listMobiles.add(dto);
            }

        } catch (NamingException name) {
        } catch (SQLException sql) {
        } finally {
            closeConnection();
        }
    }

    public void searchByName(String name) {
        UserDTO result = null;
        try {
            con = DBUtil.makeConnection();
            String sql = "select * from tbl_Mobile where mobileName like ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + name + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                String mobileId = rs.getString("mobileId");
                String description = rs.getString("description");
                float price = rs.getFloat("price");
                String mobileName = rs.getString("mobileName");
                int yearOfProduction = rs.getInt("yearOfProduction");
                int quantity = rs.getInt("quantity");
                boolean notSale = rs.getBoolean("notSale");
                if (this.listMobiles == null) {
                    this.listMobiles = new ArrayList<>();
                }
                MobileDTO dto = new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale);
                this.listMobiles.add(dto);
            }

        } catch (NamingException nam) {
        } catch (SQLException sql) {
        } finally {
            closeConnection();
        }
    }

    public boolean DeleteMobile(String idDelete) {
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "Delete from tbl_Mobile where mobileId = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, idDelete);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean UpdateMobile(MobileDTO dto) {
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "Update tbl_Mobile set  description = ?, price = ?, quantity = ? , notSale = ? where mobileId = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getDescription());
                stm.setFloat(2, dto.getPrice());
                stm.setInt(3, dto.getQuantity());
                stm.setBoolean(4, dto.isNotSale());
                stm.setString(5, dto.getMobileId());
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean createMobile(MobileDTO dto) throws SQLException, NamingException {
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "insert into tbl_Mobile(mobileId,description,price,mobileName,yearOfProduction,quantity,notSale) values(?,?, ?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getMobileId());
                stm.setString(2, dto.getDescription());
                stm.setFloat(3, dto.getPrice());
                stm.setString(4, dto.getMobileName());
                stm.setInt(5, dto.getYearOfProduction());
                stm.setInt(6, dto.getQuantity());
                stm.setBoolean(7, dto.isNotSale());
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            closeConnection();
        }
        return false;
    }
}
