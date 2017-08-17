package com.ufcg.si1.model.queixa;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import exceptions.ObjetoInvalidoException;

@Entity
public class Queixa {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String descricao;

	private Long solicitanteId;

	private String comentario = ""; // usado na atualizacao da queixa
	
	public QueixaState queixaState;
	
	public Queixa(){

	}
	
	public Queixa(String descricao, int situacao,
            Long solicitanteId) {
	this.descricao = descricao;
	this.queixaState = new Aberta();
	this.comentario = "";
	this.solicitanteId = solicitanteId;
}


	public Queixa(String descricao, String comentario,
                  Long solicitanteId) {
		this.descricao = descricao;
		this.comentario = comentario;
		this.solicitanteId = solicitanteId;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getSolicitanteId() {
		return solicitanteId;
	}

	public void setSolicitanteId(Long solicitanteId) {
		this.solicitanteId = solicitanteId;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public QueixaState getSituacao() {
		return this.queixaState;
	}

//	public void setSituacao(SituacaoQueixa situacao) {
//		this.situacao = situacao;
//	}
	
	public void abrir() throws ObjetoInvalidoException {
		this.queixaState.abrir();
	}

	public void fechar(String coment) throws ObjetoInvalidoException {
		this.queixaState.fechar();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Queixa other = (Queixa) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
