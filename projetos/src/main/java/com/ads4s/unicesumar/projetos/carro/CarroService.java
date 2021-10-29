package com.ads4s.unicesumar.projetos.carro;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarroService {
	
	@Autowired
	private CarroRepository repo;
	
	public List<Carro> obterTodos(){
		return repo.findAll();
	}
	
	public String insert(Carro novo) {
		if(repo.findById(novo.getId()).isPresent()) {
			throw new createJaExiste();
		}
		novo = repo.save(novo);
		return novo.getId();
	}

	public void atualizar(Carro carro ) {
		// TODO Auto-generated method stub
		if(!repo.findById(carro.getId()).isPresent()) {
			throw new RegistroNaoExiste();
		}
		repo.save(carro);
	}
	
	public Carro obterPeloId(String id) {
		try {
			return repo.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new RegistroNaoExiste();
		}
	}

	public void excluirPeloId(String id) {
		try {
			Carro recuperado = repo.findById(id).get();
			repo.delete(recuperado);
		} catch (NoSuchElementException e) {
			throw new RegistroNaoExiste();
		}
	}
}
