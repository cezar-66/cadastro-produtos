package br.com.cadastroprodutos.resources;

import br.com.cadastroprodutos.models.Usuario;
import br.com.cadastroprodutos.services.OperadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OperadorResource {

    @Autowired
    private OperadorService service;

    @RequestMapping(method = RequestMethod.GET, path = "/listOperadores")
    public ModelAndView listAllProdutos(){
        return service.getAllProdutos();
    }

    //detalhesOperador
    @RequestMapping(value="/{codigo}", method=RequestMethod.GET)
    public ModelAndView detalhesOperador(@PathVariable("codigo") Integer codigo){
        ModelAndView mv = service.detalhesOperador(codigo);
        return mv;
    }

}
