package br.com.ebdes.desafiolecom.impl.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional
	public List<OrdemServico> getOrdensByCliente(Cliente cliente) {
		List<OrdemServico> retorno = new ArrayList<OrdemServico>();
		retorno = getSession()
					.createCriteria(getClazz())
					.add(Restrictions.eq("cliente", cliente))
					.list();
		return retorno;
	}

	public List<OrdemServico> getOrdensNaoFinalizadas() {
		return getSession()
				.createCriteria(getClazz())
				.add(Restrictions.eq("dataFinal", null))
				.list();
	}

}
