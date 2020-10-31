/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pessoa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author flavi
 */
@Stateless
public class ProfessorDao {

    /// Injected database connection:
    @PersistenceContext private EntityManager em;

    public void perssist(Professor professor){
        em.persist(professor);
    }
   
    public List<Professor> getAllProfessores(){
        TypedQuery<Professor> query = em.createQuery("SELECT p FROM Professor p ORDER BY p.nome", Professor.class);
        return query.getResultList();
    }
    
    public List<Professor> getProfessor(String matricula){
        TypedQuery<Professor> query = em.createQuery("SELECT p FROM Professor p WHERE p.matricula = :matricula", Professor.class);
        query.setParameter("matricula", matricula);
        return query.getResultList();
    }
    
    /*
    public List<Professor> getAllProfessores(){
        TypedQuery<Professor> query = em.createQuery("SELECT p FROM Professor p ORDER BY p.nome", Professor.class);
        return query.getResultList();
    }
    
   
     public List<Professor> getProfessor(String matricula){
        TypedQuery<Professor> query = em.createQuery("SELECT p FROM Professor p WHERE p.matricula = :matricula", Professor.class);
        query.setParameter("Matricula", matricula);
        return query.getResultList();
    }
    */
    
    public void deleteProfessor(String matricula){
        List<Professor> professores = this.getProfessor(matricula);
        em.remove(professores.get(0));
    }
   
    public void updateProfessor(Professor professor){
        List<Professor> professores = this.getProfessor(professor.getMatricula());
        professores.get(0).setRG(professor.getRG());
        professores.get(0).setNome(professor.getNome());
        professores.get(0).setEmail(professor.getEmail());
        professores.get(0).setRegime(professor.getRegime());
        professores.get(0).setTitulo(professor.getTitulo());
        professores.get(0).setArea(professor.getArea());
        em.merge(professores.get(0));
    }
    
    List<Professor> getProfessor(Professor matricula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}




