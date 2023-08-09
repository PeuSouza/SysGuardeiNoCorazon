package com.devpaula.ifpe.model.entidades;

import java.sql.Timestamp;

public class Desavencas {
    int codigo;
	long data;
	Timestamp Hora;
	String Descricao;
	String Motivacao;
	String Local;
	Desafetos Desafeto;
	
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public long getData() {
		return data;
	}
	public void setData(long data) {
		this.data = data;
	}
	
	
	public Timestamp getHora() {
		return Hora;
	}
	public void setHora(Timestamp hora) {
		Hora = hora;
	}
	
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	
	public String getMotivacao() {
		return Motivacao;
	}
	public void setMotivacao(String motivacao) {
		Motivacao = motivacao;
	}
	
	public String getLocal() {
		return Local;
	}
	public void setLocal(String local) {
		Local = local;
	}

	public Desafetos getDesafeto() {
		return Desafeto;
	}
	public void setDesafeto(Desafetos desafeto) {
		Desafeto = desafeto;
	}
	
	
}
