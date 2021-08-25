package br.com.cadastroprodutos.resources;

import br.com.cadastroprodutos.models.Usuario;
import br.com.cadastroprodutos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @RequestMapping(method = RequestMethod.GET, path = "/listUsuarios")
    public ModelAndView listAllOperadores(){
        return service.getAllOperadores();
    }

    @RequestMapping(path = "/autocompleteUsuarios", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Usuario> autoCompleteOperador(@RequestParam String name){
        return service.autoCompleteUsuarios(name);
    }

    @RequestMapping(value="/formEditUser/{codigo}", method=RequestMethod.GET)
    public ModelAndView formEditUser(@RequestParam Integer codigo){
        ModelAndView mv = service.formEditUser(codigo);
        return mv;
    }

}
