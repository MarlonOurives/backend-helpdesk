package com.marlon.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marlon.helpdesk.domain.Chamado;
import com.marlon.helpdesk.domain.Cliente;
import com.marlon.helpdesk.domain.Tecnico;
import com.marlon.helpdesk.domain.enums.Perfil;
import com.marlon.helpdesk.domain.enums.Prioridade;
import com.marlon.helpdesk.domain.enums.Status;
import com.marlon.helpdesk.repositories.ChamadoRepository;
import com.marlon.helpdesk.repositories.ClienteRepository;
import com.marlon.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	
	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Marlon", "96632193005", "marlon@mail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Roberto", "85545547010", "roberto@mail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
