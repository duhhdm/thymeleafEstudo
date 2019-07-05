package com.aprendendothymeleaf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbCargo")
public class Cargo extends AbstractEntity<Integer> {
	private static final long serialVersionUID = 1L;
	
	@Column(name= "nome", nullable=false, unique = true, length=60)
	private String nome;
	
	@ManyToOne //*...1 "Regra para relacional onde um Departamento tem muitos Cargos" nesse caso esta dizendo que e a parte forte da relacao onde esta se relacionando Cargo.class com Departamento.class
	@JoinColumn(name= "idDepartamento")//insere uma Coluna com o parametro nome=Nome da coluna
	private Departamento departamento;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
}
