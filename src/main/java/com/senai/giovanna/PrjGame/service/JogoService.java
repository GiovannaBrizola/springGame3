package com.senai.giovanna.PrjGame.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.giovanna.PrjGame.entities.Jogo;
import com.senai.giovanna.PrjGame.repositories.JogoRepository;

@Service
public class JogoService {
	private final JogoRepository jogoRepository;

	// construtor que recebe a dependencia
	@Autowired
	public JogoService(JogoRepository jogoRepository) {
		this.jogoRepository = jogoRepository;
	}

	// preparando as buscas pelo id
	public Jogo getJogoById(Long id) {
		return jogoRepository.findById(id).orElse(null);
	}

	// preparando a busca geral
	public List<Jogo> getAllJogos() {
		return jogoRepository.findAll();
	}

	// salvando
	public Jogo saveJogo(Jogo jogo) {
		return jogoRepository.save(jogo);
	}

	// excluir
	public void deleteJogo(Long id) {
		jogoRepository.deleteById(id);
	}

	// fazendo o update do jogo com o optional
	public Jogo updateJogo(Long id, Jogo novoJogo) {
		Optional<Jogo> jogoOptional = jogoRepository.findById(id);
		if (jogoOptional.isPresent()) {
			Jogo jogoExistente = jogoOptional.get();
			jogoExistente.setName(novoJogo.getName());
			jogoExistente.setPlataform(novoJogo.getPlataform());
			return jogoRepository.save(jogoExistente);
		} else {
			return null;
		}
	}
}
