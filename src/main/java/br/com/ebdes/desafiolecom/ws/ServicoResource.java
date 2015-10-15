package br.com.ebdes.desafiolecom.ws;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.ebdes.desafiolecom.dao.DAOCliente;
import br.com.ebdes.desafiolecom.dao.DAOOrdemServico;
import br.com.ebdes.desafiolecom.dao.DAOServico;
import br.com.ebdes.desafiolecom.entidades.Cliente;
import br.com.ebdes.desafiolecom.entidades.OrdemServico;
import br.com.ebdes.desafiolecom.entidades.Servico;

@Controller
@RequestMapping("ws")
public class ServicoResource {
	
	@Autowired
	private DAOServico daoServico;
	@Autowired 
	private DAOCliente daoCliente;
	@Autowired
	private DAOOrdemServico daoOrdemServico;

	@RequestMapping(value="/servicos",method=RequestMethod.GET,produces="application/json")
	public List<Servico> servicos(){
		List<Servico> retorno = new ArrayList<Servico>();
		retorno = daoServico.listAll(); 
		return retorno;		
	}
	
	@RequestMapping(value="/clientes",method=RequestMethod.GET,produces="application/json")
	public List<Cliente> clientes(){
		List<Cliente> retorno = new ArrayList<Cliente>();
		retorno = daoCliente.listAll(); 
		return retorno;		
	}
	
	@RequestMapping(value="/ordens-por-cliente/{id}",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody List<OrdemServico> ordensPorCliente(@PathParam(value="id") String id){
		List<OrdemServico> retorno = new ArrayList<OrdemServico>();
		retorno = daoOrdemServico.getOrdensByCliente(daoCliente.get(new Long(id))); 
		return retorno;		
	}
	
	@RequestMapping(value="/ordens-nao-finalizadas",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody List<OrdemServico> ordensNaoFinalizadas(@PathParam(value="id") String id){
		List<OrdemServico> retorno = new ArrayList<OrdemServico>();
		retorno = daoOrdemServico.getOrdensNaoFinalizadas(); 
		return retorno;		
	}	
	
}
