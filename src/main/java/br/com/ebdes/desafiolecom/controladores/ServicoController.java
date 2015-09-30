package br.com.ebdes.desafiolecom.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.ebdes.desafiolecom.dao.DAOServico;
import br.com.ebdes.desafiolecom.entidades.Servico;

@RequestMapping("/servico")
@Controller
public class ServicoController {
	
	@Autowired
	private DAOServico daoServico;

	@RequestMapping("/listar")
	public ModelAndView listar(){
		return new ModelAndView("servico/listar")
				.addObject("servicos", daoServico.list(0, 20))
				.addObject("servico", new Servico());		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/incluir")
	public String incluir(@Valid Servico servico){
		daoServico.persistir(servico);
		return "redirect:listar";
	}
}
