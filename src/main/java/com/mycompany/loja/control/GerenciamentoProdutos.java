/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loja.control;

import com.mycompany.loja.model.Produto;
import java.util.LinkedList;

/**
 *
 * @author silvestre
 */
public class GerenciamentoProdutos {
    private LinkedList<Produto> produtos;
    public static int CODIGO = 200;
    private static GerenciamentoProdutos instance = null;
    private String carrinho;
    private double total;

    private GerenciamentoProdutos(){
        this.produtos = new LinkedList<Produto>();
        this.carrinho = "";
        this.total = 0;
    }
    
    public static GerenciamentoProdutos getInstance(){
        if (instance == null){
            instance = new GerenciamentoProdutos();
        }
        return instance;
    }

    public void adicionarProduto(Produto produto){
            this.produtos.add(produto);
    }
    
    public String listarProdutos(){
        String conteudo = "";
        for(Produto produto: this.produtos){
            conteudo = produto.exibirProduto();
        }
        return conteudo;
    }

    public Produto buscarProduto(int codigo){
        for (Produto produto: this.produtos){
            if(produto.getCodigo() == codigo){
                return produto;
            }
        }
        return null;
    }

    public void excluirProduto(int codigo){
        for(Produto produto: this.produtos){
            if(produto.getCodigo() == codigo){
                this.produtos.remove(produto);
                return;
            }
        }
    }

    public void atualizarProduto(int codigo, String nome, double preco, 
            int quantidade, String vencimento, String categoria, String descricao){
        for(Produto produto: this.produtos){
            if(codigo == produto.getCodigo()){
                produto.setNome(nome);
                produto.setPreco(preco);
                produto.setQuantidade(quantidade);
                produto.setVencimento(vencimento);
                produto.setCategoria(categoria);
                produto.setDescricao(descricao);
                return;
            }
        }
    }
    /*
    public void adicionarCarrinho(Produto produto, int quantidade){
        this.carrinho = this.carrinho + "\nCodigo: " + produto.getCodigo() + "\n\tNome: " + produto.getNome() + "\n\tQuantidade: " + quantidade + "\n\tPreço: " + produto.getPreco() * quantidade + "\n";
        this.total += produto.getPreco() * quantidade;
        produto.setQuantidade(produto.getQuantidade() - quantidade);
    }

    public String verCarrinho(){
        return this.carrinho + "\nTotal: " + this.total +"\n";
    }

    public String verificarEstoque(){
        int i;
        String conteudo = "";
        if(this.id == 0){
            return "Nenhum item encontrado no estoque.";
        }
        for(i = 0; i < this.id; ++i){
            if(this.produtos[i].getQuantidade() == 0){
                conteudo += "Código: " + this.produtos[i].getCodigo() + " Nome: "+ this.produtos[i].getNome() +" Descrição: " + this.produtos[i].getDescricao() + " Preço: " + this.produtos[i].getPreco() + "\n";
            }
        }
        if(conteudo.equals("")){
            return "Os produtos possuem itens.";
        }
        return conteudo;
    }

    public String verificarEstoque(int margem){
        int i;
        String conteudo = "";
        if(this.id == 0){
            return "Nenhum item encontrado no estoque.";
        }
        for(i = 0; i < this.id; ++i){
            if(this.produtos[i].getQuantidade() <= margem){
                conteudo += "Código: " + this.produtos[i].getCodigo() + " Nome: "+ this.produtos[i].getNome() +" Descrição: " + this.produtos[i].getDescricao() + " Preço: " + this.produtos[i].getPreco() + "\n";
            }
        }
        if(conteudo.equals("")){
            return "Os produtos possuem itens.";
        }
        return conteudo;
    }

    public String finalizarCompra(){
        String conteudo =  this.carrinho + "\nTotal: " + this.total + "\n Compra concluída com sucesso!\n";
        this.carrinho = "";
        this.total = 0;
        return conteudo;
    }*/   
}