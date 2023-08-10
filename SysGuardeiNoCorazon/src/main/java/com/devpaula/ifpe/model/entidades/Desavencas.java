package com.devpaula.ifpe.model.entidades;

import java.sql.Timestamp;

public class Desavencas {
    int codigo;
	String data;
	String Hora;
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
	public String getData() {
		return data;
	}
	public String setData(String data) {
		return data;
	}
	
	public String getHora() {
		return Hora;
	}
	public void setHora(String hora) {
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
