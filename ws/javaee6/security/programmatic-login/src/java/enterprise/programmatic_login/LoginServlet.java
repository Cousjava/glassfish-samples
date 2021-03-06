/*
 	Copyright (c) 2019 Oracle and/or its affiliates. All rights reserved.
	
	This program and the accompanying materials are made available under the
	terms of the Eclipse Public License v. 2.0, which is available at
	http://www.eclipse.org/legal/epl-2.0.
	
	This Source Code may also be made available under the following Secondary
	Licenses when the conditions for such availability set forth in the
	Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
	version 2 with the GNU Classpath Exception, which is available at
	https://www.gnu.org/software/classpath/license.html.
	
	SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
*/
package enterprise.programmatic_login;

import java.io.*;
import java.net.*;

import javax.annotation.security.DeclareRoles;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author nithyasubramanian
 */
@DeclareRoles("javaee6user")
public class LoginServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String userName = request.getParameter("txtUserName");
            String password = request.getParameter("txtPassword");
            
            out.println("Before Login"+"<br><br>");
            out.println("IsUserInRole?.." + request.isUserInRole("javaee6user")+"<br>");
            out.println("getRemoteUser?.." + request.getRemoteUser()+"<br>");
            out.println("getUserPrincipal?.." + request.getUserPrincipal()+"<br>");
            out.println("getAuthType?.." + request.getAuthType()+"<br><br>");
            
            try {
            request.login(userName, password); 
            }catch(ServletException ex) {
                out.println("Login Failed with a ServletException.." + ex.getMessage());
                return;
            }
            out.println("After Login..."+"<br><br>");
            out.println("IsUserInRole?.." + request.isUserInRole("javaee6user")+"<br>");
            out.println("getRemoteUser?.." + request.getRemoteUser()+"<br>");
            out.println("getUserPrincipal?.." + request.getUserPrincipal()+"<br>");
            out.println("getAuthType?.." + request.getAuthType()+"<br><br>");
            
            request.logout();
            out.println("After Logout..."+"<br><br>");
            out.println("IsUserInRole?.." + request.isUserInRole("javaee6user")+"<br>");
            out.println("getRemoteUser?.." + request.getRemoteUser()+"<br>");
            out.println("getUserPrincipal?.." + request.getUserPrincipal()+"<br>");
            out.println("getAuthType?.." + request.getAuthType()+"<br>");
            
            
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
