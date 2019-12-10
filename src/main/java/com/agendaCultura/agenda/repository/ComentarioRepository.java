package com.agendaCultura.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agendaCultura.agenda.domain.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer>{

}
