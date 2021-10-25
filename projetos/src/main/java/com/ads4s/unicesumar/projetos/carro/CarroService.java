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

}
