package br.com.ebdes.desafiolecom.controladores.conversores;

import java.beans.PropertyEditorSupport;

import br.com.ebdes.desafiolecom.dao.DAOCliente;
import br.com.ebdes.desafiolecom.entidades.Cliente;

public class ClientePropertyEditor extends PropertyEditorSupport {
	
	private DAOCliente daoCliente;
	
	public ClientePropertyEditor(DAOCliente dao){
		this.daoCliente = dao;
	}
	
	@Override
	public void setAsText(String text){
		Long id = new Long(text);
		Cliente cliente = daoCliente.get(id);
		super.setValue(cliente);
	}

}
