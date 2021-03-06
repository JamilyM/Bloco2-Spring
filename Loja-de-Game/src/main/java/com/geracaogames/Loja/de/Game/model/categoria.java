package com.geracaogames.Loja.de.Game.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "tb_categoria")
public class categoria {
	
	@Id
	@GeneratedValue//(strategy = GenerationType.IDENTITY)
	public Long idCategoria;
	
	@NotBlank
	public String categorias;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	public List<Produto> produto;

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getCategorias() {
		return categorias;
	}

	public void setCategorias(String categorias) {
		this.categorias = categorias;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
}
