package com.marlon.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marlon.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
