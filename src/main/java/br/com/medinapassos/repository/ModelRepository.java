package br.com.medinapassos.repository;

import br.com.medinapassos.model.Cliente;
import br.com.medinapassos.model.Endereco;
import br.com.medinapassos.model.Item;
import br.com.medinapassos.model.Pedido;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JP1
 */
public class ModelRepository {

    public static List<Cliente> getClientes(int numeroCLientes) {
        List<Cliente> clientes = new ArrayList<>();

        for (int i = 0; i < numeroCLientes; i++) {
            clientes.add(new Cliente(i + 1, "Cliente " + (i + 1)));
        }

        return clientes;
    }

    public static List<Endereco> getEnderencos(int numeroEnderecos, int numeroCLientes) {
        List<Endereco> enderencos = new ArrayList<>();

        int c = 0;
        for (int i = 0; i < numeroEnderecos; i++) {
            enderencos.add(new Endereco(i + 1, "Endereco " + (i + 1) + " do cliente " + ++c, c));
            if (c == numeroCLientes) {
                c = 0;
            }
        }

        return enderencos;
    }

    public static List<Pedido> getPedidos(int numeroPedidos) {
        List<Pedido> pedidos = new ArrayList<>();

        for (int i = 0; i < numeroPedidos; i++) {
            pedidos.add(new Pedido(i + 1, new BigDecimal(0)));
        }

        return pedidos;
    }

    public static List<Item> getItens(int numeroItens, int numeroPedidos) {
        List<Item> itens = new ArrayList<>();

        int c = 0;
        for (int i = 0; i < numeroItens; i++) {
            itens.add(new Item(i + 1, ++c, "Item " + i + " do pedido " + c, new BigDecimal(Math.random()),
                    new BigDecimal(1)));
            if (c == numeroPedidos) {
                c = 0;
            }
        }

        return itens;
    }
}
