package com.marlon.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marlon.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
