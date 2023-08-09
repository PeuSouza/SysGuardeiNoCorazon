package com.devpaula.ifpe.model.entidades.controller;

import java.sql.SQLException;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.depaula.ifpe.model.repositorios.Fachada;
import com.devpaula.ifpe.model.entidades.Desafetos;


@CrossOrigin("*")
@RestController
public class DesafetoController {
	@PostMapping ("/Desafetos")
	public String criar (@RequestBody Desafetos Desafetos) {
		try {
			Fachada.getCurrentInstance().criar(Desafetos);
			return "Novo Desafeto Cadastrado com sucesso! A vingança virá!";
		} catch (SQLException e) {
			return "Não foi possivel cadastrar!";
		}
		
	}
	
	@PutMapping("/Desafetos")
	public  void Atualizar(@RequestBody Desafetos Desafeto) {
		
		try {
			
			Fachada.getCurrentInstance().atualizar(Desafeto);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
	}
	
	@GetMapping("/Desafetos/{id}")
	public Desafetos Ler(@PathVariable("id") int id) {
		
		Desafetos Desafeto = Fachada.getCurrentInstance().lerDesafetos(id);
		
		return Desafeto;
		
	}
	
	@GetMapping("/Desafetos")
	public List<Desafetos> lertodos(){
		
		//List<Desafetos> Desafeto = new ArrayList<>();
		return Fachada.getCurrentInstance().lerTodosDesafetos();
				
	}
	
}