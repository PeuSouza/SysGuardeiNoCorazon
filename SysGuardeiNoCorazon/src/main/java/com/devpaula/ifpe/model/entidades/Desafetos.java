package com.devpaula.ifpe.model.entidades;

import java.util.List;

public class Desafetos {
	
    int id;
	String Nome;
	String Apelido;
	String Sexo;
	String DeOndeConheco;
	List<Desavencas> ListaDesavenças;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	
	public String getApelido() {
		return Apelido;
	}
	public void setApelido(String apelido) {
		Apelido = apelido;
	}
	
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	public String getDeOndeConheco() {
		return DeOndeConheco;
	}
	public void setDeOndeConheco(String deOndeConheco) {
		DeOndeConheco = deOndeConheco;
	}
	public List<Desavencas> getListaDesavenças() {
		return ListaDesavenças;
	}
	public void setListaDesavenças(List<Desavencas> listaDesavenças) {
		ListaDesavenças = listaDesavenças;
	}
	public void setDesavencas(List<Desavencas> filtroDeDesavencasporDesafeto) {
		// TODO Auto-generated method stub
		
	}
	
}
