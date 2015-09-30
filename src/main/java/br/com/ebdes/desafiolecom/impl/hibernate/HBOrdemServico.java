package br.com.ebdes.desafiolecom.impl.hibernate;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.com.ebdes.desafiolecom.dao.DAOOrdemServico;
import br.com.ebdes.desafiolecom.entidades.OrdemServico;

@Primary
@Repository
public class HBOrdemServico extends HBDAO<OrdemServico> implements DAOOrdemServico {

	@Override
	protected Class getClazz() {
		return OrdemServico.class;
	}

}
