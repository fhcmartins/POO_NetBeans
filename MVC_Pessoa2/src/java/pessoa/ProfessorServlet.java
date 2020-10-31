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
@WebServlet(name = "ProfessorServlet", urlPatterns = {"/ProfessorServlet"})
public class ProfessorServlet extends HttpServlet {

    private static String RG;
    private static String nome;
    private static String email;
    private static String matricula;
    private static String titulo;
    private static String area;
    private static String regime;
    
    // Inject DAO EJB:
    @EJB ProfessorDao professorDao;
    
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
            out.println("<title>Servlet ProfessorServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfessorServlet at " + request.getContextPath() + "</h1>");
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
            List<Professor> professores = new ArrayList<>();
            professores = professorDao.getProfessor(matricula);
            if(professores.size()>0)
                request.setAttribute("professores", professores);
        }
        
        if (request.getParameter("buttonReadAll") != null) {
            List<Professor> professores = new ArrayList<>();
            professores = professorDao.getAllProfessores();
            if(professores.size()>0)
                request.setAttribute("professores", professores);  
        }
            
        request.getRequestDispatcher("/professor.jsp").forward(request, response);
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
        matricula = request.getParameter("matricula");
        titulo = request.getParameter("titulo");
        area = request.getParameter("area");
        regime = request.getParameter("regime");
                
        Professor professor = new Professor(matricula, titulo, area, regime, RG, nome, email);
        
        if(request.getParameter("buttonCreate")!= null){
            professorDao.perssist(professor);
        }
        
        if(request.getParameter("buttonUpdate")!= null){
            professorDao.updateProfessor(professor);
        }
        
        if(request.getParameter("buttonDel") != null){
            professorDao.deleteProfessor(matricula);
        }
        
        // Display the list of alunos:
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




