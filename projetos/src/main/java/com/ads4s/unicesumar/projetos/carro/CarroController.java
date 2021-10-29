package com.ads4s.unicesumar.projetos.carro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/carros")
public class CarroController {

	@Autowired
	private CarroService service;
	
	@GetMapping
	public List<Carro> obterTodos(){
		return service.obterTodos();
	}
	
	@GetMapping("/{id}")
	public Carro obterPeloId(@PathVariable("id")String id) {
		return service.obterPeloId(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public String post(@RequestBody Carro novo) {
		
		return service.insert(novo);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@PathVariable("id")String id, @RequestBody Carro carro) {
		if(!id.equals(carro.getId())) {
			throw new RequisicaoPutInvalida();
		}
		service.atualizar(carro);
	}
	
	@DeleteMapping("/{id}")
	public void excluirPeloId(@PathVariable("id") String id) {
		service.excluirPeloId(id);
	}
	
	
}
