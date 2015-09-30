package br.com.ebdes.desafiolecom.controladores.conversores;

import java.beans.PropertyEditorSupport;

import br.com.ebdes.desafiolecom.dao.DAOServico;
import br.com.ebdes.desafiolecom.entidades.Servico;

public class ServicoPropertyEditor extends PropertyEditorSupport {
	
	private DAOServico daoServico;
	
	public ServicoPropertyEditor(DAOServico daoServico){
		this.daoServico = daoServico;
	}
	
	@Override
	public void setAsText(String text){
		Long id = new Long(text);
		Servico servico = daoServico.get(id);
		super.setValue(servico);
	}

}
