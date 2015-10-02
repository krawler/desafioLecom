package br.com.ebdes.desafiolecom.dao;

import java.util.List;

import br.com.ebdes.desafiolecom.entidades.Cliente;
import br.com.ebdes.desafiolecom.entidades.OrdemServico;

public interface DAOOrdemServico extends DAOBase<OrdemServico> {

	List<OrdemServico> getOrdensByCliente(Cliente cliente);

	List<OrdemServico> getOrdensNaoFinalizadas();
	
}
