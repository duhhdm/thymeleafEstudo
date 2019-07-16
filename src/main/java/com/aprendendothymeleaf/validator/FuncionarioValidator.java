package com.aprendendothymeleaf.validator;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.aprendendothymeleaf.domain.Funcionario;

public class FuncionarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Funcionario.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		Funcionario f = (Funcionario)obj;
		LocalDate entrada = f.getDataEntrada();
		
		LocalDate saida = f.getDataSaida();
		
		if(saida!=null) {
			if(saida.isBefore(entrada)) {
				errors.rejectValue("dataSaida","PosteriorDataEntrada.funcionario.dataSaida");
			}
		}
	}

}
