package br.com.contato.dao;

import org.springframework.stereotype.Repository;

import br.com.contato.domain.Contato;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ContatoDaoImpl implements ContatoDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Contato salvar(Contato contato) {
        em.persist(contato);
        return contato;
    }

    @Override
    public List<Contato> recuperar() {
        return em.createQuery("select c from Contato c", Contato.class).getResultList();
    }

    @Override
    public Contato recuperarPorID(long id) {
        return em.find(Contato.class, id);
    }

    @Override
    public void atualizar(Contato contato) {
        em.merge(contato);
    }

    @Override
    public void excluir(long id) {
        em.remove(em.getReference(Contato.class, id));
    }
}
