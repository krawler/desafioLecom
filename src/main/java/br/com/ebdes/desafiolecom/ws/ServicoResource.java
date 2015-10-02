package br.com.ebdes.desafiolecom.ws;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ebdes.desafiolecom.dao.DAOCliente;
import br.com.ebdes.desafiolecom.dao.DAOOrdemServico;
import br.com.ebdes.desafiolecom.dao.DAOServico;
import br.com.ebdes.desafiolecom.entidades.Cliente;
import br.com.ebdes.desafiolecom.entidades.OrdemServico;
import br.com.ebdes.desafiolecom.entidades.Servico;

@Path("/ws")
public class ServicoResource {
	
	@Autowired
	private DAOServico daoServico;
	@Autowired 
	private DAOCliente daoCliente;
	@Autowired
	private DAOOrdemServico daoOrdemServico;

	@GET
	@Path("/servicos")
	@Produces("application/json")
	public List<Servico> servicos(){
		List<Servico> retorno = new ArrayList<Servico>();
		retorno = daoServico.listAll(); 
		return retorno;		
	}
	
	@GET
	@Path("/clientes")
	@Produces("application/json")
	public List<Cliente> clientes(){
		List<Cliente> retorno = new ArrayList<Cliente>();
		retorno = daoCliente.listAll(); 
		return retorno;		
	}
	
	@GET
	@Path("/ordens-por-cliente/{id}")
	@Produces("application/json")
	public List<OrdemServico> ordensPorCliente(@PathParam(value="id") String id){
		List<OrdemServico> retorno = new ArrayList<OrdemServico>();
		retorno = daoOrdemServico.getOrdensByCliente(daoCliente.get(new Long(id))); 
		return retorno;		
	}
	
	@GET
	@Path("/ordens-nao-finalizadas")
	@Produces("application/json")
	public List<OrdemServico> ordensNaoFinalizadas(@PathParam(value="id") String id){
		List<OrdemServico> retorno = new ArrayList<OrdemServico>();
		retorno = daoOrdemServico.getOrdensNaoFinalizadas(); 
		return retorno;		
	}
	
	
	
}
