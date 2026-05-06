public class Produto {
    private int codigo;
    private String nome;
    private String descricao;
    private double preco;
    private String vencimento;
    private int quantidade;
    private String categoria;

    public Produto(String nome, double preco, String vencimento, int quantidade, String categoria, String descricao) {
        this.setCodigo(GerenciamentoProdutos.CODIGO);
        this.setNome(nome);
        this.setPreco(preco);
        this.setVencimento(vencimento);
        this.setQuantidade(quantidade);
        this.setCategoria(categoria);
        this.setDescricao(descricao);
        GerenciamentoProdutos.CODIGO++;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if(preco >= 0) this.preco = preco;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if(quantidade >= 0) this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String exibirProduto(){
        String conteudo = "";
        conteudo =
                "\n\nCódigo: " + this.codigo +
                "\nNome: " + this.nome +
                "\nPreço: " + this.preco +
                "\nQuantidade: " + this.quantidade +
                "\nVencimento: " + this.vencimento +
                "\nCategoria: " + this.categoria +
                "\nDescrição: " + this.descricao;
        return conteudo;
    }
}
