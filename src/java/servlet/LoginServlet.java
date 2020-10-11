/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.AccountService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 829942
 */
public class LoginServlet extends HttpServlet {

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
        
        if(request.getParameter("logout") != null){
            HttpSession session = request.getSession(false);//get the session if it exist   if not exist, do nothing:(false)
            session.invalidate();
   
            request.setAttribute("loginError", "User logged out");
            
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
        }
        else if(request.getSession().getAttribute("sessionUserName") != null){
            response.sendRedirect("./home");
        }
        else{
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response); 
        }
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
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(username == null){
            username = "";
        }      
        if(password == null){
            password = "";
        }
      
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        
        if(!username.equals("") && !password.equals("")){
            AccountService account = new AccountService();
            if(account.login(username, password) != null){//login successful
                HttpSession session = request.getSession(true);//get the available session, if it is not exist create one(true)
                session.setAttribute("sessionUserName", username);
                response.sendRedirect("./home");
            }
            else{//failed
                request.setAttribute("loginError", "User or password error!");
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response); 
            }
        }
        else{// one of it is null or both of them are null
            request.setAttribute("loginError", "User or password must fill in!");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response); 
        }
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
