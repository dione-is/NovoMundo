package com.ads4s.unicesumar.projetos.carro;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class createJaExiste extends RuntimeException {

	
}
