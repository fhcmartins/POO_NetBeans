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
public class AlunoDao {

    /// Injected database connection:
    @PersistenceContext private EntityManager em;

    public void perssist(Aluno aluno){
        em.persist(aluno);
    }
   
    public List<Aluno> getAllAlunos(){
        TypedQuery<Aluno> query = em.createQuery("SELECT a FROM Aluno a ORDER BY a.nome", Aluno.class);
        return query.getResultList();
    }
   
     public List<Aluno> getAluno(String RA){
        TypedQuery<Aluno> query = em.createQuery("SELECT a FROM Aluno a WHERE a.RA = :RA", Aluno.class);
        query.setParameter("RA", RA);
        return query.getResultList();
    }
    
    public void deleteAluno(String RA){
        List<Aluno> alunos = this.getAluno(RA);
        em.remove(alunos.get(0));
    }
   
    public void updateAluno(Aluno aluno){
        List<Aluno> alunos = this.getAluno(aluno.getRA());
        alunos.get(0).setNome(aluno.getNome());
        alunos.get(0).setEmail(aluno.getEmail());
        alunos.get(0).setCurso(aluno.getCurso());
        em.merge(alunos.get(0));
    }

    List<Aluno> getAluno(Aluno RA) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

