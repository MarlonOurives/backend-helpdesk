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
		Tecnico tec1 = new Tecnico(null, "Marlon", "322.964.060-84", "marlon@mail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		Cliente cli1 = new Cliente(null, "Roberto", "480.036.790-52", "roberto@mail.com", "123");
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Primeiro chamado", tec1, cli1);
		Tecnico tec2 = new Tecnico(null, "Antonio", "152.011.670-55", "antonio@mail.com", "123");
		Cliente cli2 = new Cliente(null, "Maria", "325.545.100-08", "maria@mail.com", "123");
		Chamado c2 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Primeiro chamado", tec2, cli2);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1,tec2));
		clienteRepository.saveAll(Arrays.asList(cli1,cli2));
		chamadoRepository.saveAll(Arrays.asList(c1,c2));
	}
}
