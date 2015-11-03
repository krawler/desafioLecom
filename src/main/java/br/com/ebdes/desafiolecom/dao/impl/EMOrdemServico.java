package br.com.ebdes.desafiolecom.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.springframework.context.annotation.Primary;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.com.ebdes.desafiolecom.dao.DAOOrdemServico;
import br.com.ebdes.desafiolecom.entidades.Cliente;
import br.com.ebdes.desafiolecom.entidades.OrdemServico;
import br.com.ebdes.desafiolecom.entidades.Servico;

@Primary
@Repository
public class EMOrdemServico extends EMDAO<OrdemServico> implements DAOOrdemServico {

	@Override
	protected Class getClazz() {
		return OrdemServico.class;
	}
	
	@Override
	public List<OrdemServico> list(int offset, int max){
		 List<OrdemServico> servicos = super.list(offset, max);
		 for (OrdemServico ordemServico : servicos) {
			  ordemServico.getServicos();
			  for (Servico servico : ordemServico.getServicos()) {
				   servico.getDescricao();
			}
		 }
		 return servicos;
	}
	
	@Override
	public OrdemServico get(Long id){
		OrdemServico os = super.get(id);
		os.getCliente().getNome();
		for(Servico servico : os.getServicos()){
			servico.getDescricao();
		}
		return os;
	}

	public List<OrdemServico> getOrdensByCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<OrdemServico> getOrdensNaoFinalizadas() {
		return getEntityManager()
				.createQuery("from OrdemServico where dataFinal is null")
				.getResultList();
	}

}
