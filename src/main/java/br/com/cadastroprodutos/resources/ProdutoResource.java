package br.com.cadastroprodutos.resources;

import br.com.cadastroprodutos.models.Produto;
import br.com.cadastroprodutos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @RequestMapping(method = RequestMethod.GET, path = "/listAllProdutos")
    public ModelAndView listAllProdutos() {
        return service.getAllProdutos();
    }

    @RequestMapping(path = "/autocompleteProdutos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Produto> autoCompleteOperador(@RequestParam String name) {
        return service.autoCompleteProdutos(name);
    }

    @RequestMapping(path = "/GetProdutosAutoComplete", method = RequestMethod.GET)
    public ModelAndView GetAutoComplete(@RequestParam String name){
        return service.GetAutoComplete(name);
    }

    @RequestMapping(value = "/formEditProduto/{codigoProduto}", method = RequestMethod.GET)
    public ModelAndView formEditProduto(@RequestParam Integer codigo) {
        return service.formEditProduto(codigo);
    }

    @RequestMapping(value = "/formCadastroProduto", method = RequestMethod.GET)
    public ModelAndView formCadastroProduto() {
        return service.formCadastroProduto();
    }

    @RequestMapping(value = "/formCadastroProduto", method = RequestMethod.POST)
    public String formCadastroProduto(@Valid Produto produto,
                                      BindingResult result,
                                      RedirectAttributes attributes) {
        return service.formCadastroProduto(produto, result, attributes);
    }

    @RequestMapping(value = "/updateProduto/{codigo}", method = RequestMethod.POST)
    public String updateProduto(@PathVariable("codigo") Integer codigo,
                                @Valid Produto produto,
                                BindingResult result,
                                RedirectAttributes attributes) {
        return service.updateProduto(codigo, produto, result, attributes);
    }


    @RequestMapping(value = "/deleteProduto")
    public String deleteProduto(@RequestParam Integer codigo,
                                RedirectAttributes attributes){
        return service.deleteProduto(codigo, attributes);
    }


}
