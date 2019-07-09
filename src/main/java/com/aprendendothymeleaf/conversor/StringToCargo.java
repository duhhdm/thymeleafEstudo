package com.aprendendothymeleaf.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.aprendendothymeleaf.domain.Cargo;
import com.aprendendothymeleaf.service.CargoService;

@Component
public class StringToCargo implements Converter<String, Cargo> {

	@Autowired
	CargoService servico;

	@Override
	public Cargo convert(String source) {
		if(source.isEmpty())
			return null;
		Integer id = Integer.parseInt(source);
		return servico.buscarId(id);
	}
	
	
}
