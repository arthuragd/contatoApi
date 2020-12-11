package br.com.contato.dao;

import java.util.List;

import br.com.contato.domain.Contato;

public interface ContatoDao {

    Contato salvar(Contato contato);
    List<Contato> recuperar();
    Contato recuperarPorID(long id);
    void atualizar(Contato contato);
    void excluir(long id);

}
