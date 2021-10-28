package com.marlon.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marlon.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
