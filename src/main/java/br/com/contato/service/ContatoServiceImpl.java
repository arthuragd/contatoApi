package br.com.contato.service;

import br.com.contato.dao.ContatoDao;
import br.com.contato.domain.Contato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContatoServiceImpl implements ContatoService {

    @Autowired
    private ContatoDao contatoDao;

    @Override
    public Contato salvar(Contato contato) {
        contatoDao.salvar(contato);
        return contato;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contato> recuperar() {
        return contatoDao.recuperar();
    }

    @Override
    @Transactional(readOnly = true)
    public Contato recuperarPorId(long id) {
        return contatoDao.recuperarPorID(id);
    }

    @Override
    public void atualizar(Contato contato) {
        contatoDao.atualizar(contato);
    }

    @Override
    public void excluir(long id) {
        contatoDao.excluir(id);
    }

}

