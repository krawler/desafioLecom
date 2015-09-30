package br.com.ebdes.desafiolecom.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.ebdes.desafiolecom.dao.DAOServico;
import br.com.ebdes.desafiolecom.entidades.Servico;

@Component
public class EMServico extends EMDAO<Servico> implements DAOServico {

	@Override
	protected Class getClazz() {
		return Servico.class;
	}

}
