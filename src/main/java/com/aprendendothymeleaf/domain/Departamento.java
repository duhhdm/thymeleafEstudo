package com.aprendendothymeleaf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity //declara que e uma entidade
@Table(name="tbDepartamento")//declara o nome da tabela
public class Departamento extends AbstractEntity<Integer> {
	private static final long serialVersionUID = 1L;
	
	//name="nome da coluna nullable=nao aceita null unique=campo unico legth=tamanho"
	@Column(name="nome", nullable=false, unique=true, length=60)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
