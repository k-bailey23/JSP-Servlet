/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringcalculatorjspservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author keb03_000
 */

/*  Program Purpose:
        - Write JSP and Servlet based version of a flooring cost calculator
          program
    
    Program Specifications:
        - Prompts the user for:
            o The width of the flooring area to be covered
            o The length of the flooring area to be covered
            o The cost per 1 square foot of the flooring material
        - Calculates and displays the cost of the flooring material for the
          specified area
        - Calculates and displays the labor cost for installation of the 
          flooring material given the following stipulations:
            o The team can install flooring material at a rate of 20 
              square feet per hour
            o Labor cost for the team is $86.00/hour
            o The company bills in 15 minute increments
            o The program should always round up to the next 15 minute increment
        - Calculates and displays the total time required for installation
          of the flooring material
        - Calculates and displays the total cost (labor + materials) for the 
          flooring
*/
@WebServlet(name = "FlooringCalculatorJSPServlet", urlPatterns = {"/FlooringCalculatorJSPServlet"})
public class FlooringCalculatorJSPServlet extends HttpServlet {

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
        
       // inputs
    BigDecimal width = new BigDecimal("0");
    BigDecimal length = new BigDecimal("0");
    BigDecimal costPerSqFt = new BigDecimal("0");
    
    // intermediaries
    BigDecimal area = new BigDecimal("0");
    BigDecimal hours = new BigDecimal("0");
    Integer increments = 0;
    
    // outputs
    BigDecimal flooringCost = new BigDecimal("0");
    BigDecimal laborCost = new BigDecimal("0");
    BigDecimal timeRequired = new BigDecimal("0");
    BigDecimal totalCost = new BigDecimal("0");
    
    // take inputs
          
    String widthString = request.getParameter("width");
    width = new BigDecimal(widthString);
    
    String lengthString = request.getParameter("length");
    length = new BigDecimal(lengthString);
            
    String costPerSqFtString = request.getParameter("costPerSqFt");
    costPerSqFt = new BigDecimal(costPerSqFtString);
    
    // calculate intermediate values
    
    area = width.multiply(length);
    hours = area.divide(new BigDecimal("20"), 2, RoundingMode.HALF_UP);
    increments = (int) Math.ceil(hours.multiply(new BigDecimal("4")).intValue());
    
    // calculate outputs
    
    flooringCost = area.multiply(costPerSqFt).setScale(2, RoundingMode.HALF_UP);
    laborCost = new BigDecimal(increments).divide(new BigDecimal("4")).multiply(new BigDecimal("86")).setScale(2, RoundingMode.HALF_UP);
    timeRequired = hours.setScale(2, RoundingMode.HALF_UP);
    totalCost = flooringCost.add(laborCost).setScale(2, RoundingMode.HALF_UP);
    
    // send outputs to results JSP

    request.setAttribute("flooringCost", flooringCost.toString());
    request.setAttribute("laborCost", laborCost.toString());
    request.setAttribute("timeRequired", timeRequired.toString());
    request.setAttribute("totalCost", totalCost.toString());

    RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
    rd.forward(request, response);

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
