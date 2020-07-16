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
@WebServlet(name = "DisciplinaServlet", urlPatterns = {"/DisciplinaServlet"})
public class DisciplinaServlet extends HttpServlet {

    private static String matricula;   
    private static String codigo;
    private static String nome;
    private static String semestre;
    private static String curso;
    private static String horasAula;
    private static String ementa;
    private static Professor professor;
   
    // Injected DAO EJB:
    @EJB            
    DisciplinaDao disciplinaDao;
    @EJB
    ProfessorDao professorDao;  
    
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DisciplinaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DisciplinaServlet at " + request.getContextPath() + "</h1>");
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
            List<Disciplina> disciplinas = new ArrayList<>();
            disciplinas = disciplinaDao.getDisciplina(codigo);
            if(disciplinas.size()>0)
                request.setAttribute("disciplinas", disciplinas);
        } 
        
        if (request.getParameter("buttonReadAll") != null) {
            List<Disciplina> disciplinas = new ArrayList<>();
            disciplinas = disciplinaDao.getAllDisciplinas();
            if(disciplinas.size()>0)
                request.setAttribute("disciplinas", disciplinas);  
        }
        
        if (request.getParameter("buttonDel") != null) {
            disciplinaDao.deleteDisciplina(codigo);
        }     
        request.getRequestDispatcher("/disciplina.jsp").forward(request, response);
      
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
        if(request.getParameter("buttonCreate") != null){
            codigo = request.getParameter("codigo");
            System.err.println(matricula);
            nome = request.getParameter("nome");
            semestre = request.getParameter("semestre");
            curso = request.getParameter("curso");
            horasAula = request.getParameter("horasAula");
            ementa = request.getParameter("ementa");
            matricula = request.getParameter("matricula");
            
            List<Professor> professores = professorDao.getProfessor(matricula);
            professor = professores.get(0);
            
            Disciplina disciplina = new Disciplina(codigo, nome, semestre, curso,
                                    horasAula, ementa, professor);
            disciplinaDao.perssist(disciplina);
        }
        
        if (request.getParameter("buttonUpdate") != null){
            codigo = request.getParameter("codigo");
            nome = request.getParameter("nome");
            semestre = request.getParameter("semestre");
            curso = request.getParameter("curso");
            horasAula = request.getParameter("horasAula");
            ementa = request.getParameter("ementa");
            matricula = request.getParameter("matricula");
            
            List<Professor> professores = professorDao.getProfessor(matricula);
            professor = professores.get(0);
            
            Disciplina disciplina = new Disciplina(codigo, nome, semestre, curso,
                                    horasAula, ementa, professor);
            disciplinaDao.updateDisciplina(disciplina);
        }
        
        if (request.getParameter("buttonDel") != null) {
            codigo = request.getParameter("codigo");
            disciplinaDao.deleteDisciplina(codigo);
        }
        
        // Display the list of disciplinas:
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













