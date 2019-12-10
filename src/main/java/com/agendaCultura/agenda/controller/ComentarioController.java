package com.agendaCultura.agenda.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.agendaCultura.agenda.domain.Comentario;
import com.agendaCultura.agenda.service.ComentarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/comentarios")
public class ComentarioController {
	@Autowired
	private ComentarioService service;
	
	@RequestMapping(method =RequestMethod.GET )
	public ResponseEntity<List<Comentario>> listar(){
		List<Comentario> comentario = service.buscarTodos();
		return ResponseEntity.ok().body(comentario);
	}
	
	
	//Buscar por ID
	@RequestMapping(value = "/{id}" ,method =RequestMethod.GET )
	public ResponseEntity <Comentario> buscar(@PathVariable Integer id){
		Comentario obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//Postar comentário
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Comentario obj){
		obj = service.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
