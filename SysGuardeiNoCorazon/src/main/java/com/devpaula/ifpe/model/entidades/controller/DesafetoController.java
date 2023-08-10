package com.devpaula.ifpe.model.entidades.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.depaula.ifpe.model.repositorios.Fachada;
import com.devpaula.ifpe.model.entidades.Desafetos;


@CrossOrigin(origins="*")
@RestController
public class DesafetoController {
	@PostMapping ("/Desafetos")
	public ResponseEntity<?> criar (@RequestBody Desafetos Desafetos) {
		try {
			Fachada.getCurrentInstance().criar(Desafetos);
			return  new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/Desafetos")
	public  void Atualizar(@RequestBody Desafetos Desafeto) {
		
		try {
			
			Fachada.getCurrentInstance().atualizar(Desafeto);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Erro ao alterar dados");
		}
		
	}
	
	@GetMapping("/Desafetos/{id}")
	public ResponseEntity<Desafetos> Ler(@PathVariable("id") int id) {
		Desafetos Desafeto = Fachada.getCurrentInstance().lerDesafetos(id);
 
if(Desafeto==null) {
		return new ResponseEntity<Desafetos>(HttpStatus.NOT_FOUND);
 }else {
		return new ResponseEntity<Desafetos>(Desafeto,HttpStatus.OK);
 }
		
	}
	
	@GetMapping("/Desafetos")
	public ResponseEntity<List<Desafetos>> lertodos(){
	
		List<Desafetos> Desafeto = new ArrayList<>();
		 Desafeto= Fachada.getCurrentInstance().lerTodosDesafetos();

    return new ResponseEntity<List<Desafetos>>(Desafeto,HttpStatus.OK);
	}
	
	@DeleteMapping("/Desafeto/{id}")
	public void delete(@PathVariable("id") int id) {
		Fachada.getCurrentInstance().deletarDesafetos(id);
	}
	
}