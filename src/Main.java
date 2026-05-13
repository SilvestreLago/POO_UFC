import javax.swing.JOptionPane;

void main() {
    //Criar o tamanho da lista dos produtos
    GerenciamentoProdutos genProd = new GerenciamentoProdutos(5);

    //Inicializar variáveis
    int cod, quantidade, busca;
    String nome, descricao, vencimento, categoria;
    double preco;
    Produto produto;
    boolean controle = true;

    //Execução
    while(controle) {
        //Selecionar opção
        int opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Sistema de gerenciamento de produtos: \n 1 - Inserir produto \n 2 - Listar produtos \n 3 - Buscar produto \n 4 -Excluir produto\n 5 - Atualizar produto\n 6 - Adicionar no carrinho\n 7 - Ver carrinho\n 0 - Sair \n Selecione uma opção:"));

        switch (opc) {
            case 1: //Inserir produto
                //cod = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto:"));
                nome = JOptionPane.showInputDialog("Digite o nome do produto:");
                preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto:"));
                descricao = JOptionPane.showInputDialog("Digite a descrição do produto:");
                vencimento = JOptionPane.showInputDialog("Digite a data de vencimento do produto:");
                quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto:"));
                categoria = JOptionPane.showInputDialog("Digite a categoria do produto:");
                produto = new Produto(nome, preco, vencimento, quantidade, categoria, descricao);
                genProd.adicionarProduto(produto);
                break;

            case 2: //Listar produto
                JOptionPane.showMessageDialog(null, genProd.listarProdutos());
                break;

            case 3: //Buscar produto
                busca = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto:"));
                produto = genProd.buscarProduto(busca);
                if(produto == null){
                    JOptionPane.showMessageDialog(null, "Produto não encontrado!");
                }
                else{
                    JOptionPane.showMessageDialog(null, produto.exibirProduto());
                }

                break;

            case 4: //Remover produto
                busca = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto:"));
                genProd.excluirProduto(busca);
                break;

            case 5: //Editar produto
                busca = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto:"));
                produto = genProd.buscarProduto(busca);
                if(produto == null){
                    JOptionPane.showMessageDialog(null, "Produto não encontrado!");
                }
                else{
                    nome = JOptionPane.showInputDialog("Digite o novo nome do produto:");
                    preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o novo preço do produto:"));
                    descricao = JOptionPane.showInputDialog("Digite a nova descrição do produto:");
                    vencimento = JOptionPane.showInputDialog("Digite a nova data de vencimento do produto:");
                    quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade do produto:"));
                    categoria = JOptionPane.showInputDialog("Digite a nova categoria do produto:");
                    genProd.atualizarProduto(busca, nome, preco, quantidade, vencimento, categoria, descricao);
                }
                break;

            case 6: //Adicionar no carrinho
                busca = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto:"));
                produto = genProd.buscarProduto(busca);
                if(produto == null){
                    JOptionPane.showMessageDialog(null, "Produto não encontrado!");
                }
                else{
                    quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto:"));
                    if(quantidade > produto.getQuantidade()){
                        JOptionPane.showMessageDialog(null, "Quantidade indisponível.");
                    }
                    else{
                        genProd.adicionarCarrinho(produto, quantidade);
                    }
                }
                break;

            case 7:
                JOptionPane.showMessageDialog(null, genProd.verCarrinho());
                break;

            case 0: //Sair
                JOptionPane.showMessageDialog(null, "Saindo do sistema...");
                controle = false;
                break;
        }
    }


}
