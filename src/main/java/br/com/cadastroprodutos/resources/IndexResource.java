package br.com.cadastroprodutos.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexResource {


    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String index(){
        return "views/index";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/authenticate")
    public String paginaInicial(){
        return "login";
    }

}
