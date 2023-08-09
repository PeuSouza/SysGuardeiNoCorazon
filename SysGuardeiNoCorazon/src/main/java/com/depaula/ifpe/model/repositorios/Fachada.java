package com.depaula.ifpe.model.repositorios;

import java.sql.SQLException;
import java.util.List;

import com.devpaula.ifpe.model.entidades.Desafetos;
import com.devpaula.ifpe.model.entidades.Desavencas;

public class Fachada {

	private static Fachada instance = new Fachada();
	private GenericRepository<Desafetos, Integer> Desafetosrep = null;
	private GenericRepository<Desavencas, Integer> Desavencasrep= null;
	
	private Fachada () {
		this.Desafetosrep= new DesafetosRepositorio();
		this.Desavencasrep= new DesavencasRepositorio();
	}
	public static Fachada getCurrentInstance(){
		return instance;
	}
	
	// criar 
	public void criar (Desafetos Desafeto) throws SQLException {
		this.Desafetosrep.criar(Desafeto);
	}
	
	public void criar (Desavencas Desavencas) throws SQLException {
		this.Desavencasrep.criar(Desavencas);
	}
	
	//atualizar
	
	public void atualizar (Desafetos Desafeto) throws SQLException {
		this.Desafetosrep.atualizar(Desafeto);
	}
	
	public void atualizar (Desavencas Desavencas) throws SQLException{
		this.Desavencasrep.atualizar(Desavencas);
	}
	
	//ler
	
	public Desafetos lerDesafetos(Integer key) {
		return this.Desafetosrep.ler(key);
	}
	
	public Desavencas lerDesavencas(Integer codigo) {
		return this.Desavencasrep.ler(codigo);
	}
	
	//lerTodos
	public List<Desafetos> lerTodosDesafetos(){
		return this.Desafetosrep.lerTodos();
	}
	public List<Desavencas> lerTodosDesavencas(){
		return this.Desavencasrep.lerTodos();
	}
	
	//deletar
	
	public void deletarDesafetos (Integer key) {
		this.Desafetosrep.deletar(key);
	}
	
	public void deletarDesavencas (Integer codigo) {
		this.Desavencasrep.deletar(codigo);
	}
	
}
