/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.BusinessBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bhavik
 */
public class BusinessServlet extends HttpServlet {
    @EJB BusinessBeanLocal business;
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
            out.println("<title>Servlet BusinessServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
                       // BCategory=3, BType=2, State=2, City=1
            //---Business
            //business.registerBusiness("XYZ", "xyz@gmail.com", "Varacha", "789466", "456456", "ALl", "Full", "Varacha", "Something", "No One", 3, 2, 2, 1, 2);
            //business.editBusinessProfile(2, "MNO", "abc@gmail.com", "Varacha", "745896", "45165", "All", "Full", "Vracga", "Something", "No One", 3, 2, 2, 1);
            //business.removeBusiness(2);
            
            //---Business Informations
//            ArrayList<Integer> ids = new ArrayList<Integer>();
//            ids.add(2);
//            ids.add(3);
//            business.setBusinessInfo(3, ids);
            //---Business Links
            HashMap<Integer, String> links = new HashMap<Integer, String>();
            links.put(1, "www.test.com");
            business.setBusinessLinks(3, links);
            
            //---Business Deals
//            business.addDeal(2, "20 Off", Date.valueOf("2015-03-31"), Date.valueOf("2015-03-31"), 4500, 2, "20Off.jpg");
//            business.editDeal(2, "30 Off", Date.valueOf("2015-03-31"), Date.valueOf("2015-03-31"), 4500, 2, "30Off.jpg");
//            business.removeDeal(2);
//            Collection<Dealstb> deals = business.getBusinessDeals(2);
//            out.println(deals.size());

            //---Deals Details
//            business.addDealDetails(3, Boolean.FALSE, "Anyways", "Nothing", "All Things", 2, "All Days");
//            business.editDealDetails(1, Boolean.TRUE, "Anyways", "Nothing", "All Things", 3, "All Days");
//            business.removeDealDetails(1);
            
            //---Deals Menu
//            business.addDealMenu(3, "Menu Data");
//            business.editDealMenu(2, "Updated menu Data");
//            business.removeDealMenu(1);
            out.println("Operation Completed");
            
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
