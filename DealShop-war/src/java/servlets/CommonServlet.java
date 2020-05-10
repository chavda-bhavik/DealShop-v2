/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.CommonBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bhavik
 */
public class CommonServlet extends HttpServlet {
    @EJB CommonBeanLocal common;
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CommonServlet</title>");            
            out.println("</head>");
            out.println("<body>");
                       int i = common.getAllBusiness().size();
            out.println("<br>Total Businesses are: "+i);
            i = common.getAllBusinessByCategory(3).size();
            out.println("<br>Total Business of Food Category(3) are:"+i);
//            i = common.getAllBusinessByCity(1).size();
//            out.println("<br>Total Business of Ahemdabad City(1) are:"+i);
//            i = common.getAllBusinessByState(2).size();
//            out.println("<br>Total Business of Maharastra State(2) are:"+i);
            i = common.getAllBusinessCategories().size();
            out.println("<br>Total Business Categories are:"+i);
            i = common.getAllBusinessTypes().size();
            out.println("<br>Total Business Types are:"+i);
            i = common.getAllCity().size();
            out.println("<br>Total Cities are:"+i);
            i = common.getAllOffers().size();
            out.println("<br>Total Offers Available are:"+i);
            i = common.getAllState().size();
            out.println("<br>Total States Available are:"+i);
            i = common.getInformationList().size();
            out.println("<br>Total Informations of Business are:"+i);
            out.println("</body>");
            out.println("</html>");
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
