package br.com.ebdes.desafiolecom.controladores;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ebdes.desafiolecom.dao.DAOOrdemServico;

@Controller
public class IndexController {
	
	private static Logger logger = Logger.getLogger("IndexController");
	
	@Autowired
	private DAOOrdemServico daoOrdemServico;
	
	@RequestMapping("/")
	public ModelAndView index(){
		return new ModelAndView("index")
					.addObject("ordens", daoOrdemServico.list(0,20));
	}
}
