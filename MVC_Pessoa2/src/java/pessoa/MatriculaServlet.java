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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static String mcodigo;
    private static Aluno aluno;
    private static Disciplina disciplina;
    private static String semestre;
    private static String ano;
    private static Matricula matricula;
    
    // Injected DAO EJB:
    @EJB
    AlunoDao alunoDao;
    @EJB             
    DisciplinaDao disciplinaDao;
    @EJB
    MatriculaDao matriculaDao;      
    
    
    
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
            mcodigo = request.getParameter("mcodigo");
            List<Matricula> matriculas = new ArrayList<>();
            matriculas = matriculaDao.getMatricula(mcodigo);
            
            if(matriculas.size()>0)
                request.setAttribute("matriculas", matriculas);   
        }
        
        if (request.getParameter("buttonReadAll") != null) {
            List<Matricula> matriculas = new ArrayList<>();
            matriculas = matriculaDao.getAllMatriculas();
            if(matriculas.size()>0)
                request.setAttribute("matriculas", matriculas);    
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
                 
        if(request.getParameter("buttonCreate")!=null){
            mcodigo= request.getParameter("mcodigo");
            
            String RA = request.getParameter("RA");
            List<Aluno> alunos = alunoDao.getAluno(RA);
            aluno = alunos.get(0);
            
            String codigoDisc = request.getParameter("codigoDisc");
            List<Disciplina> disciplinas = disciplinaDao.getDisciplina(codigoDisc);
            disciplina = disciplinas.get(0);
            
            semestre = request.getParameter("semestre");
            ano = request.getParameter("ano");
            
            Matricula matricula = new Matricula(mcodigo, aluno, disciplina, semestre, ano);
            matriculaDao.perssist(matricula);
        }
        
        if(request.getParameter("buttonUpdate")!=null){
            mcodigo= request.getParameter("mcodigo");
            
            String RA = request.getParameter("RA");
            List<Aluno> alunos = alunoDao.getAluno(RA);
            aluno = alunos.get(0);
            
            String mcodigo = request.getParameter("mcodigo");
            List<Disciplina> disciplinas = disciplinaDao.getDisciplina(mcodigo);
            disciplina = disciplinas.get(0);
            
            semestre = request.getParameter("semestre");
            ano = request.getParameter("ano");
            
            Matricula matricula = new Matricula(mcodigo, aluno, disciplina, semestre, ano);
            matriculaDao.updateMatricula(matricula);
        }
        
        if (request.getParameter("buttonDel") != null) {
            mcodigo= request.getParameter("mcodigo");
            matriculaDao.deleteMatricula(mcodigo);
        }
        
        // Display the list of matriculas:
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


