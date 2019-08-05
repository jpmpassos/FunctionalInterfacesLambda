package br.com.medinapassos.repository;

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

    public static List<Pedido> getPedidos(int numeroPedidos) {
        List<Pedido> pedidos = new ArrayList<>();

        for (int i = 0; i < numeroPedidos; i++) {
            pedidos.add(new Pedido(i + 1, new BigDecimal(0)));
        }

        return pedidos;
    }

    public static List<Item> getItens(int numeroItens) {
        List<Item> itens = new ArrayList<>();

        int c = 0;
        for (int i = 0; i < numeroItens; i++) {
            itens.add(new Item(i + 1, ++c, "Item " + i + " do pedido " + c, new BigDecimal(Math.random()),
                    new BigDecimal(1)));
            if (c == 20) {
                c = 0;
            }
        }

        return itens;
    }
}
