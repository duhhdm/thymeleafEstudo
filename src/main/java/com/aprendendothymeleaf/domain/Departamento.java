package com.aprendendothymeleaf.domain;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="tbDepartamentos")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//name="nome da coluna nullable=nao aceita null unique=campo unico legth=tamanho"
	@Column(name="nome", nullable=false, unique=true, length=60)
	private String nome;

	@OneToMany(mappedBy = "departamento")//esse comando fica na parte fraca da relacao
	private List<Cargo> cargos;
	
	public Departamento() {
		
	}

	public Departamento(Integer id, String nome,List<Cargo> cargos) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargos = cargos;
	}
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
