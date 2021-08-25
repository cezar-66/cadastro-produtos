package br.com.cadastroprodutos.services;

import br.com.cadastroprodutos.models.Categoria;
import br.com.cadastroprodutos.models.Produto;
import br.com.cadastroprodutos.repository.CategoriaRepository;
import br.com.cadastroprodutos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository pr;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public ModelAndView getAllProdutos(){
        ModelAndView mv = new ModelAndView("views/produtos/index");
        List<Produto> produtos = pr.findAll();
        mv.addObject("produtos", produtos);
        return mv;
    }

    public List<Produto> autoCompleteProdutos(String nome){
        if(nome.isEmpty()){
            List<Produto> results = pr.findByNomeIsContaining(nome);
            return results.stream().filter(pro -> pro.getNome().contains(nome)).collect(Collectors.toList());
        }
        return null;
    }

    public ModelAndView formEditProduto(Integer codigo){
        Produto produto = pr.getById(codigo);
        ModelAndView mv = new ModelAndView("views/produtos/edit-produto");
        mv.addObject("produto", produto);
        return mv;
    }
    public ModelAndView formCadastroProduto(){
        List<Categoria> allCategorias = categoriaRepository.findAllByOrderByNome();
        ModelAndView mv = new ModelAndView("views/produtos/cadastro-produto");
        mv.addObject("categorias", allCategorias);
        return mv;
    }


    public String formCadastroProduto(Produto produto,
                                      BindingResult result,
                                      RedirectAttributes attributes) {

        if(result.hasErrors()){
            attributes.addFlashAttribute("error", "Verifique os campos!");
            return "redirect:/listAllProdutos";
        }
        pr.save(produto);
        attributes.addFlashAttribute("success", "Produto cadastrado com sucesso!");
        return "redirect:/listAllProdutos";
    }
}
