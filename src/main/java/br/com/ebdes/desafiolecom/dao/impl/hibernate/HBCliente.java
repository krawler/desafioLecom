package br.com.ebdes.desafiolecom.dao.impl.hibernate;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.com.ebdes.desafiolecom.dao.DAOCliente;
import br.com.ebdes.desafiolecom.entidades.Cliente;

@Primary
@Repository
public class HBCliente extends HBDAO<Cliente> implements DAOCliente {

	@Override
	protected Class getClazz() {
		return Cliente.class;
	}

}
