package br.com.ebdes.desafiolecom.dao.impl.hibernate;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.com.ebdes.desafiolecom.dao.DAOServico;
import br.com.ebdes.desafiolecom.entidades.Servico;

@Repository
public class HBServico extends HBDAO<Servico> implements DAOServico {

	@Override
	protected Class getClazz() {
		return Servico.class;
	}

}
