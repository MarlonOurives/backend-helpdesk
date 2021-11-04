package com.marlon.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Marlon", "322.964.060-84", "marlon@mail.com", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Antonio", "152.011.670-55", "antonio@mail.com",encoder.encode("123"));
		Tecnico tec3 = new Tecnico(null, "Marcelo", "583.245.730-70", "marcelo@mail.com",encoder.encode("123"));
		Tecnico tec4 = new Tecnico(null, "Rafael", "915.122.010-57", "rafael@mail.com",encoder.encode("123"));
		Tecnico tec5 = new Tecnico(null, "Norberto", "437.628.730-03", "norberto@mail.com",encoder.encode("123"));

		Cliente cli1 = new Cliente(null, "Roberto", "480.036.790-52", "roberto@mail.com",encoder.encode("123"));
		Cliente cli2 = new Cliente(null, "Maria", "325.545.100-08", "maria@mail.com", encoder.encode("123"));
		Cliente cli3 = new Cliente(null, "Rangel", "105.017.030-04", "rangel@mail.com", encoder.encode("123"));
		Cliente cli4 = new Cliente(null, "Mateus", "052.059.620-03", "mateus@mail.com", encoder.encode("123"));
		Cliente cli5 = new Cliente(null, "Mikel", "245.801.370-86", "mikel@mail.com", encoder.encode("123"));

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Teste chamado 1", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.MEDIA, Status.ENCERRADO, "Chamado 2",  "Teste chamado 2", tec2, cli2);
		Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ANDAMENTO, "Chamado 3", "Teste chamado 3", tec2, cli3);
		Chamado c4 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "Chamado 4",  "Teste chamado 4", tec3, cli3);
		Chamado c5 = new Chamado(null, Prioridade.ALTA, Status.ENCERRADO, "Chamado 5",  "Teste chamado 5", tec2, cli1);
		Chamado c6 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 6",  "Teste chamado 6", tec2, cli5);

		
		tecnicoRepository.saveAll(Arrays.asList(tec1,tec2,tec3,tec4,tec5));
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3,cli4,cli5));
		chamadoRepository.saveAll(Arrays.asList(c1,c2,c2,c3,c4,c5,c6));
	}
}
