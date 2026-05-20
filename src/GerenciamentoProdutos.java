public class GerenciamentoProdutos {
    private Produto produtos[];
    public int tamanho;
    private int id;
    static int CODIGO = 200;
    private String carrinho;
    private double total;

    public GerenciamentoProdutos(int tamanho){
        this.tamanho = tamanho;
        this.produtos = new Produto[this.tamanho];
        this.id = 0;
        this.carrinho = "";
        this.total = 0;
    }

    public void adicionarProduto(Produto produto){
        if (this.id < this.tamanho){
            this.produtos[this.id] = produto;
            ++this.id;
        }
    }

    public String listarProdutos(){
        int i;
        String conteudo = "";
        for(i = 0; i < this.id; ++i){
            conteudo = conteudo + this.produtos[i].exibirProduto();
        }
        return conteudo;
    }

    public Produto buscarProduto(int codigo){
        int i;
        for (i = 0; i < this.id; i++){
            if(this.produtos[i].getCodigo() == codigo){
                return this.produtos[i];
            }
        }
        return null;
    }

    public void excluirProduto(int codigo){
        int i, j;
        for(i = 0; i < this.id; i++){
            if(this.produtos[i].getCodigo() == codigo){
                if(i == (this.id - 1)){
                    --this.id;
                }
                else{
                    for(j = i; j < (this.id-1) ; j++){
                        this.produtos[j] = this.produtos[j+i];
                    }
                    --this.id;
                    return;
                }
            }
        }
    }

    public void atualizarProduto(int codigo, String nome, double preco, int quantidade, String vencimento, String categoria, String descricao){
        int i;
        for(i = 0; i < this.id; i++){
            if(codigo == this.produtos[i].getCodigo()){
                this.produtos[i].setNome(nome);
                this.produtos[i].setPreco(preco);
                this.produtos[i].setQuantidade(quantidade);
                this.produtos[i].setVencimento(vencimento);
                this.produtos[i].setCategoria(categoria);
                this.produtos[i].setDescricao(descricao);
                return;
            }
        }
    }

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
    }
}
