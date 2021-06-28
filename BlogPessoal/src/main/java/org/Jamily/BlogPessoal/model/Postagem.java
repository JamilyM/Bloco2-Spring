package org.Jamily.BlogPessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table (name= "postagem")
public class Postagem {
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long Id;
	
    @NotNull
    @Size(min = 5, max = 100)
	public String titulo;
    
    @NotNull
    @Size(min = 10, max = 500)
	public String Texto;
	
    @Temporal(TemporalType.TIMESTAMP)
	public Date data;
    
    @ManyToOne
    @JsonIgnoreProperties("postagem")
    public Tema tema;


	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String Titulo) {
		titulo = Titulo;
	}

	public String getTexto() {
		return Texto;
	}

	public void setTexto(String texto) {
		Texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}

	
}
