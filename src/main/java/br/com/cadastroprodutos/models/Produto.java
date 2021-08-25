package br.com.cadastroprodutos.models;

import javax.persistence.*;

@Entity(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "codigo_categoria", referencedColumnName = "codigo", nullable = false)
    private Categoria categoria;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "descricao", nullable = false, length = 100)
    private String descricao;

    @Column(name = "fabricante", length = 100)
    private String fabricante;

    public Produto(Integer codigo, String nome, String descricao, Categoria categoria) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Produto(){}

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
}
