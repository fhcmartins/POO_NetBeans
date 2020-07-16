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

    /// Injected database connection:
    @PersistenceContext private EntityManager em;

    public void perssist(Matricula matricula){
        em.persist(matricula);
    }
   
    public List<Matricula> getAllMatriculas(){
        TypedQuery<Matricula> query = em.createQuery("SELECT m FROM Matricula m ORDER BY m.nome", Matricula.class);
        return query.getResultList();
    }
   
     public List<Matricula> getMatricula(String codigo){
        TypedQuery<Matricula> query = em.createQuery("SELECT m FROM Matricula m WHERE m.codigo = :codigo", Matricula.class);
        query.setParameter("codigo", codigo);
        return query.getResultList();
    }
    
    public void deleteMatricula(String codigo){
        List<Matricula> matriculas = this.getMatricula(codigo);
        em.remove(matriculas.get(0));
    }
   
    public void updateMatricula(Matricula matricula){
        List<Matricula> matriculas = this.getMatricula(matricula.getCodigo());
        matriculas.get(0).setCodigo(matricula.getCodigo());
        matriculas.get(0).setDisciplina(matricula.getDisciplina());
        matriculas.get(0).setAluno(matricula.getAluno());
        matriculas.get(0).setData(matricula.getData());
        em.merge(matriculas.get(0));
    }
}




