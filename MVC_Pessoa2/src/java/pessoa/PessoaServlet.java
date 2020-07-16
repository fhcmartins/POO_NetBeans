/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pessoa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author flavi
 */
@WebServlet(name = "PessoaServlet", urlPatterns = {"/PessoaServlet"})
public class PessoaServlet extends HttpServlet {

    private static String RG;
    private static  String nome;
    private static String email;
    // Injected DAO EJB:
    @EJB PessoaDao pessoaDao;
    
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
            out.println("<title>Servlet PessoaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PessoaServlet at " + request.getContextPath() + "</h1>");
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
        
        if (request.getParameter("buttonVoltar") != null) {
          request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        
        if (request.getParameter("buttonRead") != null) {
            List<Pessoa> pessoas = new ArrayList<>();
            pessoas = pessoaDao.getPessoa(RG);
            if(pessoas.size()>0)
                request.setAttribute("pessoas", pessoas);
        }
        if (request.getParameter("buttonReadAll") != null) {
            List<Pessoa> pessoas = new ArrayList<>();
            pessoas = pessoaDao.getAllPessoas();
            if(pessoas.size()>0)
                request.setAttribute("pessoas", pessoas);  
        }
        if (request.getParameter("buttonDel") != null) {
            pessoaDao.deletePessoa(RG);
        }     
        request.getRequestDispatcher("/pessoa.jsp").forward(request, response);
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
        RG = request.getParameter("RG");
        nome = request.getParameter("nome");
        email = request.getParameter("email");
        Pessoa pessoa = new Pessoa(RG, nome, email);
        if(request.getParameter("buttonCreate")!=null){
            pessoaDao.perssist(pessoa);
        }
        if(request.getParameter("buttonUpdate")!=null){
            pessoaDao.updatePessoa(pessoa);
        }
        // Display the list of pessoas:
        doGet(request, response);
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
