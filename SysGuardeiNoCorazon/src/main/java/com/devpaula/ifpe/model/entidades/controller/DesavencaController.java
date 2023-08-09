package com.devpaula.ifpe.model.entidades.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.depaula.ifpe.model.repositorios.Fachada;
import com.devpaula.ifpe.model.entidades.Desafetos;
import com.devpaula.ifpe.model.entidades.Desavencas;

@RestController
public class DesavencaController {
	@PostMapping ("/Desavencas/{Desafetos_id}")
	public String criar (@RequestBody Desavencas Desavenca, @PathVariable ("Desafetos_id") int id ) {
		
		Desafetos Desafeto;
		try {
			Desafeto=Fachada.getCurrentInstance().lerDesafetos(id);
			Desavenca.setDesafeto(Desafeto);
			Fachada.getCurrentInstance().criar(Desavenca);
			return "Nova desavenca Cadastrada com sucesso! A vingança virá!";
		} catch (SQLException e) {
			return "Não foi possivel cadastrar!";
		}
		
	}
	@PutMapping("/Desavencas")
	public  void Atualizar(@RequestBody Desavencas Desavenca) {
		
		try {
			
			Fachada.getCurrentInstance().atualizar(Desavenca);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
	}
	
	@GetMapping("/Desavencas/{codigo}")
	public Desavencas Ler(@PathVariable("codigo") int codigo) {
		
		Desavencas Desavenca = Fachada.getCurrentInstance().lerDesavencas(codigo);
		
		return Desavenca;
		
	}
	
	@GetMapping("/Desavencas")
	public List<Desavencas> lertodos(){
		
		return Fachada.getCurrentInstance().lerTodosDesavencas();
				
	}
	

	
}
