package br.com.medinapassos.utils;

import br.com.medinapassos.model.Item;
import br.com.medinapassos.model.Pedido;
import br.com.medinapassos.preencherlista.IPreencherLista;
import br.com.medinapassos.preencherlista.IPreencherTeste;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author JP1
 */
public class FuncoesUtils {

    public static void preencherPedidos(List<Pedido> pedidos, List<Item> itens) {
        pedidos.forEach(
                p -> p.getItens().addAll(
                        itens.stream().filter(i -> i.getPedidoId().equals(p.getPedidoId())).collect(Collectors.toList())
                )
        );
    }

    public static <T, E> void preencher(
            List<T> t, List<E> e,
            IPreencherTeste<? super T, ? super E> iPreencherTeste,
            IPreencherLista<? super T, ? super E> iPreencherLista) {
        t.forEach(p -> iPreencherLista
                .preencher(p, e.stream().filter(f -> iPreencherTeste.testar(p, f))
                        .collect(Collectors.toList())));
    }
}
