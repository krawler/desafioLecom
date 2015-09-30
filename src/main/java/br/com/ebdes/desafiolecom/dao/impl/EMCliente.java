package br.com.ebdes.desafiolecom.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.ebdes.desafiolecom.dao.DAOCliente;
import br.com.ebdes.desafiolecom.entidades.Cliente;

@Component
public class EMCliente extends EMDAO<Cliente> implements DAOCliente {

	@Override
	protected Class getClazz() {
		return Cliente.class;
	}	
}
