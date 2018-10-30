/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import error.CreateErr;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mobile.MobileDAO;
import mobile.MobileDTO;

/**
 *
 * @author hp
 */
@WebServlet(name = "CreateMobileServlet", urlPatterns = {"/CreateMobileServlet"})
public class CreateMobileServlet extends HttpServlet {

    private final String createMobile = "createMobile.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = createMobile;
        CreateErr err = new CreateErr();
        boolean isNull = false;
        try {
            String txtIdMobile = request.getParameter("txtIdMobile");
            if (txtIdMobile.equals("")) {
                err.setMobileIdLengthErr("this Id can't empty");
                isNull = true;
            }
            String txtDescription = request.getParameter("txtDescription");
            if (txtDescription.equals("")) {
                err.setDescriptionLenghthErr("this description can't empty");
                isNull = true;
            }
            float numPrice = 0;
            String price = request.getParameter("txtPrice");
            if (price != null) {
                numPrice = Float.parseFloat(price);
            }
            String txtMobileName = request.getParameter("txtMobileName");
            if (txtMobileName.equals("")) {
                err.setMobileNameLengthErr("this name can't empty");
                isNull = true;
            }
            if (isNull) {
                request.setAttribute("CREATEERR", err);
            } else {
                int numYearOfProduction = 0;
                String yearOfProduction = request.getParameter("txtYearOfProduction");
                if (yearOfProduction != null) {
                    numYearOfProduction = Integer.parseInt(yearOfProduction);
                }
                int numQuantity = 0;
                String quantity = request.getParameter("txtQuantity");
                if (quantity != null) {
                    numQuantity = Integer.parseInt(quantity);
                }
                String sale = request.getParameter("IsNotSale");
                boolean IsNotSale = false;
                if (sale != null) {
                    IsNotSale = true;
                }
                MobileDAO dao = new MobileDAO();
                boolean result = dao.createMobile(new MobileDTO(txtIdMobile, txtDescription, numPrice, txtMobileName, numYearOfProduction, numQuantity, IsNotSale));
                if (result) {
                    url = createMobile;
                }
            }
        } catch (SQLException sql) {
            String msg = sql.getMessage();
            if (msg.contains("duplicate")) {
                err.setMobileNameExistedErr("this Mobile existed");
                request.setAttribute("CREATEERR", err);
            }
        } catch (NamingException name) {
            log("createAccountServlet Naming" + name.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
