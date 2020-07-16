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
@WebServlet(name = "MatriculaServlet", urlPatterns = {"/MatriculaServlet"})
public class MatriculaServlet extends HttpServlet {

    private static String codigo; // Cod. da matricula
    private static String data;
    private static Aluno RA;
    private static Disciplina disciplina;
    
    // Injected DAO EJB
    @EJB
    DisciplinaDao disciplinaDao;
    @EJB
    AlunoDao alunoDao;
    @EJB
    MatriculaDao matriculaDao;
        
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
            out.println("<title>Servlet MatriculaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MatriculaServlet at " + request.getContextPath() + "</h1>");
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
            codigo = request.getParameter("codigo");
            
            // Listando matriculas pelo código
            List<Matricula> matriculas = new ArrayList<>();
            matriculas = matriculaDao.getMatricula(codigo);
            if(matriculas.size()>0)
                request.setAttribute("matriculas", matriculas);
            
            // Listando alunos pelo RA
            List<Aluno> alunos = new ArrayList<>();
            alunos = alunoDao.getAluno(RA);
            if(alunos.size()>0)
                request.setAttribute("RA", alunos);
        }
        
        if (request.getParameter("buttonReadAll") != null) {
            List<Matricula> matriculas = new ArrayList<>();
            matriculas = matriculaDao.getAllMatriculas();
            if(matriculas.size()>0)
                request.setAttribute("matriculas", matriculas);
            
            List<Aluno> alunos = new ArrayList<>();
            alunos = alunoDao.getAllAlunos();
            if(alunos.size()>0)
                request.setAttribute("RA", alunos);
        }
        
        if (request.getParameter("buttonDel") != null) {
            matriculaDao.deleteMatricula(codigo);
        }
        
        request.getRequestDispatcher("/matricula.jsp").forward(request, response);
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
            System.err.println(codigo);
            data = request.getParameter("data");
            RA = request.getParameter("RA");
            disciplina = request.getParameter("disciplina");
                            
            List<Aluno> alunos = alunoDao.getAluno(RA);
            aluno = alunos.get(0);
            
            Matricula matricula = new Matricula(codigo, disciplina, RA, data);
            disciplinaDao.perssist(disciplina);
        }
        
        if (request.getParameter("buttonUpdate") != null){
            codigo = request.getParameter("codigo");
            System.err.println(codigo);
            data = request.getParameter("data");
            RA = request.getParameter("RA");
            disciplina = request.getParameter("disciplina");
            
            Matricula matricula = new Matricula(codigo, disciplina, RA, data);
            
            if(request.getParameter("buttonCreate") != null){
                matriculaDao.perssist(matricula);
            }
            
            if(request.getParameter("buttonUpdate") != null){
                matriculaDao.updateMatricula(matricula);
            }
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





















