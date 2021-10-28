package com.marlon.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marlon.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
