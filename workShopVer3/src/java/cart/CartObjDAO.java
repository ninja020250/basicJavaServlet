/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.naming.NamingException;
import mobile.MobileDTO;
import util.DBUtil;

/**
 *
 * @author hp
 */
public class CartObjDAO {

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

    public boolean saveCartToData(CartObj cart, String mobileId, int quantity) throws SQLException, NamingException {
        try {
            Date date = new Date();
            con = DBUtil.makeConnection();
            SimpleDateFormat simple = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
            String cartId = simple.format(date);
            if (con != null) {
                int n = 0;
                String sql = "insert into tbl_cart(custId,date,mobileId,quantity,cartId) values(?,?, ?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, cart.getCusId());
                java.sql.Date termDay = new java.sql.Date(date.getTime());
                stm.setDate(2, termDay);
                stm.setString(3, mobileId);
                stm.setInt(4, quantity);
                stm.setString(5, cartId);
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
