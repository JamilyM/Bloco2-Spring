package com.geracaogames.Loja.de.Game.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class Produto {
	
	@Id
	@GeneratedValue//(strategy = GenerationType.IDENTITY)
	public Long idProduto;
	
	@NotBlank
	public String produtos;
	
	@NotNull
	public String descricao;
	
	@NotEmpty
	public long preço;
	
	@ManyToOne
	@JoinColumn(name = "fk_categoria")
	private categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "fk_usuario")
	@JsonIgnoreProperties("produto")
	public Usuario usuario;


	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getProdutos() {
		return produtos;
	}

	public void setProdutos(String produtos) {
		this.produtos = produtos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public long getPreço() {
		return preço;
	}

	public void setPreço(long preço) {
		this.preço = preço;
	}

	public categoria getCategoria() {
		return categoria;
	}

	public void setcategoria(categoria categoria) {
		this.categoria = categoria;
	}


	public void setCategoria(categoria categoria) {
		this.categoria = categoria;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
