package br.com.ebdes.desafiolecom.dao.impl;

import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Component;

import br.com.ebdes.desafiolecom.dao.DAOOrdemServico;
import br.com.ebdes.desafiolecom.entidades.OrdemServico;

@Component
public class EMOrdemServico extends EMDAO<OrdemServico> implements DAOOrdemServico {

	@Override
	protected Class getClazz() {
		return OrdemServico.class;
	}

}
