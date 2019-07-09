package com.aprendendothymeleaf.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.aprendendothymeleaf.domain.Departamento;
import com.aprendendothymeleaf.service.DepartamentoService;

/*
 * como e um componente do spring temos que ter uma anotacao para identificar que e um bean do spring
 * utilizei o @Component para fazer a conversao eu iniciei a variavel do DepartamentoService para
 * caso text nao esteja vazio ele retorna um objeto obtido pela buscarId();
 */

@Component
public class StringToDepartamento implements Converter<String, Departamento> {

	@Autowired
	private DepartamentoService depService;
	
	@Override
	public Departamento convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Integer id = Integer.parseInt(text);
		return depService.buscarId(id);
	}
	
}
