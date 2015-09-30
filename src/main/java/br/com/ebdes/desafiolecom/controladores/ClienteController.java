package br.com.ebdes.desafiolecom.controladores;

import javax.websocket.server.PathParam;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.ebdes.desafiolecom.dao.DAOCliente;
import br.com.ebdes.desafiolecom.entidades.Cliente;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private DAOCliente daoCliente;
	
	@RequestMapping("/listar")
	public ModelAndView listar(){
		return new ModelAndView("cliente/listar")
					.addObject("clientes", daoCliente.list(0, 20));
	}
	
	@RequestMapping("/cadastro")
	public ModelAndView cadastro(){
		return new ModelAndView("cliente/cadastro")
					.addObject("cliente", new Cliente());
	}
	
	@RequestMapping("/cadastro/{id}")
	public ModelAndView cadastro(@PathVariable("id") Long id){
		ModelAndView mav =  new ModelAndView();
		mav.getModel().put("cliente", daoCliente.get(id));
		mav.setViewName("cliente/cadastro");
		return mav;
	}
	
	@RequestMapping(value="/incluir", method=RequestMethod.POST)
	public String incluir(@Valid Cliente cliente){
		daoCliente.persistir(cliente);
		return "redirect:listar";
	}
	
	@RequestMapping(value="/excluir/{id}")
	public String excluir(@PathVariable("id") Long id){
		Cliente cliente = daoCliente.get(id);
		daoCliente.excluir(cliente);
		return "redirect:listar";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
