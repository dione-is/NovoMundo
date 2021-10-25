package com.ads4s.unicesumar.projetos.carro;

import java.util.List;

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
			throw new RuntimeException("esse carro ja existe");
		}
		novo = repo.save(novo);
		return novo.getId();
	}

}
