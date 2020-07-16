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
public class PessoaDao {

   /// Injected database connection:
    @PersistenceContext private EntityManager em;

    public void perssist(Pessoa pessoa){
        em.persist(pessoa);
    }
   
    public List<Pessoa> getAllPessoas(){
        TypedQuery<Pessoa> query = em.createQuery("SELECT p FROM Pessoa p ORDER BY p.nome", Pessoa.class);
        return query.getResultList();
    }
   
     public List<Pessoa> getPessoa(String RG){
        TypedQuery<Pessoa> query = em.createQuery("SELECT p FROM Pessoa p WHERE p.RG = :RG", Pessoa.class);
        query.setParameter("RG", RG);
        return query.getResultList();
    }
    
    public void deletePessoa(String RG){
        List<Pessoa> pessoas = this.getPessoa(RG);
        em.remove(pessoas.get(0));
    }
   
    public void updatePessoa(Pessoa pessoa){
        List<Pessoa> pessoas = this.getPessoa(pessoa.getRG());
        pessoas.get(0).setNome(pessoa.getNome());
        pessoas.get(0).setEmail(pessoa.getEmail());
        em.merge(pessoas.get(0));
    }
}
