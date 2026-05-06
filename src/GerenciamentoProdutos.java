public class GerenciamentoProdutos {
    private Produto produtos[];
    public int tamanho;
    private int id;
    static int CODIGO = 200;

    public GerenciamentoProdutos(int tamanho){
        this.tamanho = tamanho;
        this.produtos = new Produto[this.tamanho];
        this.id = 0;
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
}
