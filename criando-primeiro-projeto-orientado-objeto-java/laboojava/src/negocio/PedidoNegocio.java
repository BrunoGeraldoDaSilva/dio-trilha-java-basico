package negocio;

import java.time.LocalDate;
import java.util.List;

import basedados.Banco;
import entidade.Cupom;
import entidade.Pedido;
import entidade.Produto;

public class PedidoNegocio {
    private Banco bancoDados;

    public PedidoNegocio(Banco banco) {
        this.bancoDados = banco;
    }

    private double calcularTotal(List<Produto> produtos, Cupom cupom) {

        double total = 0.0;
        for (Produto produto: produtos) {
            total += produto.calcularFrete();
        }

        if (cupom != null) {
            return  total * (1 - cupom.getDesconto());
        } else {
            return  total;
        }

    }

    public void salvar(Pedido novoPedido) {
        salvar(novoPedido, null);
    }

    public void salvar(Pedido novoPedido, Cupom cupom) {

        
        
        
    	//Definir padrão código
    	String codigo = "PE%4d%2d%04d"; //quer dizer ano,mes,dias
    			
    	//Pegar data do dia corrente
    	LocalDate hoje = LocalDate.now();
    	
    	//Formatar código
    	codigo = String.format(codigo, hoje.getYear(), hoje.getMonthValue(), bancoDados.getPedidos().length);

        //Setar código no pedido
    	novoPedido.setCodigo(codigo);
    	
        //Setar cliente no pedido
    	novoPedido.setCliente(bancoDados.getCliente());
    	
        //Calcular e set total
    	novoPedido.setTotal(calcularTotal(novoPedido.getProdutos(), cupom));
    	
        //Adicionar no banco
    	bancoDados.adicionarPedido(novoPedido);
    	
        //Mensagem
    	System.out.println("Pedido salvo com sucesso. ");
    	
    }

    public void excluir(String codigo) {

        int pedidoExclusao = -1;
        for (int i = 0; i < bancoDados.getPedidos().length; i++) {

            Pedido pedido = bancoDados.getPedidos()[i];
            if (pedido.getCodigo().equals(codigo)) {
                pedidoExclusao = i;
                break;
            }
        }

        if (pedidoExclusao != -1) {
            bancoDados.removerPedido(pedidoExclusao);
            System.out.println("Pedido excluído com sucesso.");
        } else {
            System.out.println("Pedido inexistente.");
        }
    }
    
}
