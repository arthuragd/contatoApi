package br.com.contato.service;

import java.util.List;

import br.com.contato.domain.Contato;

public interface ContatoService {

    Contato salvar(Contato contato);
    List<Contato> recuperar();
    Contato recuperarPorId(long id);
    void atualizar(Contato contato);
    void excluir(long id);

}
