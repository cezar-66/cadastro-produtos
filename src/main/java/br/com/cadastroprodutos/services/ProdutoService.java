package br.com.cadastroprodutos.services;

import br.com.cadastroprodutos.models.Produto;
import br.com.cadastroprodutos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository pr;

    public ModelAndView getAllProdutos(){
        ModelAndView mv = new ModelAndView("views/produtos/listaProdutos");
        List<Produto> produtos = pr.findAll();
        mv.addObject("produtos", produtos);
        return mv;
    }
}
