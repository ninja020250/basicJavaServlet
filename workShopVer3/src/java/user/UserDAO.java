/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import util.DBUtil;

/**
 *
 * @author hp
 */
public class UserDAO implements Serializable{

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    private void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }

        if (stm != null) {
            stm.close();
        }

        if (con != null) {
            con.close();
        }

    }

    public UserDTO checkLogin(String userId, int password) throws NamingException, SQLException {
        UserDTO result = null;
        try {

            con = DBUtil.makeConnection();
            String sql = "select * from tbl_User where userId=? and password=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, userId);
            stm.setInt(2, password);
            rs = stm.executeQuery();
            if (rs.next()) {
                String fullName = rs.getString("fullName");
                int role = rs.getInt("role");
                if (role != 1) {
                    result = new UserDTO(userId, password, fullName, role);
                    return result;
                }
            }

        } catch (NamingException name) {
        } catch (SQLException sql) {
        } finally {
            closeConnection();
        }
        return result;
    }

}
