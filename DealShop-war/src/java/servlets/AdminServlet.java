/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.AdminBeanLocal;
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
public class AdminServlet extends HttpServlet {
    @EJB AdminBeanLocal admin;
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
            out.println("<title>Servlet AdminServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            //            for(Statetb st:states) {
//                out.println(st.getName());
//            }
            ///Collection<Statetb> states = admin.getStates(Collection<Statetb>);
            //---State---
//            admin.addState("Gujarat");
//            admin.editState(2, "Maharstra");
            //admin.removeState(13);
            
            //---City---
//            admin.addCity("Surat", 2);
//            admin.addCity("Rajkot", 3);
//            admin.editCity(1, "Ahemdabad", 3);
//            admin.removeCity(2);

            //---DealsCategory
//            admin.addDealsCategory("Food");
//            admin.editDealsCategory(1, "Breakfast");
//            admin.removeDealsCategory(1);

            //---Offer
//            admin.addOffer("20 Off", "20OFF", "Nothing", Date.valueOf("2015-03-31"), Date.valueOf("2015-05-31"), "BannerImage1", "OfferImage1");
//            admin.editOffer(1,"30% Off", "30OFF", "Nothina", Date.valueOf("2020-03-31"), Date.valueOf("2020-04-31"), "BannerImage1", "OfferImage1");
//            admin.removeOffer(1);

            //---Links
            //admin.addLink("Website", "WebLogo.png");
            //admin.editLink(1, "Facebook", "FacebookLogo.png");
            //admin.removeLink(1);
            
            //---BusinessCategory
            //admin.addBussinessCategory("Hotels");
            //admin.editBussinessCategory(1, "FastFood");
            //admin.removeBussinessCategory(2);
            
            //---BusinessType
            //admin.addBussinessType("FoodCart", 1);
            //admin.editBussinessType(1, "Stall", 2);
            //admin.removeBussinessType(2);
            
            //---BusinessInformation
//            admin.addInformation("WIFI");
//            admin.addInformation("A.C.");
//            admin.addInformation("Vantilation");
            //admin.editInformation(1, "A.C.");
            //admin.removeInformation(1);
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
