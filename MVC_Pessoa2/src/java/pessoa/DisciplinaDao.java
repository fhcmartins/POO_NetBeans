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
public class DisciplinaDao {

    /// Injected database connection:
    @PersistenceContext private EntityManager em;

    public void perssist(Disciplina disciplina){
        em.persist(disciplina);
    }
   
    public List<Disciplina> getAllDisciplinas(){
        TypedQuery<Disciplina> query = em.createQuery("SELECT d FROM Disciplina d ORDER BY d.nome", Disciplina.class);
        return query.getResultList();
    }
   
     public List<Disciplina> getDisciplina(String dcodigo){
        TypedQuery<Disciplina> query = em.createQuery("SELECT d FROM Disciplina d WHERE d.dcodigo = :dcodigo", Disciplina.class);
        query.setParameter("dcodigo", dcodigo);
        return query.getResultList();
    }
    
    public void deleteDisciplina(String dcodigo){
        List<Disciplina> disciplinas = this.getDisciplina(dcodigo);
        em.remove(disciplinas.get(0));
    }
   
    public void updateDisciplina(Disciplina disciplina){
        List<Disciplina> disciplinas = this.getDisciplina(disciplina.getDcodigo());
        disciplinas.get(0).setNome(disciplina.getNome());
        disciplinas.get(0).setSemestre(disciplina.getSemestre());
        disciplinas.get(0).setCurso(disciplina.getCurso());
        disciplinas.get(0).setHorasAula(disciplina.getHorasAula());
        disciplinas.get(0).setEmenta(disciplina.getEmenta());
        //disciplinas.get(0).setProfessor(disciplina.getProfessor());
        em.merge(disciplinas.get(0));
    }
    
}
