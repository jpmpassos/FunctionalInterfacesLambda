package br.com.medinapassos.utils;

import br.com.medinapassos.model.Cliente;
import br.com.medinapassos.model.Endereco;
import br.com.medinapassos.model.Item;
import br.com.medinapassos.model.Pedido;
import br.com.medinapassos.repository.ModelRepository;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JP1
 */
public class FuncoesUtilsTest {

    public FuncoesUtilsTest() {
    }

    @Test
    public void testPreencherPedidos() {
        System.out.println("preencherPedidos");
        List<Pedido> pedidos = ModelRepository.getPedidos(4);
        List<Item> itens = ModelRepository.getItens(4, 4);
        FuncoesUtils.preencherPedidos(pedidos, itens);

        assertEquals(pedidos.get(0).getPedidoId(), pedidos.get(0).getItens().get(0).getPedidoId());

        assertEquals(pedidos.get(1).getPedidoId(), pedidos.get(1).getItens().get(0).getPedidoId());

        assertEquals(pedidos.get(2).getPedidoId(), pedidos.get(2).getItens().get(0).getPedidoId());

        assertEquals(pedidos.get(3).getPedidoId(), pedidos.get(3).getItens().get(0).getPedidoId());

        System.out.println();
        System.out.println();
        System.out.println(" FuncoesUtils.preencherPedidos(pedidos, itens)  ");

        pedidos.forEach(p -> {
            System.out.println("----------------------------------");
            System.out.println("Pedido: " + p.getPedidoId());
            p.getItens().forEach(i -> System.out.println("   Item: " + i.getItemId()));
        });

        System.out.println("----------------------------------");
    }

    @Test
    public void testPreencher() {

        List<Pedido> pedidos = ModelRepository.getPedidos(4);
        List<Item> itens = ModelRepository.getItens(4, 4);

        FuncoesUtils.<Pedido, Item>preencher(
                pedidos, itens,
                (Pedido p, Item i) -> p.getPedidoId().equals(i.getPedidoId()),
                (Pedido p, List<? super Item> l)
                -> p.setItens((List<Item>) l)
        );

        assertEquals(pedidos.get(0).getPedidoId(), pedidos.get(0).getItens().get(0).getPedidoId());

        assertEquals(pedidos.get(1).getPedidoId(), pedidos.get(1).getItens().get(0).getPedidoId());

        assertEquals(pedidos.get(2).getPedidoId(), pedidos.get(2).getItens().get(0).getPedidoId());

        assertEquals(pedidos.get(3).getPedidoId(), pedidos.get(3).getItens().get(0).getPedidoId());

        System.out.println();
        System.out.println();
        System.out.println(" FuncoesUtils.<Pedido, Item>preencher  ");
        pedidos.forEach(p -> {
            System.out.println("----------------------------------");
            System.out.println("Pedido: " + p.getPedidoId());
            p.getItens().forEach(i -> System.out.println("   Item: " + i.getItemId()));
        });

        System.out.println("----------------------------------");

        List<Cliente> clientes = ModelRepository.getClientes(4);
        List<Endereco> enderecos = ModelRepository.getEnderencos(16, 4);

        FuncoesUtils.<Cliente, Endereco>preencher(
                clientes, enderecos,
                (Cliente c, Endereco e) -> c.getClienteId().equals(e.getClienteId()),
                (Cliente c, List<? super Endereco> l)
                -> c.setEnderecos((List<Endereco>) l)
        );

        assertEquals(clientes.get(3).getClienteId(), enderecos.get(7).getClienteId());
        
        System.out.println();
        System.out.println();
        System.out.println(" FuncoesUtils.<Cliente, Endereco>preencher  ");
        clientes.forEach(c -> {
            System.out.println("----------------------------------");
            System.out.println(c.getNome());
            c.getEnderecos().forEach(e -> System.out.println("  " + e.getEndereco()));
        });

        System.out.println("----------------------------------");
    }
}
