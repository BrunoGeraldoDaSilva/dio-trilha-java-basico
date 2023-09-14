package negocio;

import java.util.Optional;

import basedados.Banco;
import entidade.Produto;

public class ProdutoNegocio {
     private Banco bancoDados;

    public ProdutoNegocio(Banco banco) {
        this.bancoDados = banco;
    }

    public void salvar(Produto novoProduto) {

        String codigo = "PR%04d";
        codigo = String.format(codigo, bancoDados.getProdutos().length);
        novoProduto.setCodigo(codigo);

        boolean produtoRepetido = false;
        for (Produto produto: bancoDados.getProdutos()) {
            if (produto.getCodigo() == novoProduto.getCodigo()) { //Tem que usar no lugar no sinal ==.equals
                produtoRepetido = true;
                System.out.println("Produto já cadastrado.");
                break;
            }
        }

        if (!produtoRepetido) {
            this.bancoDados.adicionarProduto(novoProduto);
            System.out.println("Produto cadastrado com sucesso.");
        }
    }

    public void excluir(String codigo) {
        
    	int produtoExclusao = -1;
    	for (int i = 0; i < bancoDados.getProdutos().length; i++) {
    		
    		Produto produto = bancoDados.getProdutos()[i];
    		if (produto.getCodigo().equals(codigo)) {
    			produtoExclusao = i;
    			break;
    		}
    	}
    	if (produtoExclusao != -1) {
    		bancoDados.removerProduto(produtoExclusao);
    		System.out.println("Proguto excluido com sucesso.");
    	} else {
    		System.out.println("Produto inexistente.");
    	}
    }

    public Optional<Produto> consultar(String codigo) {

        for (Produto produto: bancoDados.getProdutos()) {

            if (produto.getCodigo().equalsIgnoreCase(codigo)) {
                return  Optional.of(produto);
            }
        }

        return Optional.empty();
    }

    public void listarTodos() {

        if (bancoDados.getProdutos().length == 0) {
            System.out.println("Não existem produtos cadastrados");
        } else {

            for (Produto produto: bancoDados.getProdutos()) {
                System.out.println(produto.toString());
            }
        }
    }
}
