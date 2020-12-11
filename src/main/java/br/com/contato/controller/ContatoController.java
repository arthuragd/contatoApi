package br.com.contato.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contato.domain.Contato;
import br.com.contato.service.ContatoService;

/**
 */
@RestController
@RequestMapping("/api/v1.0")
public class ContatoController {

	@Autowired
	ContatoService contatoService;

	@GetMapping("/contatos")
	public List<Contato> getAllContatos() {
		return contatoService.recuperar();
	}

	@GetMapping("/contatos/{id}")
	public Contato getContatoById(@PathVariable(value = "id") Long id) {
		return contatoService.recuperarPorId(id);
	}

	@PostMapping("/contatos")
	public Contato createContato(@Valid @RequestBody Contato contato) {
		return contatoService.salvar(contato);
	}

	@PutMapping("/contatos/{id}")
	public Contato updateContato(@PathVariable(value = "id") Long id, @Valid @RequestBody Contato contatoDetails) {

		Contato contato = contatoService.recuperarPorId(id);
		contato.setNome(contatoDetails.getNome());
		contato.setEmail(contatoDetails.getEmail());

		Contato updatedContato = contatoService.salvar(contato);
		return updatedContato;
	}

	@DeleteMapping("/contatos/{id}")
	public ResponseEntity<Contato> deleteContato(@PathVariable(value = "id") Long id) {
		contatoService.excluir(id);
		return ResponseEntity.ok().build();
	}
}
