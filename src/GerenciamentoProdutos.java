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
}
