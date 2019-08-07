package br.com.medinapassos.utils;

import br.com.medinapassos.model.Item;
import br.com.medinapassos.model.Pedido;
import br.com.medinapassos.preencherlista.IPreencherLista;
import br.com.medinapassos.preencherlista.IPreencherTeste;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author JP1
 */
public class FuncoesUtils {

    ///Função utilizando nova api stream
    public static void preencherPedidos(List<Pedido> pedidos, List<Item> itens) {
        pedidos.forEach(
                p -> p.getItens().addAll(
                        itens.stream().filter(i -> i.getPedidoId().equals(p.getPedidoId())).collect(Collectors.toList())
                )
        );
    }

    ///Função utilizando nova api stream com processamento paralelo
    public static void preencherPedidosParallel(List<Pedido> pedidos, List<Item> itens) {
        pedidos.forEach(
                p -> p.getItens().addAll(
                        itens.parallelStream().filter(
                                i -> i.getPedidoId().equals(p.getPedidoId())
                        ).collect(Collectors.toList())
                )
        );
    }

    //Função genérica utilizando duas interface funcional (expressões lambdas) e a nova api stream
    public static <T, E> void preencher(
            List<T> t, List<E> e,
            IPreencherTeste<? super T, ? super E> iPreencherTeste,
            IPreencherLista<? super T, ? super E> iPreencherLista) {
        t.forEach(p -> iPreencherLista
                .preencher(p, e.stream().filter(f -> iPreencherTeste.testar(p, f))
                        .collect(Collectors.toList())));
    }

    //Função genérica utilizando duas interface funcional (expressões lambdas) 
    //e a nova api stream e utilizando o processamento paralelo
    public static <T, E> void preencherParallel(
            List<T> t, List<E> e,
            IPreencherTeste<? super T, ? super E> iPreencherTeste,
            IPreencherLista<? super T, ? super E> iPreencherLista) {
        t.forEach(p -> iPreencherLista
                .preencher(p, e.parallelStream().filter(f -> iPreencherTeste.testar(p, f))
                        .collect(Collectors.toList())));
    }

    //função utilizando o algoritimo binarySearch na busca dos itens e não a api stream
    public static void preencherPedidosCustomizado(List<Pedido> pedidos, List<Item> itens) {
        List<Item> itensTemp = new ArrayList<>(itens);

        itensTemp.sort((Item arg0, Item arg1) -> arg0.getPedidoId().compareTo(arg1.getPedidoId()));

        Item item = new Item();
        int index = -1;
        for (int i = 0; i < pedidos.size(); i++) {
            item.setPedidoId(pedidos.get(i).getPedidoId());
            index = -1;

            while (true) {
                index = Collections.binarySearch(
                        itensTemp,
                        item,
                        (Item arg0, Item arg1) -> arg0.getPedidoId().compareTo(arg1.getPedidoId())
                );
                if (index >= 0) {
                    pedidos.get(i).getItens().add(itensTemp.get(index));
                    itensTemp.remove(index);
                } else {
                    break;
                }
            }
        }
    }

    //Algoritimo  desenvolvido por Medina Passos, que realiza o preenchimento quase que instataneo
    public static void preencherPedidoItemMedinaPassos(List<Pedido> pedidos, List<Item> itens) {
        Collections.sort(pedidos, (Pedido arg0, Pedido arg1) -> arg0.getPedidoId().compareTo(arg1.getPedidoId()));
        Collections.sort(itens, (Item arg0, Item arg1) -> arg0.getPedidoId().compareTo(arg1.getPedidoId()));

        int x1, x2;

        x1 = 0;
        x2 = 0;
        while (pedidos.size() > x1 && itens.size() > x2) {
            if (pedidos.get(x1).getPedidoId().intValue() == itens.get(x2).getPedidoId().intValue()) {
                if (pedidos.get(x1).getItens() == null) {
                    pedidos.get(x1).setItens(new ArrayList<>());
                }
                pedidos.get(x1).getItens().add(itens.get(x2));
                x2++;
            } else if (pedidos.get(x1).getPedidoId().intValue() > itens.get(x2).getPedidoId().intValue()) {
                x2++;
            } else if (pedidos.get(x1).getPedidoId().intValue() < itens.get(x2).getPedidoId().intValue()) {
                x1++;
            }
        }
    }

}
