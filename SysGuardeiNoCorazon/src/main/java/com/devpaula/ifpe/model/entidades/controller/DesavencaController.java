package com.devpaula.ifpe.model.entidades.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.depaula.ifpe.model.repositorios.Fachada;
import com.devpaula.ifpe.model.entidades.Desafetos;
import com.devpaula.ifpe.model.entidades.Desavencas;

@CrossOrigin(origins="*")
@RestController
public class DesavencaController {
	@PostMapping ("/Desavencas/{desafeto_id}")
	public ResponseEntity<?> criar (@RequestBody Desavencas Desavenca, @PathVariable ("desafeto_id") int id ) {
		
		Desafetos Desafeto;
		try {
			Desafeto=Fachada.getCurrentInstance().lerDesafetos(id);
			Desavenca.setDesafeto(Desafeto);
			Fachada.getCurrentInstance().criar(Desavenca);
			return  new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PutMapping("/Desavencas")
	public  void Atualizar(@RequestBody Desavencas Desavenca) {
		
		try {
			
			Fachada.getCurrentInstance().atualizar(Desavenca);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Erro ao alterar Desavenca");
		}
		
	}
	
	@GetMapping("/Desavencas/{codigo}")
	public ResponseEntity<Desavencas> Ler(@PathVariable("codigo") int codigo) {
		Desavencas Desavenca = Fachada.getCurrentInstance().lerDesavencas(codigo);
		
		if(Desavenca==null) {
			return new ResponseEntity<Desavencas>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Desavencas>(Desavenca,HttpStatus.OK);
		}
		
		
	}
	
	@GetMapping("/Desavencas")
	public ResponseEntity<List<Desavencas>>lertodos(){
		List<Desavencas> lDesavenca = new ArrayList<>();
		lDesavenca= Fachada.getCurrentInstance().lerTodosDesavencas();
		return new ResponseEntity<List<Desavencas>>(lDesavenca,HttpStatus.OK);

	}
}
