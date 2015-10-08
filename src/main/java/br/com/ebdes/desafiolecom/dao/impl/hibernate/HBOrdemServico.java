package br.com.ebdes.desafiolecom.dao.impl.hibernate;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.com.ebdes.desafiolecom.dao.DAOOrdemServico;
import br.com.ebdes.desafiolecom.entidades.Cliente;
import br.com.ebdes.desafiolecom.entidades.OrdemServico;

@Primary
@Repository
public class HBOrdemServico extends HBDAO<OrdemServico> implements DAOOrdemServico {

	@Override
	protected Class getClazz() {
		return OrdemServico.class;
	}

	public List<OrdemServico> getOrdensByCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrdemServico> getOrdensNaoFinalizadas() {
		// TODO Auto-generated method stub
		return null;
	}

}
