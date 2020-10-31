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
public class MatriculaDao {
    
    // Injected database connection:
    @PersistenceContext private EntityManager em;
 
    public void perssist(Matricula matricula){
        em.persist(matricula);
    }
    
    public List<Matricula> getAllMatriculas(){
        TypedQuery<Matricula> query = em.createQuery("SELECT m FROM Matricula m ORDER BY m.ano", Matricula.class);
        return query.getResultList();
    }
    
    public List<Matricula> getMatricula(String mcodigo){
        TypedQuery<Matricula> query = em.createQuery("SELECT m FROM Matricula m WHERE m.mcodigo = :mcodigo", Matricula.class);
        query.setParameter("mcodigo", mcodigo);
        return query.getResultList();
    }
     
    public void deleteMatricula(String mcodigo){
        List<Matricula> matriculas = this.getMatricula(mcodigo);
        em.remove(matriculas.get(0));
    }
    
    public void updateMatricula(Matricula matricula){
        List<Matricula> matriculas = this.getMatricula(matricula.getMcodigo());
        matriculas.get(0).setAluno(matricula.getAluno());
        matriculas.get(0).setDisciplina(matricula.getDisciplina());        
        matriculas.get(0).setSemestre(matricula.getSemestre());
        matriculas.get(0).setAno(matricula.getAno());
        em.merge(matriculas.get(0));
    }
}


