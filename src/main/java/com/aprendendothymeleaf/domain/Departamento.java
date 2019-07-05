package com.aprendendothymeleaf.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * Adicionamos o @OneToMany porque temos muitos cargos para 1 departamento
 * Foi adicionado um atributo mappedBy ele e necessario pq o relacionamento
 * Entre Departamento e cargo sera Bidirecional e quando temos um relacionamento Bidireicional
 * temos que definir qual e o lado mais fraco e o lado forte da relacao
 * o lado forte e onde contem a chave estrangeira o mappedBy significa dizer qual e o lado forte da relacao
 * esse atributo entao e o departamento que se encontra na classe Cargo.class
 * 
 */

@Entity //declara que e uma entidade
@Table(name="tbDepartamento")//declara o nome da tabela
public class Departamento extends AbstractEntity<Integer> {
	private static final long serialVersionUID = 1L;
	
	//name="nome da coluna nullable=nao aceita null unique=campo unico legth=tamanho"
	@Column(name="nome", nullable=false, unique=true, length=60)
	private String nome;

	@OneToMany(mappedBy = "departamento")//esse comando fica na parte fraca da relacao
	private List<Cargo> cargos;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
