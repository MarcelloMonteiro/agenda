package com.agendaCultura.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendaCultura.agenda.domain.Comentario;
import com.agendaCultura.agenda.repository.ComentarioRepository;

@Service
public class ComentarioService {
	@Autowired
	private ComentarioRepository repo;
	
	public Comentario inserir (Comentario obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	//Buscar por Id
	public Comentario buscar(Integer id) {
		Optional<Comentario> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	//Bucar todos
	public List <Comentario> buscarTodos(){
		List <Comentario> comentarios = repo.findAll();
		return comentarios;
	}
}
