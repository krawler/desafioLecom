package br.com.ebdes.desafiolecom.impl.dao.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ebdes.desafiolecom.dao.DAOCliente;
import br.com.ebdes.desafiolecom.dao.DAOOrdemServico;
import br.com.ebdes.desafiolecom.entidades.Cliente;
import br.com.ebdes.desafiolecom.entidades.OrdemServico;

@Primary
@Repository
public class HBCliente extends HBDAO<Cliente> implements DAOCliente {
	
	@Autowired
	private DAOOrdemServico daoOrdemServico;

	@Override
	protected Class getClazz() {
		return Cliente.class;
	}
	
	@Transactional
	@Override
	public void excluir(Cliente cliente){
		/*
		List<OrdemServico> ordens = daoOrdemServico.getOrdensByCliente(cliente);
		for (OrdemServico ordemServico : ordens) {
			daoOrdemServico.excluir(ordemServico);
		}*/
		getSession().delete(cliente);
	}

}
