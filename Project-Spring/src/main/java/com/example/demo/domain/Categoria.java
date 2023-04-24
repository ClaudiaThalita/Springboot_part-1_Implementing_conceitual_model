package com.example.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

// Serializable é uma interface que diz que os obejtos dessa classe poderão ser convertidos em uma sequencia de bits 
// Para que serve? Para que os objetos possam ser gravados em arquivos, para trafegar em rede

@Entity
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	//no diagrama, categoria tem vários produtos, além disso, precisamos iniciar as "coleçoes"
	@JsonManagedReference //é usado para resolver o problema de referências circulares em objetos Java que precisam ser convertidos em JSON. Isso ocorre quando há uma relação bidirecional entre duas entidades e, ao converter uma dessas entidades em JSON, a biblioteca Jackson entra em um loop infinito porque não sabe quando parar.
	@ManyToMany(mappedBy = "categorias")
	private List<Produto> produtos = new ArrayList<>();
	 
	public Categoria() {
		
	}

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	// gerando hash code equals, que vai comparar os objetos, neste caso, compararemos somente o id dos objetos	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}
//	


	
	
}
